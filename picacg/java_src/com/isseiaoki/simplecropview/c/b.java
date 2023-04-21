package com.isseiaoki.simplecropview.c;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.opengl.GLES10;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class b {
    private static final String TAG = "b";
    public static int ch;
    public static int ci;

    public static int a(Context context, Uri uri) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"orientation"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int i = cursor.getInt(0);
                        closeQuietly(cursor);
                        return i;
                    }
                } catch (RuntimeException unused) {
                    closeQuietly(cursor);
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(cursor);
                    throw th;
                }
            }
            closeQuietly(cursor);
            return 0;
        } catch (RuntimeException unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static Bitmap a(Context context, Uri uri, int i) {
        InputStream inputStream;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b(context, uri, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static int b(Context context, Uri uri, int i) {
        InputStream openInputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
            closeQuietly(openInputStream);
        } catch (FileNotFoundException unused2) {
            inputStream = openInputStream;
            closeQuietly(inputStream);
            ch = options.outWidth;
            ci = options.outHeight;
            while (true) {
                if (options.outWidth / i2 > i) {
                }
                i2 *= 2;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = openInputStream;
            closeQuietly(inputStream);
            throw th;
        }
        ch = options.outWidth;
        ci = options.outHeight;
        while (true) {
            if (options.outWidth / i2 > i && options.outHeight / i2 <= i) {
                return i2;
            }
            i2 *= 2;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static int getMaxSize() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        if (iArr[0] > 0) {
            return Math.min(iArr[0], 4096);
        }
        return 2048;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }
}
