package com.soundcloud.android.crop;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.soundcloud.android.crop.ImageViewTouchBase;
import com.soundcloud.android.crop.c;
import com.soundcloud.android.crop.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class CropImageActivity extends c {
    private Uri by;
    private Uri bz;
    private int exifRotation;
    private final Handler handler = new Handler();
    private int vf;
    private int vg;
    private int vh;
    private int vi;
    private boolean vj;
    private int vk;
    private e vl;
    private CropImageView vm;
    private HighlightView vn;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    @Override // com.soundcloud.android.crop.c
    public /* bridge */ /* synthetic */ void a(c.b bVar) {
        super.a(bVar);
    }

    @Override // com.soundcloud.android.crop.c
    public /* bridge */ /* synthetic */ void b(c.b bVar) {
        super.b(bVar);
    }

    @Override // com.soundcloud.android.crop.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ed();
        ee();
        ef();
        if (this.vl == null) {
            finish();
        } else {
            ei();
        }
    }

    @TargetApi(19)
    private void ed() {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().clearFlags(67108864);
        }
    }

    private void ee() {
        setContentView(d.c.crop__activity_crop);
        this.vm = (CropImageView) findViewById(d.b.crop_image);
        this.vm.context = this;
        this.vm.setRecycler(new ImageViewTouchBase.a() { // from class: com.soundcloud.android.crop.CropImageActivity.1
            @Override // com.soundcloud.android.crop.ImageViewTouchBase.a
            public void i(Bitmap bitmap) {
                bitmap.recycle();
                System.gc();
            }
        });
        findViewById(d.b.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.soundcloud.android.crop.CropImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CropImageActivity.this.setResult(0);
                CropImageActivity.this.finish();
            }
        });
        findViewById(d.b.btn_done).setOnClickListener(new View.OnClickListener() { // from class: com.soundcloud.android.crop.CropImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CropImageActivity.this.ej();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context, com.soundcloud.android.crop.CropImageActivity] */
    private void ef() {
        Throwable th;
        InputStream inputStream;
        OutOfMemoryError e;
        IOException e2;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.vf = extras.getInt("aspect_x");
            this.vg = extras.getInt("aspect_y");
            this.vh = extras.getInt("max_x");
            this.vi = extras.getInt("max_y");
            this.bz = (Uri) extras.getParcelable("output");
        }
        this.by = intent.getData();
        if (this.by != null) {
            ContentResolver contentResolver = getContentResolver();
            ?? r1 = this.by;
            this.exifRotation = com.soundcloud.android.crop.a.h(com.soundcloud.android.crop.a.a(this, contentResolver, r1));
            try {
                try {
                    this.vk = d(this.by);
                    inputStream = getContentResolver().openInputStream(this.by);
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = this.vk;
                        this.vl = new e(BitmapFactory.decodeStream(inputStream, null, options), this.exifRotation);
                        r1 = inputStream;
                    } catch (IOException e3) {
                        e2 = e3;
                        b.a("Error reading image: " + e2.getMessage(), e2);
                        b(e2);
                        r1 = inputStream;
                        com.soundcloud.android.crop.a.b(r1);
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        b.a("OOM reading image: " + e.getMessage(), e);
                        b(e);
                        r1 = inputStream;
                        com.soundcloud.android.crop.a.b(r1);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.soundcloud.android.crop.a.b(r1);
                    throw th;
                }
            } catch (IOException e5) {
                inputStream = null;
                e2 = e5;
            } catch (OutOfMemoryError e6) {
                inputStream = null;
                e = e6;
            } catch (Throwable th3) {
                r1 = 0;
                th = th3;
                com.soundcloud.android.crop.a.b(r1);
                throw th;
            }
            com.soundcloud.android.crop.a.b(r1);
        }
    }

    private int d(Uri uri) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                com.soundcloud.android.crop.a.b(openInputStream);
                int eg = eg();
                while (true) {
                    if (options.outHeight / i <= eg && options.outWidth / i <= eg) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = openInputStream;
                com.soundcloud.android.crop.a.b(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int eg() {
        int eh = eh();
        if (eh == 0) {
            return 2048;
        }
        return Math.min(eh, 4096);
    }

    private int eh() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    private void ei() {
        if (isFinishing()) {
            return;
        }
        this.vm.a(this.vl, true);
        com.soundcloud.android.crop.a.a(this, null, getResources().getString(d.C0015d.crop__wait), new Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                CropImageActivity.this.handler.post(new Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CropImageActivity.this.vm.getScale() == 1.0f) {
                            CropImageActivity.this.vm.ep();
                        }
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                    new a().en();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, this.handler);
    }

    /* loaded from: classes.dex */
    private class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void em() {
            int i;
            if (CropImageActivity.this.vl == null) {
                return;
            }
            HighlightView highlightView = new HighlightView(CropImageActivity.this.vm);
            int width = CropImageActivity.this.vl.getWidth();
            int height = CropImageActivity.this.vl.getHeight();
            boolean z = false;
            Rect rect = new Rect(0, 0, width, height);
            int min = (Math.min(width, height) * 4) / 5;
            if (CropImageActivity.this.vf == 0 || CropImageActivity.this.vg == 0) {
                i = min;
            } else if (CropImageActivity.this.vf > CropImageActivity.this.vg) {
                i = (CropImageActivity.this.vg * min) / CropImageActivity.this.vf;
            } else {
                i = min;
                min = (CropImageActivity.this.vf * min) / CropImageActivity.this.vg;
            }
            int i2 = (width - min) / 2;
            int i3 = (height - i) / 2;
            RectF rectF = new RectF(i2, i3, i2 + min, i3 + i);
            Matrix unrotatedMatrix = CropImageActivity.this.vm.getUnrotatedMatrix();
            if (CropImageActivity.this.vf != 0 && CropImageActivity.this.vg != 0) {
                z = true;
            }
            highlightView.a(unrotatedMatrix, rect, rectF, z);
            CropImageActivity.this.vm.c(highlightView);
        }

        public void en() {
            CropImageActivity.this.handler.post(new Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.em();
                    CropImageActivity.this.vm.invalidate();
                    if (CropImageActivity.this.vm.vt.size() == 1) {
                        CropImageActivity.this.vn = CropImageActivity.this.vm.vt.get(0);
                        CropImageActivity.this.vn.G(true);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej() {
        if (this.vn == null || this.vj) {
            return;
        }
        this.vj = true;
        Rect m = this.vn.m(this.vk);
        int width = m.width();
        int height = m.height();
        if (this.vh > 0 && this.vi > 0 && (width > this.vh || height > this.vi)) {
            float f = width / height;
            if (this.vh / this.vi > f) {
                height = this.vi;
                width = (int) ((this.vi * f) + 0.5f);
            } else {
                int i = this.vh;
                height = (int) ((this.vh / f) + 0.5f);
                width = i;
            }
        }
        try {
            Bitmap a2 = a(m, width, height);
            if (a2 != null) {
                this.vm.a(new e(a2, this.exifRotation), true);
                this.vm.ep();
                this.vm.vt.clear();
            }
            g(a2);
        } catch (IllegalArgumentException e) {
            b(e);
            finish();
        }
    }

    private void g(final Bitmap bitmap) {
        if (bitmap != null) {
            com.soundcloud.android.crop.a.a(this, null, getResources().getString(d.C0015d.crop__saving), new Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    CropImageActivity.this.h(bitmap);
                }
            }, this.handler);
        } else {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private Bitmap a(Rect rect, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        InputStream inputStream;
        Bitmap bitmap3;
        Bitmap bitmap4;
        int width;
        int height;
        Rect rect2;
        Bitmap createBitmap;
        ek();
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = getContentResolver().openInputStream(this.by);
                try {
                    try {
                        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                        width = newInstance.getWidth();
                        height = newInstance.getHeight();
                        if (this.exifRotation != 0) {
                            Matrix matrix = new Matrix();
                            matrix.setRotate(-this.exifRotation);
                            RectF rectF = new RectF();
                            matrix.mapRect(rectF, new RectF(rect));
                            rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                            rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        } else {
                            rect2 = rect;
                        }
                        try {
                            bitmap4 = newInstance.decodeRegion(rect2, new BitmapFactory.Options());
                        } catch (IllegalArgumentException e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.soundcloud.android.crop.a.b(inputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bitmap4 = inputStream2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    bitmap4 = inputStream2;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            bitmap2 = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            bitmap = null;
        }
        try {
            if (rect2.width() <= i && rect2.height() <= i2) {
                createBitmap = bitmap4;
                com.soundcloud.android.crop.a.b(inputStream);
                return createBitmap;
            }
            Matrix matrix2 = new Matrix();
            matrix2.postScale(i / rect2.width(), i2 / rect2.height());
            createBitmap = Bitmap.createBitmap(bitmap4, 0, 0, bitmap4.getWidth(), bitmap4.getHeight(), matrix2, true);
            com.soundcloud.android.crop.a.b(inputStream);
            return createBitmap;
        } catch (IOException e6) {
            e = e6;
            inputStream2 = inputStream;
            bitmap2 = bitmap4;
            b.a("Error cropping image: " + e.getMessage(), e);
            b(e);
            bitmap3 = bitmap2;
            com.soundcloud.android.crop.a.b(inputStream2);
            return bitmap3;
        } catch (IllegalArgumentException e7) {
            e = e7;
            inputStream2 = bitmap4;
            throw new IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.exifRotation + ")", e);
        } catch (OutOfMemoryError e8) {
            e = e8;
            inputStream2 = inputStream;
            bitmap = bitmap4;
            b.a("OOM cropping image: " + e.getMessage(), e);
            b(e);
            bitmap3 = bitmap;
            com.soundcloud.android.crop.a.b(inputStream2);
            return bitmap3;
        }
    }

    private void ek() {
        this.vm.clear();
        if (this.vl != null) {
            this.vl.recycle();
        }
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final Bitmap bitmap) {
        if (this.bz != null) {
            OutputStream outputStream = null;
            try {
                try {
                    OutputStream openOutputStream = getContentResolver().openOutputStream(this.bz);
                    if (openOutputStream != null) {
                        try {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, openOutputStream);
                        } catch (IOException e) {
                            e = e;
                            outputStream = openOutputStream;
                            b(e);
                            b.a("Cannot open file: " + this.bz, e);
                            com.soundcloud.android.crop.a.b(outputStream);
                            com.soundcloud.android.crop.a.a(com.soundcloud.android.crop.a.a(this, getContentResolver(), this.by), com.soundcloud.android.crop.a.a(this, getContentResolver(), this.bz));
                            e(this.bz);
                            this.handler.post(new Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    CropImageActivity.this.vm.clear();
                                    bitmap.recycle();
                                }
                            });
                            finish();
                        } catch (Throwable th) {
                            th = th;
                            outputStream = openOutputStream;
                            com.soundcloud.android.crop.a.b(outputStream);
                            throw th;
                        }
                    }
                    com.soundcloud.android.crop.a.b(openOutputStream);
                } catch (IOException e2) {
                    e = e2;
                }
                com.soundcloud.android.crop.a.a(com.soundcloud.android.crop.a.a(this, getContentResolver(), this.by), com.soundcloud.android.crop.a.a(this, getContentResolver(), this.bz));
                e(this.bz);
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.handler.post(new Runnable() { // from class: com.soundcloud.android.crop.CropImageActivity.6
            @Override // java.lang.Runnable
            public void run() {
                CropImageActivity.this.vm.clear();
                bitmap.recycle();
            }
        });
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soundcloud.android.crop.c, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.vl != null) {
            this.vl.recycle();
        }
    }

    public boolean el() {
        return this.vj;
    }

    private void e(Uri uri) {
        setResult(-1, new Intent().putExtra("output", uri));
    }

    private void b(Throwable th) {
        setResult(404, new Intent().putExtra("error", th));
    }
}
