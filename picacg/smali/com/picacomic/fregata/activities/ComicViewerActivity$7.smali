.class Lcom/picacomic/fregata/activities/ComicViewerActivity$7;
.super Ljava/lang/Object;
.source "ComicViewerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/activities/ComicViewerActivity;->bF()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic ij:Lcom/picacomic/fregata/activities/ComicViewerActivity;


# direct methods
.method constructor <init>(Lcom/picacomic/fregata/activities/ComicViewerActivity;)V
    .locals 0

    .line 705
    iput-object p1, p0, Lcom/picacomic/fregata/activities/ComicViewerActivity$7;->ij:Lcom/picacomic/fregata/activities/ComicViewerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 709
    iget-object p1, p0, Lcom/picacomic/fregata/activities/ComicViewerActivity$7;->ij:Lcom/picacomic/fregata/activities/ComicViewerActivity;

    iget-boolean p1, p1, Lcom/picacomic/fregata/activities/ComicViewerActivity;->hE:Z

    if-eqz p1, :cond_0

    .line 710
    iget-object p1, p0, Lcom/picacomic/fregata/activities/ComicViewerActivity$7;->ij:Lcom/picacomic/fregata/activities/ComicViewerActivity;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/picacomic/fregata/activities/ComicViewerActivity;->k(Z)V

    goto :goto_0

    .line 712
    :cond_0
    iget-object p1, p0, Lcom/picacomic/fregata/activities/ComicViewerActivity$7;->ij:Lcom/picacomic/fregata/activities/ComicViewerActivity;

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/picacomic/fregata/activities/ComicViewerActivity;->k(Z)V

    :goto_0
    return-void
.end method
