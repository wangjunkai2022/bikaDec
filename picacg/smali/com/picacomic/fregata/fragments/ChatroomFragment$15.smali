.class Lcom/picacomic/fregata/fragments/ChatroomFragment$15;
.super Ljava/lang/Object;
.source "ChatroomFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/ChatroomFragment;->ca()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;


# direct methods
.method constructor <init>(Lcom/picacomic/fregata/fragments/ChatroomFragment;)V
    .locals 0

    .line 908
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$15;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 912
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$15;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ChatroomFragment;->cB()Z

    move-result p1

    if-eqz p1, :cond_0

    .line 913
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$15;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/picacomic/fregata/fragments/ChatroomFragment;->m(Z)V

    goto :goto_0

    .line 915
    :cond_0
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$15;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/picacomic/fregata/fragments/ChatroomFragment;->m(Z)V

    :goto_0
    return-void
.end method
