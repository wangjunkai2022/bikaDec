.class final enum Lio/socket/client/Manager$ReadyState;
.super Ljava/lang/Enum;
.source "Manager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/socket/client/Manager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "ReadyState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lio/socket/client/Manager$ReadyState;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum xt:Lio/socket/client/Manager$ReadyState;

.field public static final enum xu:Lio/socket/client/Manager$ReadyState;

.field public static final enum xv:Lio/socket/client/Manager$ReadyState;

.field private static final synthetic xw:[Lio/socket/client/Manager$ReadyState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .line 25
    new-instance v0, Lio/socket/client/Manager$ReadyState;

    const-string v1, "CLOSED"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lio/socket/client/Manager$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/client/Manager$ReadyState;->xt:Lio/socket/client/Manager$ReadyState;

    new-instance v0, Lio/socket/client/Manager$ReadyState;

    const-string v1, "OPENING"

    const/4 v3, 0x1

    invoke-direct {v0, v1, v3}, Lio/socket/client/Manager$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/client/Manager$ReadyState;->xu:Lio/socket/client/Manager$ReadyState;

    new-instance v0, Lio/socket/client/Manager$ReadyState;

    const-string v1, "OPEN"

    const/4 v4, 0x2

    invoke-direct {v0, v1, v4}, Lio/socket/client/Manager$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/client/Manager$ReadyState;->xv:Lio/socket/client/Manager$ReadyState;

    const/4 v0, 0x3

    .line 24
    new-array v0, v0, [Lio/socket/client/Manager$ReadyState;

    sget-object v1, Lio/socket/client/Manager$ReadyState;->xt:Lio/socket/client/Manager$ReadyState;

    aput-object v1, v0, v2

    sget-object v1, Lio/socket/client/Manager$ReadyState;->xu:Lio/socket/client/Manager$ReadyState;

    aput-object v1, v0, v3

    sget-object v1, Lio/socket/client/Manager$ReadyState;->xv:Lio/socket/client/Manager$ReadyState;

    aput-object v1, v0, v4

    sput-object v0, Lio/socket/client/Manager$ReadyState;->xw:[Lio/socket/client/Manager$ReadyState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lio/socket/client/Manager$ReadyState;
    .locals 1

    .line 24
    const-class v0, Lio/socket/client/Manager$ReadyState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lio/socket/client/Manager$ReadyState;

    return-object p0
.end method

.method public static values()[Lio/socket/client/Manager$ReadyState;
    .locals 1

    .line 24
    sget-object v0, Lio/socket/client/Manager$ReadyState;->xw:[Lio/socket/client/Manager$ReadyState;

    invoke-virtual {v0}, [Lio/socket/client/Manager$ReadyState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/socket/client/Manager$ReadyState;

    return-object v0
.end method
