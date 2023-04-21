package com.soundcloud.android.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RotateBitmap.java */
/* loaded from: classes.dex */
public class e {
    private Bitmap bitmap;
    private int rotation;

    public e(Bitmap bitmap, int i) {
        this.bitmap = bitmap;
        this.rotation = i % 360;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public int getRotation() {
        return this.rotation;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Matrix er() {
        Matrix matrix = new Matrix();
        if (this.bitmap != null && this.rotation != 0) {
            matrix.preTranslate(-(this.bitmap.getWidth() / 2), -(this.bitmap.getHeight() / 2));
            matrix.postRotate(this.rotation);
            matrix.postTranslate(getWidth() / 2, getHeight() / 2);
        }
        return matrix;
    }

    public boolean es() {
        return (this.rotation / 90) % 2 != 0;
    }

    public int getHeight() {
        if (this.bitmap == null) {
            return 0;
        }
        if (es()) {
            return this.bitmap.getWidth();
        }
        return this.bitmap.getHeight();
    }

    public int getWidth() {
        if (this.bitmap == null) {
            return 0;
        }
        if (es()) {
            return this.bitmap.getHeight();
        }
        return this.bitmap.getWidth();
    }

    public void recycle() {
        if (this.bitmap != null) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
    }
}
