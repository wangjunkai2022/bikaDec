.class final enum Lio/socket/engineio/client/Socket$ReadyState;
.super Ljava/lang/Enum;
.source "Socket.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/socket/engineio/client/Socket;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "ReadyState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lio/socket/engineio/client/Socket$ReadyState;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum yV:Lio/socket/engineio/client/Socket$ReadyState;

.field public static final enum yW:Lio/socket/engineio/client/Socket$ReadyState;

.field public static final enum yX:Lio/socket/engineio/client/Socket$ReadyState;

.field public static final enum yY:Lio/socket/engineio/client/Socket$ReadyState;

.field private static final synthetic yZ:[Lio/socket/engineio/client/Socket$ReadyState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 39
    new-instance v0, Lio/socket/engineio/client/Socket$ReadyState;

    const-string v1, "OPENING"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lio/socket/engineio/client/Socket$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Socket$ReadyState;->yV:Lio/socket/engineio/client/Socket$ReadyState;

    new-instance v0, Lio/socket/engineio/client/Socket$ReadyState;

    const-string v1, "OPEN"

    const/4 v3, 0x1

    invoke-direct {v0, v1, v3}, Lio/socket/engineio/client/Socket$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Socket$ReadyState;->yW:Lio/socket/engineio/client/Socket$ReadyState;

    new-instance v0, Lio/socket/engineio/client/Socket$ReadyState;

    const-string v1, "CLOSING"

    const/4 v4, 0x2

    invoke-direct {v0, v1, v4}, Lio/socket/engineio/client/Socket$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Socket$ReadyState;->yX:Lio/socket/engineio/client/Socket$ReadyState;

    new-instance v0, Lio/socket/engineio/client/Socket$ReadyState;

    const-string v1, "CLOSED"

    const/4 v5, 0x3

    invoke-direct {v0, v1, v5}, Lio/socket/engineio/client/Socket$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Socket$ReadyState;->yY:Lio/socket/engineio/client/Socket$ReadyState;

    const/4 v0, 0x4

    .line 38
    new-array v0, v0, [Lio/socket/engineio/client/Socket$ReadyState;

    sget-object v1, Lio/socket/engineio/client/Socket$ReadyState;->yV:Lio/socket/engineio/client/Socket$ReadyState;

    aput-object v1, v0, v2

    sget-object v1, Lio/socket/engineio/client/Socket$ReadyState;->yW:Lio/socket/engineio/client/Socket$ReadyState;

    aput-object v1, v0, v3

    sget-object v1, Lio/socket/engineio/client/Socket$ReadyState;->yX:Lio/socket/engineio/client/Socket$ReadyState;

    aput-object v1, v0, v4

    sget-object v1, Lio/socket/engineio/client/Socket$ReadyState;->yY:Lio/socket/engineio/client/Socket$ReadyState;

    aput-object v1, v0, v5

    sput-object v0, Lio/socket/engineio/client/Socket$ReadyState;->yZ:[Lio/socket/engineio/client/Socket$ReadyState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 38
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lio/socket/engineio/client/Socket$ReadyState;
    .locals 1

    .line 38
    const-class v0, Lio/socket/engineio/client/Socket$ReadyState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lio/socket/engineio/client/Socket$ReadyState;

    return-object p0
.end method

.method public static values()[Lio/socket/engineio/client/Socket$ReadyState;
    .locals 1

    .line 38
    sget-object v0, Lio/socket/engineio/client/Socket$ReadyState;->yZ:[Lio/socket/engineio/client/Socket$ReadyState;

    invoke-virtual {v0}, [Lio/socket/engineio/client/Socket$ReadyState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/socket/engineio/client/Socket$ReadyState;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .line 43
    invoke-super {p0}, Ljava/lang/Enum;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
