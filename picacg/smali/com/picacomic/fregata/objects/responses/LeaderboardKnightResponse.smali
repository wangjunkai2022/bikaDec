.class public Lcom/picacomic/fregata/objects/responses/LeaderboardKnightResponse;
.super Ljava/lang/Object;
.source "LeaderboardKnightResponse.java"


# instance fields
.field users:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/picacomic/fregata/objects/LeaderboardKnightObject;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Lcom/picacomic/fregata/objects/LeaderboardKnightObject;",
            ">;)V"
        }
    .end annotation

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/picacomic/fregata/objects/responses/LeaderboardKnightResponse;->users:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public getUsers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Lcom/picacomic/fregata/objects/LeaderboardKnightObject;",
            ">;"
        }
    .end annotation

    .line 18
    iget-object v0, p0, Lcom/picacomic/fregata/objects/responses/LeaderboardKnightResponse;->users:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setUsers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Lcom/picacomic/fregata/objects/LeaderboardKnightObject;",
            ">;)V"
        }
    .end annotation

    .line 22
    iput-object p1, p0, Lcom/picacomic/fregata/objects/responses/LeaderboardKnightResponse;->users:Ljava/util/ArrayList;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 27
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "LeaderboardKnightResponse{users="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/picacomic/fregata/objects/responses/LeaderboardKnightResponse;->users:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
