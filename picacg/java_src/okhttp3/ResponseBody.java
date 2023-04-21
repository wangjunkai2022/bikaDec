package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.c;
import okio.e;
/* loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract e source();

    public final InputStream byteStream() {
        return source().fC();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        e source = source();
        try {
            byte[] fL = source.fL();
            Util.closeQuietly(source);
            if (contentLength == -1 || contentLength == fL.length) {
                return fL;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + fL.length + ") disagree");
        } catch (Throwable th) {
            Util.closeQuietly(source);
            throw th;
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public final String string() throws IOException {
        e source = source();
        try {
            return source.a(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly(source);
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        c a = new c().a(str, charset);
        return create(mediaType, a.size(), a);
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new c().k(bArr));
    }

    public static ResponseBody create(@Nullable final MediaType mediaType, final long j, final e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ResponseBody() { // from class: okhttp3.ResponseBody.1
            @Override // okhttp3.ResponseBody
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.ResponseBody
            public long contentLength() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            public e source() {
                return eVar;
            }
        };
    }

    /* loaded from: classes.dex */
    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final e source;

        BomAwareReader(e eVar, Charset charset) {
            this.source = eVar;
            this.charset = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.source.fC(), Util.bomAwareCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            if (this.delegate != null) {
                this.delegate.close();
            } else {
                this.source.close();
            }
        }
    }
}
