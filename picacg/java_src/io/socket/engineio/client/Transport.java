package io.socket.engineio.client;

import io.socket.engineio.parser.b;
import io.socket.engineio.parser.c;
import io.socket.utf8.UTF8Exception;
import java.net.Proxy;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
/* loaded from: classes.dex */
public abstract class Transport extends io.socket.b.a {
    protected String hostname;
    protected HostnameVerifier hostnameVerifier;
    public String name;
    protected String path;
    protected int port;
    protected Proxy proxy;
    protected boolean secure;
    protected boolean yc;
    protected String yh;
    public Map<String, String> yk;
    protected SSLContext yp;
    protected String yq;
    protected String yr;
    public boolean za;
    protected Socket zb;
    protected ReadyState zc;

    /* loaded from: classes.dex */
    public static class a {
        public String hostname;
        public HostnameVerifier hostnameVerifier;
        public String path;
        public Proxy proxy;
        public boolean secure;
        public boolean yc;
        public String yh;
        public Map<String, String> yk;
        public SSLContext yp;
        public String yq;
        public String yr;
        protected Socket zb;
        public int port = -1;
        public int yf = -1;
    }

    protected abstract void b(b[] bVarArr) throws UTF8Exception;

    protected abstract void fc();

    protected abstract void fd();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public enum ReadyState {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public Transport(a aVar) {
        this.path = aVar.path;
        this.hostname = aVar.hostname;
        this.port = aVar.port;
        this.secure = aVar.secure;
        this.yk = aVar.yk;
        this.yh = aVar.yh;
        this.yc = aVar.yc;
        this.yp = aVar.yp;
        this.zb = aVar.zb;
        this.hostnameVerifier = aVar.hostnameVerifier;
        this.proxy = aVar.proxy;
        this.yq = aVar.yq;
        this.yr = aVar.yr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Transport b(String str, Exception exc) {
        b("error", new EngineIOException(str, exc));
        return this;
    }

    public Transport fa() {
        io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.Transport.1
            @Override // java.lang.Runnable
            public void run() {
                if (Transport.this.zc == ReadyState.CLOSED || Transport.this.zc == null) {
                    Transport.this.zc = ReadyState.OPENING;
                    Transport.this.fc();
                }
            }
        });
        return this;
    }

    public Transport fb() {
        io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.Transport.2
            @Override // java.lang.Runnable
            public void run() {
                if (Transport.this.zc == ReadyState.OPENING || Transport.this.zc == ReadyState.OPEN) {
                    Transport.this.fd();
                    Transport.this.onClose();
                }
            }
        });
        return this;
    }

    public void a(final b[] bVarArr) {
        io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.Transport.3
            @Override // java.lang.Runnable
            public void run() {
                if (Transport.this.zc == ReadyState.OPEN) {
                    try {
                        Transport.this.b(bVarArr);
                        return;
                    } catch (UTF8Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                throw new RuntimeException("Transport not open");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS() {
        this.zc = ReadyState.OPEN;
        this.za = true;
        b("open", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aL(String str) {
        a(c.aM(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(byte[] bArr) {
        a(c.e(bArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        b("packet", bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClose() {
        this.zc = ReadyState.CLOSED;
        b("close", new Object[0]);
    }
}
