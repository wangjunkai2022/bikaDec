.class Lio/socket/engineio/client/Socket$16;
.super Ljava/lang/Object;
.source "Socket.java"

# interfaces
.implements Lio/socket/b/a$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/engineio/client/Socket;->a(Lio/socket/engineio/client/Transport;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic yB:Lio/socket/engineio/client/Socket;

.field final synthetic yv:Lio/socket/engineio/client/Socket;


# direct methods
.method constructor <init>(Lio/socket/engineio/client/Socket;Lio/socket/engineio/client/Socket;)V
    .locals 0

    .line 310
    iput-object p1, p0, Lio/socket/engineio/client/Socket$16;->yv:Lio/socket/engineio/client/Socket;

    iput-object p2, p0, Lio/socket/engineio/client/Socket$16;->yB:Lio/socket/engineio/client/Socket;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs a([Ljava/lang/Object;)V
    .locals 2

    .line 313
    iget-object v0, p0, Lio/socket/engineio/client/Socket$16;->yB:Lio/socket/engineio/client/Socket;

    array-length v1, p1

    if-lez v1, :cond_0

    const/4 v1, 0x0

    aget-object p1, p1, v1

    check-cast p1, Lio/socket/engineio/parser/b;

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    invoke-static {v0, p1}, Lio/socket/engineio/client/Socket;->a(Lio/socket/engineio/client/Socket;Lio/socket/engineio/parser/b;)V

    return-void
.end method
