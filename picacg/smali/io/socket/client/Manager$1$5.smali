.class Lio/socket/client/Manager$1$5;
.super Ljava/lang/Object;
.source "Manager.java"

# interfaces
.implements Lio/socket/client/c$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/client/Manager$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic xe:Lio/socket/client/Manager$1;

.field final synthetic xj:Ljava/util/Timer;


# direct methods
.method constructor <init>(Lio/socket/client/Manager$1;Ljava/util/Timer;)V
    .locals 0

    .line 319
    iput-object p1, p0, Lio/socket/client/Manager$1$5;->xe:Lio/socket/client/Manager$1;

    iput-object p2, p0, Lio/socket/client/Manager$1$5;->xj:Ljava/util/Timer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .line 322
    iget-object v0, p0, Lio/socket/client/Manager$1$5;->xj:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    return-void
.end method
