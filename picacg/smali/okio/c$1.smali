.class Lokio/c$1;
.super Ljava/io/OutputStream;
.source "Buffer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lokio/c;->fy()Ljava/io/OutputStream;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic Ar:Lokio/c;


# direct methods
.method constructor <init>(Lokio/c;)V
    .locals 0

    .line 72
    iput-object p1, p0, Lokio/c$1;->Ar:Lokio/c;

    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 0

    return-void
.end method

.method public flush()V
    .locals 0

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 88
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lokio/c$1;->Ar:Lokio/c;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ".outputStream()"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public write(I)V
    .locals 1

    .line 74
    iget-object v0, p0, Lokio/c$1;->Ar:Lokio/c;

    int-to-byte p1, p1

    invoke-virtual {v0, p1}, Lokio/c;->am(I)Lokio/c;

    return-void
.end method

.method public write([BII)V
    .locals 1

    .line 78
    iget-object v0, p0, Lokio/c$1;->Ar:Lokio/c;

    invoke-virtual {v0, p1, p2, p3}, Lokio/c;->a([BII)Lokio/c;

    return-void
.end method
