package com.soundcloud.android.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.soundcloud.android.crop.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: CropUtil.java */
/* loaded from: classes.dex */
class a {
    public static void b(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static int h(File file) {
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e) {
            b.a("Error getting Exif data", e);
            return 0;
        }
    }

    public static boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
            exifInterface2.setAttribute("Orientation", exifInterface.getAttribute("Orientation"));
            exifInterface2.saveAttributes();
            return true;
        } catch (IOException e) {
            b.a("Error copying Exif data", e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        if (r1 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
        r1.close();
     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File a(android.content.Context r8, android.content.ContentResolver r9, android.net.Uri r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "file"
            java.lang.String r2 = r10.getScheme()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L1a
            java.io.File r8 = new java.io.File
            java.lang.String r9 = r10.getPath()
            r8.<init>(r9)
            return r8
        L1a:
            java.lang.String r1 = "content"
            java.lang.String r2 = r10.getScheme()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L98
            r1 = 2
            java.lang.String[] r4 = new java.lang.String[r1]
            r1 = 0
            java.lang.String r2 = "_data"
            r4[r1] = r2
            r1 = 1
            java.lang.String r2 = "_display_name"
            r4[r1] = r2
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r3 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7e java.lang.SecurityException -> L81 java.lang.IllegalArgumentException -> L88
            if (r1 == 0) goto L7b
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            if (r2 == 0) goto L7b
            java.lang.String r2 = r10.toString()     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            java.lang.String r3 = "content://com.google.android.gallery3d"
            boolean r2 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            if (r2 == 0) goto L57
            java.lang.String r2 = "_display_name"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            goto L5d
        L57:
            java.lang.String r2 = "_data"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
        L5d:
            r3 = -1
            if (r2 == r3) goto L7b
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            if (r3 != 0) goto L7b
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L75 java.lang.SecurityException -> L77 java.lang.IllegalArgumentException -> L79
            if (r1 == 0) goto L74
            r1.close()
        L74:
            return r3
        L75:
            r8 = move-exception
            goto L92
        L77:
            goto L82
        L79:
            r0 = r1
            goto L88
        L7b:
            if (r1 == 0) goto L98
            goto L84
        L7e:
            r8 = move-exception
            r1 = r0
            goto L92
        L81:
            r1 = r0
        L82:
            if (r1 == 0) goto L98
        L84:
            r1.close()
            goto L98
        L88:
            java.io.File r8 = b(r8, r9, r10)     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L91
            r0.close()
        L91:
            return r8
        L92:
            if (r1 == 0) goto L97
            r1.close()
        L97:
            throw r8
        L98:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soundcloud.android.crop.a.a(android.content.Context, android.content.ContentResolver, android.net.Uri):java.io.File");
    }

    private static String ay(Context context) throws IOException {
        return File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
    }

    @Nullable
    private static File b(Context context, ContentResolver contentResolver, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                String ay = ay(context);
                fileOutputStream = new FileOutputStream(ay);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            File file = new File(ay);
                            b(fileInputStream);
                            b(fileOutputStream);
                            return file;
                        }
                    }
                } catch (IOException unused) {
                    b(fileInputStream);
                    b(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    b(fileInputStream);
                    b(fileOutputStream2);
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void a(c cVar, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC0014a(cVar, runnable, ProgressDialog.show(cVar, str, str2, true, false), handler)).start();
    }

    /* compiled from: CropUtil.java */
    /* renamed from: com.soundcloud.android.crop.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class RunnableC0014a extends c.a implements Runnable {
        private final Handler handler;
        private final ProgressDialog vA;
        private final Runnable vB;
        private final Runnable vC = new Runnable() { // from class: com.soundcloud.android.crop.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0014a.this.vz.a(RunnableC0014a.this);
                if (RunnableC0014a.this.vA.getWindow() != null) {
                    RunnableC0014a.this.vA.dismiss();
                }
            }
        };
        private final c vz;

        public RunnableC0014a(c cVar, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.vz = cVar;
            this.vA = progressDialog;
            this.vB = runnable;
            this.vz.b(this);
            this.handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.vB.run();
            } finally {
                this.handler.post(this.vC);
            }
        }

        @Override // com.soundcloud.android.crop.c.a, com.soundcloud.android.crop.c.b
        public void a(c cVar) {
            this.vC.run();
            this.handler.removeCallbacks(this.vC);
        }

        @Override // com.soundcloud.android.crop.c.a, com.soundcloud.android.crop.c.b
        public void b(c cVar) {
            this.vA.hide();
        }

        @Override // com.soundcloud.android.crop.c.a, com.soundcloud.android.crop.c.b
        public void c(c cVar) {
            this.vA.show();
        }
    }
}
