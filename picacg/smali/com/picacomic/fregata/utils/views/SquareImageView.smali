.class public Lcom/picacomic/fregata/utils/views/SquareImageView;
.super Landroid/widget/ImageView;
.source "SquareImageView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .line 24
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .line 28
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .line 32
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 0

    .line 37
    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onMeasure(II)V

    .line 38
    invoke-virtual {p0}, Lcom/picacomic/fregata/utils/views/SquareImageView;->getMeasuredWidth()I

    move-result p1

    .line 39
    invoke-virtual {p0, p1, p1}, Lcom/picacomic/fregata/utils/views/SquareImageView;->setMeasuredDimension(II)V

    return-void
.end method
