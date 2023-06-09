.class final Lokhttp3/internal/ws/WebSocketWriter;
.super Ljava/lang/Object;
.source "WebSocketWriter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lokhttp3/internal/ws/WebSocketWriter$FrameSink;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field activeWriter:Z

.field final buffer:Lokio/c;

.field final frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

.field final isClient:Z

.field final maskBuffer:[B

.field final maskKey:[B

.field final random:Ljava/util/Random;

.field final sink:Lokio/d;

.field writerClosed:Z


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method constructor <init>(ZLokio/d;Ljava/util/Random;)V
    .locals 1

    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    new-instance v0, Lokio/c;

    invoke-direct {v0}, Lokio/c;-><init>()V

    iput-object v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->buffer:Lokio/c;

    .line 57
    new-instance v0, Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    invoke-direct {v0, p0}, Lokhttp3/internal/ws/WebSocketWriter$FrameSink;-><init>(Lokhttp3/internal/ws/WebSocketWriter;)V

    iput-object v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    if-eqz p2, :cond_3

    if-eqz p3, :cond_2

    .line 67
    iput-boolean p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->isClient:Z

    .line 68
    iput-object p2, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    .line 69
    iput-object p3, p0, Lokhttp3/internal/ws/WebSocketWriter;->random:Ljava/util/Random;

    const/4 p2, 0x0

    if-eqz p1, :cond_0

    const/4 p3, 0x4

    .line 72
    new-array p3, p3, [B

    goto :goto_0

    :cond_0
    move-object p3, p2

    :goto_0
    iput-object p3, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    if-eqz p1, :cond_1

    const/16 p1, 0x2000

    .line 73
    new-array p2, p1, [B

    :cond_1
    iput-object p2, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskBuffer:[B

    return-void

    .line 66
    :cond_2
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "random == null"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 65
    :cond_3
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "sink == null"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private writeControlFrameSynchronized(ILokio/ByteString;)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 123
    iget-boolean v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->writerClosed:Z

    if-nez v0, :cond_2

    .line 125
    invoke-virtual {p2}, Lokio/ByteString;->size()I

    move-result v0

    int-to-long v1, v0

    const-wide/16 v3, 0x7d

    cmp-long v5, v1, v3

    if-gtz v5, :cond_1

    or-int/lit16 p1, p1, 0x80

    .line 132
    iget-object v1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {v1, p1}, Lokio/d;->at(I)Lokio/d;

    .line 135
    iget-boolean p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->isClient:Z

    if-eqz p1, :cond_0

    or-int/lit16 p1, v0, 0x80

    .line 137
    iget-object v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {v0, p1}, Lokio/d;->at(I)Lokio/d;

    .line 139
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->random:Ljava/util/Random;

    iget-object v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    invoke-virtual {p1, v0}, Ljava/util/Random;->nextBytes([B)V

    .line 140
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    iget-object v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    invoke-interface {p1, v0}, Lokio/d;->k([B)Lokio/d;

    .line 142
    invoke-virtual {p2}, Lokio/ByteString;->toByteArray()[B

    move-result-object p1

    .line 143
    array-length p2, p1

    int-to-long v2, p2

    iget-object v4, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    const-wide/16 v5, 0x0

    move-object v1, p1

    invoke-static/range {v1 .. v6}, Lokhttp3/internal/ws/WebSocketProtocol;->toggleMask([BJ[BJ)V

    .line 144
    iget-object p2, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p2, p1}, Lokio/d;->k([B)Lokio/d;

    goto :goto_0

    .line 146
    :cond_0
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p1, v0}, Lokio/d;->at(I)Lokio/d;

    .line 147
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p1, p2}, Lokio/d;->b(Lokio/ByteString;)Lokio/d;

    .line 150
    :goto_0
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p1}, Lokio/d;->flush()V

    return-void

    .line 127
    :cond_1
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Payload size must be less than or equal to 125"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 123
    :cond_2
    new-instance p1, Ljava/io/IOException;

    const-string p2, "closed"

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method newMessageSink(IJ)Lokio/p;
    .locals 2

    .line 158
    iget-boolean v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->activeWriter:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    .line 161
    iput-boolean v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->activeWriter:Z

    .line 164
    iget-object v1, p0, Lokhttp3/internal/ws/WebSocketWriter;->frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    iput p1, v1, Lokhttp3/internal/ws/WebSocketWriter$FrameSink;->formatOpcode:I

    .line 165
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    iput-wide p2, p1, Lokhttp3/internal/ws/WebSocketWriter$FrameSink;->contentLength:J

    .line 166
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    iput-boolean v0, p1, Lokhttp3/internal/ws/WebSocketWriter$FrameSink;->isFirstFrame:Z

    .line 167
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    const/4 p2, 0x0

    iput-boolean p2, p1, Lokhttp3/internal/ws/WebSocketWriter$FrameSink;->closed:Z

    .line 169
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->frameSink:Lokhttp3/internal/ws/WebSocketWriter$FrameSink;

    return-object p1

    .line 159
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Another message writer is active. Did you call close()?"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method writeClose(ILokio/ByteString;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 98
    sget-object v0, Lokio/ByteString;->As:Lokio/ByteString;

    if-nez p1, :cond_0

    if-eqz p2, :cond_3

    :cond_0
    if-eqz p1, :cond_1

    .line 101
    invoke-static {p1}, Lokhttp3/internal/ws/WebSocketProtocol;->validateCloseCode(I)V

    .line 103
    :cond_1
    new-instance v0, Lokio/c;

    invoke-direct {v0}, Lokio/c;-><init>()V

    .line 104
    invoke-virtual {v0, p1}, Lokio/c;->an(I)Lokio/c;

    if-eqz p2, :cond_2

    .line 106
    invoke-virtual {v0, p2}, Lokio/c;->a(Lokio/ByteString;)Lokio/c;

    .line 108
    :cond_2
    invoke-virtual {v0}, Lokio/c;->readByteString()Lokio/ByteString;

    move-result-object v0

    .line 111
    :cond_3
    monitor-enter p0

    const/16 p1, 0x8

    const/4 p2, 0x1

    .line 113
    :try_start_0
    invoke-direct {p0, p1, v0}, Lokhttp3/internal/ws/WebSocketWriter;->writeControlFrameSynchronized(ILokio/ByteString;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 115
    :try_start_1
    iput-boolean p2, p0, Lokhttp3/internal/ws/WebSocketWriter;->writerClosed:Z

    .line 117
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    goto :goto_0

    :catchall_1
    move-exception p1

    .line 115
    iput-boolean p2, p0, Lokhttp3/internal/ws/WebSocketWriter;->writerClosed:Z

    throw p1

    .line 117
    :goto_0
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p1
.end method

.method writeMessageFrameSynchronized(IJZZ)V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 176
    iget-boolean v0, p0, Lokhttp3/internal/ws/WebSocketWriter;->writerClosed:Z

    if-nez v0, :cond_8

    const/4 v0, 0x0

    if-eqz p4, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    if-eqz p5, :cond_1

    or-int/lit16 p1, p1, 0x80

    .line 182
    :cond_1
    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p4, p1}, Lokio/d;->at(I)Lokio/d;

    .line 185
    iget-boolean p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->isClient:Z

    if-eqz p1, :cond_2

    const/16 p1, 0x80

    goto :goto_1

    :cond_2
    const/4 p1, 0x0

    :goto_1
    const-wide/16 p4, 0x7d

    cmp-long v1, p2, p4

    if-gtz v1, :cond_3

    long-to-int p4, p2

    or-int/2addr p1, p4

    .line 190
    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p4, p1}, Lokio/d;->at(I)Lokio/d;

    goto :goto_2

    :cond_3
    const-wide/32 p4, 0xffff

    cmp-long v1, p2, p4

    if-gtz v1, :cond_4

    or-int/lit8 p1, p1, 0x7e

    .line 193
    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p4, p1}, Lokio/d;->at(I)Lokio/d;

    .line 194
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    long-to-int p4, p2

    invoke-interface {p1, p4}, Lokio/d;->as(I)Lokio/d;

    goto :goto_2

    :cond_4
    or-int/lit8 p1, p1, 0x7f

    .line 197
    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p4, p1}, Lokio/d;->at(I)Lokio/d;

    .line 198
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p1, p2, p3}, Lokio/d;->z(J)Lokio/d;

    .line 201
    :goto_2
    iget-boolean p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->isClient:Z

    if-eqz p1, :cond_6

    .line 202
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->random:Ljava/util/Random;

    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    invoke-virtual {p1, p4}, Ljava/util/Random;->nextBytes([B)V

    .line 203
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    invoke-interface {p1, p4}, Lokio/d;->k([B)Lokio/d;

    const-wide/16 p4, 0x0

    :goto_3
    cmp-long p1, p4, p2

    if-gez p1, :cond_7

    .line 206
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskBuffer:[B

    array-length p1, p1

    int-to-long v1, p1

    invoke-static {p2, p3, v1, v2}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v1

    long-to-int p1, v1

    .line 207
    iget-object v1, p0, Lokhttp3/internal/ws/WebSocketWriter;->buffer:Lokio/c;

    iget-object v2, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskBuffer:[B

    invoke-virtual {v1, v2, v0, p1}, Lokio/c;->read([BII)I

    move-result p1

    const/4 v1, -0x1

    if-eq p1, v1, :cond_5

    .line 209
    iget-object v1, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskBuffer:[B

    int-to-long v7, p1

    iget-object v4, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskKey:[B

    move-wide v2, v7

    move-wide v5, p4

    invoke-static/range {v1 .. v6}, Lokhttp3/internal/ws/WebSocketProtocol;->toggleMask([BJ[BJ)V

    .line 210
    iget-object v1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    iget-object v2, p0, Lokhttp3/internal/ws/WebSocketWriter;->maskBuffer:[B

    invoke-interface {v1, v2, v0, p1}, Lokio/d;->b([BII)Lokio/d;

    add-long/2addr p4, v7

    goto :goto_3

    .line 208
    :cond_5
    new-instance p1, Ljava/lang/AssertionError;

    invoke-direct {p1}, Ljava/lang/AssertionError;-><init>()V

    throw p1

    .line 214
    :cond_6
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    iget-object p4, p0, Lokhttp3/internal/ws/WebSocketWriter;->buffer:Lokio/c;

    invoke-interface {p1, p4, p2, p3}, Lokio/d;->write(Lokio/c;J)V

    .line 217
    :cond_7
    iget-object p1, p0, Lokhttp3/internal/ws/WebSocketWriter;->sink:Lokio/d;

    invoke-interface {p1}, Lokio/d;->fA()Lokio/d;

    return-void

    .line 176
    :cond_8
    new-instance p1, Ljava/io/IOException;

    const-string p2, "closed"

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method writePing(Lokio/ByteString;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 78
    monitor-enter p0

    const/16 v0, 0x9

    .line 79
    :try_start_0
    invoke-direct {p0, v0, p1}, Lokhttp3/internal/ws/WebSocketWriter;->writeControlFrameSynchronized(ILokio/ByteString;)V

    .line 80
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p1
.end method

.method writePong(Lokio/ByteString;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 85
    monitor-enter p0

    const/16 v0, 0xa

    .line 86
    :try_start_0
    invoke-direct {p0, v0, p1}, Lokhttp3/internal/ws/WebSocketWriter;->writeControlFrameSynchronized(ILokio/ByteString;)V

    .line 87
    monitor-exit p0

    return-void

    :catchall_0
    move-exception p1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p1
.end method
