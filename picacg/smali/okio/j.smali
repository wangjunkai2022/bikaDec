.class public final Lokio/j;
.super Ljava/lang/Object;
.source "InflaterSource.java"

# interfaces
.implements Lokio/q;


# instance fields
.field private final Aw:Ljava/util/zip/Inflater;

.field private Ay:I

.field private closed:Z

.field private final source:Lokio/e;


# direct methods
.method constructor <init>(Lokio/e;Ljava/util/zip/Inflater;)V
    .locals 0

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_1

    if-eqz p2, :cond_0

    .line 51
    iput-object p1, p0, Lokio/j;->source:Lokio/e;

    .line 52
    iput-object p2, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    return-void

    .line 50
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "inflater == null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 49
    :cond_1
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "source == null"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private ga()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 112
    iget v0, p0, Lokio/j;->Ay:I

    if-nez v0, :cond_0

    return-void

    .line 113
    :cond_0
    iget v0, p0, Lokio/j;->Ay:I

    iget-object v1, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    invoke-virtual {v1}, Ljava/util/zip/Inflater;->getRemaining()I

    move-result v1

    sub-int/2addr v0, v1

    .line 114
    iget v1, p0, Lokio/j;->Ay:I

    sub-int/2addr v1, v0

    iput v1, p0, Lokio/j;->Ay:I

    .line 115
    iget-object v1, p0, Lokio/j;->source:Lokio/e;

    int-to-long v2, v0

    invoke-interface {v1, v2, v3}, Lokio/e;->t(J)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 123
    iget-boolean v0, p0, Lokio/j;->closed:Z

    if-eqz v0, :cond_0

    return-void

    .line 124
    :cond_0
    iget-object v0, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->end()V

    const/4 v0, 0x1

    .line 125
    iput-boolean v0, p0, Lokio/j;->closed:Z

    .line 126
    iget-object v0, p0, Lokio/j;->source:Lokio/e;

    invoke-interface {v0}, Lokio/e;->close()V

    return-void
.end method

.method public fZ()Z
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 95
    iget-object v0, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->needsInput()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    .line 97
    :cond_0
    invoke-direct {p0}, Lokio/j;->ga()V

    .line 98
    iget-object v0, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->getRemaining()I

    move-result v0

    if-nez v0, :cond_2

    .line 101
    iget-object v0, p0, Lokio/j;->source:Lokio/e;

    invoke-interface {v0}, Lokio/e;->fB()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    return v0

    .line 104
    :cond_1
    iget-object v0, p0, Lokio/j;->source:Lokio/e;

    invoke-interface {v0}, Lokio/e;->fx()Lokio/c;

    move-result-object v0

    iget-object v0, v0, Lokio/c;->Aq:Lokio/n;

    .line 105
    iget v2, v0, Lokio/n;->limit:I

    iget v3, v0, Lokio/n;->pos:I

    sub-int/2addr v2, v3

    iput v2, p0, Lokio/j;->Ay:I

    .line 106
    iget-object v2, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    iget-object v3, v0, Lokio/n;->data:[B

    iget v0, v0, Lokio/n;->pos:I

    iget v4, p0, Lokio/j;->Ay:I

    invoke-virtual {v2, v3, v0, v4}, Ljava/util/zip/Inflater;->setInput([BII)V

    return v1

    .line 98
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "?"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public read(Lokio/c;J)J
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-wide/16 v0, 0x0

    cmp-long v2, p2, v0

    if-ltz v2, :cond_7

    .line 58
    iget-boolean v2, p0, Lokio/j;->closed:Z

    if-nez v2, :cond_6

    cmp-long v2, p2, v0

    if-nez v2, :cond_0

    return-wide v0

    .line 62
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lokio/j;->fZ()Z

    move-result p2

    const/4 p3, 0x1

    .line 66
    :try_start_0
    invoke-virtual {p1, p3}, Lokio/c;->ap(I)Lokio/n;

    move-result-object p3

    .line 67
    iget-object v0, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    iget-object v1, p3, Lokio/n;->data:[B

    iget v2, p3, Lokio/n;->limit:I

    iget v3, p3, Lokio/n;->limit:I

    rsub-int v3, v3, 0x2000

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/zip/Inflater;->inflate([BII)I

    move-result v0

    if-lez v0, :cond_1

    .line 69
    iget p2, p3, Lokio/n;->limit:I

    add-int/2addr p2, v0

    iput p2, p3, Lokio/n;->limit:I

    .line 70
    iget-wide p2, p1, Lokio/c;->size:J

    int-to-long v0, v0

    add-long/2addr p2, v0

    iput-wide p2, p1, Lokio/c;->size:J

    return-wide v0

    .line 73
    :cond_1
    iget-object v0, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->finished()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lokio/j;->Aw:Ljava/util/zip/Inflater;

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->needsDictionary()Z

    move-result v0

    if-eqz v0, :cond_2

    goto :goto_1

    :cond_2
    if-nez p2, :cond_3

    goto :goto_0

    .line 82
    :cond_3
    new-instance p1, Ljava/io/EOFException;

    const-string p2, "source exhausted prematurely"

    invoke-direct {p1, p2}, Ljava/io/EOFException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 74
    :cond_4
    :goto_1
    invoke-direct {p0}, Lokio/j;->ga()V

    .line 75
    iget p2, p3, Lokio/n;->pos:I

    iget v0, p3, Lokio/n;->limit:I

    if-ne p2, v0, :cond_5

    .line 77
    invoke-virtual {p3}, Lokio/n;->gd()Lokio/n;

    move-result-object p2

    iput-object p2, p1, Lokio/c;->Aq:Lokio/n;

    .line 78
    invoke-static {p3}, Lokio/o;->b(Lokio/n;)V
    :try_end_0
    .catch Ljava/util/zip/DataFormatException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_5
    const-wide/16 p1, -0x1

    return-wide p1

    :catch_0
    move-exception p1

    .line 84
    new-instance p2, Ljava/io/IOException;

    invoke-direct {p2, p1}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    .line 58
    :cond_6
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "closed"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 57
    :cond_7
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "byteCount < 0: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public timeout()Lokio/r;
    .locals 1

    .line 119
    iget-object v0, p0, Lokio/j;->source:Lokio/e;

    invoke-interface {v0}, Lokio/e;->timeout()Lokio/r;

    move-result-object v0

    return-object v0
.end method
