.class Lcom/soundcloud/android/crop/CropImageActivity$1;
.super Ljava/lang/Object;
.source "CropImageActivity.java"

# interfaces
.implements Lcom/soundcloud/android/crop/ImageViewTouchBase$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/soundcloud/android/crop/CropImageActivity;->ee()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic vo:Lcom/soundcloud/android/crop/CropImageActivity;


# direct methods
.method constructor <init>(Lcom/soundcloud/android/crop/CropImageActivity;)V
    .locals 0

    .line 97
    iput-object p1, p0, Lcom/soundcloud/android/crop/CropImageActivity$1;->vo:Lcom/soundcloud/android/crop/CropImageActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public i(Landroid/graphics/Bitmap;)V
    .locals 0

    .line 100
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->recycle()V

    .line 101
    invoke-static {}, Ljava/lang/System;->gc()V

    return-void
.end method
