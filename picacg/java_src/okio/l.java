package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
final class l implements d {
    public final p AD;
    public final c buffer = new c();
    boolean closed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.AD = pVar;
    }

    @Override // okio.d, okio.e
    public c fx() {
        return this.buffer;
    }

    @Override // okio.p
    public void write(c cVar, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(cVar, j);
        fO();
    }

    @Override // okio.d
    public d b(ByteString byteString) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.b(byteString);
        return fO();
    }

    @Override // okio.d
    public d aV(String str) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.aV(str);
        return fO();
    }

    @Override // okio.d
    public d k(byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.k(bArr);
        return fO();
    }

    @Override // okio.d
    public d b(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.b(bArr, i, i2);
        return fO();
    }

    @Override // okio.d
    public long a(q qVar) throws IOException {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = qVar.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
            fO();
        }
    }

    @Override // okio.d
    public d at(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.at(i);
        return fO();
    }

    @Override // okio.d
    public d as(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.as(i);
        return fO();
    }

    @Override // okio.d
    public d ar(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.ar(i);
        return fO();
    }

    @Override // okio.d
    public d z(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.z(j);
        return fO();
    }

    @Override // okio.d
    public d y(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.y(j);
        return fO();
    }

    @Override // okio.d
    public d x(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.x(j);
        return fO();
    }

    @Override // okio.d
    public d fO() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long fD = this.buffer.fD();
        if (fD > 0) {
            this.AD.write(this.buffer, fD);
        }
        return this;
    }

    @Override // okio.d
    public d fA() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.AD.write(this.buffer, size);
        }
        return this;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.buffer.size > 0) {
            this.AD.write(this.buffer, this.buffer.size);
        }
        this.AD.flush();
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.buffer.size > 0) {
                this.AD.write(this.buffer, this.buffer.size);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.AD.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            s.c(th);
        }
    }

    @Override // okio.p
    public r timeout() {
        return this.AD.timeout();
    }

    public String toString() {
        return "buffer(" + this.AD + ")";
    }
}
