.class public Lcom/picacomic/fregata/holders/NotificationViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "NotificationViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private sW:Lcom/picacomic/fregata/holders/NotificationViewHolder;


# direct methods
.method public constructor <init>(Lcom/picacomic/fregata/holders/NotificationViewHolder;Landroid/view/View;)V
    .locals 3
    .annotation build Landroid/support/annotation/UiThread;
    .end annotation

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/picacomic/fregata/holders/NotificationViewHolder_ViewBinding;->sW:Lcom/picacomic/fregata/holders/NotificationViewHolder;

    const-string v0, "field \'imageView_avatar\'"

    .line 22
    const-class v1, Landroid/widget/ImageView;

    const v2, 0x7f090140

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/picacomic/fregata/holders/NotificationViewHolder;->imageView_avatar:Landroid/widget/ImageView;

    const-string v0, "field \'imageView_character\'"

    .line 23
    const-class v1, Landroid/widget/ImageView;

    const v2, 0x7f090142

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/picacomic/fregata/holders/NotificationViewHolder;->imageView_character:Landroid/widget/ImageView;

    const-string v0, "field \'textView_content\'"

    .line 24
    const-class v1, Landroid/widget/TextView;

    const v2, 0x7f0902c5

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/picacomic/fregata/holders/NotificationViewHolder;->textView_content:Landroid/widget/TextView;

    const-string v0, "field \'textView_timestamp\'"

    .line 25
    const-class v1, Landroid/widget/TextView;

    const v2, 0x7f0902c6

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/picacomic/fregata/holders/NotificationViewHolder;->textView_timestamp:Landroid/widget/TextView;

    const-string v0, "field \'imageView_image\'"

    .line 26
    const-class v1, Landroid/widget/ImageView;

    const v2, 0x7f09016d

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/widget/ImageView;

    iput-object p2, p1, Lcom/picacomic/fregata/holders/NotificationViewHolder;->imageView_image:Landroid/widget/ImageView;

    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2
    .annotation build Landroid/support/annotation/CallSuper;
    .end annotation

    .line 32
    iget-object v0, p0, Lcom/picacomic/fregata/holders/NotificationViewHolder_ViewBinding;->sW:Lcom/picacomic/fregata/holders/NotificationViewHolder;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 34
    iput-object v1, p0, Lcom/picacomic/fregata/holders/NotificationViewHolder_ViewBinding;->sW:Lcom/picacomic/fregata/holders/NotificationViewHolder;

    .line 36
    iput-object v1, v0, Lcom/picacomic/fregata/holders/NotificationViewHolder;->imageView_avatar:Landroid/widget/ImageView;

    .line 37
    iput-object v1, v0, Lcom/picacomic/fregata/holders/NotificationViewHolder;->imageView_character:Landroid/widget/ImageView;

    .line 38
    iput-object v1, v0, Lcom/picacomic/fregata/holders/NotificationViewHolder;->textView_content:Landroid/widget/TextView;

    .line 39
    iput-object v1, v0, Lcom/picacomic/fregata/holders/NotificationViewHolder;->textView_timestamp:Landroid/widget/TextView;

    .line 40
    iput-object v1, v0, Lcom/picacomic/fregata/holders/NotificationViewHolder;->imageView_image:Landroid/widget/ImageView;

    return-void

    .line 33
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
