.class public Lcom/picacomic/fregata/holders/SingleImageTextView_ViewBinding;
.super Ljava/lang/Object;
.source "SingleImageTextView_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private sX:Lcom/picacomic/fregata/holders/SingleImageTextView;


# direct methods
.method public constructor <init>(Lcom/picacomic/fregata/holders/SingleImageTextView;Landroid/view/View;)V
    .locals 3
    .annotation build Landroid/support/annotation/UiThread;
    .end annotation

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/picacomic/fregata/holders/SingleImageTextView_ViewBinding;->sX:Lcom/picacomic/fregata/holders/SingleImageTextView;

    const-string v0, "field \'imageView_image\'"

    .line 27
    const-class v1, Lcom/picacomic/fregata/utils/views/ComicThumbImageView;

    const v2, 0x7f090175

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/picacomic/fregata/utils/views/ComicThumbImageView;

    iput-object v0, p1, Lcom/picacomic/fregata/holders/SingleImageTextView;->imageView_image:Lcom/picacomic/fregata/utils/views/ComicThumbImageView;

    const-string v0, "field \'textView_title\'"

    .line 28
    const-class v1, Landroid/widget/TextView;

    const v2, 0x7f0902f1

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/widget/TextView;

    iput-object p2, p1, Lcom/picacomic/fregata/holders/SingleImageTextView;->textView_title:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2
    .annotation build Landroid/support/annotation/CallSuper;
    .end annotation

    .line 34
    iget-object v0, p0, Lcom/picacomic/fregata/holders/SingleImageTextView_ViewBinding;->sX:Lcom/picacomic/fregata/holders/SingleImageTextView;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 36
    iput-object v1, p0, Lcom/picacomic/fregata/holders/SingleImageTextView_ViewBinding;->sX:Lcom/picacomic/fregata/holders/SingleImageTextView;

    .line 38
    iput-object v1, v0, Lcom/picacomic/fregata/holders/SingleImageTextView;->imageView_image:Lcom/picacomic/fregata/utils/views/ComicThumbImageView;

    .line 39
    iput-object v1, v0, Lcom/picacomic/fregata/holders/SingleImageTextView;->textView_title:Landroid/widget/TextView;

    return-void

    .line 35
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
