.class Landroid/support/v4/print/PrintHelperApi20;
.super Landroid/support/v4/print/PrintHelperKitkat;
.source "PrintHelperApi20.java"


# annotations
.annotation build Landroid/support/annotation/RequiresApi;
    value = 0x14
.end annotation


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .line 28
    invoke-direct {p0, p1}, Landroid/support/v4/print/PrintHelperKitkat;-><init>(Landroid/content/Context;)V

    const/4 p1, 0x0

    .line 33
    iput-boolean p1, p0, Landroid/support/v4/print/PrintHelperApi20;->mPrintActivityRespectsOrientation:Z

    return-void
.end method
