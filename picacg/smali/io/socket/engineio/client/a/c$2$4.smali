.class Lio/socket/engineio/client/a/c$2$4;
.super Ljava/lang/Object;
.source "WebSocket.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/engineio/client/a/c$2;->onClosed(Lokhttp3/WebSocket;ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zI:Lio/socket/engineio/client/a/c$2;


# direct methods
.method constructor <init>(Lio/socket/engineio/client/a/c$2;)V
    .locals 0

    .line 119
    iput-object p1, p0, Lio/socket/engineio/client/a/c$2$4;->zI:Lio/socket/engineio/client/a/c$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 122
    iget-object v0, p0, Lio/socket/engineio/client/a/c$2$4;->zI:Lio/socket/engineio/client/a/c$2;

    iget-object v0, v0, Lio/socket/engineio/client/a/c$2;->zG:Lio/socket/engineio/client/a/c;

    invoke-static {v0}, Lio/socket/engineio/client/a/c;->b(Lio/socket/engineio/client/a/c;)V

    return-void
.end method
