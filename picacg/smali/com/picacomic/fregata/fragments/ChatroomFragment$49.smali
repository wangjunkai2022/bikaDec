.class Lcom/picacomic/fregata/fragments/ChatroomFragment$49;
.super Ljava/lang/Object;
.source "ChatroomFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/ChatroomFragment;->b(Landroid/view/View;)V
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

    .line 2916
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$49;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 0

    .line 2919
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$49;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ChatroomFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object p1

    invoke-virtual {p1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 2920
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$49;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ChatroomFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object p1

    invoke-virtual {p1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    return-void
.end method
