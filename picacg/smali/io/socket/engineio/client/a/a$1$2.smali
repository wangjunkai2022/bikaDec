.class Lio/socket/engineio/client/a/a$1$2;
.super Ljava/lang/Object;
.source "Polling.java"

# interfaces
.implements Lio/socket/b/a$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/engineio/client/a/a$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zo:Lio/socket/engineio/client/a/a$1;

.field final synthetic zp:[I

.field final synthetic zq:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lio/socket/engineio/client/a/a$1;[ILjava/lang/Runnable;)V
    .locals 0

    .line 61
    iput-object p1, p0, Lio/socket/engineio/client/a/a$1$2;->zo:Lio/socket/engineio/client/a/a$1;

    iput-object p2, p0, Lio/socket/engineio/client/a/a$1$2;->zp:[I

    iput-object p3, p0, Lio/socket/engineio/client/a/a$1$2;->zq:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public varargs a([Ljava/lang/Object;)V
    .locals 2

    .line 64
    invoke-static {}, Lio/socket/engineio/client/a/a;->fh()Ljava/util/logging/Logger;

    move-result-object p1

    const-string v0, "pre-pause polling complete"

    invoke-virtual {p1, v0}, Ljava/util/logging/Logger;->fine(Ljava/lang/String;)V

    .line 65
    iget-object p1, p0, Lio/socket/engineio/client/a/a$1$2;->zp:[I

    const/4 v0, 0x0

    aget v1, p1, v0

    add-int/lit8 v1, v1, -0x1

    aput v1, p1, v0

    if-nez v1, :cond_0

    .line 66
    iget-object p1, p0, Lio/socket/engineio/client/a/a$1$2;->zq:Ljava/lang/Runnable;

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    :cond_0
    return-void
.end method
