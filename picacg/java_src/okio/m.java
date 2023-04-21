package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class m implements e {
    public final q AE;
    public final c buffer = new c();
    boolean closed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(q qVar) {
        if (qVar == null) {
            throw new NullPointerException("source == null");
        }
        this.AE = qVar;
    }

    @Override // okio.e
    public c fx() {
        return this.buffer;
    }

    @Override // okio.q
    public long read(c cVar, long j) throws IOException {
        if (cVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else {
                if (this.buffer.size == 0 && this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1L;
                }
                return this.buffer.read(cVar, Math.min(j, this.buffer.size));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.e
    public boolean fB() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.fB() && this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // okio.e
    public void l(long j) throws IOException {
        if (!m(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public boolean m(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else {
            while (this.buffer.size < j) {
                if (this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // okio.e
    public byte readByte() throws IOException {
        l(1L);
        return this.buffer.readByte();
    }

    @Override // okio.e
    public ByteString o(long j) throws IOException {
        l(j);
        return this.buffer.o(j);
    }

    @Override // okio.e
    public byte[] fL() throws IOException {
        this.buffer.a(this.AE);
        return this.buffer.fL();
    }

    @Override // okio.e
    public byte[] s(long j) throws IOException {
        l(j);
        return this.buffer.s(j);
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            l(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.buffer.size > 0) {
                int read = this.buffer.read(bArr, i, (int) this.buffer.size);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw e;
        }
    }

    @Override // okio.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = i2;
        s.checkOffsetAndCount(bArr.length, i, j);
        if (this.buffer.size == 0 && this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i, (int) Math.min(j, this.buffer.size));
    }

    @Override // okio.e
    public void a(c cVar, long j) throws IOException {
        try {
            l(j);
            this.buffer.a(cVar, j);
        } catch (EOFException e) {
            cVar.a((q) this.buffer);
            throw e;
        }
    }

    @Override // okio.e
    public long a(p pVar) throws IOException {
        if (pVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long fD = this.buffer.fD();
            if (fD > 0) {
                j += fD;
                pVar.write(this.buffer, fD);
            }
        }
        if (this.buffer.size() > 0) {
            long size = j + this.buffer.size();
            pVar.write(this.buffer, this.buffer.size());
            return size;
        }
        return j;
    }

    @Override // okio.e
    public String a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.a(this.AE);
        return this.buffer.a(charset);
    }

    @Override // okio.e
    public String fJ() throws IOException {
        return q(Long.MAX_VALUE);
    }

    public String q(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long a = a((byte) 10, 0L, j2);
        if (a != -1) {
            return this.buffer.r(a);
        }
        if (j2 < Long.MAX_VALUE && m(j2) && this.buffer.n(j2 - 1) == 13 && m(1 + j2) && this.buffer.n(j2) == 10) {
            return this.buffer.r(j2);
        }
        c cVar = new c();
        this.buffer.a(cVar, 0L, Math.min(32L, this.buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j) + " content=" + cVar.readByteString().fU() + (char) 8230);
    }

    @Override // okio.e
    public short readShort() throws IOException {
        l(2L);
        return this.buffer.readShort();
    }

    @Override // okio.e
    public short fE() throws IOException {
        l(2L);
        return this.buffer.fE();
    }

    @Override // okio.e
    public int readInt() throws IOException {
        l(4L);
        return this.buffer.readInt();
    }

    @Override // okio.e
    public int fF() throws IOException {
        l(4L);
        return this.buffer.fF();
    }

    @Override // okio.e
    public long readLong() throws IOException {
        l(8L);
        return this.buffer.readLong();
    }

    @Override // okio.e
    public long fG() throws IOException {
        byte n;
        l(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!m(i2)) {
                break;
            }
            n = this.buffer.n(i);
            if ((n < 48 || n > 57) && !(i == 0 && n == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(n)));
        }
        return this.buffer.fG();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long fH() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.l(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.m(r3)
            if (r3 == 0) goto L4a
            okio.c r3 = r6.buffer
            long r4 = (long) r1
            byte r3 = r3.n(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.c r0 = r6.buffer
            long r0 = r0.fH()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.m.fH():long");
    }

    @Override // okio.e
    public void t(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.buffer.size == 0 && this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.buffer.size());
            this.buffer.t(min);
            j -= min;
        }
    }

    @Override // okio.e
    public long a(byte b) throws IOException {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j, long j2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a = this.buffer.a(b, j, j2);
            if (a != -1) {
                return a;
            }
            long j3 = this.buffer.size;
            if (j3 >= j2 || this.AE.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // okio.e
    public boolean a(long j, ByteString byteString) throws IOException {
        return a(j, byteString, 0, byteString.size());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!m(1 + j2) || this.buffer.n(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.e
    public InputStream fC() {
        return new InputStream() { // from class: okio.m.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (m.this.closed) {
                    throw new IOException("closed");
                }
                if (m.this.buffer.size == 0 && m.this.AE.read(m.this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return m.this.buffer.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (m.this.closed) {
                    throw new IOException("closed");
                }
                s.checkOffsetAndCount(bArr.length, i, i2);
                if (m.this.buffer.size == 0 && m.this.AE.read(m.this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return m.this.buffer.read(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (m.this.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(m.this.buffer.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                m.this.close();
            }

            public String toString() {
                return m.this + ".inputStream()";
            }
        };
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.AE.close();
        this.buffer.clear();
    }

    @Override // okio.q
    public r timeout() {
        return this.AE.timeout();
    }

    public String toString() {
        return "buffer(" + this.AE + ")";
    }
}
