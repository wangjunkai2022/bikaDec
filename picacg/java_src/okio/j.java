package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class j implements q {
    private final Inflater Aw;
    private int Ay;
    private boolean closed;
    private final e source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.source = eVar;
        this.Aw = inflater;
    }

    @Override // okio.q
    public long read(c cVar, long j) throws IOException {
        n ap;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else {
            if (j == 0) {
                return 0L;
            }
            while (true) {
                boolean fZ = fZ();
                try {
                    ap = cVar.ap(1);
                    int inflate = this.Aw.inflate(ap.data, ap.limit, 8192 - ap.limit);
                    if (inflate > 0) {
                        ap.limit += inflate;
                        long j2 = inflate;
                        cVar.size += j2;
                        return j2;
                    } else if (this.Aw.finished() || this.Aw.needsDictionary()) {
                        break;
                    } else if (fZ) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            ga();
            if (ap.pos == ap.limit) {
                cVar.Aq = ap.gd();
                o.b(ap);
                return -1L;
            }
            return -1L;
        }
    }

    public boolean fZ() throws IOException {
        if (this.Aw.needsInput()) {
            ga();
            if (this.Aw.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.source.fB()) {
                return true;
            }
            n nVar = this.source.fx().Aq;
            this.Ay = nVar.limit - nVar.pos;
            this.Aw.setInput(nVar.data, nVar.pos, this.Ay);
            return false;
        }
        return false;
    }

    private void ga() throws IOException {
        if (this.Ay == 0) {
            return;
        }
        int remaining = this.Ay - this.Aw.getRemaining();
        this.Ay -= remaining;
        this.source.t(remaining);
    }

    @Override // okio.q
    public r timeout() {
        return this.source.timeout();
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.Aw.end();
        this.closed = true;
        this.source.close();
    }
}
