.class abstract Lcom/soundcloud/android/crop/ImageViewTouchBase;
.super Landroid/widget/ImageView;
.source "ImageViewTouchBase.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/soundcloud/android/crop/ImageViewTouchBase$a;
    }
.end annotation


# instance fields
.field protected handler:Landroid/os/Handler;

.field protected wc:Landroid/graphics/Matrix;

.field protected wd:Landroid/graphics/Matrix;

.field private final we:Landroid/graphics/Matrix;

.field private final wf:[F

.field protected final wg:Lcom/soundcloud/android/crop/e;

.field wh:I

.field wi:I

.field wj:F

.field private wk:Ljava/lang/Runnable;

.field private wl:Lcom/soundcloud/android/crop/ImageViewTouchBase$a;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .line 80
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 43
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    .line 50
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    .line 54
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->we:Landroid/graphics/Matrix;

    const/16 p1, 0x9

    .line 57
    new-array p1, p1, [F

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wf:[F

    .line 60
    new-instance p1, Lcom/soundcloud/android/crop/e;

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p1, v0, v1}, Lcom/soundcloud/android/crop/e;-><init>(Landroid/graphics/Bitmap;I)V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    const/4 p1, -0x1

    .line 62
    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wh:I

    .line 63
    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wi:I

    .line 69
    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->handler:Landroid/os/Handler;

    .line 81
    invoke-direct {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->init()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .line 85
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    .line 50
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    .line 54
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->we:Landroid/graphics/Matrix;

    const/16 p1, 0x9

    .line 57
    new-array p1, p1, [F

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wf:[F

    .line 60
    new-instance p1, Lcom/soundcloud/android/crop/e;

    const/4 p2, 0x0

    const/4 v0, 0x0

    invoke-direct {p1, p2, v0}, Lcom/soundcloud/android/crop/e;-><init>(Landroid/graphics/Bitmap;I)V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    const/4 p1, -0x1

    .line 62
    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wh:I

    .line 63
    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wi:I

    .line 69
    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->handler:Landroid/os/Handler;

    .line 86
    invoke-direct {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->init()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .line 90
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 43
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    .line 50
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    .line 54
    new-instance p1, Landroid/graphics/Matrix;

    invoke-direct {p1}, Landroid/graphics/Matrix;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->we:Landroid/graphics/Matrix;

    const/16 p1, 0x9

    .line 57
    new-array p1, p1, [F

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wf:[F

    .line 60
    new-instance p1, Lcom/soundcloud/android/crop/e;

    const/4 p2, 0x0

    const/4 p3, 0x0

    invoke-direct {p1, p2, p3}, Lcom/soundcloud/android/crop/e;-><init>(Landroid/graphics/Bitmap;I)V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    const/4 p1, -0x1

    .line 62
    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wh:I

    .line 63
    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wi:I

    .line 69
    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->handler:Landroid/os/Handler;

    .line 91
    invoke-direct {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->init()V

    return-void
.end method

.method private a(Landroid/graphics/RectF;FF)F
    .locals 2

    .line 221
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getHeight()I

    move-result v0

    int-to-float v0, v0

    cmpg-float v1, p2, v0

    if-gez v1, :cond_0

    sub-float/2addr v0, p2

    const/high16 p2, 0x40000000    # 2.0f

    div-float/2addr v0, p2

    .line 223
    iget p1, p1, Landroid/graphics/RectF;->top:F

    sub-float p3, v0, p1

    goto :goto_0

    .line 224
    :cond_0
    iget p2, p1, Landroid/graphics/RectF;->top:F

    const/4 v1, 0x0

    cmpl-float p2, p2, v1

    if-lez p2, :cond_1

    .line 225
    iget p1, p1, Landroid/graphics/RectF;->top:F

    neg-float p3, p1

    goto :goto_0

    .line 226
    :cond_1
    iget p2, p1, Landroid/graphics/RectF;->bottom:F

    cmpg-float p2, p2, v0

    if-gez p2, :cond_2

    .line 227
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getHeight()I

    move-result p2

    int-to-float p2, p2

    iget p1, p1, Landroid/graphics/RectF;->bottom:F

    sub-float p3, p2, p1

    :cond_2
    :goto_0
    return p3
.end method

.method private a(Landroid/graphics/Bitmap;I)V
    .locals 2

    .line 142
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 143
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 145
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setDither(Z)V

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v0}, Lcom/soundcloud/android/crop/e;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 149
    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v1, p1}, Lcom/soundcloud/android/crop/e;->setBitmap(Landroid/graphics/Bitmap;)V

    .line 150
    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v1, p2}, Lcom/soundcloud/android/crop/e;->setRotation(I)V

    if-eqz v0, :cond_1

    if-eq v0, p1, :cond_1

    .line 152
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wl:Lcom/soundcloud/android/crop/ImageViewTouchBase$a;

    if-eqz p1, :cond_1

    .line 153
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wl:Lcom/soundcloud/android/crop/ImageViewTouchBase$a;

    invoke-interface {p1, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase$a;->i(Landroid/graphics/Bitmap;)V

    :cond_1
    return-void
.end method

.method private a(Lcom/soundcloud/android/crop/e;Landroid/graphics/Matrix;Z)V
    .locals 7

    .line 264
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getWidth()I

    move-result v0

    int-to-float v0, v0

    .line 265
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getHeight()I

    move-result v1

    int-to-float v1, v1

    .line 267
    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->getWidth()I

    move-result v2

    int-to-float v2, v2

    .line 268
    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->getHeight()I

    move-result v3

    int-to-float v3, v3

    .line 269
    invoke-virtual {p2}, Landroid/graphics/Matrix;->reset()V

    div-float v4, v0, v2

    const/high16 v5, 0x40400000    # 3.0f

    .line 272
    invoke-static {v4, v5}, Ljava/lang/Math;->min(FF)F

    move-result v4

    div-float v6, v1, v3

    .line 273
    invoke-static {v6, v5}, Ljava/lang/Math;->min(FF)F

    move-result v5

    .line 274
    invoke-static {v4, v5}, Ljava/lang/Math;->min(FF)F

    move-result v4

    if-eqz p3, :cond_0

    .line 277
    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->er()Landroid/graphics/Matrix;

    move-result-object p1

    invoke-virtual {p2, p1}, Landroid/graphics/Matrix;->postConcat(Landroid/graphics/Matrix;)Z

    .line 279
    :cond_0
    invoke-virtual {p2, v4, v4}, Landroid/graphics/Matrix;->postScale(FF)Z

    mul-float v2, v2, v4

    sub-float/2addr v0, v2

    const/high16 p1, 0x40000000    # 2.0f

    div-float/2addr v0, p1

    mul-float v3, v3, v4

    sub-float/2addr v1, v3

    div-float/2addr v1, p1

    .line 280
    invoke-virtual {p2, v0, v1}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    return-void
.end method

.method private b(Landroid/graphics/RectF;FF)F
    .locals 2

    .line 233
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getWidth()I

    move-result v0

    int-to-float v0, v0

    cmpg-float v1, p2, v0

    if-gez v1, :cond_0

    sub-float/2addr v0, p2

    const/high16 p2, 0x40000000    # 2.0f

    div-float/2addr v0, p2

    .line 235
    iget p1, p1, Landroid/graphics/RectF;->left:F

    sub-float p3, v0, p1

    goto :goto_0

    .line 236
    :cond_0
    iget p2, p1, Landroid/graphics/RectF;->left:F

    const/4 v1, 0x0

    cmpl-float p2, p2, v1

    if-lez p2, :cond_1

    .line 237
    iget p1, p1, Landroid/graphics/RectF;->left:F

    neg-float p3, p1

    goto :goto_0

    .line 238
    :cond_1
    iget p2, p1, Landroid/graphics/RectF;->right:F

    cmpg-float p2, p2, v0

    if-gez p2, :cond_2

    .line 239
    iget p1, p1, Landroid/graphics/RectF;->right:F

    sub-float p3, v0, p1

    :cond_2
    :goto_0
    return p3
.end method

.method private init()V
    .locals 1

    .line 245
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    return-void
.end method


# virtual methods
.method protected a(Landroid/graphics/Matrix;)F
    .locals 1

    const/4 v0, 0x0

    .line 255
    invoke-virtual {p0, p1, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Landroid/graphics/Matrix;I)F

    move-result p1

    return p1
.end method

.method protected a(Landroid/graphics/Matrix;I)F
    .locals 1

    .line 249
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wf:[F

    invoke-virtual {p1, v0}, Landroid/graphics/Matrix;->getValues([F)V

    .line 250
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wf:[F

    aget p1, p1, p2

    return p1
.end method

.method public a(Landroid/graphics/Bitmap;Z)V
    .locals 2

    .line 165
    new-instance v0, Lcom/soundcloud/android/crop/e;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/soundcloud/android/crop/e;-><init>(Landroid/graphics/Bitmap;I)V

    invoke-virtual {p0, v0, p2}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Lcom/soundcloud/android/crop/e;Z)V

    return-void
.end method

.method public a(Lcom/soundcloud/android/crop/e;Z)V
    .locals 2

    .line 169
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getWidth()I

    move-result v0

    if-gtz v0, :cond_0

    .line 172
    new-instance v0, Lcom/soundcloud/android/crop/ImageViewTouchBase$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/soundcloud/android/crop/ImageViewTouchBase$1;-><init>(Lcom/soundcloud/android/crop/ImageViewTouchBase;Lcom/soundcloud/android/crop/e;Z)V

    iput-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wk:Ljava/lang/Runnable;

    return-void

    .line 180
    :cond_0
    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 181
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Lcom/soundcloud/android/crop/e;Landroid/graphics/Matrix;Z)V

    .line 182
    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->getRotation()I

    move-result p1

    invoke-direct {p0, v0, p1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Landroid/graphics/Bitmap;I)V

    goto :goto_0

    .line 184
    :cond_1
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    invoke-virtual {p1}, Landroid/graphics/Matrix;->reset()V

    const/4 p1, 0x0

    .line 185
    invoke-virtual {p0, p1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setImageBitmap(Landroid/graphics/Bitmap;)V

    :goto_0
    if-eqz p2, :cond_2

    .line 189
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    invoke-virtual {p1}, Landroid/graphics/Matrix;->reset()V

    .line 191
    :cond_2
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 192
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->eq()F

    move-result p1

    iput p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wj:F

    return-void
.end method

.method protected c(FFF)V
    .locals 1

    .line 310
    iget v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wj:F

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    .line 311
    iget p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wj:F

    .line 314
    :cond_0
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getScale()F

    move-result v0

    div-float/2addr p1, v0

    .line 317
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p1, p2, p3}, Landroid/graphics/Matrix;->postScale(FFFF)Z

    .line 318
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 319
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->ep()V

    return-void
.end method

.method public clear()V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 158
    invoke-virtual {p0, v0, v1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Landroid/graphics/Bitmap;Z)V

    return-void
.end method

.method protected d(FFFF)V
    .locals 10

    .line 324
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getScale()F

    move-result v0

    sub-float/2addr p1, v0

    div-float v6, p1, p4

    .line 325
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getScale()F

    move-result v5

    .line 326
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 328
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->handler:Landroid/os/Handler;

    new-instance v9, Lcom/soundcloud/android/crop/ImageViewTouchBase$2;

    move-object v0, v9

    move-object v1, p0

    move v2, p4

    move v7, p2

    move v8, p3

    invoke-direct/range {v0 .. v8}, Lcom/soundcloud/android/crop/ImageViewTouchBase$2;-><init>(Lcom/soundcloud/android/crop/ImageViewTouchBase;FJFFFF)V

    invoke-virtual {p1, v9}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method protected ep()V
    .locals 5

    .line 199
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v0}, Lcom/soundcloud/android/crop/e;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    .line 203
    :cond_0
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v1

    .line 205
    new-instance v2, Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    int-to-float v0, v0

    const/4 v4, 0x0

    invoke-direct {v2, v4, v4, v3, v0}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 206
    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 208
    invoke-virtual {v2}, Landroid/graphics/RectF;->height()F

    move-result v0

    .line 209
    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v1

    .line 213
    invoke-direct {p0, v2, v0, v4}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Landroid/graphics/RectF;FF)F

    move-result v0

    .line 214
    invoke-direct {p0, v2, v1, v4}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->b(Landroid/graphics/RectF;FF)F

    move-result v1

    .line 216
    invoke-virtual {p0, v1, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->l(FF)V

    .line 217
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setImageMatrix(Landroid/graphics/Matrix;)V

    return-void
.end method

.method protected eq()F
    .locals 3

    .line 300
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v0}, Lcom/soundcloud/android/crop/e;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-nez v0, :cond_0

    const/high16 v0, 0x3f800000    # 1.0f

    return v0

    .line 304
    :cond_0
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v0}, Lcom/soundcloud/android/crop/e;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iget v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wh:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    .line 305
    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {v1}, Lcom/soundcloud/android/crop/e;->getHeight()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wi:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    .line 306
    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    const/high16 v1, 0x40800000    # 4.0f

    mul-float v0, v0, v1

    return v0
.end method

.method protected getImageViewMatrix()Landroid/graphics/Matrix;
    .locals 2

    .line 287
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->we:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 288
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->we:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->postConcat(Landroid/graphics/Matrix;)Z

    .line 289
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->we:Landroid/graphics/Matrix;

    return-object v0
.end method

.method protected getScale()F
    .locals 1

    .line 259
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Landroid/graphics/Matrix;)F

    move-result v0

    return v0
.end method

.method public getUnrotatedMatrix()Landroid/graphics/Matrix;
    .locals 3

    .line 293
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    .line 294
    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    const/4 v2, 0x0

    invoke-direct {p0, v1, v0, v2}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Lcom/soundcloud/android/crop/e;Landroid/graphics/Matrix;Z)V

    .line 295
    iget-object v1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->postConcat(Landroid/graphics/Matrix;)Z

    return-object v0
.end method

.method protected l(FF)V
    .locals 1

    .line 393
    iget-object v0, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wd:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    return-void
.end method

.method protected n(F)V
    .locals 3

    .line 343
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getWidth()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x40000000    # 2.0f

    div-float/2addr v0, v1

    .line 344
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getHeight()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v2, v1

    .line 345
    invoke-virtual {p0, p1, v0, v2}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->c(FFF)V

    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1

    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 116
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 117
    invoke-virtual {p2}, Landroid/view/KeyEvent;->startTracking()V

    const/4 p1, 0x1

    return p1

    .line 120
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result p1

    return p1
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 2

    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 125
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isTracking()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Landroid/view/KeyEvent;->isCanceled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 126
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getScale()F

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 129
    invoke-virtual {p0, v1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->n(F)V

    const/4 p1, 0x1

    return p1

    .line 133
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result p1

    return p1
.end method

.method protected onLayout(ZIIII)V
    .locals 0

    .line 100
    invoke-super/range {p0 .. p5}, Landroid/widget/ImageView;->onLayout(ZIIII)V

    sub-int/2addr p4, p2

    .line 101
    iput p4, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wh:I

    sub-int/2addr p5, p3

    .line 102
    iput p5, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wi:I

    .line 103
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wk:Ljava/lang/Runnable;

    if-eqz p1, :cond_0

    const/4 p2, 0x0

    .line 105
    iput-object p2, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wk:Ljava/lang/Runnable;

    .line 106
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 108
    :cond_0
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    invoke-virtual {p1}, Lcom/soundcloud/android/crop/e;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object p1

    if-eqz p1, :cond_1

    .line 109
    iget-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wg:Lcom/soundcloud/android/crop/e;

    iget-object p2, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wc:Landroid/graphics/Matrix;

    const/4 p3, 0x1

    invoke-direct {p0, p1, p2, p3}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Lcom/soundcloud/android/crop/e;Landroid/graphics/Matrix;Z)V

    .line 110
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setImageMatrix(Landroid/graphics/Matrix;)V

    :cond_1
    return-void
.end method

.method protected p(FF)V
    .locals 0

    .line 397
    invoke-virtual {p0, p1, p2}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->l(FF)V

    .line 398
    invoke-virtual {p0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->setImageMatrix(Landroid/graphics/Matrix;)V

    return-void
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 1

    const/4 v0, 0x0

    .line 138
    invoke-direct {p0, p1, v0}, Lcom/soundcloud/android/crop/ImageViewTouchBase;->a(Landroid/graphics/Bitmap;I)V

    return-void
.end method

.method public setRecycler(Lcom/soundcloud/android/crop/ImageViewTouchBase$a;)V
    .locals 0

    .line 95
    iput-object p1, p0, Lcom/soundcloud/android/crop/ImageViewTouchBase;->wl:Lcom/soundcloud/android/crop/ImageViewTouchBase$a;

    return-void
.end method
