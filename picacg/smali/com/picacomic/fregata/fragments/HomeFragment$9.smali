.class Lcom/picacomic/fregata/fragments/HomeFragment$9;
.super Ljava/lang/Object;
.source "HomeFragment.java"

# interfaces
.implements Lretrofit2/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/picacomic/fregata/fragments/HomeFragment;->dk()V
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
        "Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic py:Lcom/picacomic/fregata/fragments/HomeFragment;


# direct methods
.method constructor <init>(Lcom/picacomic/fregata/fragments/HomeFragment;)V
    .locals 0

    .line 468
    iput-object p1, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

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
            "Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;",
            ">;>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .line 514
    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 515
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/HomeFragment;->bC()V

    .line 516
    new-instance p1, Lcom/picacomic/fregata/b/c;

    iget-object p2, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {p2}, Lcom/picacomic/fregata/fragments/HomeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object p2

    invoke-direct {p1, p2}, Lcom/picacomic/fregata/b/c;-><init>(Landroid/content/Context;)V

    .line 517
    invoke-virtual {p1}, Lcom/picacomic/fregata/b/c;->dN()V

    .line 518
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/HomeFragment;->bI()V

    return-void
.end method

.method public onResponse(Lretrofit2/Call;Lretrofit2/Response;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lretrofit2/Call<",
            "Lcom/picacomic/fregata/objects/responses/GeneralResponse<",
            "Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;",
            ">;>;",
            "Lretrofit2/Response<",
            "Lcom/picacomic/fregata/objects/responses/GeneralResponse<",
            "Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;",
            ">;>;)V"
        }
    .end annotation

    .line 471
    invoke-virtual {p2}, Lretrofit2/Response;->code()I

    move-result p1

    const/16 v0, 0xc8

    if-ne p1, v0, :cond_0

    .line 472
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast p1, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lcom/picacomic/fregata/utils/f;->aA(Ljava/lang/String;)V

    .line 484
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    if-eqz p1, :cond_1

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast p1, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;

    invoke-virtual {p1}, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;->getAnnouncements()Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsData;

    move-result-object p1

    if-eqz p1, :cond_1

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p1, p1, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast p1, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;

    invoke-virtual {p1}, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;->getAnnouncements()Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsData;

    move-result-object p1

    invoke-virtual {p1}, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsData;->getDocs()Ljava/util/ArrayList;

    move-result-object p1

    if-eqz p1, :cond_1

    .line 485
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/picacomic/fregata/objects/responses/GeneralResponse;

    iget-object p2, p2, Lcom/picacomic/fregata/objects/responses/GeneralResponse;->data:Ljava/lang/Object;

    check-cast p2, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;

    invoke-virtual {p2}, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsResponse;->getAnnouncements()Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsData;

    move-result-object p2

    invoke-virtual {p2}, Lcom/picacomic/fregata/objects/responses/DataClass/AnnouncementsResponse/AnnouncementsData;->getDocs()Ljava/util/ArrayList;

    move-result-object p2

    iput-object p2, p1, Lcom/picacomic/fregata/fragments/HomeFragment;->pt:Ljava/util/ArrayList;

    goto :goto_0

    .line 502
    :cond_0
    :try_start_0
    new-instance p1, Lcom/picacomic/fregata/b/c;

    iget-object v0, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {v0}, Lcom/picacomic/fregata/fragments/HomeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p2}, Lretrofit2/Response;->code()I

    move-result v1

    invoke-virtual {p2}, Lretrofit2/Response;->errorBody()Lokhttp3/ResponseBody;

    move-result-object p2

    invoke-virtual {p2}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, v0, v1, p2}, Lcom/picacomic/fregata/b/c;-><init>(Landroid/content/Context;ILjava/lang/String;)V

    .line 503
    invoke-virtual {p1}, Lcom/picacomic/fregata/b/c;->dN()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    .line 505
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 508
    :cond_1
    :goto_0
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/HomeFragment;->bC()V

    .line 509
    iget-object p1, p0, Lcom/picacomic/fregata/fragments/HomeFragment$9;->py:Lcom/picacomic/fregata/fragments/HomeFragment;

    invoke-virtual {p1}, Lcom/picacomic/fregata/fragments/HomeFragment;->bI()V

    return-void
.end method
