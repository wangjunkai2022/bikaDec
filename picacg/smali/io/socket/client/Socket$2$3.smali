.class Lio/socket/client/Socket$2$3;
.super Ljava/lang/Object;
.source "Socket.java"

# interfaces
.implements Lio/socket/b/a$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/socket/client/Socket$2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic xJ:Lio/socket/client/Socket$2;


# direct methods
.method constructor <init>(Lio/socket/client/Socket$2;)V
    .locals 0

    .line 114
    iput-object p1, p0, Lio/socket/client/Socket$2$3;->xJ:Lio/socket/client/Socket$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs a([Ljava/lang/Object;)V
    .locals 2

    .line 117
    iget-object v0, p0, Lio/socket/client/Socket$2$3;->xJ:Lio/socket/client/Socket$2;

    iget-object v0, v0, Lio/socket/client/Socket$2;->xI:Lio/socket/client/d;

    array-length v1, p1

    if-lez v1, :cond_0

    const/4 v1, 0x0

    aget-object p1, p1, v1

    check-cast p1, Ljava/lang/String;

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    invoke-static {v0, p1}, Lio/socket/client/d;->a(Lio/socket/client/d;Ljava/lang/String;)V

    return-void
.end method
