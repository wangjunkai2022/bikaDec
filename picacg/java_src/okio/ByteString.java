package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    transient String At;
    final byte[] data;
    transient int hashCode;
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString As = l(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString l(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ByteString((byte[]) bArr.clone());
    }

    public static ByteString aW(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(s.UTF_8));
        byteString.At = str;
        return byteString;
    }

    public String fP() {
        String str = this.At;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, s.UTF_8);
        this.At = str2;
        return str2;
    }

    public String fQ() {
        return b.i(this.data);
    }

    public ByteString fR() {
        return aX("MD5");
    }

    public ByteString fS() {
        return aX("SHA-1");
    }

    public ByteString fT() {
        return aX("SHA-256");
    }

    private ByteString aX(String str) {
        try {
            return l(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @Nullable
    public static ByteString aY(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] decode = b.decode(str);
        if (decode != null) {
            return new ByteString(decode);
        }
        return null;
    }

    public String fU() {
        byte[] bArr;
        char[] cArr = new char[this.data.length * 2];
        int i = 0;
        for (byte b : this.data) {
            int i2 = i + 1;
            cArr[i] = HEX_DIGITS[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = HEX_DIGITS[b & 15];
        }
        return new String(cArr);
    }

    public static ByteString aZ(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
        }
        return l(bArr);
    }

    private static int decodeHexDigit(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    public static ByteString a(InputStream inputStream, int i) throws IOException {
        if (inputStream != null) {
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + i);
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("in == null");
    }

    public ByteString fV() {
        for (int i = 0; i < this.data.length; i++) {
            byte b = this.data[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr = (byte[]) this.data.clone();
                bArr[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString m(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i2 > this.data.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == this.data.length) {
            return this;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.data, i, bArr, 0, i3);
        return new ByteString(bArr);
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        cVar.b(this.data, 0, this.data.length);
    }

    public boolean a(int i, ByteString byteString, int i2, int i3) {
        return byteString.a(i2, this.data, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.data.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && s.a(this.data, i, bArr, i2, i3);
    }

    public final boolean c(ByteString byteString) {
        return a(0, byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == this.data.length && byteString.a(0, this.data, 0, this.data.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = getByte(i) & 255;
            int i3 = byteString.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String fP = fP();
        int g = g(fP, 64);
        if (g == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + fU() + "]";
            }
            return "[size=" + this.data.length + " hex=" + m(0, 64).fU() + "…]";
        }
        String replace = fP.substring(0, g).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (g < fP.length()) {
            return "[size=" + this.data.length + " text=" + replace + "…]";
        }
        return "[text=" + replace + "]";
    }

    static int g(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString a = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, a.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
