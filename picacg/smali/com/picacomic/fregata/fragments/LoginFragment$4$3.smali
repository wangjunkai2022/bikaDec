.class Lcom/picacomic/fregata/fragments/LoginFragment$4$3;
.super Ljava/lang/Object;
.source "LoginFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/LoginFragment$4;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;


# direct methods
.method constructor <init>(Lcom/picacomic/fregata/fragments/LoginFragment$4;)V
    .locals 0

    .line 278
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .line 281
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    const/4 p2, 0x1

    invoke-virtual {p1, p2}, Lcom/picacomic/fregata/fragments/LoginFragment;->E(Z)V

    .line 282
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    iget-boolean p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment;->pZ:Z

    if-eqz p1, :cond_0

    goto :goto_0

    .line 286
    :cond_0
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/LoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object p1

    const p2, 0x7f0f005f

    const/4 v0, 0x0

    invoke-static {p1, p2, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 287
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment;->pT:Landroid/widget/EditText;

    if-eqz p1, :cond_1

    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment;->pT:Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object p1

    if-eqz p1, :cond_1

    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment;->pT:Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    const-string p2, ""

    invoke-virtual {p1, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_1

    .line 288
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p1, p1, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    iget-object p2, p0, Lcom/picacomic/fregata/fragments/LoginFragment$4$3;->qe:Lcom/picacomic/fregata/fragments/LoginFragment$4;

    iget-object p2, p2, Lcom/picacomic/fregata/fragments/LoginFragment$4;->qc:Lcom/picacomic/fregata/fragments/LoginFragment;

    iget-object p2, p2, Lcom/picacomic/fregata/fragments/LoginFragment;->pT:Landroid/widget/EditText;

    invoke-virtual {p2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    iput-object p2, p1, Lcom/picacomic/fregata/fragments/LoginFragment;->qa:Ljava/lang/String;

    :cond_1
    :goto_0
    return-void
.end method
