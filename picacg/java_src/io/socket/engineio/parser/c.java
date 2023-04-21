package io.socket.engineio.parser;

import android.support.v7.widget.ActivityChooserView;
import io.socket.utf8.UTF8Exception;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Parser.java */
/* loaded from: classes.dex */
public class c {
    private static final int zN = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).length();
    private static final Map<String, Integer> zO = new HashMap<String, Integer>() { // from class: io.socket.engineio.parser.Parser$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            put("open", 0);
            put("close", 1);
            put("ping", 2);
            put("pong", 3);
            put("message", 4);
            put("upgrade", 5);
            put("noop", 6);
        }
    };
    private static final Map<Integer, String> zP = new HashMap();
    private static io.socket.engineio.parser.b<String> zQ;

    /* compiled from: Parser.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        boolean a(io.socket.engineio.parser.b<T> bVar, int i, int i2);
    }

    /* compiled from: Parser.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void d(T t);
    }

    static {
        for (Map.Entry<String, Integer> entry : zO.entrySet()) {
            zP.put(entry.getValue(), entry.getKey());
        }
        zQ = new io.socket.engineio.parser.b<>("error", "parser error");
    }

    public static void a(io.socket.engineio.parser.b bVar, b bVar2) throws UTF8Exception {
        a(bVar, false, bVar2);
    }

    public static void a(io.socket.engineio.parser.b bVar, boolean z, b bVar2) throws UTF8Exception {
        if (bVar.data instanceof byte[]) {
            b(bVar, bVar2);
            return;
        }
        String valueOf = String.valueOf(zO.get(bVar.type));
        if (bVar.data != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf);
            sb.append(z ? io.socket.utf8.a.encode(String.valueOf(bVar.data)) : String.valueOf(bVar.data));
            valueOf = sb.toString();
        }
        bVar2.d(valueOf);
    }

    private static void b(io.socket.engineio.parser.b<byte[]> bVar, b<byte[]> bVar2) {
        byte[] bArr = bVar.data;
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = zO.get(bVar.type).byteValue();
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        bVar2.d(bArr2);
    }

    public static io.socket.engineio.parser.b<String> aM(String str) {
        return c(str, false);
    }

    public static io.socket.engineio.parser.b<String> c(String str, boolean z) {
        int i;
        try {
            i = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            i = -1;
        }
        if (z) {
            try {
                str = io.socket.utf8.a.decode(str);
            } catch (UTF8Exception unused2) {
                return zQ;
            }
        }
        if (i < 0 || i >= zP.size()) {
            return zQ;
        }
        if (str.length() > 1) {
            return new io.socket.engineio.parser.b<>(zP.get(Integer.valueOf(i)), str.substring(1));
        }
        return new io.socket.engineio.parser.b<>(zP.get(Integer.valueOf(i)));
    }

    public static io.socket.engineio.parser.b<byte[]> e(byte[] bArr) {
        byte b2 = bArr[0];
        byte[] bArr2 = new byte[bArr.length - 1];
        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
        return new io.socket.engineio.parser.b<>(zP.get(Integer.valueOf(b2)), bArr2);
    }

    public static void a(io.socket.engineio.parser.b[] bVarArr, b<byte[]> bVar) throws UTF8Exception {
        if (bVarArr.length == 0) {
            bVar.d(new byte[0]);
            return;
        }
        final ArrayList arrayList = new ArrayList(bVarArr.length);
        for (io.socket.engineio.parser.b bVar2 : bVarArr) {
            a(bVar2, true, new b() { // from class: io.socket.engineio.parser.c.1
                @Override // io.socket.engineio.parser.c.b
                public void d(Object obj) {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        String valueOf = String.valueOf(str.length());
                        byte[] bArr = new byte[valueOf.length() + 2];
                        bArr[0] = 0;
                        int i = 0;
                        while (i < valueOf.length()) {
                            int i2 = i + 1;
                            bArr[i2] = (byte) Character.getNumericValue(valueOf.charAt(i));
                            i = i2;
                        }
                        bArr[bArr.length - 1] = -1;
                        arrayList.add(io.socket.engineio.parser.a.a(new byte[][]{bArr, c.aN(str)}));
                        return;
                    }
                    byte[] bArr2 = (byte[]) obj;
                    String valueOf2 = String.valueOf(bArr2.length);
                    byte[] bArr3 = new byte[valueOf2.length() + 2];
                    bArr3[0] = 1;
                    int i3 = 0;
                    while (i3 < valueOf2.length()) {
                        int i4 = i3 + 1;
                        bArr3[i4] = (byte) Character.getNumericValue(valueOf2.charAt(i3));
                        i3 = i4;
                    }
                    bArr3[bArr3.length - 1] = -1;
                    arrayList.add(io.socket.engineio.parser.a.a(new byte[][]{bArr3, bArr2}));
                }
            });
        }
        bVar.d(io.socket.engineio.parser.a.a((byte[][]) arrayList.toArray(new byte[arrayList.size()])));
    }

    public static void a(String str, a<String> aVar) {
        if (str == null || str.length() == 0) {
            aVar.a(zQ, 0, 1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        StringBuilder sb2 = sb;
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (':' != charAt) {
                sb2.append(charAt);
            } else {
                try {
                    int parseInt = Integer.parseInt(sb2.toString());
                    int i2 = i + 1;
                    try {
                        String substring = str.substring(i2, i2 + parseInt);
                        if (substring.length() != 0) {
                            io.socket.engineio.parser.b<String> c = c(substring, true);
                            if (zQ.type.equals(c.type) && zQ.data.equals(c.data)) {
                                aVar.a(zQ, 0, 1);
                                return;
                            } else if (!aVar.a(c, i + parseInt, length)) {
                                return;
                            }
                        }
                        i += parseInt;
                        sb2 = new StringBuilder();
                    } catch (IndexOutOfBoundsException unused) {
                        aVar.a(zQ, 0, 1);
                        return;
                    }
                } catch (NumberFormatException unused2) {
                    aVar.a(zQ, 0, 1);
                    return;
                }
            }
            i++;
        }
        if (sb2.length() > 0) {
            aVar.a(zQ, 0, 1);
        }
    }

    public static void a(byte[] bArr, a aVar) {
        boolean z;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (wrap.capacity() > 0) {
                StringBuilder sb = new StringBuilder();
                boolean z2 = (wrap.get(0) & 255) == 0;
                int i = 1;
                while (true) {
                    int i2 = wrap.get(i) & 255;
                    if (i2 == 255) {
                        z = false;
                        break;
                    } else if (sb.length() > zN) {
                        z = true;
                        break;
                    } else {
                        sb.append(i2);
                        i++;
                    }
                }
                if (z) {
                    aVar.a(zQ, 0, 1);
                    return;
                }
                wrap.position(sb.length() + 1);
                ByteBuffer slice = wrap.slice();
                int parseInt = Integer.parseInt(sb.toString());
                slice.position(1);
                int i3 = parseInt + 1;
                slice.limit(i3);
                byte[] bArr2 = new byte[slice.remaining()];
                slice.get(bArr2);
                if (z2) {
                    arrayList.add(f(bArr2));
                } else {
                    arrayList.add(bArr2);
                }
                slice.clear();
                slice.position(i3);
                wrap = slice.slice();
            } else {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    Object obj = arrayList.get(i4);
                    if (obj instanceof String) {
                        aVar.a(c((String) obj, true), i4, size);
                    } else if (obj instanceof byte[]) {
                        aVar.a(e((byte[]) obj), i4, size);
                    }
                }
                return;
            }
        }
    }

    private static String f(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.appendCodePoint(b2 & 255);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] aN(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Character.codePointAt(str, i);
        }
        return bArr;
    }
}
