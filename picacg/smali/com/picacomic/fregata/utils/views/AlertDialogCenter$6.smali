.class final Lcom/picacomic/fregata/utils/views/AlertDialogCenter$6;
.super Ljava/lang/Object;
.source "AlertDialogCenter.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/utils/views/AlertDialogCenter;->sortingAdvancedCategoriesOptions(Landroid/content/Context;[Ljava/lang/String;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;Landroid/content/DialogInterface$OnClickListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 276
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 279
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    return-void
.end method