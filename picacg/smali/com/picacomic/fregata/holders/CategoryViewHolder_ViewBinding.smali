.class public Lcom/picacomic/fregata/holders/CategoryViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "CategoryViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private sm:Lcom/picacomic/fregata/holders/CategoryViewHolder;


# direct methods
.method public constructor <init>(Lcom/picacomic/fregata/holders/CategoryViewHolder;Landroid/view/View;)V
    .locals 3
    .annotation build Landroid/support/annotation/UiThread;
    .end annotation

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/picacomic/fregata/holders/CategoryViewHolder_ViewBinding;->sm:Lcom/picacomic/fregata/holders/CategoryViewHolder;

    const-string v0, "field \'imageView_image\'"

    .line 22
    const-class v1, Landroid/widget/ImageView;

    const v2, 0x7f09013d

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/picacomic/fregata/holders/CategoryViewHolder;->imageView_image:Landroid/widget/ImageView;

    const-string v0, "field \'textView_title\'"

    .line 23
    const-class v1, Landroid/widget/TextView;

    const v2, 0x7f090250

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/widget/TextView;

    iput-object p2, p1, Lcom/picacomic/fregata/holders/CategoryViewHolder;->textView_title:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2
    .annotation build Landroid/support/annotation/CallSuper;
    .end annotation

    .line 29
    iget-object v0, p0, Lcom/picacomic/fregata/holders/CategoryViewHolder_ViewBinding;->sm:Lcom/picacomic/fregata/holders/CategoryViewHolder;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 31
    iput-object v1, p0, Lcom/picacomic/fregata/holders/CategoryViewHolder_ViewBinding;->sm:Lcom/picacomic/fregata/holders/CategoryViewHolder;

    .line 33
    iput-object v1, v0, Lcom/picacomic/fregata/holders/CategoryViewHolder;->imageView_image:Landroid/widget/ImageView;

    .line 34
    iput-object v1, v0, Lcom/picacomic/fregata/holders/CategoryViewHolder;->textView_title:Landroid/widget/TextView;

    return-void

    .line 30
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
