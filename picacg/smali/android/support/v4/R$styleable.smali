.class public final Landroid/support/v4/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final FontFamily:[I

.field public static final FontFamilyFont:[I

.field public static final FontFamilyFont_font:I = 0x0

.field public static final FontFamilyFont_fontStyle:I = 0x1

.field public static final FontFamilyFont_fontWeight:I = 0x2

.field public static final FontFamily_fontProviderAuthority:I = 0x0

.field public static final FontFamily_fontProviderCerts:I = 0x1

.field public static final FontFamily_fontProviderPackage:I = 0x2

.field public static final FontFamily_fontProviderQuery:I = 0x3


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x4

    .line 32
    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroid/support/v4/R$styleable;->FontFamily:[I

    const/4 v0, 0x3

    .line 37
    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Landroid/support/v4/R$styleable;->FontFamilyFont:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x7f0400af
        0x7f0400b0
        0x7f0400b1
        0x7f0400b2
    .end array-data

    :array_1
    .array-data 4
        0x7f0400ae
        0x7f0400b3
        0x7f0400b4
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
