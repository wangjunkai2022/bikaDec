package io.socket.engineio.client.a;

import io.socket.engineio.client.Transport;
import io.socket.engineio.parser.c;
import io.socket.utf8.UTF8Exception;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
/* compiled from: WebSocket.java */
/* loaded from: classes.dex */
public class c extends Transport {
    private static final Logger logger = Logger.getLogger(b.class.getName());
    private WebSocket zD;

    public c(Transport.a aVar) {
        super(aVar);
        this.name = "websocket";
    }

    @Override // io.socket.engineio.client.Transport
    protected void fc() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        b("requestHeaders", treeMap);
        OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().connectTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS);
        if (this.yp != null) {
            writeTimeout.sslSocketFactory(this.yp.getSocketFactory());
        }
        if (this.hostnameVerifier != null) {
            writeTimeout.hostnameVerifier(this.hostnameVerifier);
        }
        if (this.proxy != null) {
            writeTimeout.proxy(this.proxy);
        }
        if (this.yq != null && !this.yq.isEmpty()) {
            final String basic = Credentials.basic(this.yq, this.yr);
            writeTimeout.proxyAuthenticator(new Authenticator() { // from class: io.socket.engineio.client.a.c.1
                @Override // okhttp3.Authenticator
                public Request authenticate(Route route, Response response) throws IOException {
                    return response.request().newBuilder().header("Proxy-Authorization", basic).build();
                }
            });
        }
        Request.Builder url = new Request.Builder().url(ff());
        for (Map.Entry entry : treeMap.entrySet()) {
            for (String str : (List) entry.getValue()) {
                url.addHeader((String) entry.getKey(), str);
            }
        }
        Request build = url.build();
        OkHttpClient build2 = writeTimeout.build();
        this.zD = build2.newWebSocket(build, new WebSocketListener() { // from class: io.socket.engineio.client.a.c.2
            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                final Map<String, List<String>> multimap = response.headers().toMultimap();
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.b("responseHeaders", multimap);
                        this.eS();
                    }
                });
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, final String str2) {
                if (str2 == null) {
                    return;
                }
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.c.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        this.aL(str2);
                    }
                });
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, final ByteString byteString) {
                if (byteString == null) {
                    return;
                }
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.c.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        this.c(byteString.toByteArray());
                    }
                });
            }

            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i, String str2) {
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.c.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        this.onClose();
                    }
                });
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, final Throwable th, Response response) {
                if (th instanceof Exception) {
                    io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.c.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            this.b("websocket error", (Exception) th);
                        }
                    });
                }
            }
        });
        build2.dispatcher().executorService().shutdown();
    }

    @Override // io.socket.engineio.client.Transport
    protected void b(io.socket.engineio.parser.b[] bVarArr) throws UTF8Exception {
        this.za = false;
        final Runnable runnable = new Runnable() { // from class: io.socket.engineio.client.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                io.socket.g.a.c(new Runnable() { // from class: io.socket.engineio.client.a.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.za = true;
                        this.b("drain", new Object[0]);
                    }
                });
            }
        };
        final int[] iArr = {bVarArr.length};
        for (io.socket.engineio.parser.b bVar : bVarArr) {
            if (this.zc != Transport.ReadyState.OPENING && this.zc != Transport.ReadyState.OPEN) {
                return;
            }
            io.socket.engineio.parser.c.a(bVar, new c.b() { // from class: io.socket.engineio.client.a.c.4
                @Override // io.socket.engineio.parser.c.b
                public void d(Object obj) {
                    try {
                        if (obj instanceof String) {
                            this.zD.send((String) obj);
                        } else if (obj instanceof byte[]) {
                            this.zD.send(ByteString.l((byte[]) obj));
                        }
                    } catch (IllegalStateException unused) {
                        c.logger.fine("websocket closed before we could write");
                    }
                    int[] iArr2 = iArr;
                    int i = iArr2[0] - 1;
                    iArr2[0] = i;
                    if (i == 0) {
                        runnable.run();
                    }
                }
            });
        }
    }

    @Override // io.socket.engineio.client.Transport
    protected void fd() {
        if (this.zD != null) {
            try {
                this.zD.close(1000, "");
            } catch (IllegalStateException unused) {
            }
        }
        if (this.zD != null) {
            this.zD.cancel();
        }
    }

    protected String ff() {
        String str;
        Map map = this.yk;
        if (map == null) {
            map = new HashMap();
        }
        String str2 = this.secure ? "wss" : "ws";
        String str3 = "";
        if (this.port > 0 && (("wss".equals(str2) && this.port != 443) || ("ws".equals(str2) && this.port != 80))) {
            str3 = ":" + this.port;
        }
        if (this.yc) {
            map.put(this.yh, io.socket.h.a.fw());
        }
        String d = io.socket.e.a.d(map);
        if (d.length() > 0) {
            d = "?" + d;
        }
        boolean contains = this.hostname.contains(":");
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("://");
        if (contains) {
            str = "[" + this.hostname + "]";
        } else {
            str = this.hostname;
        }
        sb.append(str);
        sb.append(str3);
        sb.append(this.path);
        sb.append(d);
        return sb.toString();
    }
}
