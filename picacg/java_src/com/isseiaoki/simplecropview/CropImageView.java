package com.isseiaoki.simplecropview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.isseiaoki.simplecropview.a;
import com.isseiaoki.simplecropview.b.b;
import com.isseiaoki.simplecropview.b.c;
import com.isseiaoki.simplecropview.b.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class CropImageView extends ImageView {
    private static final String TAG = "CropImageView";
    private Uri A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private Bitmap.CompressFormat I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private TouchArea Q;
    private CropMode R;
    private ShowMode S;
    private ShowMode T;
    private float U;
    private int V;
    private int W;
    private int a;
    private boolean a_;
    private boolean aa;
    private PointF ab;
    private float ac;
    private float ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private float ai;
    private boolean aj;
    private int ak;
    private boolean al;
    private boolean b_;
    private int c;
    private boolean c_;
    private float d;
    private float e;
    private boolean f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private RectF k;
    private RectF l;
    private PointF m;
    private float mAngle;
    private int mBackgroundColor;
    private Handler mHandler;
    private Interpolator mInterpolator;
    private Matrix mMatrix;
    private float mScale;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private com.isseiaoki.simplecropview.a.a r;
    private final Interpolator s;
    private c t;
    private b u;
    private d v;
    private ExecutorService w;
    private Uri z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TouchArea {
        OUT_OF_BOUNDS,
        CENTER,
        LEFT_TOP,
        RIGHT_TOP,
        LEFT_BOTTOM,
        RIGHT_BOTTOM
    }

    private float a(float f, float f2, float f3) {
        return f % 180.0f == 0.0f ? f2 : f3;
    }

    private float a(float f, float f2, float f3, float f4) {
        return (f < f2 || f > f3) ? f4 : f;
    }

    private float b(float f, float f2, float f3) {
        return f % 180.0f == 0.0f ? f3 : f2;
    }

    private float e(float f) {
        return f * f;
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.c = 0;
        this.mScale = 1.0f;
        this.mAngle = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = false;
        this.mMatrix = null;
        this.m = new PointF();
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = new DecelerateInterpolator();
        this.mInterpolator = this.s;
        this.t = null;
        this.u = null;
        this.v = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.z = null;
        this.A = null;
        this.B = 0;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = Bitmap.CompressFormat.PNG;
        this.J = 100;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = false;
        this.Q = TouchArea.OUT_OF_BOUNDS;
        this.R = CropMode.SQUARE;
        this.S = ShowMode.SHOW_ALWAYS;
        this.T = ShowMode.SHOW_ALWAYS;
        this.W = 0;
        this.a_ = true;
        this.b_ = true;
        this.c_ = true;
        this.aa = true;
        this.ab = new PointF(1.0f, 1.0f);
        this.ac = 2.0f;
        this.ad = 2.0f;
        this.aj = true;
        this.ak = 100;
        this.al = true;
        this.w = Executors.newSingleThreadExecutor();
        float density = getDensity();
        this.V = (int) (14.0f * density);
        this.U = 50.0f * density;
        float f = density * 1.0f;
        this.ac = f;
        this.ad = f;
        this.h = new Paint();
        this.g = new Paint();
        this.i = new Paint();
        this.i.setFilterBitmap(true);
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setColor(-1);
        this.j.setTextSize(15.0f * density);
        this.mMatrix = new Matrix();
        this.mScale = 1.0f;
        this.mBackgroundColor = 0;
        this.af = -1;
        this.ae = -1157627904;
        this.ag = -1;
        this.ah = -1140850689;
        a(context, attributeSet, i, density);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.bd = getBitmap();
        savedState.be = this.R;
        savedState.backgroundColor = this.mBackgroundColor;
        savedState.bf = this.ae;
        savedState.bg = this.af;
        savedState.bh = this.S;
        savedState.bi = this.T;
        savedState.bj = this.a_;
        savedState.bk = this.b_;
        savedState.bl = this.V;
        savedState.bm = this.W;
        savedState.bn = this.U;
        savedState.bo = this.ab.x;
        savedState.bp = this.ab.y;
        savedState.bq = this.ac;
        savedState.br = this.ad;
        savedState.bs = this.c_;
        savedState.bt = this.ag;
        savedState.bu = this.ah;
        savedState.bv = this.ai;
        savedState.bw = this.mAngle;
        savedState.bx = this.aj;
        savedState.animationDuration = this.ak;
        savedState.exifRotation = this.B;
        savedState.by = this.z;
        savedState.bz = this.A;
        savedState.bA = this.I;
        savedState.bB = this.J;
        savedState.bC = this.G;
        savedState.bD = this.C;
        savedState.bE = this.D;
        savedState.bF = this.E;
        savedState.bG = this.F;
        savedState.bH = this.al;
        savedState.bI = this.K;
        savedState.bJ = this.L;
        savedState.bK = this.M;
        savedState.bL = this.N;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.R = savedState.be;
        this.mBackgroundColor = savedState.backgroundColor;
        this.ae = savedState.bf;
        this.af = savedState.bg;
        this.S = savedState.bh;
        this.T = savedState.bi;
        this.a_ = savedState.bj;
        this.b_ = savedState.bk;
        this.V = savedState.bl;
        this.W = savedState.bm;
        this.U = savedState.bn;
        this.ab = new PointF(savedState.bo, savedState.bp);
        this.ac = savedState.bq;
        this.ad = savedState.br;
        this.c_ = savedState.bs;
        this.ag = savedState.bt;
        this.ah = savedState.bu;
        this.ai = savedState.bv;
        this.mAngle = savedState.bw;
        this.aj = savedState.bx;
        this.ak = savedState.animationDuration;
        this.B = savedState.exifRotation;
        this.z = savedState.by;
        this.A = savedState.bz;
        this.I = savedState.bA;
        this.J = savedState.bB;
        this.G = savedState.bC;
        this.C = savedState.bD;
        this.D = savedState.bE;
        this.E = savedState.bF;
        this.F = savedState.bG;
        this.al = savedState.bH;
        this.K = savedState.bI;
        this.L = savedState.bJ;
        this.M = savedState.bK;
        this.N = savedState.bL;
        setImageBitmap(savedState.bd);
        requestLayout();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        this.a = (size - getPaddingLeft()) - getPaddingRight();
        this.c = (size2 - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getDrawable() != null) {
            a(this.a, this.c);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.mBackgroundColor);
        if (this.f) {
            a();
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.mMatrix, this.i);
                b(canvas);
            }
            if (this.G) {
                a(canvas);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.w.shutdown();
        super.onDetachedFromWindow();
    }

    private void a(Context context, AttributeSet attributeSet, int i, float f) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0003a.scv_CropImageView, i, 0);
        this.R = CropMode.SQUARE;
        try {
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(a.C0003a.scv_CropImageView_scv_img_src);
                if (drawable != null) {
                    setImageDrawable(drawable);
                }
                CropMode[] values = CropMode.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    CropMode cropMode = values[i2];
                    if (obtainStyledAttributes.getInt(a.C0003a.scv_CropImageView_scv_crop_mode, 3) == cropMode.getId()) {
                        this.R = cropMode;
                        break;
                    }
                    i2++;
                }
                this.mBackgroundColor = obtainStyledAttributes.getColor(a.C0003a.scv_CropImageView_scv_background_color, 0);
                this.ae = obtainStyledAttributes.getColor(a.C0003a.scv_CropImageView_scv_overlay_color, -1157627904);
                this.af = obtainStyledAttributes.getColor(a.C0003a.scv_CropImageView_scv_frame_color, -1);
                this.ag = obtainStyledAttributes.getColor(a.C0003a.scv_CropImageView_scv_handle_color, -1);
                this.ah = obtainStyledAttributes.getColor(a.C0003a.scv_CropImageView_scv_guide_color, -1140850689);
                ShowMode[] values2 = ShowMode.values();
                int length2 = values2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    ShowMode showMode = values2[i3];
                    if (obtainStyledAttributes.getInt(a.C0003a.scv_CropImageView_scv_guide_show_mode, 1) == showMode.getId()) {
                        this.S = showMode;
                        break;
                    }
                    i3++;
                }
                ShowMode[] values3 = ShowMode.values();
                int length3 = values3.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length3) {
                        break;
                    }
                    ShowMode showMode2 = values3[i4];
                    if (obtainStyledAttributes.getInt(a.C0003a.scv_CropImageView_scv_handle_show_mode, 1) == showMode2.getId()) {
                        this.T = showMode2;
                        break;
                    }
                    i4++;
                }
                setGuideShowMode(this.S);
                setHandleShowMode(this.T);
                this.V = obtainStyledAttributes.getDimensionPixelSize(a.C0003a.scv_CropImageView_scv_handle_size, (int) (14.0f * f));
                this.W = obtainStyledAttributes.getDimensionPixelSize(a.C0003a.scv_CropImageView_scv_touch_padding, 0);
                this.U = obtainStyledAttributes.getDimensionPixelSize(a.C0003a.scv_CropImageView_scv_min_frame_size, (int) (50.0f * f));
                int i5 = (int) (f * 1.0f);
                this.ac = obtainStyledAttributes.getDimensionPixelSize(a.C0003a.scv_CropImageView_scv_frame_stroke_weight, i5);
                this.ad = obtainStyledAttributes.getDimensionPixelSize(a.C0003a.scv_CropImageView_scv_guide_stroke_weight, i5);
                this.c_ = obtainStyledAttributes.getBoolean(a.C0003a.scv_CropImageView_scv_crop_enabled, true);
                this.ai = a(obtainStyledAttributes.getFloat(a.C0003a.scv_CropImageView_scv_initial_frame_scale, 1.0f), 0.01f, 1.0f, 1.0f);
                this.aj = obtainStyledAttributes.getBoolean(a.C0003a.scv_CropImageView_scv_animation_enabled, true);
                this.ak = obtainStyledAttributes.getInt(a.C0003a.scv_CropImageView_scv_animation_duration, 100);
                this.al = obtainStyledAttributes.getBoolean(a.C0003a.scv_CropImageView_scv_handle_shadow_enabled, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas) {
        int i;
        StringBuilder sb;
        int i2;
        Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
        this.j.measureText("W");
        int i3 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int density = (int) (this.l.left + (this.V * 0.5f * getDensity()));
        int density2 = (int) (this.l.top + i3 + (this.V * 0.5f * getDensity()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LOADED FROM: ");
        sb2.append(this.z != null ? "Uri" : "Bitmap");
        float f = density;
        canvas.drawText(sb2.toString(), f, density2, this.j);
        StringBuilder sb3 = new StringBuilder();
        if (this.z == null) {
            sb3.append("INPUT_IMAGE_SIZE: ");
            sb3.append((int) this.d);
            sb3.append("x");
            sb3.append((int) this.e);
            i = density2 + i3;
            canvas.drawText(sb3.toString(), f, i, this.j);
            sb = new StringBuilder();
        } else {
            i = density2 + i3;
            canvas.drawText("INPUT_IMAGE_SIZE: " + this.K + "x" + this.L, f, i, this.j);
            sb = new StringBuilder();
        }
        sb.append("LOADED_IMAGE_SIZE: ");
        sb.append(getBitmap().getWidth());
        sb.append("x");
        sb.append(getBitmap().getHeight());
        int i4 = i + i3;
        canvas.drawText(sb.toString(), f, i4, this.j);
        StringBuilder sb4 = new StringBuilder();
        if (this.M <= 0 || this.N <= 0) {
            return;
        }
        sb4.append("OUTPUT_IMAGE_SIZE: ");
        sb4.append(this.M);
        sb4.append("x");
        sb4.append(this.N);
        int i5 = i4 + i3;
        canvas.drawText(sb4.toString(), f, i5, this.j);
        canvas.drawText("EXIF ROTATION: " + this.B, f, i5 + i3, this.j);
        canvas.drawText("CURRENT_ROTATION: " + ((int) this.mAngle), f, i2 + i3, this.j);
    }

    private void b(Canvas canvas) {
        if (this.c_ && !this.p) {
            c(canvas);
            d(canvas);
            if (this.a_) {
                e(canvas);
            }
            if (this.b_) {
                f(canvas);
            }
        }
    }

    private void c(Canvas canvas) {
        this.g.setAntiAlias(true);
        this.g.setFilterBitmap(true);
        this.g.setColor(this.ae);
        this.g.setStyle(Paint.Style.FILL);
        Path path = new Path();
        if (!this.q && (this.R == CropMode.CIRCLE || this.R == CropMode.CIRCLE_SQUARE)) {
            path.addRect(this.l, Path.Direction.CW);
            PointF pointF = new PointF((this.k.left + this.k.right) / 2.0f, (this.k.top + this.k.bottom) / 2.0f);
            path.addCircle(pointF.x, pointF.y, (this.k.right - this.k.left) / 2.0f, Path.Direction.CCW);
            canvas.drawPath(path, this.g);
            return;
        }
        path.addRect(this.l, Path.Direction.CW);
        path.addRect(this.k, Path.Direction.CCW);
        canvas.drawPath(path, this.g);
    }

    private void d(Canvas canvas) {
        this.h.setAntiAlias(true);
        this.h.setFilterBitmap(true);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setColor(this.af);
        this.h.setStrokeWidth(this.ac);
        canvas.drawRect(this.k, this.h);
    }

    private void e(Canvas canvas) {
        this.h.setColor(this.ah);
        this.h.setStrokeWidth(this.ad);
        float f = this.k.left + ((this.k.right - this.k.left) / 3.0f);
        float f2 = this.k.right - ((this.k.right - this.k.left) / 3.0f);
        float f3 = this.k.top + ((this.k.bottom - this.k.top) / 3.0f);
        float f4 = this.k.bottom - ((this.k.bottom - this.k.top) / 3.0f);
        canvas.drawLine(f, this.k.top, f, this.k.bottom, this.h);
        canvas.drawLine(f2, this.k.top, f2, this.k.bottom, this.h);
        canvas.drawLine(this.k.left, f3, this.k.right, f3, this.h);
        canvas.drawLine(this.k.left, f4, this.k.right, f4, this.h);
    }

    private void f(Canvas canvas) {
        if (this.al) {
            g(canvas);
        }
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.ag);
        canvas.drawCircle(this.k.left, this.k.top, this.V, this.h);
        canvas.drawCircle(this.k.right, this.k.top, this.V, this.h);
        canvas.drawCircle(this.k.left, this.k.bottom, this.V, this.h);
        canvas.drawCircle(this.k.right, this.k.bottom, this.V, this.h);
    }

    private void g(Canvas canvas) {
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(-1157627904);
        RectF rectF = new RectF(this.k);
        rectF.offset(0.0f, 1.0f);
        canvas.drawCircle(rectF.left, rectF.top, this.V, this.h);
        canvas.drawCircle(rectF.right, rectF.top, this.V, this.h);
        canvas.drawCircle(rectF.left, rectF.bottom, this.V, this.h);
        canvas.drawCircle(rectF.right, rectF.bottom, this.V, this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(this.m.x - (this.d * 0.5f), this.m.y - (this.e * 0.5f));
        this.mMatrix.postScale(this.mScale, this.mScale, this.m.x, this.m.y);
        this.mMatrix.postRotate(this.mAngle, this.m.x, this.m.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        setCenter(new PointF(getPaddingLeft() + (i * 0.5f), getPaddingTop() + (i2 * 0.5f)));
        setScale(a(i, i2, this.mAngle));
        a();
        this.l = a(new RectF(0.0f, 0.0f, this.d, this.e), this.mMatrix);
        this.k = a(this.l);
        this.f = true;
        invalidate();
    }

    private float a(int i, int i2, float f) {
        this.d = getDrawable().getIntrinsicWidth();
        this.e = getDrawable().getIntrinsicHeight();
        if (this.d <= 0.0f) {
            this.d = i;
        }
        if (this.e <= 0.0f) {
            this.e = i2;
        }
        float f2 = i;
        float f3 = i2;
        float f4 = f2 / f3;
        float f5 = f(f) / g(f);
        if (f5 >= f4) {
            return f2 / f(f);
        }
        if (f5 < f4) {
            return f3 / g(f);
        }
        return 1.0f;
    }

    private RectF a(RectF rectF, Matrix matrix) {
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        return rectF2;
    }

    private RectF a(RectF rectF) {
        float c = c(rectF.width());
        float d = d(rectF.height());
        float width = rectF.width() / rectF.height();
        float f = c / d;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        if (f >= width) {
            f2 = rectF.left;
            f4 = rectF.right;
            float f6 = (rectF.top + rectF.bottom) * 0.5f;
            float width2 = (rectF.width() / f) * 0.5f;
            f3 = f6 - width2;
            f5 = f6 + width2;
        } else if (f < width) {
            f3 = rectF.top;
            f5 = rectF.bottom;
            float f7 = (rectF.left + rectF.right) * 0.5f;
            float height = rectF.height() * f * 0.5f;
            f4 = f7 + height;
            f2 = f7 - height;
        }
        float f8 = f4 - f2;
        float f9 = f5 - f3;
        float f10 = f2 + (f8 / 2.0f);
        float f11 = f3 + (f9 / 2.0f);
        float f12 = (f8 * this.ai) / 2.0f;
        float f13 = (f9 * this.ai) / 2.0f;
        return new RectF(f10 - f12, f11 - f13, f10 + f12, f11 + f13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f || !this.c_ || !this.aa || this.p || this.q || this.O || this.H) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                a(motionEvent);
                return true;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                c(motionEvent);
                return true;
            case 2:
                b(motionEvent);
                if (this.Q != TouchArea.OUT_OF_BOUNDS) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                onCancel();
                return true;
            default:
                return false;
        }
    }

    private void a(MotionEvent motionEvent) {
        invalidate();
        this.n = motionEvent.getX();
        this.o = motionEvent.getY();
        a(motionEvent.getX(), motionEvent.getY());
    }

    private void b(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.n;
        float y = motionEvent.getY() - this.o;
        switch (this.Q) {
            case CENTER:
                g(x, y);
                break;
            case LEFT_TOP:
                h(x, y);
                break;
            case RIGHT_TOP:
                i(x, y);
                break;
            case LEFT_BOTTOM:
                j(x, y);
                break;
            case RIGHT_BOTTOM:
                k(x, y);
                break;
        }
        invalidate();
        this.n = motionEvent.getX();
        this.o = motionEvent.getY();
    }

    private void c(MotionEvent motionEvent) {
        if (this.S == ShowMode.SHOW_ON_TOUCH) {
            this.a_ = false;
        }
        if (this.T == ShowMode.SHOW_ON_TOUCH) {
            this.b_ = false;
        }
        this.Q = TouchArea.OUT_OF_BOUNDS;
        invalidate();
    }

    private void onCancel() {
        this.Q = TouchArea.OUT_OF_BOUNDS;
        invalidate();
    }

    private void a(float f, float f2) {
        if (c(f, f2)) {
            this.Q = TouchArea.LEFT_TOP;
            if (this.T == ShowMode.SHOW_ON_TOUCH) {
                this.b_ = true;
            }
            if (this.S == ShowMode.SHOW_ON_TOUCH) {
                this.a_ = true;
            }
        } else if (d(f, f2)) {
            this.Q = TouchArea.RIGHT_TOP;
            if (this.T == ShowMode.SHOW_ON_TOUCH) {
                this.b_ = true;
            }
            if (this.S == ShowMode.SHOW_ON_TOUCH) {
                this.a_ = true;
            }
        } else if (e(f, f2)) {
            this.Q = TouchArea.LEFT_BOTTOM;
            if (this.T == ShowMode.SHOW_ON_TOUCH) {
                this.b_ = true;
            }
            if (this.S == ShowMode.SHOW_ON_TOUCH) {
                this.a_ = true;
            }
        } else if (f(f, f2)) {
            this.Q = TouchArea.RIGHT_BOTTOM;
            if (this.T == ShowMode.SHOW_ON_TOUCH) {
                this.b_ = true;
            }
            if (this.S == ShowMode.SHOW_ON_TOUCH) {
                this.a_ = true;
            }
        } else if (b(f, f2)) {
            if (this.S == ShowMode.SHOW_ON_TOUCH) {
                this.a_ = true;
            }
            this.Q = TouchArea.CENTER;
        } else {
            this.Q = TouchArea.OUT_OF_BOUNDS;
        }
    }

    private boolean b(float f, float f2) {
        if (this.k.left > f || this.k.right < f || this.k.top > f2 || this.k.bottom < f2) {
            return false;
        }
        this.Q = TouchArea.CENTER;
        return true;
    }

    private boolean c(float f, float f2) {
        float f3 = f - this.k.left;
        float f4 = f2 - this.k.top;
        return e((float) (this.V + this.W)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean d(float f, float f2) {
        float f3 = f - this.k.right;
        float f4 = f2 - this.k.top;
        return e((float) (this.V + this.W)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean e(float f, float f2) {
        float f3 = f - this.k.left;
        float f4 = f2 - this.k.bottom;
        return e((float) (this.V + this.W)) >= (f3 * f3) + (f4 * f4);
    }

    private boolean f(float f, float f2) {
        float f3 = f - this.k.right;
        float f4 = f2 - this.k.bottom;
        return e((float) (this.V + this.W)) >= (f3 * f3) + (f4 * f4);
    }

    private void g(float f, float f2) {
        this.k.left += f;
        this.k.right += f;
        this.k.top += f2;
        this.k.bottom += f2;
        c();
    }

    private void h(float f, float f2) {
        if (this.R == CropMode.FREE) {
            this.k.left += f;
            this.k.top += f2;
            if (d()) {
                this.k.left -= this.U - getFrameW();
            }
            if (e()) {
                this.k.top -= this.U - getFrameH();
            }
            b();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        this.k.left += f;
        this.k.top += ratioY;
        if (d()) {
            float frameW = this.U - getFrameW();
            this.k.left -= frameW;
            this.k.top -= (frameW * getRatioY()) / getRatioX();
        }
        if (e()) {
            float frameH = this.U - getFrameH();
            this.k.top -= frameH;
            this.k.left -= (frameH * getRatioX()) / getRatioY();
        }
        if (!a(this.k.left)) {
            float f3 = this.l.left - this.k.left;
            this.k.left += f3;
            this.k.top += (f3 * getRatioY()) / getRatioX();
        }
        if (b(this.k.top)) {
            return;
        }
        float f4 = this.l.top - this.k.top;
        this.k.top += f4;
        this.k.left += (f4 * getRatioX()) / getRatioY();
    }

    private void i(float f, float f2) {
        if (this.R == CropMode.FREE) {
            this.k.right += f;
            this.k.top += f2;
            if (d()) {
                this.k.right += this.U - getFrameW();
            }
            if (e()) {
                this.k.top -= this.U - getFrameH();
            }
            b();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        this.k.right += f;
        this.k.top -= ratioY;
        if (d()) {
            float frameW = this.U - getFrameW();
            this.k.right += frameW;
            this.k.top -= (frameW * getRatioY()) / getRatioX();
        }
        if (e()) {
            float frameH = this.U - getFrameH();
            this.k.top -= frameH;
            this.k.right += (frameH * getRatioX()) / getRatioY();
        }
        if (!a(this.k.right)) {
            float f3 = this.k.right - this.l.right;
            this.k.right -= f3;
            this.k.top += (f3 * getRatioY()) / getRatioX();
        }
        if (b(this.k.top)) {
            return;
        }
        float f4 = this.l.top - this.k.top;
        this.k.top += f4;
        this.k.right -= (f4 * getRatioX()) / getRatioY();
    }

    private void j(float f, float f2) {
        if (this.R == CropMode.FREE) {
            this.k.left += f;
            this.k.bottom += f2;
            if (d()) {
                this.k.left -= this.U - getFrameW();
            }
            if (e()) {
                this.k.bottom += this.U - getFrameH();
            }
            b();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        this.k.left += f;
        this.k.bottom -= ratioY;
        if (d()) {
            float frameW = this.U - getFrameW();
            this.k.left -= frameW;
            this.k.bottom += (frameW * getRatioY()) / getRatioX();
        }
        if (e()) {
            float frameH = this.U - getFrameH();
            this.k.bottom += frameH;
            this.k.left -= (frameH * getRatioX()) / getRatioY();
        }
        if (!a(this.k.left)) {
            float f3 = this.l.left - this.k.left;
            this.k.left += f3;
            this.k.bottom -= (f3 * getRatioY()) / getRatioX();
        }
        if (b(this.k.bottom)) {
            return;
        }
        float f4 = this.k.bottom - this.l.bottom;
        this.k.bottom -= f4;
        this.k.left += (f4 * getRatioX()) / getRatioY();
    }

    private void k(float f, float f2) {
        if (this.R == CropMode.FREE) {
            this.k.right += f;
            this.k.bottom += f2;
            if (d()) {
                this.k.right += this.U - getFrameW();
            }
            if (e()) {
                this.k.bottom += this.U - getFrameH();
            }
            b();
            return;
        }
        float ratioY = (getRatioY() * f) / getRatioX();
        this.k.right += f;
        this.k.bottom += ratioY;
        if (d()) {
            float frameW = this.U - getFrameW();
            this.k.right += frameW;
            this.k.bottom += (frameW * getRatioY()) / getRatioX();
        }
        if (e()) {
            float frameH = this.U - getFrameH();
            this.k.bottom += frameH;
            this.k.right += (frameH * getRatioX()) / getRatioY();
        }
        if (!a(this.k.right)) {
            float f3 = this.k.right - this.l.right;
            this.k.right -= f3;
            this.k.bottom -= (f3 * getRatioY()) / getRatioX();
        }
        if (b(this.k.bottom)) {
            return;
        }
        float f4 = this.k.bottom - this.l.bottom;
        this.k.bottom -= f4;
        this.k.right -= (f4 * getRatioX()) / getRatioY();
    }

    private void b() {
        float f = this.k.left - this.l.left;
        float f2 = this.k.right - this.l.right;
        float f3 = this.k.top - this.l.top;
        float f4 = this.k.bottom - this.l.bottom;
        if (f < 0.0f) {
            this.k.left -= f;
        }
        if (f2 > 0.0f) {
            this.k.right -= f2;
        }
        if (f3 < 0.0f) {
            this.k.top -= f3;
        }
        if (f4 > 0.0f) {
            this.k.bottom -= f4;
        }
    }

    private void c() {
        float f = this.k.left - this.l.left;
        if (f < 0.0f) {
            this.k.left -= f;
            this.k.right -= f;
        }
        float f2 = this.k.right - this.l.right;
        if (f2 > 0.0f) {
            this.k.left -= f2;
            this.k.right -= f2;
        }
        float f3 = this.k.top - this.l.top;
        if (f3 < 0.0f) {
            this.k.top -= f3;
            this.k.bottom -= f3;
        }
        float f4 = this.k.bottom - this.l.bottom;
        if (f4 > 0.0f) {
            this.k.top -= f4;
            this.k.bottom -= f4;
        }
    }

    private boolean a(float f) {
        return this.l.left <= f && this.l.right >= f;
    }

    private boolean b(float f) {
        return this.l.top <= f && this.l.bottom >= f;
    }

    private boolean d() {
        return getFrameW() < this.U;
    }

    private boolean e() {
        return getFrameH() < this.U;
    }

    private void a(int i) {
        if (this.l == null) {
            return;
        }
        if (this.q) {
            getAnimator().l();
        }
        final RectF rectF = new RectF(this.k);
        final RectF a = a(this.l);
        final float f = a.left - rectF.left;
        final float f2 = a.top - rectF.top;
        final float f3 = a.right - rectF.right;
        final float f4 = a.bottom - rectF.bottom;
        if (this.aj) {
            com.isseiaoki.simplecropview.a.a animator = getAnimator();
            animator.a(new com.isseiaoki.simplecropview.a.b() { // from class: com.isseiaoki.simplecropview.CropImageView.1
                @Override // com.isseiaoki.simplecropview.a.b
                public void j() {
                    CropImageView.this.q = true;
                }

                @Override // com.isseiaoki.simplecropview.a.b
                public void h(float f5) {
                    CropImageView.this.k = new RectF(rectF.left + (f * f5), rectF.top + (f2 * f5), rectF.right + (f3 * f5), rectF.bottom + (f4 * f5));
                    CropImageView.this.invalidate();
                }

                @Override // com.isseiaoki.simplecropview.a.b
                public void k() {
                    CropImageView.this.k = a;
                    CropImageView.this.invalidate();
                    CropImageView.this.q = false;
                }
            });
            animator.a(i);
            return;
        }
        this.k = a(this.l);
        invalidate();
    }

    private float c(float f) {
        switch (this.R) {
            case FIT_IMAGE:
                return this.l.width();
            case FREE:
                return f;
            case RATIO_4_3:
                return 4.0f;
            case RATIO_3_4:
                return 3.0f;
            case RATIO_16_9:
                return 16.0f;
            case RATIO_9_16:
                return 9.0f;
            case SQUARE:
            case CIRCLE:
            case CIRCLE_SQUARE:
                return 1.0f;
            case CUSTOM:
                return this.ab.x;
            default:
                return f;
        }
    }

    private float d(float f) {
        switch (this.R) {
            case FIT_IMAGE:
                return this.l.height();
            case FREE:
                return f;
            case RATIO_4_3:
                return 3.0f;
            case RATIO_3_4:
                return 4.0f;
            case RATIO_16_9:
                return 9.0f;
            case RATIO_9_16:
                return 16.0f;
            case SQUARE:
            case CIRCLE:
            case CIRCLE_SQUARE:
                return 1.0f;
            case CUSTOM:
                return this.ab.y;
            default:
                return f;
        }
    }

    private float getRatioX() {
        int i = AnonymousClass7.aH[this.R.ordinal()];
        if (i == 1) {
            return this.l.width();
        }
        switch (i) {
            case 3:
                return 4.0f;
            case 4:
                return 3.0f;
            case 5:
                return 16.0f;
            case 6:
                return 9.0f;
            case 7:
            case 8:
            case 9:
                return 1.0f;
            case 10:
                return this.ab.x;
            default:
                return 1.0f;
        }
    }

    private float getRatioY() {
        int i = AnonymousClass7.aH[this.R.ordinal()];
        if (i == 1) {
            return this.l.height();
        }
        switch (i) {
            case 3:
                return 3.0f;
            case 4:
                return 4.0f;
            case 5:
                return 9.0f;
            case 6:
                return 16.0f;
            case 7:
            case 8:
            case 9:
                return 1.0f;
            case 10:
                return this.ab.y;
            default:
                return 1.0f;
        }
    }

    private float getDensity() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.isseiaoki.simplecropview.b.a aVar) {
        if (aVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.onError();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.onError();
                }
            });
        }
    }

    private Bitmap getBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private float f(float f) {
        return a(f, this.d, this.e);
    }

    private float g(float f) {
        return b(f, this.d, this.e);
    }

    private Bitmap a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setRotate(this.mAngle, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private com.isseiaoki.simplecropview.a.a getAnimator() {
        f();
        return this.r;
    }

    private void f() {
        if (this.r == null) {
            if (Build.VERSION.SDK_INT < 14) {
                this.r = new com.isseiaoki.simplecropview.a.d(this.mInterpolator);
            } else {
                this.r = new com.isseiaoki.simplecropview.a.c(this.mInterpolator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap g() {
        Bitmap bitmap;
        InputStream inputStream;
        Throwable th;
        Bitmap decodeRegion;
        Bitmap bitmap2;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = getContext().getContentResolver().openInputStream(this.z);
                try {
                    try {
                        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                        int width = newInstance.getWidth();
                        int height = newInstance.getHeight();
                        Rect b = b(width, height);
                        if (this.mAngle != 0.0f) {
                            Matrix matrix = new Matrix();
                            matrix.setRotate(-this.mAngle);
                            RectF rectF = new RectF();
                            matrix.mapRect(rectF, new RectF(b));
                            rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                            b = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        }
                        decodeRegion = newInstance.decodeRegion(b, new BitmapFactory.Options());
                    } catch (Throwable th2) {
                        th = th2;
                        com.isseiaoki.simplecropview.c.b.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    bitmap = null;
                    inputStream2 = inputStream;
                } catch (Exception e2) {
                    e = e2;
                    bitmap = null;
                    inputStream2 = inputStream;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    bitmap = null;
                    inputStream2 = inputStream;
                }
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } catch (IOException e4) {
            e = e4;
            bitmap = null;
        } catch (Exception e5) {
            e = e5;
            bitmap = null;
        } catch (OutOfMemoryError e6) {
            e = e6;
            bitmap = null;
        }
        try {
            if (this.mAngle != 0.0f) {
                bitmap2 = a(decodeRegion);
                decodeRegion.recycle();
            } else {
                bitmap2 = decodeRegion;
            }
            com.isseiaoki.simplecropview.c.b.closeQuietly(inputStream);
            return bitmap2;
        } catch (IOException e7) {
            e = e7;
            inputStream2 = inputStream;
            bitmap = decodeRegion;
            com.isseiaoki.simplecropview.c.a.a("An error occurred while cropping the image: " + e.getMessage(), e);
            com.isseiaoki.simplecropview.c.b.closeQuietly(inputStream2);
            return bitmap;
        } catch (Exception e8) {
            e = e8;
            inputStream2 = inputStream;
            bitmap = decodeRegion;
            com.isseiaoki.simplecropview.c.a.a("An unexpected error has occurred: " + e.getMessage(), e);
            com.isseiaoki.simplecropview.c.b.closeQuietly(inputStream2);
            return bitmap;
        } catch (OutOfMemoryError e9) {
            e = e9;
            inputStream2 = inputStream;
            bitmap = decodeRegion;
            com.isseiaoki.simplecropview.c.a.a("OOM Error: " + e.getMessage(), e);
            com.isseiaoki.simplecropview.c.b.closeQuietly(inputStream2);
            return bitmap;
        }
    }

    private Rect b(int i, int i2) {
        float f = i;
        float f2 = i2;
        float a = a(this.mAngle, f, f2) / this.l.width();
        float f3 = this.l.left * a;
        float f4 = this.l.top * a;
        return new Rect(Math.max(Math.round((this.k.left * a) - f3), 0), Math.max(Math.round((this.k.top * a) - f4), 0), Math.min(Math.round((this.k.right * a) - f3), Math.round(a(this.mAngle, f, f2))), Math.min(Math.round((this.k.bottom * a) - f4), Math.round(b(this.mAngle, f, f2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap b(Bitmap bitmap) {
        int i;
        int i2;
        int round;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float ratioX = getRatioX() / getRatioY();
        int i3 = 0;
        if (this.E > 0) {
            i3 = this.E;
            i = Math.round(this.E / ratioX);
        } else {
            if (this.F > 0) {
                i2 = this.F;
                round = Math.round(this.F * ratioX);
            } else if (this.C <= 0 || this.D <= 0 || (width <= this.C && height <= this.D)) {
                i = 0;
            } else if (this.C / this.D >= ratioX) {
                i2 = this.D;
                round = Math.round(this.D * ratioX);
            } else {
                i3 = this.C;
                i = Math.round(this.C / ratioX);
            }
            int i4 = i2;
            i3 = round;
            i = i4;
        }
        if (i3 <= 0 || i <= 0) {
            return bitmap;
        }
        Bitmap a = com.isseiaoki.simplecropview.c.b.a(bitmap, i3, i);
        if (bitmap != a) {
            bitmap.recycle();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Runnable, com.isseiaoki.simplecropview.CropImageView$3] */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.os.Handler] */
    public void a(Bitmap bitmap, final Uri uri) {
        OutputStream outputStream = 0;
        OutputStream outputStream2 = null;
        try {
            try {
                OutputStream openOutputStream = getContext().getContentResolver().openOutputStream(uri);
                if (openOutputStream != null) {
                    try {
                        bitmap.compress(this.I, this.J, openOutputStream);
                    } catch (IOException e) {
                        e = e;
                        outputStream2 = openOutputStream;
                        com.isseiaoki.simplecropview.c.a.a("An error occurred while saving the image: " + uri, e);
                        a(this.v);
                        com.isseiaoki.simplecropview.c.b.closeQuietly(outputStream2);
                        ?? r4 = this.mHandler;
                        outputStream = new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CropImageView.this.v != null) {
                                    CropImageView.this.v.a(uri);
                                }
                            }
                        };
                        r4.post(outputStream);
                    } catch (Throwable th) {
                        th = th;
                        outputStream = openOutputStream;
                        com.isseiaoki.simplecropview.c.b.closeQuietly(outputStream);
                        throw th;
                    }
                }
                com.isseiaoki.simplecropview.c.b.closeQuietly(openOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
        ?? r42 = this.mHandler;
        outputStream = new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.3
            @Override // java.lang.Runnable
            public void run() {
                if (CropImageView.this.v != null) {
                    CropImageView.this.v.a(uri);
                }
            }
        };
        r42.post(outputStream);
    }

    public Bitmap getImageBitmap() {
        return getBitmap();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f = false;
        super.setImageResource(i);
        h();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f = false;
        super.setImageDrawable(drawable);
        h();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        this.f = false;
        super.setImageURI(uri);
        h();
    }

    private void h() {
        i();
        if (getDrawable() != null) {
            a(this.a, this.c);
        }
    }

    private void i() {
        if (this.O) {
            return;
        }
        this.z = null;
        this.A = null;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.mAngle = this.B;
    }

    public void a(Uri uri, c cVar) {
        this.t = cVar;
        this.z = uri;
        if (uri == null) {
            a(this.t);
            throw new IllegalStateException("Source Uri must not be null.");
        } else {
            this.w.submit(new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.4
                @Override // java.lang.Runnable
                public void run() {
                    CropImageView.this.O = true;
                    CropImageView.this.B = com.isseiaoki.simplecropview.c.b.a(CropImageView.this.getContext(), CropImageView.this.z);
                    int maxSize = com.isseiaoki.simplecropview.c.b.getMaxSize();
                    int max = Math.max(CropImageView.this.a, CropImageView.this.c);
                    if (max != 0) {
                        maxSize = max;
                    }
                    try {
                        final Bitmap a = com.isseiaoki.simplecropview.c.b.a(CropImageView.this.getContext(), CropImageView.this.z, maxSize);
                        CropImageView.this.K = com.isseiaoki.simplecropview.c.b.ch;
                        CropImageView.this.L = com.isseiaoki.simplecropview.c.b.ci;
                        CropImageView.this.mHandler.post(new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CropImageView.this.setImageBitmap(a);
                                if (CropImageView.this.t != null) {
                                    CropImageView.this.t.onSuccess();
                                }
                                CropImageView.this.O = false;
                            }
                        });
                    } catch (Exception e) {
                        com.isseiaoki.simplecropview.c.a.a("An unexpected error has occurred: " + e.getMessage(), e);
                        CropImageView.this.a(CropImageView.this.t);
                        CropImageView.this.O = false;
                    } catch (OutOfMemoryError e2) {
                        com.isseiaoki.simplecropview.c.a.a("OOM Error: " + e2.getMessage(), e2);
                        CropImageView.this.a(CropImageView.this.t);
                        CropImageView.this.O = false;
                    }
                }
            });
        }
    }

    public void a(RotateDegrees rotateDegrees, int i) {
        if (this.p) {
            getAnimator().l();
        }
        final float f = this.mAngle;
        final float value = this.mAngle + rotateDegrees.getValue();
        final float f2 = value - f;
        final float f3 = this.mScale;
        final float a = a(this.a, this.c, value);
        if (this.aj) {
            final float f4 = a - f3;
            com.isseiaoki.simplecropview.a.a animator = getAnimator();
            animator.a(new com.isseiaoki.simplecropview.a.b() { // from class: com.isseiaoki.simplecropview.CropImageView.5
                @Override // com.isseiaoki.simplecropview.a.b
                public void j() {
                    CropImageView.this.p = true;
                }

                @Override // com.isseiaoki.simplecropview.a.b
                public void h(float f5) {
                    CropImageView.this.mAngle = f + (f2 * f5);
                    CropImageView.this.mScale = f3 + (f4 * f5);
                    CropImageView.this.a();
                    CropImageView.this.invalidate();
                }

                @Override // com.isseiaoki.simplecropview.a.b
                public void k() {
                    CropImageView.this.mAngle = value % 360.0f;
                    CropImageView.this.mScale = a;
                    CropImageView.this.a(CropImageView.this.a, CropImageView.this.c);
                    CropImageView.this.p = false;
                }
            });
            animator.a(i);
            return;
        }
        this.mAngle = value % 360.0f;
        this.mScale = a;
        a(this.a, this.c);
    }

    public void a(RotateDegrees rotateDegrees) {
        a(rotateDegrees, this.ak);
    }

    public Bitmap getCroppedBitmap() {
        Bitmap bitmap = getBitmap();
        if (bitmap == null) {
            return null;
        }
        Bitmap a = a(bitmap);
        Rect b = b(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(a, b.left, b.top, b.width(), b.height(), (Matrix) null, false);
        if (a != bitmap) {
            a.recycle();
        }
        return this.R == CropMode.CIRCLE ? c(createBitmap) : createBitmap;
    }

    public Bitmap c(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawCircle(width, height, Math.min(width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public void a(Uri uri, b bVar, d dVar) {
        this.A = uri;
        this.u = bVar;
        this.v = dVar;
        if (this.H) {
            a(this.u);
            a(this.v);
            return;
        }
        this.H = true;
        this.w.submit(new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.6
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap g;
                if (CropImageView.this.z != null) {
                    g = CropImageView.this.g();
                    if (CropImageView.this.R == CropMode.CIRCLE) {
                        g = CropImageView.this.c(g);
                    }
                } else {
                    g = CropImageView.this.getCroppedBitmap();
                }
                if (g != null) {
                    g = CropImageView.this.b(g);
                    CropImageView.this.M = g.getWidth();
                    CropImageView.this.N = g.getHeight();
                    CropImageView.this.mHandler.post(new Runnable() { // from class: com.isseiaoki.simplecropview.CropImageView.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CropImageView.this.u != null) {
                                CropImageView.this.u.d(g);
                            }
                            if (CropImageView.this.G) {
                                CropImageView.this.invalidate();
                            }
                        }
                    });
                } else {
                    CropImageView.this.a(CropImageView.this.u);
                }
                if (CropImageView.this.A == null) {
                    CropImageView.this.a(CropImageView.this.v);
                    return;
                }
                CropImageView.this.a(g, CropImageView.this.A);
                CropImageView.this.H = false;
            }
        });
    }

    public RectF getActualCropRect() {
        float f = this.l.left / this.mScale;
        float f2 = this.l.top / this.mScale;
        return new RectF((this.k.left / this.mScale) - f, (this.k.top / this.mScale) - f2, (this.k.right / this.mScale) - f, (this.k.bottom / this.mScale) - f2);
    }

    public void a(CropMode cropMode, int i) {
        if (cropMode == CropMode.CUSTOM) {
            c(1, 1);
            return;
        }
        this.R = cropMode;
        a(i);
    }

    public void setCropMode(CropMode cropMode) {
        a(cropMode, this.ak);
    }

    public void a(int i, int i2, int i3) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.R = CropMode.CUSTOM;
        this.ab = new PointF(i, i2);
        a(i3);
    }

    public void c(int i, int i2) {
        a(i, i2, this.ak);
    }

    public void setOverlayColor(int i) {
        this.ae = i;
        invalidate();
    }

    public void setFrameColor(int i) {
        this.af = i;
        invalidate();
    }

    public void setHandleColor(int i) {
        this.ag = i;
        invalidate();
    }

    public void setGuideColor(int i) {
        this.ah = i;
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        invalidate();
    }

    public void setMinFrameSizeInDp(int i) {
        this.U = i * getDensity();
    }

    public void setMinFrameSizeInPx(int i) {
        this.U = i;
    }

    public void setHandleSizeInDp(int i) {
        this.V = (int) (i * getDensity());
    }

    public void setTouchPaddingInDp(int i) {
        this.W = (int) (i * getDensity());
    }

    public void setGuideShowMode(ShowMode showMode) {
        this.S = showMode;
        switch (showMode) {
            case SHOW_ALWAYS:
                this.a_ = true;
                break;
            case NOT_SHOW:
            case SHOW_ON_TOUCH:
                this.a_ = false;
                break;
        }
        invalidate();
    }

    public void setHandleShowMode(ShowMode showMode) {
        this.T = showMode;
        switch (showMode) {
            case SHOW_ALWAYS:
                this.b_ = true;
                break;
            case NOT_SHOW:
            case SHOW_ON_TOUCH:
                this.b_ = false;
                break;
        }
        invalidate();
    }

    public void setFrameStrokeWeightInDp(int i) {
        this.ac = i * getDensity();
        invalidate();
    }

    public void setGuideStrokeWeightInDp(int i) {
        this.ad = i * getDensity();
        invalidate();
    }

    public void setCropEnabled(boolean z) {
        this.c_ = z;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.aa = z;
    }

    public void setInitialFrameScale(float f) {
        this.ai = a(f, 0.01f, 1.0f, 1.0f);
    }

    public void setAnimationEnabled(boolean z) {
        this.aj = z;
    }

    public void setAnimationDuration(int i) {
        this.ak = i;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        this.r = null;
        f();
    }

    public void setDebug(boolean z) {
        this.G = z;
        invalidate();
    }

    public void setLoggingEnabled(boolean z) {
        com.isseiaoki.simplecropview.c.a.enabled = z;
    }

    public void setLoadCallback(c cVar) {
        this.t = cVar;
    }

    public void setCropCallback(b bVar) {
        this.u = bVar;
    }

    public void setSaveCallback(d dVar) {
        this.v = dVar;
    }

    public void setOutputWidth(int i) {
        this.E = i;
        this.F = 0;
    }

    public void setOutputHeight(int i) {
        this.F = i;
        this.E = 0;
    }

    public void d(int i, int i2) {
        this.C = i;
        this.D = i2;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.I = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.J = i;
    }

    public void setHandleShadowEnabled(boolean z) {
        this.al = z;
    }

    private void setScale(float f) {
        this.mScale = f;
    }

    private void setCenter(PointF pointF) {
        this.m = pointF;
    }

    private float getFrameW() {
        return this.k.right - this.k.left;
    }

    private float getFrameH() {
        return this.k.bottom - this.k.top;
    }

    /* loaded from: classes.dex */
    public enum CropMode {
        FIT_IMAGE(0),
        RATIO_4_3(1),
        RATIO_3_4(2),
        SQUARE(3),
        RATIO_16_9(4),
        RATIO_9_16(5),
        FREE(6),
        CUSTOM(7),
        CIRCLE(8),
        CIRCLE_SQUARE(9);
        
        private final int aT;

        CropMode(int i) {
            this.aT = i;
        }

        public int getId() {
            return this.aT;
        }
    }

    /* loaded from: classes.dex */
    public enum ShowMode {
        SHOW_ALWAYS(1),
        SHOW_ON_TOUCH(2),
        NOT_SHOW(3);
        
        private final int aT;

        ShowMode(int i) {
            this.aT = i;
        }

        public int getId() {
            return this.aT;
        }
    }

    /* loaded from: classes.dex */
    public enum RotateDegrees {
        ROTATE_90D(90),
        ROTATE_180D(180),
        ROTATE_270D(270),
        ROTATE_M90D(-90),
        ROTATE_M180D(-180),
        ROTATE_M270D(-270);
        
        private final int bb;

        RotateDegrees(int i) {
            this.bb = i;
        }

        public int getValue() {
            return this.bb;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.isseiaoki.simplecropview.CropImageView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int animationDuration;
        Bitmap.CompressFormat bA;
        int bB;
        boolean bC;
        int bD;
        int bE;
        int bF;
        int bG;
        boolean bH;
        int bI;
        int bJ;
        int bK;
        int bL;
        int backgroundColor;
        Bitmap bd;
        CropMode be;
        int bf;
        int bg;
        ShowMode bh;
        ShowMode bi;
        boolean bj;
        boolean bk;
        int bl;
        int bm;
        float bn;
        float bo;
        float bp;
        float bq;
        float br;
        boolean bs;
        int bt;
        int bu;
        float bv;
        float bw;
        boolean bx;
        Uri by;
        Uri bz;
        int exifRotation;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bd = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            this.be = (CropMode) parcel.readSerializable();
            this.backgroundColor = parcel.readInt();
            this.bf = parcel.readInt();
            this.bg = parcel.readInt();
            this.bh = (ShowMode) parcel.readSerializable();
            this.bi = (ShowMode) parcel.readSerializable();
            this.bj = parcel.readInt() != 0;
            this.bk = parcel.readInt() != 0;
            this.bl = parcel.readInt();
            this.bm = parcel.readInt();
            this.bn = parcel.readFloat();
            this.bo = parcel.readFloat();
            this.bp = parcel.readFloat();
            this.bq = parcel.readFloat();
            this.br = parcel.readFloat();
            this.bs = parcel.readInt() != 0;
            this.bt = parcel.readInt();
            this.bu = parcel.readInt();
            this.bv = parcel.readFloat();
            this.bw = parcel.readFloat();
            this.bx = parcel.readInt() != 0;
            this.animationDuration = parcel.readInt();
            this.exifRotation = parcel.readInt();
            this.by = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.bz = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.bA = (Bitmap.CompressFormat) parcel.readSerializable();
            this.bB = parcel.readInt();
            this.bC = parcel.readInt() != 0;
            this.bD = parcel.readInt();
            this.bE = parcel.readInt();
            this.bF = parcel.readInt();
            this.bG = parcel.readInt();
            this.bH = parcel.readInt() != 0;
            this.bI = parcel.readInt();
            this.bJ = parcel.readInt();
            this.bK = parcel.readInt();
            this.bL = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.bd, i);
            parcel.writeSerializable(this.be);
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.bf);
            parcel.writeInt(this.bg);
            parcel.writeSerializable(this.bh);
            parcel.writeSerializable(this.bi);
            parcel.writeInt(this.bj ? 1 : 0);
            parcel.writeInt(this.bk ? 1 : 0);
            parcel.writeInt(this.bl);
            parcel.writeInt(this.bm);
            parcel.writeFloat(this.bn);
            parcel.writeFloat(this.bo);
            parcel.writeFloat(this.bp);
            parcel.writeFloat(this.bq);
            parcel.writeFloat(this.br);
            parcel.writeInt(this.bs ? 1 : 0);
            parcel.writeInt(this.bt);
            parcel.writeInt(this.bu);
            parcel.writeFloat(this.bv);
            parcel.writeFloat(this.bw);
            parcel.writeInt(this.bx ? 1 : 0);
            parcel.writeInt(this.animationDuration);
            parcel.writeInt(this.exifRotation);
            parcel.writeParcelable(this.by, i);
            parcel.writeParcelable(this.bz, i);
            parcel.writeSerializable(this.bA);
            parcel.writeInt(this.bB);
            parcel.writeInt(this.bC ? 1 : 0);
            parcel.writeInt(this.bD);
            parcel.writeInt(this.bE);
            parcel.writeInt(this.bF);
            parcel.writeInt(this.bG);
            parcel.writeInt(this.bH ? 1 : 0);
            parcel.writeInt(this.bI);
            parcel.writeInt(this.bJ);
            parcel.writeInt(this.bK);
            parcel.writeInt(this.bL);
        }
    }
}
