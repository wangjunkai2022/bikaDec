.class Lio/socket/engineio/client/Socket$12$1;
.super Ljava/lang/Object;
.source "Socket.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/engineio/client/Socket$12;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic yB:Lio/socket/engineio/client/Socket;

.field final synthetic yK:Lio/socket/engineio/client/Socket$12;


# direct methods
.method constructor <init>(Lio/socket/engineio/client/Socket$12;Lio/socket/engineio/client/Socket;)V
    .locals 0

    .line 235
    iput-object p1, p0, Lio/socket/engineio/client/Socket$12$1;->yK:Lio/socket/engineio/client/Socket$12;

    iput-object p2, p0, Lio/socket/engineio/client/Socket$12$1;->yB:Lio/socket/engineio/client/Socket;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 238
    iget-object v0, p0, Lio/socket/engineio/client/Socket$12$1;->yB:Lio/socket/engineio/client/Socket;

    const-string v1, "error"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    new-instance v3, Lio/socket/engineio/client/EngineIOException;

    const-string v4, "No transports available"

    invoke-direct {v3, v4}, Lio/socket/engineio/client/EngineIOException;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Lio/socket/engineio/client/Socket;->b(Ljava/lang/String;[Ljava/lang/Object;)Lio/socket/b/a;

    return-void
.end method
