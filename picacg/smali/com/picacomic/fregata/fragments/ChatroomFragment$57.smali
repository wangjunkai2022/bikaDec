.class Lcom/picacomic/fregata/fragments/ChatroomFragment$57;
.super Ljava/lang/Object;
.source "ChatroomFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/ChatroomFragment;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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

    .line 3122
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$57;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .line 3125
    iget-object p2, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$57;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    const/4 v0, 0x0

    invoke-virtual {p2, v0}, Lcom/picacomic/fregata/fragments/ChatroomFragment;->v(Z)V

    .line 3126
    iget-object p2, p0, Lcom/picacomic/fregata/fragments/ChatroomFragment$57;->lY:Lcom/picacomic/fregata/fragments/ChatroomFragment;

    const/4 v0, -0x1

    iput v0, p2, Lcom/picacomic/fregata/fragments/ChatroomFragment;->lC:I

    .line 3127
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    return-void
.end method
