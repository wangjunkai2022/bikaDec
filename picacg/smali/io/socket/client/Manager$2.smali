.class Lio/socket/client/Manager$2;
.super Ljava/lang/Object;
.source "Manager.java"

# interfaces
.implements Lio/socket/f/c$c$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/client/Manager;->b(Lio/socket/f/b;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic xc:Lio/socket/client/Manager;

.field final synthetic xd:Lio/socket/client/Manager;


# direct methods
.method constructor <init>(Lio/socket/client/Manager;Lio/socket/client/Manager;)V
    .locals 0

    .line 461
    iput-object p1, p0, Lio/socket/client/Manager$2;->xc:Lio/socket/client/Manager;

    iput-object p2, p0, Lio/socket/client/Manager$2;->xd:Lio/socket/client/Manager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a([Ljava/lang/Object;)V
    .locals 5

    .line 464
    array-length v0, p1

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_2

    aget-object v3, p1, v2

    .line 465
    instance-of v4, v3, Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 466
    iget-object v4, p0, Lio/socket/client/Manager$2;->xd:Lio/socket/client/Manager;

    iget-object v4, v4, Lio/socket/client/Manager;->wX:Lio/socket/engineio/client/Socket;

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Lio/socket/engineio/client/Socket;->write(Ljava/lang/String;)V

    goto :goto_1

    .line 467
    :cond_0
    instance-of v4, v3, [B

    if-eqz v4, :cond_1

    .line 468
    iget-object v4, p0, Lio/socket/client/Manager$2;->xd:Lio/socket/client/Manager;

    iget-object v4, v4, Lio/socket/client/Manager;->wX:Lio/socket/engineio/client/Socket;

    check-cast v3, [B

    invoke-virtual {v4, v3}, Lio/socket/engineio/client/Socket;->write([B)V

    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 471
    :cond_2
    iget-object p1, p0, Lio/socket/client/Manager$2;->xd:Lio/socket/client/Manager;

    invoke-static {p1, v1}, Lio/socket/client/Manager;->b(Lio/socket/client/Manager;Z)Z

    .line 472
    iget-object p1, p0, Lio/socket/client/Manager$2;->xd:Lio/socket/client/Manager;

    invoke-static {p1}, Lio/socket/client/Manager;->k(Lio/socket/client/Manager;)V

    return-void
.end method
