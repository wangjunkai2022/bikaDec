package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements Cloneable, d, e {
    private static final byte[] Ap = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable
    n Aq;
    long size;

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.d
    public d fA() {
        return this;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
    }

    @Override // okio.d, okio.e
    public c fx() {
        return this;
    }

    @Override // okio.d
    /* renamed from: fz */
    public c fO() {
        return this;
    }

    public long size() {
        return this.size;
    }

    public OutputStream fy() {
        return new OutputStream() { // from class: okio.c.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                c.this.at((byte) i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                c.this.b(bArr, i, i2);
            }

            public String toString() {
                return c.this + ".outputStream()";
            }
        };
    }

    @Override // okio.e
    public boolean fB() {
        return this.size == 0;
    }

    @Override // okio.e
    public void l(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public boolean m(long j) {
        return this.size >= j;
    }

    @Override // okio.e
    public InputStream fC() {
        return new InputStream() { // from class: okio.c.2
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (c.this.size > 0) {
                    return c.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.read(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.size, 2147483647L);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        s.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.size += j2;
        n nVar = this.Aq;
        while (j >= nVar.limit - nVar.pos) {
            j -= nVar.limit - nVar.pos;
            nVar = nVar.AI;
        }
        while (j2 > 0) {
            n nVar2 = new n(nVar);
            nVar2.pos = (int) (nVar2.pos + j);
            nVar2.limit = Math.min(nVar2.pos + ((int) j2), nVar2.limit);
            if (cVar.Aq == null) {
                nVar2.AJ = nVar2;
                nVar2.AI = nVar2;
                cVar.Aq = nVar2;
            } else {
                cVar.Aq.AJ.a(nVar2);
            }
            j2 -= nVar2.limit - nVar2.pos;
            nVar = nVar.AI;
            j = 0;
        }
        return this;
    }

    public long fD() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        n nVar = this.Aq.AJ;
        return (nVar.limit >= 8192 || !nVar.AH) ? j : j - (nVar.limit - nVar.pos);
    }

    @Override // okio.e
    public byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        n nVar = this.Aq;
        int i = nVar.pos;
        int i2 = nVar.limit;
        int i3 = i + 1;
        byte b = nVar.data[i];
        this.size--;
        if (i3 == i2) {
            this.Aq = nVar.gd();
            o.b(nVar);
        } else {
            nVar.pos = i3;
        }
        return b;
    }

    public byte n(long j) {
        s.checkOffsetAndCount(this.size, j, 1L);
        n nVar = this.Aq;
        while (true) {
            long j2 = nVar.limit - nVar.pos;
            if (j >= j2) {
                j -= j2;
                nVar = nVar.AI;
            } else {
                return nVar.data[nVar.pos + ((int) j)];
            }
        }
    }

    @Override // okio.e
    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        n nVar = this.Aq;
        int i = nVar.pos;
        int i2 = nVar.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = nVar.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.size -= 2;
        if (i4 == i2) {
            this.Aq = nVar.gd();
            o.b(nVar);
        } else {
            nVar.pos = i4;
        }
        return (short) i5;
    }

    @Override // okio.e
    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        n nVar = this.Aq;
        int i = nVar.pos;
        int i2 = nVar.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = nVar.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.size -= 4;
        if (i8 == i2) {
            this.Aq = nVar.gd();
            o.b(nVar);
        } else {
            nVar.pos = i8;
        }
        return i9;
    }

    @Override // okio.e
    public long readLong() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        n nVar = this.Aq;
        int i8 = nVar.pos;
        int i9 = nVar.limit;
        if (i9 - i8 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = nVar.data;
        long j = ((bArr[i8] & 255) << 56) | ((bArr[i] & 255) << 48) | ((bArr[i2] & 255) << 40) | ((bArr[i3] & 255) << 32) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 16);
        int i10 = i8 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j2 = (bArr[i7] & 255) | ((bArr[i6] & 255) << 8) | j;
        this.size -= 8;
        if (i10 == i9) {
            this.Aq = nVar.gd();
            o.b(nVar);
        } else {
            nVar.pos = i10;
        }
        return j2;
    }

    @Override // okio.e
    public short fE() {
        return s.a(readShort());
    }

    @Override // okio.e
    public int fF() {
        return s.aw(readInt());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ae A[EDGE_INSN: B:46:0x00ae->B:39:0x00ae ?: BREAK  , SYNTHETIC] */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long fG() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lb9
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L10:
            okio.n r10 = r0.Aq
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L18:
            if (r12 >= r13) goto L9a
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6c
            r1 = 57
            if (r15 > r1) goto L6c
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L38
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L76
        L3f:
            okio.c r1 = new okio.c
            r1.<init>()
            okio.c r1 = r1.y(r3)
            okio.c r1 = r1.at(r15)
            if (r5 != 0) goto L51
            r1.readByte()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.fI()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r1 = 45
            if (r15 != r1) goto L7b
            if (r7 != 0) goto L7b
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L76:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L7b:
            if (r7 == 0) goto L7f
            r6 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9a:
            if (r12 != r13) goto La6
            okio.n r1 = r10.gd()
            r0.Aq = r1
            okio.o.b(r10)
            goto La8
        La6:
            r10.pos = r12
        La8:
            if (r6 != 0) goto Lae
            okio.n r1 = r0.Aq
            if (r1 != 0) goto L10
        Lae:
            long r1 = r0.size
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.size = r1
            if (r5 == 0) goto Lb7
            goto Lb8
        Lb7:
            long r3 = -r3
        Lb8:
            return r3
        Lb9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.fG():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a6 A[EDGE_INSN: B:42:0x00a6->B:37:0x00a6 ?: BREAK  , SYNTHETIC] */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long fH() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lad
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.n r6 = r15.Aq
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L92
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3b
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
            int r11 = r11 + 10
            goto L3b
        L2f:
            r11 = 65
            if (r10 < r11) goto L73
            r11 = 70
            if (r10 > r11) goto L73
            int r11 = r10 + (-65)
            int r11 = r11 + 10
        L3b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4b
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4b:
            okio.c r0 = new okio.c
            r0.<init>()
            okio.c r0 = r0.x(r4)
            okio.c r0 = r0.at(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.fI()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L73:
            if (r0 == 0) goto L77
            r1 = 1
            goto L92
        L77:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L92:
            if (r8 != r9) goto L9e
            okio.n r7 = r6.gd()
            r15.Aq = r7
            okio.o.b(r6)
            goto La0
        L9e:
            r6.pos = r8
        La0:
            if (r1 != 0) goto La6
            okio.n r6 = r15.Aq
            if (r6 != 0) goto Lb
        La6:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        Lad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.fH():long");
    }

    public ByteString readByteString() {
        return new ByteString(fL());
    }

    @Override // okio.e
    public ByteString o(long j) throws EOFException {
        return new ByteString(s(j));
    }

    @Override // okio.e
    public void a(c cVar, long j) throws EOFException {
        if (this.size < j) {
            cVar.write(this, this.size);
            throw new EOFException();
        } else {
            cVar.write(this, j);
        }
    }

    @Override // okio.e
    public long a(p pVar) throws IOException {
        long j = this.size;
        if (j > 0) {
            pVar.write(this, j);
        }
        return j;
    }

    public String fI() {
        try {
            return a(this.size, s.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String p(long j) throws EOFException {
        return a(j, s.UTF_8);
    }

    @Override // okio.e
    public String a(Charset charset) {
        try {
            return a(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        s.checkOffsetAndCount(this.size, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                n nVar = this.Aq;
                if (nVar.pos + j > nVar.limit) {
                    return new String(s(j), charset);
                }
                String str = new String(nVar.data, nVar.pos, (int) j, charset);
                nVar.pos = (int) (nVar.pos + j);
                this.size -= j;
                if (nVar.pos == nVar.limit) {
                    this.Aq = nVar.gd();
                    o.b(nVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.e
    public String fJ() throws EOFException {
        return q(Long.MAX_VALUE);
    }

    public String q(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long a = a((byte) 10, 0L, j2);
        if (a != -1) {
            return r(a);
        }
        if (j2 < size() && n(j2 - 1) == 13 && n(j2) == 10) {
            return r(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + cVar.readByteString().fU() + (char) 8230);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (n(j2) == 13) {
                String p = p(j2);
                t(2L);
                return p;
            }
        }
        String p2 = p(j);
        t(1L);
        return p2;
    }

    public int fK() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size == 0) {
            throw new EOFException();
        }
        byte n = n(0L);
        if ((n & 128) == 0) {
            i = n & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((n & 224) == 192) {
            i = n & 31;
            i2 = 2;
            i3 = 128;
        } else if ((n & 240) == 224) {
            i = n & 15;
            i2 = 3;
            i3 = 2048;
        } else if ((n & 248) != 240) {
            t(1L);
            return 65533;
        } else {
            i = n & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.size < j) {
            throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(n) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte n2 = n(j2);
            if ((n2 & 192) != 128) {
                t(j2);
                return 65533;
            }
            i = (i << 6) | (n2 & 63);
        }
        t(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    @Override // okio.e
    public byte[] fL() {
        try {
            return s(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.e
    public byte[] s(long j) throws EOFException {
        s.checkOffsetAndCount(this.size, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.e
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // okio.e
    public int read(byte[] bArr, int i, int i2) {
        s.checkOffsetAndCount(bArr.length, i, i2);
        n nVar = this.Aq;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i2, nVar.limit - nVar.pos);
        System.arraycopy(nVar.data, nVar.pos, bArr, i, min);
        nVar.pos += min;
        this.size -= min;
        if (nVar.pos == nVar.limit) {
            this.Aq = nVar.gd();
            o.b(nVar);
        }
        return min;
    }

    public void clear() {
        try {
            t(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.e
    public void t(long j) throws EOFException {
        while (j > 0) {
            if (this.Aq == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.Aq.limit - this.Aq.pos);
            long j2 = min;
            this.size -= j2;
            j -= j2;
            this.Aq.pos += min;
            if (this.Aq.pos == this.Aq.limit) {
                n nVar = this.Aq;
                this.Aq = nVar.gd();
                o.b(nVar);
            }
        }
    }

    @Override // okio.d
    /* renamed from: a */
    public c b(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    @Override // okio.d
    /* renamed from: aU */
    public c aV(String str) {
        return c(str, 0, str.length());
    }

    public c c(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        n ap = ap(1);
                        byte[] bArr = ap.data;
                        int i3 = ap.limit - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = (i3 + i4) - ap.limit;
                        ap.limit += i5;
                        this.size += i5;
                        i = i4;
                    } else if (charAt < 2048) {
                        at((charAt >> 6) | 192);
                        at((charAt & '?') | 128);
                        i++;
                    } else if (charAt < 55296 || charAt > 57343) {
                        at((charAt >> '\f') | 224);
                        at(((charAt >> 6) & 63) | 128);
                        at((charAt & '?') | 128);
                        i++;
                    } else {
                        int i6 = i + 1;
                        char charAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            at(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            at((i7 >> 18) | 240);
                            at(((i7 >> 12) & 63) | 128);
                            at(((i7 >> 6) & 63) | 128);
                            at((i7 & 63) | 128);
                            i += 2;
                        }
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public c al(int i) {
        if (i < 128) {
            at(i);
        } else if (i < 2048) {
            at((i >> 6) | 192);
            at((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                at(63);
            } else {
                at((i >> 12) | 224);
                at(((i >> 6) & 63) | 128);
                at((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            at((i >> 18) | 240);
            at(((i >> 12) & 63) | 128);
            at(((i >> 6) & 63) | 128);
            at((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 <= str.length()) {
                if (charset == null) {
                    throw new IllegalArgumentException("charset == null");
                }
                if (charset.equals(s.UTF_8)) {
                    return c(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return b(bytes, 0, bytes.length);
            } else {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.d
    /* renamed from: j */
    public c k(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return b(bArr, 0, bArr.length);
    }

    @Override // okio.d
    /* renamed from: a */
    public c b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        s.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            n ap = ap(1);
            int min = Math.min(i3 - i, 8192 - ap.limit);
            System.arraycopy(bArr, i, ap.data, ap.limit, min);
            i += min;
            ap.limit += min;
        }
        this.size += j;
        return this;
    }

    @Override // okio.d
    public long a(q qVar) throws IOException {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = qVar.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.d
    /* renamed from: am */
    public c at(int i) {
        n ap = ap(1);
        byte[] bArr = ap.data;
        int i2 = ap.limit;
        ap.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // okio.d
    /* renamed from: an */
    public c as(int i) {
        n ap = ap(2);
        byte[] bArr = ap.data;
        int i2 = ap.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        ap.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.d
    /* renamed from: ao */
    public c ar(int i) {
        n ap = ap(4);
        byte[] bArr = ap.data;
        int i2 = ap.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        ap.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.d
    /* renamed from: u */
    public c z(long j) {
        n ap = ap(8);
        byte[] bArr = ap.data;
        int i = ap.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        ap.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.d
    /* renamed from: v */
    public c y(long j) {
        if (j == 0) {
            return at(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return aV("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        n ap = ap(i);
        byte[] bArr = ap.data;
        int i2 = ap.limit + i;
        while (j != 0) {
            i2--;
            bArr[i2] = Ap[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        ap.limit += i;
        this.size += i;
        return this;
    }

    @Override // okio.d
    /* renamed from: w */
    public c x(long j) {
        if (j == 0) {
            return at(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n ap = ap(numberOfTrailingZeros);
        byte[] bArr = ap.data;
        int i = ap.limit;
        for (int i2 = (ap.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = Ap[(int) (15 & j)];
            j >>>= 4;
        }
        ap.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n ap(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.Aq == null) {
            this.Aq = o.gf();
            n nVar = this.Aq;
            n nVar2 = this.Aq;
            n nVar3 = this.Aq;
            nVar2.AJ = nVar3;
            nVar.AI = nVar3;
            return nVar3;
        }
        n nVar4 = this.Aq.AJ;
        return (nVar4.limit + i > 8192 || !nVar4.AH) ? nVar4.a(o.gf()) : nVar4;
    }

    @Override // okio.p
    public void write(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        s.checkOffsetAndCount(cVar.size, 0L, j);
        while (j > 0) {
            if (j < cVar.Aq.limit - cVar.Aq.pos) {
                n nVar = this.Aq != null ? this.Aq.AJ : null;
                if (nVar != null && nVar.AH) {
                    if ((nVar.limit + j) - (nVar.AG ? 0 : nVar.pos) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        cVar.Aq.a(nVar, (int) j);
                        cVar.size -= j;
                        this.size += j;
                        return;
                    }
                }
                cVar.Aq = cVar.Aq.au((int) j);
            }
            n nVar2 = cVar.Aq;
            long j2 = nVar2.limit - nVar2.pos;
            cVar.Aq = nVar2.gd();
            if (this.Aq == null) {
                this.Aq = nVar2;
                n nVar3 = this.Aq;
                n nVar4 = this.Aq;
                n nVar5 = this.Aq;
                nVar4.AJ = nVar5;
                nVar3.AI = nVar5;
            } else {
                this.Aq.AJ.a(nVar2).ge();
            }
            cVar.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // okio.q
    public long read(c cVar, long j) {
        if (cVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.size == 0) {
                return -1L;
            } else {
                if (j > this.size) {
                    j = this.size;
                }
                cVar.write(this, j);
                return j;
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.e
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(byte r11, long r12, long r14) {
        /*
            r10 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto L78
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 < 0) goto L78
            long r2 = r10.size
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 <= 0) goto L12
            long r14 = r10.size
        L12:
            r2 = -1
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 != 0) goto L19
            return r2
        L19:
            okio.n r4 = r10.Aq
            if (r4 != 0) goto L1e
            return r2
        L1e:
            long r5 = r10.size
            long r5 = r5 - r12
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 >= 0) goto L35
            long r0 = r10.size
        L27:
            int r5 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r5 <= 0) goto L44
            okio.n r4 = r4.AJ
            int r5 = r4.limit
            int r6 = r4.pos
            int r5 = r5 - r6
            long r5 = (long) r5
            long r0 = r0 - r5
            goto L27
        L35:
            int r5 = r4.limit
            int r6 = r4.pos
            int r5 = r5 - r6
            long r5 = (long) r5
            long r5 = r5 + r0
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 >= 0) goto L44
            okio.n r4 = r4.AI
            r0 = r5
            goto L35
        L44:
            int r5 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r5 >= 0) goto L77
            byte[] r5 = r4.data
            int r6 = r4.limit
            long r6 = (long) r6
            int r8 = r4.pos
            long r8 = (long) r8
            long r8 = r8 + r14
            long r8 = r8 - r0
            long r6 = java.lang.Math.min(r6, r8)
            int r6 = (int) r6
            int r7 = r4.pos
            long r7 = (long) r7
            long r7 = r7 + r12
            long r7 = r7 - r0
            int r12 = (int) r7
        L5d:
            if (r12 >= r6) goto L6c
            r13 = r5[r12]
            if (r13 != r11) goto L69
            int r11 = r4.pos
            int r12 = r12 - r11
            long r11 = (long) r12
            long r11 = r11 + r0
            return r11
        L69:
            int r12 = r12 + 1
            goto L5d
        L6c:
            int r12 = r4.limit
            int r13 = r4.pos
            int r12 = r12 - r13
            long r12 = (long) r12
            long r12 = r12 + r0
            okio.n r4 = r4.AI
            r0 = r12
            goto L44
        L77:
            return r2
        L78:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            long r2 = r10.size
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0[r1] = r2
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r13 = 1
            r0[r13] = r12
            r12 = 2
            java.lang.Long r13 = java.lang.Long.valueOf(r14)
            r0[r12] = r13
            java.lang.String r12 = "size=%s fromIndex=%s toIndex=%s"
            java.lang.String r12 = java.lang.String.format(r12, r0)
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.c.a(byte, long, long):long");
    }

    @Override // okio.e
    public boolean a(long j, ByteString byteString) {
        return a(j, byteString, 0, byteString.size());
    }

    public boolean a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (n(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.p
    public r timeout() {
        return r.NONE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.size != cVar.size) {
                return false;
            }
            long j = 0;
            if (this.size == 0) {
                return true;
            }
            n nVar = this.Aq;
            n nVar2 = cVar.Aq;
            int i = nVar.pos;
            int i2 = nVar2.pos;
            while (j < this.size) {
                long min = Math.min(nVar.limit - i, nVar2.limit - i2);
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    if (nVar.data[i4] != nVar2.data[i3]) {
                        return false;
                    }
                    i5++;
                    i4 = i6;
                    i3 = i7;
                }
                if (i4 == nVar.limit) {
                    nVar = nVar.AI;
                    i = nVar.pos;
                } else {
                    i = i4;
                }
                if (i3 == nVar2.limit) {
                    nVar2 = nVar2.AI;
                    i2 = nVar2.pos;
                } else {
                    i2 = i3;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        n nVar = this.Aq;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = nVar.limit;
            for (int i3 = nVar.pos; i3 < i2; i3++) {
                i = (i * 31) + nVar.data[i3];
            }
            nVar = nVar.AI;
        } while (nVar != this.Aq);
        return i;
    }

    public String toString() {
        return fN().toString();
    }

    /* renamed from: fM */
    public c clone() {
        c cVar = new c();
        if (this.size == 0) {
            return cVar;
        }
        cVar.Aq = new n(this.Aq);
        n nVar = cVar.Aq;
        n nVar2 = cVar.Aq;
        n nVar3 = cVar.Aq;
        nVar2.AJ = nVar3;
        nVar.AI = nVar3;
        n nVar4 = this.Aq;
        while (true) {
            nVar4 = nVar4.AI;
            if (nVar4 != this.Aq) {
                cVar.Aq.AJ.a(new n(nVar4));
            } else {
                cVar.size = this.size;
                return cVar;
            }
        }
    }

    public ByteString fN() {
        if (this.size > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return aq((int) this.size);
    }

    public ByteString aq(int i) {
        if (i == 0) {
            return ByteString.As;
        }
        return new SegmentedByteString(this, i);
    }
}
