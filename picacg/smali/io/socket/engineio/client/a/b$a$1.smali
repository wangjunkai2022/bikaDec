.class Lio/socket/engineio/client/a/b$a$1;
.super Ljava/lang/Object;
.source "PollingXHR.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/socket/engineio/client/a/b$a;->create()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zB:Lio/socket/engineio/client/a/b$a;

.field final synthetic zC:Lio/socket/engineio/client/a/b$a;


# direct methods
.method constructor <init>(Lio/socket/engineio/client/a/b$a;Lio/socket/engineio/client/a/b$a;)V
    .locals 0

    .line 199
    iput-object p1, p0, Lio/socket/engineio/client/a/b$a$1;->zC:Lio/socket/engineio/client/a/b$a;

    iput-object p2, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    const/4 v0, 0x0

    .line 204
    :try_start_0
    iget-object v1, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v1}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;)[B

    move-result-object v1

    if-eqz v1, :cond_0

    .line 205
    iget-object v1, p0, Lio/socket/engineio/client/a/b$a$1;->zC:Lio/socket/engineio/client/a/b$a;

    invoke-static {v1}, Lio/socket/engineio/client/a/b$a;->b(Lio/socket/engineio/client/a/b$a;)Ljava/net/HttpURLConnection;

    move-result-object v1

    iget-object v2, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v2}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;)[B

    move-result-object v2

    array-length v2, v2

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    .line 206
    new-instance v1, Ljava/io/BufferedOutputStream;

    iget-object v2, p0, Lio/socket/engineio/client/a/b$a$1;->zC:Lio/socket/engineio/client/a/b$a;

    invoke-static {v2}, Lio/socket/engineio/client/a/b$a;->b(Lio/socket/engineio/client/a/b$a;)Ljava/net/HttpURLConnection;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 207
    :try_start_1
    iget-object v0, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v0}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;)[B

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/OutputStream;->write([B)V

    .line 208
    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v0, v1

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    goto :goto_6

    :catch_0
    move-exception v0

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    goto :goto_3

    :catch_1
    move-exception v0

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    goto :goto_4

    .line 211
    :cond_0
    :goto_0
    :try_start_2
    iget-object v1, p0, Lio/socket/engineio/client/a/b$a$1;->zC:Lio/socket/engineio/client/a/b$a;

    invoke-static {v1}, Lio/socket/engineio/client/a/b$a;->b(Lio/socket/engineio/client/a/b$a;)Ljava/net/HttpURLConnection;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v1

    .line 212
    iget-object v2, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v2, v1}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;Ljava/util/Map;)V

    .line 214
    iget-object v1, p0, Lio/socket/engineio/client/a/b$a$1;->zC:Lio/socket/engineio/client/a/b$a;

    invoke-static {v1}, Lio/socket/engineio/client/a/b$a;->b(Lio/socket/engineio/client/a/b$a;)Ljava/net/HttpURLConnection;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    const/16 v2, 0xc8

    if-ne v2, v1, :cond_1

    .line 216
    iget-object v1, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v1}, Lio/socket/engineio/client/a/b$a;->c(Lio/socket/engineio/client/a/b$a;)V

    goto :goto_1

    .line 218
    :cond_1
    iget-object v2, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    new-instance v3, Ljava/io/IOException;

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    invoke-static {v2, v3}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;Ljava/lang/Exception;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/NullPointerException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :goto_1
    if-eqz v0, :cond_2

    .line 228
    :goto_2
    :try_start_3
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    goto :goto_5

    :catchall_1
    move-exception v1

    goto :goto_6

    :catch_2
    move-exception v1

    .line 225
    :goto_3
    :try_start_4
    iget-object v2, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v2, v1}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;Ljava/lang/Exception;)V

    if-eqz v0, :cond_2

    goto :goto_2

    :catch_3
    move-exception v1

    .line 221
    :goto_4
    iget-object v2, p0, Lio/socket/engineio/client/a/b$a$1;->zB:Lio/socket/engineio/client/a/b$a;

    invoke-static {v2, v1}, Lio/socket/engineio/client/a/b$a;->a(Lio/socket/engineio/client/a/b$a;Ljava/lang/Exception;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    if-eqz v0, :cond_2

    goto :goto_2

    :catch_4
    :cond_2
    :goto_5
    return-void

    :goto_6
    if-eqz v0, :cond_3

    .line 228
    :try_start_5
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_5

    .line 229
    :catch_5
    :cond_3
    throw v1
.end method
