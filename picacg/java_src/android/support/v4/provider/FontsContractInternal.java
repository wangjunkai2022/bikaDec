package android.support.v4.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.support.annotation.GuardedBy;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.fonts.FontResult;
import android.support.v4.os.ResultReceiver;
import android.support.v4.provider.FontsContractCompat;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class FontsContractInternal {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String PARCEL_FONT_RESULTS = "font_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
    private static final String TAG = "FontsContractCompat";
    private static final int THREAD_RENEWAL_THRESHOLD_MS = 10000;
    private static final Comparator<byte[]> sByteArrayComparator = new Comparator<byte[]>() { // from class: android.support.v4.provider.FontsContractInternal.3
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };
    private final Context mContext;
    @GuardedBy("mLock")
    private Handler mHandler;
    private final PackageManager mPackageManager;
    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final Object mLock = new Object();
    private final Runnable mReplaceDispatcherThreadRunnable = new Runnable() { // from class: android.support.v4.provider.FontsContractInternal.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (FontsContractInternal.this.mLock) {
                if (FontsContractInternal.this.mThread != null) {
                    FontsContractInternal.this.mThread.quit();
                    FontsContractInternal.this.mThread = null;
                    FontsContractInternal.this.mHandler = null;
                }
            }
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FontsContractInternal(Context context) {
        this.mContext = context.getApplicationContext();
        this.mPackageManager = this.mContext.getPackageManager();
    }

    @VisibleForTesting
    FontsContractInternal(Context context, PackageManager packageManager) {
        this.mContext = context;
        this.mPackageManager = packageManager;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void getFont(final FontRequest fontRequest, final ResultReceiver resultReceiver) {
        synchronized (this.mLock) {
            if (this.mHandler == null) {
                this.mThread = new HandlerThread("fonts", 10);
                this.mThread.start();
                this.mHandler = new Handler(this.mThread.getLooper());
            }
            this.mHandler.post(new Runnable() { // from class: android.support.v4.provider.FontsContractInternal.2
                @Override // java.lang.Runnable
                public void run() {
                    ProviderInfo provider = FontsContractInternal.this.getProvider(fontRequest, resultReceiver);
                    if (provider == null) {
                        return;
                    }
                    FontsContractInternal.this.getFontFromProvider(fontRequest, resultReceiver, provider.authority);
                }
            });
            this.mHandler.removeCallbacks(this.mReplaceDispatcherThreadRunnable);
            this.mHandler.postDelayed(this.mReplaceDispatcherThreadRunnable, 10000L);
        }
    }

    @VisibleForTesting
    ProviderInfo getProvider(FontRequest fontRequest, ResultReceiver resultReceiver) {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = this.mPackageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            Log.e(TAG, "Can't find content provider " + providerAuthority);
            resultReceiver.send(-1, null);
            return null;
        } else if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            Log.e(TAG, "Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
            resultReceiver.send(-1, null);
            return null;
        } else {
            try {
                List<byte[]> convertToByteArrayList = convertToByteArrayList(this.mPackageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(convertToByteArrayList, sByteArrayComparator);
                List<List<byte[]>> certificates = getCertificates(fontRequest);
                for (int i = 0; i < certificates.size(); i++) {
                    ArrayList arrayList = new ArrayList(certificates.get(i));
                    Collections.sort(arrayList, sByteArrayComparator);
                    if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                Log.e(TAG, "Certificates don't match for given provider " + providerAuthority);
                resultReceiver.send(-2, null);
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Can't find content provider " + providerAuthority, e);
                resultReceiver.send(-1, null);
                return null;
            }
        }
    }

    private List<List<byte[]>> getCertificates(FontRequest fontRequest) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(this.mContext.getResources(), fontRequest.getCertificatesArrayResId());
    }

    private boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    @VisibleForTesting
    void getFontFromProvider(FontRequest fontRequest, ResultReceiver resultReceiver, String str) {
        Cursor cursor;
        int i;
        Uri withAppendedId;
        int i2;
        int i3;
        String str2;
        int i4;
        boolean z;
        FontsContractInternal fontsContractInternal = this;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Bundle bundle = null;
        try {
            cursor = fontsContractInternal.mContext.getContentResolver().query(build, new String[]{"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new String[]{fontRequest.getQuery()}, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                        int columnIndex4 = cursor.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                        int columnIndex5 = cursor.getColumnIndex(FontsContractCompat.Columns.VARIATION_SETTINGS);
                        int columnIndex6 = cursor.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                        int columnIndex7 = cursor.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                        while (cursor.moveToNext()) {
                            int i5 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                            if (i5 != 0) {
                                int i6 = i5 < 0 ? 1 : i5;
                                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                    try {
                                        ((FontResult) arrayList.get(i7)).getFileDescriptor().close();
                                    } catch (IOException unused) {
                                    }
                                }
                                resultReceiver.send(i6, bundle);
                                if (cursor != null) {
                                    cursor.close();
                                    return;
                                }
                                return;
                            }
                            if (columnIndex3 == -1) {
                                i = columnIndex6;
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                i = columnIndex6;
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            try {
                                ParcelFileDescriptor openFileDescriptor = fontsContractInternal.mContext.getContentResolver().openFileDescriptor(withAppendedId, "r");
                                if (openFileDescriptor != null) {
                                    int i8 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                                    if (columnIndex5 != -1) {
                                        str2 = cursor.getString(columnIndex5);
                                        i2 = i;
                                    } else {
                                        i2 = i;
                                        str2 = null;
                                    }
                                    if (i2 == -1 || columnIndex7 == -1) {
                                        i4 = 400;
                                        z = false;
                                    } else {
                                        try {
                                            i4 = cursor.getInt(i2);
                                            z = cursor.getInt(columnIndex7) == 1;
                                        } catch (FileNotFoundException e) {
                                            e = e;
                                            StringBuilder sb = new StringBuilder();
                                            i3 = columnIndex;
                                            sb.append("FileNotFoundException raised when interacting with content provider ");
                                            sb.append(str);
                                            Log.e(TAG, sb.toString(), e);
                                            columnIndex6 = i2;
                                            columnIndex = i3;
                                            fontsContractInternal = this;
                                            bundle = null;
                                        }
                                    }
                                    arrayList.add(new FontResult(openFileDescriptor, i8, str2, i4, z));
                                } else {
                                    i2 = i;
                                }
                                i3 = columnIndex;
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                i2 = i;
                            }
                            columnIndex6 = i2;
                            columnIndex = i3;
                            fontsContractInternal = this;
                            bundle = null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (!arrayList.isEmpty()) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArrayList("font_results", arrayList);
                resultReceiver.send(0, bundle2);
                return;
            }
            resultReceiver.send(1, null);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
