.class public final enum Lio/socket/engineio/client/Transport$ReadyState;
.super Ljava/lang/Enum;
.source "Transport.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/socket/engineio/client/Transport;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "ReadyState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lio/socket/engineio/client/Transport$ReadyState;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum zf:Lio/socket/engineio/client/Transport$ReadyState;

.field public static final enum zg:Lio/socket/engineio/client/Transport$ReadyState;

.field public static final enum zh:Lio/socket/engineio/client/Transport$ReadyState;

.field public static final enum zi:Lio/socket/engineio/client/Transport$ReadyState;

.field private static final synthetic zj:[Lio/socket/engineio/client/Transport$ReadyState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 18
    new-instance v0, Lio/socket/engineio/client/Transport$ReadyState;

    const-string v1, "OPENING"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lio/socket/engineio/client/Transport$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Transport$ReadyState;->zf:Lio/socket/engineio/client/Transport$ReadyState;

    new-instance v0, Lio/socket/engineio/client/Transport$ReadyState;

    const-string v1, "OPEN"

    const/4 v3, 0x1

    invoke-direct {v0, v1, v3}, Lio/socket/engineio/client/Transport$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Transport$ReadyState;->zg:Lio/socket/engineio/client/Transport$ReadyState;

    new-instance v0, Lio/socket/engineio/client/Transport$ReadyState;

    const-string v1, "CLOSED"

    const/4 v4, 0x2

    invoke-direct {v0, v1, v4}, Lio/socket/engineio/client/Transport$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Transport$ReadyState;->zh:Lio/socket/engineio/client/Transport$ReadyState;

    new-instance v0, Lio/socket/engineio/client/Transport$ReadyState;

    const-string v1, "PAUSED"

    const/4 v5, 0x3

    invoke-direct {v0, v1, v5}, Lio/socket/engineio/client/Transport$ReadyState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/socket/engineio/client/Transport$ReadyState;->zi:Lio/socket/engineio/client/Transport$ReadyState;

    const/4 v0, 0x4

    .line 17
    new-array v0, v0, [Lio/socket/engineio/client/Transport$ReadyState;

    sget-object v1, Lio/socket/engineio/client/Transport$ReadyState;->zf:Lio/socket/engineio/client/Transport$ReadyState;

    aput-object v1, v0, v2

    sget-object v1, Lio/socket/engineio/client/Transport$ReadyState;->zg:Lio/socket/engineio/client/Transport$ReadyState;

    aput-object v1, v0, v3

    sget-object v1, Lio/socket/engineio/client/Transport$ReadyState;->zh:Lio/socket/engineio/client/Transport$ReadyState;

    aput-object v1, v0, v4

    sget-object v1, Lio/socket/engineio/client/Transport$ReadyState;->zi:Lio/socket/engineio/client/Transport$ReadyState;

    aput-object v1, v0, v5

    sput-object v0, Lio/socket/engineio/client/Transport$ReadyState;->zj:[Lio/socket/engineio/client/Transport$ReadyState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 17
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lio/socket/engineio/client/Transport$ReadyState;
    .locals 1

    .line 17
    const-class v0, Lio/socket/engineio/client/Transport$ReadyState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lio/socket/engineio/client/Transport$ReadyState;

    return-object p0
.end method

.method public static values()[Lio/socket/engineio/client/Transport$ReadyState;
    .locals 1

    .line 17
    sget-object v0, Lio/socket/engineio/client/Transport$ReadyState;->zj:[Lio/socket/engineio/client/Transport$ReadyState;

    invoke-virtual {v0}, [Lio/socket/engineio/client/Transport$ReadyState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/socket/engineio/client/Transport$ReadyState;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .line 22
    invoke-super {p0}, Ljava/lang/Enum;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
