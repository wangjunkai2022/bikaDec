.class public Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment_ViewBinding;
.super Ljava/lang/Object;
.source "SupportUsQQAlipayFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private rX:Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;


# direct methods
.method public constructor <init>(Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;Landroid/view/View;)V
    .locals 3
    .annotation build Landroid/support/annotation/UiThread;
    .end annotation

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment_ViewBinding;->rX:Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;

    const-string v0, "field \'textView_alipay\'"

    .line 21
    const-class v1, Landroid/widget/TextView;

    const v2, 0x7f0902f2

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;->textView_alipay:Landroid/widget/TextView;

    const-string v0, "field \'textView_alipayTitle\'"

    .line 22
    const-class v1, Landroid/widget/TextView;

    const v2, 0x7f0902f3

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/widget/TextView;

    iput-object p2, p1, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;->textView_alipayTitle:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2
    .annotation build Landroid/support/annotation/CallSuper;
    .end annotation

    .line 28
    iget-object v0, p0, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment_ViewBinding;->rX:Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 30
    iput-object v1, p0, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment_ViewBinding;->rX:Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;

    .line 32
    iput-object v1, v0, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;->textView_alipay:Landroid/widget/TextView;

    .line 33
    iput-object v1, v0, Lcom/picacomic/fregata/fragments/SupportUsQQAlipayFragment;->textView_alipayTitle:Landroid/widget/TextView;

    return-void

    .line 29
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
