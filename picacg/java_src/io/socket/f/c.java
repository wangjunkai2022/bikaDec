package io.socket.f;

import io.socket.f.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONTokener;
/* compiled from: Parser.java */
/* loaded from: classes.dex */
public class c {
    private static final Logger logger = Logger.getLogger(c.class.getName());
    public static int wB = 4;
    public static String[] zV = {"CONNECT", "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static io.socket.f.b<String> fm() {
        return new io.socket.f.b<>(4, "parser error");
    }

    /* compiled from: Parser.java */
    /* renamed from: io.socket.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027c {

        /* compiled from: Parser.java */
        /* renamed from: io.socket.f.c$c$a */
        /* loaded from: classes.dex */
        public interface a {
            void a(Object[] objArr);
        }

        public void a(io.socket.f.b bVar, a aVar) {
            c.logger.fine(String.format("encoding packet %s", bVar));
            if (5 == bVar.type || 6 == bVar.type) {
                b(bVar, aVar);
            } else {
                aVar.a(new String[]{g(bVar)});
            }
        }

        private String g(io.socket.f.b bVar) {
            boolean z;
            StringBuilder sb = new StringBuilder();
            sb.append(bVar.type);
            if (5 == bVar.type || 6 == bVar.type) {
                sb.append(bVar.zU);
                sb.append("-");
            }
            if (bVar.xC == null || bVar.xC.length() == 0 || "/".equals(bVar.xC)) {
                z = false;
            } else {
                sb.append(bVar.xC);
                z = true;
            }
            if (bVar.id >= 0) {
                if (z) {
                    sb.append(",");
                    z = false;
                }
                sb.append(bVar.id);
            }
            if (bVar.data != 0) {
                if (z) {
                    sb.append(",");
                }
                sb.append(bVar.data);
            }
            c.logger.fine(String.format("encoded %s as %s", bVar, sb));
            return sb.toString();
        }

        private void b(io.socket.f.b bVar, a aVar) {
            a.C0026a f = io.socket.f.a.f(bVar);
            String g = g(f.zS);
            ArrayList arrayList = new ArrayList(Arrays.asList(f.zT));
            arrayList.add(0, g);
            aVar.a(arrayList.toArray());
        }
    }

    /* compiled from: Parser.java */
    /* loaded from: classes.dex */
    public static class b extends io.socket.b.a {
        public static String zY = "decoded";
        a zZ = null;

        public void add(String str) {
            io.socket.f.b aS = aS(str);
            if (5 == aS.type || 6 == aS.type) {
                this.zZ = new a(aS);
                if (this.zZ.zW.zU == 0) {
                    b(zY, aS);
                    return;
                }
                return;
            }
            b(zY, aS);
        }

        public void h(byte[] bArr) {
            if (this.zZ == null) {
                throw new RuntimeException("got binary data when not reconstructing a packet");
            }
            io.socket.f.b g = this.zZ.g(bArr);
            if (g != null) {
                this.zZ = null;
                b(zY, g);
            }
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
        private static io.socket.f.b aS(String str) {
            int i;
            io.socket.f.b bVar = new io.socket.f.b();
            int length = str.length();
            bVar.type = Character.getNumericValue(str.charAt(0));
            if (bVar.type < 0 || bVar.type > c.zV.length - 1) {
                return c.fm();
            }
            if (5 != bVar.type && 6 != bVar.type) {
                i = 0;
            } else if (!str.contains("-") || length <= 1) {
                return c.fm();
            } else {
                StringBuilder sb = new StringBuilder();
                i = 0;
                while (true) {
                    i++;
                    if (str.charAt(i) == '-') {
                        break;
                    }
                    sb.append(str.charAt(i));
                }
                bVar.zU = Integer.parseInt(sb.toString());
            }
            int i2 = i + 1;
            if (length > i2 && '/' == str.charAt(i2)) {
                StringBuilder sb2 = new StringBuilder();
                do {
                    i++;
                    char charAt = str.charAt(i);
                    if (',' == charAt) {
                        break;
                    }
                    sb2.append(charAt);
                } while (i + 1 != length);
                bVar.xC = sb2.toString();
            } else {
                bVar.xC = "/";
            }
            int i3 = i + 1;
            if (length > i3 && Character.getNumericValue(Character.valueOf(str.charAt(i3)).charValue()) > -1) {
                StringBuilder sb3 = new StringBuilder();
                do {
                    i++;
                    char charAt2 = str.charAt(i);
                    if (Character.getNumericValue(charAt2) < 0) {
                        i--;
                        break;
                    }
                    sb3.append(charAt2);
                } while (i + 1 != length);
                try {
                    bVar.id = Integer.parseInt(sb3.toString());
                } catch (NumberFormatException unused) {
                    return c.fm();
                }
            }
            int i4 = i + 1;
            if (length > i4) {
                try {
                    str.charAt(i4);
                    bVar.data = new JSONTokener(str.substring(i4)).nextValue();
                } catch (JSONException e) {
                    c.logger.log(Level.WARNING, "An error occured while retrieving data from JSONTokener", (Throwable) e);
                    return c.fm();
                }
            }
            c.logger.fine(String.format("decoded %s as %s", str, bVar));
            return bVar;
        }

        public void destroy() {
            if (this.zZ != null) {
                this.zZ.fo();
            }
        }
    }

    /* compiled from: Parser.java */
    /* loaded from: classes.dex */
    static class a {
        public io.socket.f.b zW;
        List<byte[]> zX = new ArrayList();

        a(io.socket.f.b bVar) {
            this.zW = bVar;
        }

        public io.socket.f.b g(byte[] bArr) {
            this.zX.add(bArr);
            if (this.zX.size() == this.zW.zU) {
                io.socket.f.b a = io.socket.f.a.a(this.zW, (byte[][]) this.zX.toArray(new byte[this.zX.size()]));
                fo();
                return a;
            }
            return null;
        }

        public void fo() {
            this.zW = null;
            this.zX = new ArrayList();
        }
    }
}
