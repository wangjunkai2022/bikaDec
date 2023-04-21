package okio;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SegmentedByteString extends ByteString {
    final transient byte[][] AL;
    final transient int[] AM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(c cVar, int i) {
        super(null);
        s.checkOffsetAndCount(cVar.size, 0L, i);
        int i2 = 0;
        n nVar = cVar.Aq;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (nVar.limit == nVar.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += nVar.limit - nVar.pos;
            i4++;
            nVar = nVar.AI;
        }
        this.AL = new byte[i4];
        this.AM = new int[i4 * 2];
        n nVar2 = cVar.Aq;
        int i5 = 0;
        while (i2 < i) {
            this.AL[i5] = nVar2.data;
            i2 += nVar2.limit - nVar2.pos;
            if (i2 > i) {
                i2 = i;
            }
            this.AM[i5] = i2;
            this.AM[this.AL.length + i5] = nVar2.pos;
            nVar2.AG = true;
            i5++;
            nVar2 = nVar2.AI;
        }
    }

    @Override // okio.ByteString
    public String fP() {
        return gg().fP();
    }

    @Override // okio.ByteString
    public String fQ() {
        return gg().fQ();
    }

    @Override // okio.ByteString
    public String fU() {
        return gg().fU();
    }

    @Override // okio.ByteString
    public ByteString fV() {
        return gg().fV();
    }

    @Override // okio.ByteString
    public ByteString fR() {
        return gg().fR();
    }

    @Override // okio.ByteString
    public ByteString fS() {
        return gg().fS();
    }

    @Override // okio.ByteString
    public ByteString fT() {
        return gg().fT();
    }

    @Override // okio.ByteString
    public ByteString m(int i, int i2) {
        return gg().m(i, i2);
    }

    @Override // okio.ByteString
    public byte getByte(int i) {
        s.checkOffsetAndCount(this.AM[this.AL.length - 1], i, 1L);
        int av = av(i);
        return this.AL[av][(i - (av == 0 ? 0 : this.AM[av - 1])) + this.AM[this.AL.length + av]];
    }

    private int av(int i) {
        int binarySearch = Arrays.binarySearch(this.AM, 0, this.AL.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // okio.ByteString
    public int size() {
        return this.AM[this.AL.length - 1];
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[this.AM[this.AL.length - 1]];
        int length = this.AL.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.AM[length + i];
            int i4 = this.AM[i];
            System.arraycopy(this.AL[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public void a(c cVar) {
        int length = this.AL.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.AM[length + i];
            int i4 = this.AM[i];
            n nVar = new n(this.AL[i], i3, (i3 + i4) - i2);
            if (cVar.Aq == null) {
                nVar.AJ = nVar;
                nVar.AI = nVar;
                cVar.Aq = nVar;
            } else {
                cVar.Aq.AJ.a(nVar);
            }
            i++;
            i2 = i4;
        }
        cVar.size += i2;
    }

    @Override // okio.ByteString
    public boolean a(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int av = av(i);
        while (i3 > 0) {
            int i4 = av == 0 ? 0 : this.AM[av - 1];
            int min = Math.min(i3, ((this.AM[av] - i4) + i4) - i);
            if (!byteString.a(i2, this.AL[av], (i - i4) + this.AM[this.AL.length + av], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            av++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int av = av(i);
        while (i3 > 0) {
            int i4 = av == 0 ? 0 : this.AM[av - 1];
            int min = Math.min(i3, ((this.AM[av] - i4) + i4) - i);
            if (!s.a(this.AL[av], (i - i4) + this.AM[this.AL.length + av], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            av++;
        }
        return true;
    }

    private ByteString gg() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && a(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.AL.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.AL[i2];
            int i5 = this.AM[length + i2];
            int i6 = this.AM[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    @Override // okio.ByteString
    public String toString() {
        return gg().toString();
    }

    private Object writeReplace() {
        return gg();
    }
}
