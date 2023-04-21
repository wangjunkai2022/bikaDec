package okio;

import java.io.IOException;
/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class f implements p {
    private final p delegate;

    public f(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = pVar;
    }

    public final p delegate() {
        return this.delegate;
    }

    @Override // okio.p
    public void write(c cVar, long j) throws IOException {
        this.delegate.write(cVar, j);
    }

    @Override // okio.p, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.p
    public r timeout() {
        return this.delegate.timeout();
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
