.class Lcom/just/agentweb/download/i$a;
.super Ljava/lang/Object;
.source "ExecutorProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/just/agentweb/download/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation


# static fields
.field private static final gp:Lcom/just/agentweb/download/i;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 66
    new-instance v0, Lcom/just/agentweb/download/i;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/just/agentweb/download/i;-><init>(Lcom/just/agentweb/download/i$1;)V

    sput-object v0, Lcom/just/agentweb/download/i$a;->gp:Lcom/just/agentweb/download/i;

    return-void
.end method

.method static synthetic bf()Lcom/just/agentweb/download/i;
    .locals 1

    .line 65
    sget-object v0, Lcom/just/agentweb/download/i$a;->gp:Lcom/just/agentweb/download/i;

    return-object v0
.end method
