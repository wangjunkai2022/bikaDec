.class Lcom/picacomic/fregata/fragments/TutorialPopupFragment$2;
.super Ljava/lang/Object;
.source "TutorialPopupFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/TutorialPopupFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic sb:Lcom/picacomic/fregata/fragments/TutorialPopupFragment;


# direct methods
.method constructor <init>(Lcom/picacomic/fregata/fragments/TutorialPopupFragment;)V
    .locals 0

    .line 119
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/TutorialPopupFragment$2;->sb:Lcom/picacomic/fregata/fragments/TutorialPopupFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 0

    const/4 p1, 0x4

    if-eq p2, p1, :cond_0

    const/16 p1, 0x54

    if-eq p2, p1, :cond_0

    const/4 p1, 0x0

    return p1

    :cond_0
    const/4 p1, 0x1

    return p1
.end method
