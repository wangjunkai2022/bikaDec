.class Lcom/picacomic/fregata/fragments/ComicListFragment$11;
.super Ljava/lang/Object;
.source "ComicListFragment.java"

# interfaces
.implements Lretrofit2/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/ComicListFragment;->cR()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lretrofit2/Callback<",
        "Lcom/picacomic/fregata/objects/responses/GeneralResponse<",
        "Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic nT:Lcom/picacomic/fregata/fragments/ComicListFragment;


# direct methods
.method constructor <init>(Lcom/picacomic/fregata/fragments/ComicListFragment;)V
    .locals 0

    .line 664
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lretrofit2/Call;Ljava/lang/Throwable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lcom/picacomic/fregata/objects/responses/GeneralResponse<",
            "Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;",
            ">;>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .line 692
    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 693
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ComicListFragment;->bC()V

    .line 694
    new-instance p1, Lcom/picacomic/fregata/b/c;

    iget-object p2, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-virtual {p2}, Lcom/picacomic/fregata/fragments/ComicListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object p2

    invoke-direct {p1, p2}, Lcom/picacomic/fregata/b/c;-><init>(Landroid/content/Context;)V

    .line 695
    invoke-virtual {p1}, Lcom/picacomic/fregata/b/c;->dN()V

    .line 696
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ComicListFragment;->bI()V

    return-void
.end method

.method public onResponse(Lretrofit2/Call;Lretrofit2/Response;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lcom/picacomic/fregata/objects/responses/GeneralResponse<",
            "Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;",
            ">;>;",
            "Lretrofit2/Response<",
            "Lcom/picacomic/fregata/objects/responses/GeneralResponse<",
            "Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;",
            ">;>;)V"
        }
    .end annotation

    .line 667
    invoke-virtual {p2}, Lretrofit2/Response;->code()I

    move-result p1

    const/16 v0, 0xc8

    if-ne p1, v0, :cond_0

    .line 668
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast p1, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/picacomic/fregata/utils/f;->aA(Ljava/lang/String;)V

    .line 669
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    if-eqz p1, :cond_1

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast p1, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;

    invoke-virtual {p1}, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;->getComics()Ljava/util/ArrayList;

    move-result-object p1

    if-eqz p1, :cond_1

    const/4 p1, 0x0

    .line 670
    :goto_0
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object v0, v0, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;

    invoke-virtual {v0}, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;->getComics()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p1, v0, :cond_1

    .line 671
    iget-object v0, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    iget-object v0, v0, Lcom/picacomic/fregata/fragments/ComicListFragment;->nE:Ljava/util/ArrayList;

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object v1, v1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;

    invoke-virtual {v1}, Lcom/picacomic/fregata/objects/responses/ComicRandomListResponse;->getComics()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 680
    :cond_0
    :try_start_0
    new-instance p1, Lcom/picacomic/fregata/b/c;

    iget-object v0, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-virtual {v0}, Lcom/picacomic/fregata/fragments/ComicListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p2}, Lretrofit2/Response;->code()I

    move-result v1

    invoke-virtual {p2}, Lretrofit2/Response;->errorBody()Lokhttp3/ResponseBody;

    move-result-object p2

    invoke-virtual {p2}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, v0, v1, p2}, Lcom/picacomic/fregata/b/c;-><init>(Landroid/content/Context;ILjava/lang/String;)V

    .line 681
    invoke-virtual {p1}, Lcom/picacomic/fregata/b/c;->dN()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception p1

    .line 683
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 686
    :cond_1
    :goto_1
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ComicListFragment;->bC()V

    .line 687
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/ComicListFragment$11;->nT:Lcom/picacomic/fregata/fragments/ComicListFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/ComicListFragment;->bI()V

    return-void
.end method
