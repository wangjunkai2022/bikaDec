.class public Lcom/makeramen/roundedimageview/b;
.super Landroid/graphics/drawable/Drawable;
.source "RoundedDrawable.java"


# instance fields
.field private gA:Z

.field private final gB:[Z

.field private gC:Z

.field private gD:Landroid/content/res/ColorStateList;

.field private gE:Landroid/widget/ImageView$ScaleType;

.field private final gt:Landroid/graphics/RectF;

.field private final gu:Landroid/graphics/RectF;

.field private final gv:Landroid/graphics/RectF;

.field private gw:Landroid/graphics/Shader$TileMode;

.field private gz:Landroid/graphics/Shader$TileMode;

.field private final mBitmap:Landroid/graphics/Bitmap;

.field private final mBitmapHeight:I

.field private final mBitmapPaint:Landroid/graphics/Paint;

.field private final mBitmapWidth:I

.field private final mBorderPaint:Landroid/graphics/Paint;

.field private final mBorderRect:Landroid/graphics/RectF;

.field private mBorderWidth:F

.field private mCornerRadius:F

.field private final mDrawableRect:Landroid/graphics/RectF;

.field private final mShaderMatrix:Landroid/graphics/Matrix;


# direct methods
.method public constructor <init>(Landroid/graphics/Bitmap;)V
    .locals 5

    .line 73
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 48
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    .line 49
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    .line 50
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    .line 55
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    .line 57
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    .line 58
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    .line 60
    sget-object v0, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->gw:Landroid/graphics/Shader$TileMode;

    .line 61
    sget-object v0, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    iput-object v0, p0, Lcom/makeramen/roundedimageview/b;->gz:Landroid/graphics/Shader$TileMode;

    const/4 v0, 0x1

    .line 62
    iput-boolean v0, p0, Lcom/makeramen/roundedimageview/b;->gA:Z

    const/4 v1, 0x0

    .line 65
    iput v1, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    const/4 v2, 0x4

    .line 66
    new-array v2, v2, [Z

    fill-array-data v2, :array_0

    iput-object v2, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x0

    .line 68
    iput-boolean v2, p0, Lcom/makeramen/roundedimageview/b;->gC:Z

    .line 69
    iput v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    const/high16 v2, -0x1000000

    .line 70
    invoke-static {v2}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    iput-object v3, p0, Lcom/makeramen/roundedimageview/b;->gD:Landroid/content/res/ColorStateList;

    .line 71
    sget-object v3, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    iput-object v3, p0, Lcom/makeramen/roundedimageview/b;->gE:Landroid/widget/ImageView$ScaleType;

    .line 74
    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBitmap:Landroid/graphics/Bitmap;

    .line 76
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    iput v3, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    .line 77
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result p1

    iput p1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    .line 78
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v3, v3

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v4, v4

    invoke-virtual {p1, v1, v1, v3, v4}, Landroid/graphics/RectF;->set(FFFF)V

    .line 80
    new-instance p1, Landroid/graphics/Paint;

    invoke-direct {p1}, Landroid/graphics/Paint;-><init>()V

    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    .line 81
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 82
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 84
    new-instance p1, Landroid/graphics/Paint;

    invoke-direct {p1}, Landroid/graphics/Paint;-><init>()V

    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    .line 85
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 86
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 87
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gD:Landroid/content/res/ColorStateList;

    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->getState()[I

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 88
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    return-void

    :array_0
    .array-data 1
        0x1t
        0x1t
        0x1t
        0x1t
    .end array-data
.end method

.method public static a(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .locals 4

    if-eqz p0, :cond_3

    .line 101
    instance-of v0, p0, Lcom/makeramen/roundedimageview/b;

    if-eqz v0, :cond_0

    return-object p0

    .line 104
    :cond_0
    instance-of v0, p0, Landroid/graphics/drawable/LayerDrawable;

    if-eqz v0, :cond_2

    .line 105
    check-cast p0, Landroid/graphics/drawable/LayerDrawable;

    .line 106
    invoke-virtual {p0}, Landroid/graphics/drawable/LayerDrawable;->getNumberOfLayers()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 110
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/LayerDrawable;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 111
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/LayerDrawable;->getId(I)I

    move-result v3

    invoke-static {v2}, Lcom/makeramen/roundedimageview/b;->a(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {p0, v3, v2}, Landroid/graphics/drawable/LayerDrawable;->setDrawableByLayerId(ILandroid/graphics/drawable/Drawable;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    return-object p0

    .line 117
    :cond_2
    invoke-static {p0}, Lcom/makeramen/roundedimageview/b;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 119
    new-instance p0, Lcom/makeramen/roundedimageview/b;

    invoke-direct {p0, v0}, Lcom/makeramen/roundedimageview/b;-><init>(Landroid/graphics/Bitmap;)V

    return-object p0

    :cond_3
    return-object p0
.end method

.method private static a([Z)Z
    .locals 4

    .line 615
    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    aget-boolean v3, p0, v2

    if-eqz v3, :cond_0

    const/4 p0, 0x1

    return p0

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return v1
.end method

.method public static b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 5

    .line 126
    instance-of v0, p0, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v0, :cond_0

    .line 127
    check-cast p0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0

    .line 131
    :cond_0
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    const/4 v1, 0x2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 132
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    invoke-static {v2, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 134
    :try_start_0
    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 135
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 136
    invoke-virtual {v1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v2

    invoke-virtual {v1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {p0, v4, v4, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 137
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p0

    .line 139
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    const-string p0, "RoundedDrawable"

    const-string v0, "Failed to create bitmap from drawable!"

    .line 140
    invoke-static {p0, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method private static b([Z)Z
    .locals 4

    .line 622
    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    aget-boolean v3, p0, v2

    if-eqz v3, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    const/4 p0, 0x1

    return p0
.end method

.method public static e(Landroid/graphics/Bitmap;)Lcom/makeramen/roundedimageview/b;
    .locals 1

    if-eqz p0, :cond_0

    .line 93
    new-instance v0, Lcom/makeramen/roundedimageview/b;

    invoke-direct {v0, p0}, Lcom/makeramen/roundedimageview/b;-><init>(Landroid/graphics/Bitmap;)V

    return-object v0

    :cond_0
    const/4 p0, 0x0

    return-object p0
.end method

.method private h(Landroid/graphics/Canvas;)V
    .locals 8

    .line 311
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    invoke-static {v0}, Lcom/makeramen/roundedimageview/b;->b([Z)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 316
    :cond_0
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_1

    return-void

    .line 320
    :cond_1
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->left:F

    .line 321
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget v1, v1, Landroid/graphics/RectF;->top:F

    .line 322
    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v2

    add-float/2addr v2, v0

    .line 323
    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    add-float/2addr v3, v1

    .line 324
    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    .line 326
    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v6, 0x0

    aget-boolean v5, v5, v6

    if-nez v5, :cond_2

    .line 327
    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    add-float v6, v0, v4

    add-float v7, v1, v4

    invoke-virtual {v5, v0, v1, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 328
    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    iget-object v6, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v5, v6}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 331
    :cond_2
    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v6, 0x1

    aget-boolean v5, v5, v6

    if-nez v5, :cond_3

    .line 332
    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    sub-float v6, v2, v4

    invoke-virtual {v5, v6, v1, v2, v4}, Landroid/graphics/RectF;->set(FFFF)V

    .line 333
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 336
    :cond_3
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v5, 0x2

    aget-boolean v1, v1, v5

    if-nez v1, :cond_4

    .line 337
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    sub-float v5, v2, v4

    sub-float v6, v3, v4

    invoke-virtual {v1, v5, v6, v2, v3}, Landroid/graphics/RectF;->set(FFFF)V

    .line 338
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 341
    :cond_4
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x3

    aget-boolean v1, v1, v2

    if-nez v1, :cond_5

    .line 342
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    sub-float v2, v3, v4

    add-float/2addr v4, v0

    invoke-virtual {v1, v0, v2, v4, v3}, Landroid/graphics/RectF;->set(FFFF)V

    .line 343
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gv:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    :cond_5
    return-void
.end method

.method private i(Landroid/graphics/Canvas;)V
    .locals 13

    .line 348
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    invoke-static {v0}, Lcom/makeramen/roundedimageview/b;->b([Z)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 353
    :cond_0
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_1

    return-void

    .line 357
    :cond_1
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->left:F

    .line 358
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget v8, v1, Landroid/graphics/RectF;->top:F

    .line 359
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->width()F

    move-result v1

    add-float v9, v0, v1

    .line 360
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->height()F

    move-result v1

    add-float v10, v8, v1

    .line 361
    iget v11, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    .line 362
    iget v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    const/high16 v2, 0x40000000    # 2.0f

    div-float v12, v1, v2

    .line 364
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x0

    aget-boolean v1, v1, v2

    if-nez v1, :cond_2

    sub-float v3, v0, v12

    add-float v5, v0, v11

    .line 365
    iget-object v7, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move-object v2, p1

    move v4, v8

    move v6, v8

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    sub-float v3, v8, v12

    add-float v5, v8, v11

    .line 366
    iget-object v6, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move-object v1, p1

    move v2, v0

    move v4, v0

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 369
    :cond_2
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x1

    aget-boolean v1, v1, v2

    if-nez v1, :cond_3

    sub-float v1, v9, v11

    sub-float v3, v1, v12

    .line 370
    iget-object v7, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move-object v2, p1

    move v4, v8

    move v5, v9

    move v6, v8

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    sub-float v4, v8, v12

    add-float v6, v8, v11

    .line 371
    iget-object v7, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move v3, v9

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 374
    :cond_3
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x2

    aget-boolean v1, v1, v2

    if-nez v1, :cond_4

    sub-float v1, v9, v11

    sub-float v3, v1, v12

    add-float v5, v9, v12

    .line 375
    iget-object v7, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move-object v2, p1

    move v4, v10

    move v6, v10

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    sub-float v4, v10, v11

    .line 376
    iget-object v7, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move v3, v9

    move v5, v9

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 379
    :cond_4
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x3

    aget-boolean v1, v1, v2

    if-nez v1, :cond_5

    sub-float v3, v0, v12

    add-float v5, v0, v11

    .line 380
    iget-object v7, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move-object v2, p1

    move v4, v10

    move v6, v10

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    sub-float v3, v10, v11

    .line 381
    iget-object v6, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    move-object v1, p1

    move v2, v0

    move v4, v0

    move v5, v10

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    :cond_5
    return-void
.end method

.method private updateShaderMatrix()V
    .locals 6

    .line 172
    sget-object v0, Lcom/makeramen/roundedimageview/b$1;->$SwitchMap$android$widget$ImageView$ScaleType:[I

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gE:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/high16 v1, 0x3f000000    # 0.5f

    const/high16 v2, 0x40000000    # 2.0f

    packed-switch v0, :pswitch_data_0

    .line 228
    :pswitch_0
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 229
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    sget-object v4, Landroid/graphics/Matrix$ScaleToFit;->CENTER:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v3, v4}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    .line 230
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 231
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v1, v2

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    invoke-virtual {v0, v1, v3}, Landroid/graphics/RectF;->inset(FF)V

    .line 232
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    sget-object v3, Landroid/graphics/Matrix$ScaleToFit;->FILL:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    goto/16 :goto_2

    .line 252
    :pswitch_1
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 253
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v1, v2

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    invoke-virtual {v0, v1, v3}, Landroid/graphics/RectF;->inset(FF)V

    .line 254
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 255
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    sget-object v3, Landroid/graphics/Matrix$ScaleToFit;->FILL:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    goto/16 :goto_2

    .line 244
    :pswitch_2
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 245
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    sget-object v4, Landroid/graphics/Matrix$ScaleToFit;->START:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v3, v4}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    .line 246
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 247
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v1, v2

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    invoke-virtual {v0, v1, v3}, Landroid/graphics/RectF;->inset(FF)V

    .line 248
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    sget-object v3, Landroid/graphics/Matrix$ScaleToFit;->FILL:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    goto/16 :goto_2

    .line 236
    :pswitch_3
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 237
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    sget-object v4, Landroid/graphics/Matrix$ScaleToFit;->END:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v3, v4}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    .line 238
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 239
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v1, v2

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    invoke-virtual {v0, v1, v3}, Landroid/graphics/RectF;->inset(FF)V

    .line 240
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    sget-object v3, Landroid/graphics/Matrix$ScaleToFit;->FILL:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    goto/16 :goto_2

    .line 205
    :pswitch_4
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 207
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v0, v0

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    move-result v3

    cmpg-float v0, v0, v3

    if-gtz v0, :cond_0

    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v0, v0

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    cmpg-float v0, v0, v3

    if-gtz v0, :cond_0

    const/high16 v0, 0x3f800000    # 1.0f

    goto :goto_0

    .line 210
    :cond_0
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v3, v3

    div-float/2addr v0, v3

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    .line 211
    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v4, v4

    div-float/2addr v3, v4

    .line 210
    invoke-static {v0, v3}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 214
    :goto_0
    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    move-result v3

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v4, v4

    mul-float v4, v4, v0

    sub-float/2addr v3, v4

    mul-float v3, v3, v1

    add-float/2addr v3, v1

    float-to-int v3, v3

    int-to-float v3, v3

    .line 215
    iget-object v4, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->height()F

    move-result v4

    iget v5, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v5, v5

    mul-float v5, v5, v0

    sub-float/2addr v4, v5

    mul-float v4, v4, v1

    add-float/2addr v4, v1

    float-to-int v1, v4

    int-to-float v1, v1

    .line 217
    iget-object v4, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v4, v0, v0}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 218
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, v3, v1}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 220
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 221
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 222
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v1, v2

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    invoke-virtual {v0, v1, v3}, Landroid/graphics/RectF;->inset(FF)V

    .line 223
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gu:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    sget-object v3, Landroid/graphics/Matrix$ScaleToFit;->FILL:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    goto/16 :goto_2

    .line 183
    :pswitch_5
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v0, v3}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 184
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v4, v2

    invoke-virtual {v0, v3, v4}, Landroid/graphics/RectF;->inset(FF)V

    .line 186
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 191
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v0, v0

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    mul-float v0, v0, v3

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    move-result v3

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v4, v4

    mul-float v3, v3, v4

    const/4 v4, 0x0

    cmpl-float v0, v0, v3

    if-lez v0, :cond_1

    .line 192
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v3, v3

    div-float/2addr v0, v3

    .line 193
    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    move-result v3

    iget v5, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v5, v5

    mul-float v5, v5, v0

    sub-float/2addr v3, v5

    mul-float v3, v3, v1

    goto :goto_1

    .line 195
    :cond_1
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v3, v3

    div-float/2addr v0, v3

    .line 196
    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    iget v5, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v5, v5

    mul-float v5, v5, v0

    sub-float/2addr v3, v5

    mul-float v3, v3, v1

    move v4, v3

    const/4 v3, 0x0

    .line 199
    :goto_1
    iget-object v5, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v5, v0, v0}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 200
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    add-float/2addr v3, v1

    float-to-int v3, v3

    int-to-float v3, v3

    iget v5, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v5, v2

    add-float/2addr v3, v5

    add-float/2addr v4, v1

    float-to-int v1, v4

    int-to-float v1, v1

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v4, v2

    add-float/2addr v1, v4

    invoke-virtual {v0, v3, v1}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    goto :goto_2

    .line 174
    :pswitch_6
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v0, v3}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 175
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v3, v2

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    div-float/2addr v4, v2

    invoke-virtual {v0, v3, v4}, Landroid/graphics/RectF;->inset(FF)V

    .line 177
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 178
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v2

    iget v3, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    int-to-float v3, v3

    sub-float/2addr v2, v3

    mul-float v2, v2, v1

    add-float/2addr v2, v1

    float-to-int v2, v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    .line 179
    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v3

    iget v4, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    int-to-float v4, v4

    sub-float/2addr v3, v4

    mul-float v3, v3, v1

    add-float/2addr v3, v1

    float-to-int v1, v3

    int-to-float v1, v1

    .line 178
    invoke-virtual {v0, v2, v1}, Landroid/graphics/Matrix;->setTranslate(FF)V

    .line 259
    :goto_2
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    return-void

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public a(Landroid/content/res/ColorStateList;)Lcom/makeramen/roundedimageview/b;
    .locals 3

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    .line 550
    invoke-static {p1}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object p1

    :goto_0
    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->gD:Landroid/content/res/ColorStateList;

    .line 551
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gD:Landroid/content/res/ColorStateList;

    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->getState()[I

    move-result-object v1

    const/high16 v2, -0x1000000

    invoke-virtual {v0, v1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setColor(I)V

    return-object p0
.end method

.method public a(Landroid/graphics/Shader$TileMode;)Lcom/makeramen/roundedimageview/b;
    .locals 1

    .line 584
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gw:Landroid/graphics/Shader$TileMode;

    if-eq v0, p1, :cond_0

    .line 585
    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->gw:Landroid/graphics/Shader$TileMode;

    const/4 p1, 0x1

    .line 586
    iput-boolean p1, p0, Lcom/makeramen/roundedimageview/b;->gA:Z

    .line 587
    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->invalidateSelf()V

    :cond_0
    return-object p0
.end method

.method public a(Landroid/widget/ImageView$ScaleType;)Lcom/makeramen/roundedimageview/b;
    .locals 1

    if-nez p1, :cond_0

    .line 570
    sget-object p1, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    .line 572
    :cond_0
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gE:Landroid/widget/ImageView$ScaleType;

    if-eq v0, p1, :cond_1

    .line 573
    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->gE:Landroid/widget/ImageView$ScaleType;

    .line 574
    invoke-direct {p0}, Lcom/makeramen/roundedimageview/b;->updateShaderMatrix()V

    :cond_1
    return-object p0
.end method

.method public b(FFFF)Lcom/makeramen/roundedimageview/b;
    .locals 4

    .line 498
    new-instance v0, Ljava/util/HashSet;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    .line 499
    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 500
    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 501
    invoke-static {p3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 502
    invoke-static {p4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    const/4 v1, 0x0

    .line 504
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 506
    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v2

    const/4 v3, 0x1

    if-gt v2, v3, :cond_6

    .line 510
    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 511
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    .line 512
    invoke-static {v0}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v2

    if-nez v2, :cond_0

    cmpg-float v2, v0, v1

    if-ltz v2, :cond_0

    .line 515
    iput v0, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    goto :goto_0

    .line 513
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "Invalid radius value: "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 517
    :cond_1
    iput v1, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    .line 520
    :goto_0
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 v2, 0x0

    cmpl-float p1, p1, v1

    if-lez p1, :cond_2

    const/4 p1, 0x1

    goto :goto_1

    :cond_2
    const/4 p1, 0x0

    :goto_1
    aput-boolean p1, v0, v2

    .line 521
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    cmpl-float p2, p2, v1

    if-lez p2, :cond_3

    const/4 p2, 0x1

    goto :goto_2

    :cond_3
    const/4 p2, 0x0

    :goto_2
    aput-boolean p2, p1, v3

    .line 522
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 p2, 0x2

    cmpl-float p3, p3, v1

    if-lez p3, :cond_4

    const/4 p3, 0x1

    goto :goto_3

    :cond_4
    const/4 p3, 0x0

    :goto_3
    aput-boolean p3, p1, p2

    .line 523
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    const/4 p2, 0x3

    cmpl-float p3, p4, v1

    if-lez p3, :cond_5

    const/4 v2, 0x1

    :cond_5
    aput-boolean v2, p1, p2

    return-object p0

    .line 507
    :cond_6
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Multiple nonzero corner radii not yet supported."

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public b(Landroid/graphics/Shader$TileMode;)Lcom/makeramen/roundedimageview/b;
    .locals 1

    .line 597
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gz:Landroid/graphics/Shader$TileMode;

    if-eq v0, p1, :cond_0

    .line 598
    iput-object p1, p0, Lcom/makeramen/roundedimageview/b;->gz:Landroid/graphics/Shader$TileMode;

    const/4 p1, 0x1

    .line 599
    iput-boolean p1, p0, Lcom/makeramen/roundedimageview/b;->gA:Z

    .line 600
    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->invalidateSelf()V

    :cond_0
    return-object p0
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1    # Landroid/graphics/Canvas;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 273
    iget-boolean v0, p0, Lcom/makeramen/roundedimageview/b;->gA:Z

    if-eqz v0, :cond_1

    .line 274
    new-instance v0, Landroid/graphics/BitmapShader;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBitmap:Landroid/graphics/Bitmap;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->gw:Landroid/graphics/Shader$TileMode;

    iget-object v3, p0, Lcom/makeramen/roundedimageview/b;->gz:Landroid/graphics/Shader$TileMode;

    invoke-direct {v0, v1, v2, v3}, Landroid/graphics/BitmapShader;-><init>(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    .line 275
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gw:Landroid/graphics/Shader$TileMode;

    sget-object v2, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->gz:Landroid/graphics/Shader$TileMode;

    sget-object v2, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    if-ne v1, v2, :cond_0

    .line 276
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mShaderMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/BitmapShader;->setLocalMatrix(Landroid/graphics/Matrix;)V

    .line 278
    :cond_0
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    const/4 v0, 0x0

    .line 279
    iput-boolean v0, p0, Lcom/makeramen/roundedimageview/b;->gA:Z

    .line 282
    :cond_1
    iget-boolean v0, p0, Lcom/makeramen/roundedimageview/b;->gC:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_3

    .line 283
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_2

    .line 284
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 285
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    goto :goto_0

    .line 287
    :cond_2
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    goto :goto_0

    .line 290
    :cond_3
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gB:[Z

    invoke-static {v0}, Lcom/makeramen/roundedimageview/b;->a([Z)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 291
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mCornerRadius:F

    .line 292
    iget v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    cmpl-float v1, v2, v1

    if-lez v1, :cond_4

    .line 293
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v0, v0, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 294
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v0, v0, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 295
    invoke-direct {p0, p1}, Lcom/makeramen/roundedimageview/b;->h(Landroid/graphics/Canvas;)V

    .line 296
    invoke-direct {p0, p1}, Lcom/makeramen/roundedimageview/b;->i(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 298
    :cond_4
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v0, v0, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 299
    invoke-direct {p0, p1}, Lcom/makeramen/roundedimageview/b;->h(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 302
    :cond_5
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mDrawableRect:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 303
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_6

    .line 304
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderRect:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    :cond_6
    :goto_0
    return-void
.end method

.method public e(Z)Lcom/makeramen/roundedimageview/b;
    .locals 0

    .line 560
    iput-boolean p1, p0, Lcom/makeramen/roundedimageview/b;->gC:Z

    return-object p0
.end method

.method public getAlpha()I
    .locals 1

    .line 392
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    return v0
.end method

.method public getColorFilter()Landroid/graphics/ColorFilter;
    .locals 1

    .line 403
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColorFilter()Landroid/graphics/ColorFilter;

    move-result-object v0

    return-object v0
.end method

.method public getIntrinsicHeight()I
    .locals 1

    .line 431
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapHeight:I

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .line 426
    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapWidth:I

    return v0
.end method

.method public getOpacity()I
    .locals 1

    const/4 v0, -0x3

    return v0
.end method

.method public i(F)Lcom/makeramen/roundedimageview/b;
    .locals 1

    .line 532
    iput p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    .line 533
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    iget v0, p0, Lcom/makeramen/roundedimageview/b;->mBorderWidth:F

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    return-object p0
.end method

.method public isStateful()Z
    .locals 1

    .line 153
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gD:Landroid/content/res/ColorStateList;

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v0

    return v0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .locals 1
    .param p1    # Landroid/graphics/Rect;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 264
    invoke-super {p0, p1}, Landroid/graphics/drawable/Drawable;->onBoundsChange(Landroid/graphics/Rect;)V

    .line 266
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gt:Landroid/graphics/RectF;

    invoke-virtual {v0, p1}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 268
    invoke-direct {p0}, Lcom/makeramen/roundedimageview/b;->updateShaderMatrix()V

    return-void
.end method

.method protected onStateChange([I)Z
    .locals 2

    .line 158
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->gD:Landroid/content/res/ColorStateList;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    .line 159
    iget-object v1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    invoke-virtual {v1}, Landroid/graphics/Paint;->getColor()I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 160
    iget-object p1, p0, Lcom/makeramen/roundedimageview/b;->mBorderPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setColor(I)V

    const/4 p1, 0x1

    return p1

    .line 163
    :cond_0
    invoke-super {p0, p1}, Landroid/graphics/drawable/Drawable;->onStateChange([I)Z

    move-result p1

    return p1
.end method

.method public setAlpha(I)V
    .locals 1

    .line 397
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 398
    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->invalidateSelf()V

    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1

    .line 408
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 409
    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->invalidateSelf()V

    return-void
.end method

.method public setDither(Z)V
    .locals 1

    .line 414
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setDither(Z)V

    .line 415
    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->invalidateSelf()V

    return-void
.end method

.method public setFilterBitmap(Z)V
    .locals 1

    .line 420
    iget-object v0, p0, Lcom/makeramen/roundedimageview/b;->mBitmapPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 421
    invoke-virtual {p0}, Lcom/makeramen/roundedimageview/b;->invalidateSelf()V

    return-void
.end method
