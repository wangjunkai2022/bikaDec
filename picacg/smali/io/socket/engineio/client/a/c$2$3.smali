.class Lio/socket/engineio/client/a/c$2$3;
.super Ljava/lang/Object;
.source "WebSocket.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/engineio/client/a/c$2;->onMessage(Lokhttp3/WebSocket;Lokio/ByteString;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zI:Lio/socket/engineio/client/a/c$2;

.field final synthetic zK:Lokio/ByteString;


# direct methods
.method constructor <init>(Lio/socket/engineio/client/a/c$2;Lokio/ByteString;)V
    .locals 0

    .line 109
    iput-object p1, p0, Lio/socket/engineio/client/a/c$2$3;->zI:Lio/socket/engineio/client/a/c$2;

    iput-object p2, p0, Lio/socket/engineio/client/a/c$2$3;->zK:Lokio/ByteString;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 112
    iget-object v0, p0, Lio/socket/engineio/client/a/c$2$3;->zI:Lio/socket/engineio/client/a/c$2;

    iget-object v0, v0, Lio/socket/engineio/client/a/c$2;->zG:Lio/socket/engineio/client/a/c;

    iget-object v1, p0, Lio/socket/engineio/client/a/c$2$3;->zK:Lokio/ByteString;

    invoke-virtual {v1}, Lokio/ByteString;->toByteArray()[B

    move-result-object v1

    invoke-static {v0, v1}, Lio/socket/engineio/client/a/c;->a(Lio/socket/engineio/client/a/c;[B)V

    return-void
.end method
