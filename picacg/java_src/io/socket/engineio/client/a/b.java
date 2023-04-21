package io.socket.engineio.client.a;

import io.socket.b.a;
import io.socket.engineio.client.Transport;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
/* compiled from: PollingXHR.java */
/* loaded from: classes.dex */
public class b extends io.socket.engineio.client.a.a {
    private static final Logger logger = Logger.getLogger(b.class.getName());

    public b(Transport.a aVar) {
        super(aVar);
    }

    protected a fi() {
        return a((a.C0024a) null);
    }

    protected a a(a.C0024a c0024a) {
        if (c0024a == null) {
            c0024a = new a.C0024a();
        }
        c0024a.zz = ff();
        c0024a.yp = this.yp;
        c0024a.hostnameVerifier = this.hostnameVerifier;
        c0024a.proxy = this.proxy;
        a aVar = new a(c0024a);
        aVar.a("requestHeaders", new a.InterfaceC0017a() { // from class: io.socket.engineio.client.a.b.2
            @Override // io.socket.b.a.InterfaceC0017a
            public void a(Object... objArr) {
                this.b("requestHeaders", objArr[0]);
            }
        }).a("responseHeaders", new a.InterfaceC0017a() { // from class: io.socket.engineio.client.a.b.1
            @Override // io.socket.b.a.InterfaceC0017a
            public void a(final Object... objArr) {
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.b("responseHeaders", objArr[0]);
                    }
                });
            }
        });
        return aVar;
    }

    @Override // io.socket.engineio.client.a.a
    protected void c(byte[] bArr, final Runnable runnable) {
        a.C0024a c0024a = new a.C0024a();
        c0024a.method = "POST";
        c0024a.data = bArr;
        a a2 = a(c0024a);
        a2.a("success", new a.InterfaceC0017a() { // from class: io.socket.engineio.client.a.b.3
            @Override // io.socket.b.a.InterfaceC0017a
            public void a(Object... objArr) {
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                });
            }
        });
        a2.a("error", new a.InterfaceC0017a() { // from class: io.socket.engineio.client.a.b.4
            @Override // io.socket.b.a.InterfaceC0017a
            public void a(final Object... objArr) {
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.b.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.b("xhr post error", (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0]);
                    }
                });
            }
        });
        a2.create();
    }

    @Override // io.socket.engineio.client.a.a
    protected void fg() {
        logger.fine("xhr poll");
        a fi = fi();
        fi.a("data", new a.InterfaceC0017a() { // from class: io.socket.engineio.client.a.b.5
            @Override // io.socket.b.a.InterfaceC0017a
            public void a(final Object... objArr) {
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.b.5.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[]] */
                    /* JADX WARN: Type inference failed for: r0v7 */
                    @Override // java.lang.Runnable
                    public void run() {
                        String str = objArr.length > 0 ? objArr[0] : null;
                        if (str instanceof String) {
                            this.aL(str);
                        } else if (str instanceof byte[]) {
                            this.c((byte[]) str);
                        }
                    }
                });
            }
        });
        fi.a("error", new a.InterfaceC0017a() { // from class: io.socket.engineio.client.a.b.6
            @Override // io.socket.b.a.InterfaceC0017a
            public void a(final Object... objArr) {
                io.socket.g.a.b(new Runnable() { // from class: io.socket.engineio.client.a.b.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.b("xhr poll error", (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0]);
                    }
                });
            }
        });
        fi.create();
    }

    /* compiled from: PollingXHR.java */
    /* loaded from: classes.dex */
    public static class a extends io.socket.b.a {
        private byte[] data;
        private HostnameVerifier hostnameVerifier;
        private String method;
        private Proxy proxy;
        private SSLContext yp;
        private HttpURLConnection zA;
        private String zz;

        /* compiled from: PollingXHR.java */
        /* renamed from: io.socket.engineio.client.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0024a {
            public byte[] data;
            public HostnameVerifier hostnameVerifier;
            public String method;
            public Proxy proxy;
            public SSLContext yp;
            public String zz;
        }

        public a(C0024a c0024a) {
            this.method = c0024a.method != null ? c0024a.method : "GET";
            this.zz = c0024a.zz;
            this.data = c0024a.data;
            this.yp = c0024a.yp;
            this.hostnameVerifier = c0024a.hostnameVerifier;
            this.proxy = c0024a.proxy;
        }

        public void create() {
            try {
                b.logger.fine(String.format("xhr open %s: %s", this.method, this.zz));
                URL url = new URL(this.zz);
                this.zA = this.proxy != null ? (HttpURLConnection) url.openConnection(this.proxy) : (HttpURLConnection) url.openConnection();
                this.zA.setRequestMethod(this.method);
                this.zA.setConnectTimeout(10000);
                if (this.zA instanceof HttpsURLConnection) {
                    if (this.yp != null) {
                        ((HttpsURLConnection) this.zA).setSSLSocketFactory(this.yp.getSocketFactory());
                    }
                    if (this.hostnameVerifier != null) {
                        ((HttpsURLConnection) this.zA).setHostnameVerifier(this.hostnameVerifier);
                    }
                }
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                if ("POST".equals(this.method)) {
                    this.zA.setDoOutput(true);
                    treeMap.put("Content-type", new LinkedList(Arrays.asList("application/octet-stream")));
                }
                b(treeMap);
                for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
                    for (String str : entry.getValue()) {
                        this.zA.addRequestProperty(entry.getKey(), str);
                    }
                }
                b.logger.fine(String.format("sending xhr with url %s | data %s", this.zz, this.data));
                new Thread(new Runnable() { // from class: io.socket.engineio.client.a.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BufferedOutputStream bufferedOutputStream = null;
                        try {
                            try {
                                if (this.data != null) {
                                    a.this.zA.setFixedLengthStreamingMode(this.data.length);
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(a.this.zA.getOutputStream());
                                    try {
                                        bufferedOutputStream2.write(this.data);
                                        bufferedOutputStream2.flush();
                                        bufferedOutputStream = bufferedOutputStream2;
                                    } catch (IOException e) {
                                        e = e;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        this.c(e);
                                        if (bufferedOutputStream == null) {
                                            return;
                                        }
                                        bufferedOutputStream.close();
                                    } catch (NullPointerException e2) {
                                        e = e2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        this.c(e);
                                        if (bufferedOutputStream == null) {
                                            return;
                                        }
                                        bufferedOutputStream.close();
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.c(a.this.zA.getHeaderFields());
                                int responseCode = a.this.zA.getResponseCode();
                                if (200 == responseCode) {
                                    this.fk();
                                } else {
                                    this.c(new IOException(Integer.toString(responseCode)));
                                }
                                if (bufferedOutputStream == null) {
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (IOException e3) {
                            e = e3;
                        } catch (NullPointerException e4) {
                            e = e4;
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }).start();
            } catch (IOException e) {
                c(e);
            }
        }

        private void onSuccess() {
            b("success", new Object[0]);
        }

        private void aL(String str) {
            b("data", str);
            onSuccess();
        }

        private void c(byte[] bArr) {
            b("data", bArr);
            onSuccess();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Exception exc) {
            b("error", exc);
        }

        private void b(Map<String, List<String>> map) {
            b("requestHeaders", map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Map<String, List<String>> map) {
            b("responseHeaders", map);
        }

        private void cleanup() {
            if (this.zA == null) {
                return;
            }
            this.zA.disconnect();
            this.zA = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00aa A[Catch: IOException -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ad, blocks: (B:31:0x008f, B:45:0x00aa), top: B:67:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void fk() {
            /*
                r9 = this;
                java.net.HttpURLConnection r0 = r9.zA
                java.lang.String r0 = r0.getContentType()
                r1 = 0
                java.lang.String r2 = "application/octet-stream"
                boolean r0 = r2.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                if (r0 == 0) goto L60
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.net.HttpURLConnection r2 = r9.zA     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                r0.<init>(r2)     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                r2.<init>()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                r4 = 0
                r5 = 0
            L25:
                int r6 = r0.read(r3)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                if (r6 <= 0) goto L35
                byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                java.lang.System.arraycopy(r3, r4, r7, r4, r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                r2.add(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                int r5 = r5 + r6
                goto L25
            L35:
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
            L3d:
                boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                if (r4 == 0) goto L4d
                java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                byte[] r4 = (byte[]) r4     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                r3.put(r4)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                goto L3d
            L4d:
                byte[] r2 = r3.array()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                r9.c(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5b
                goto L88
            L55:
                r2 = move-exception
                r8 = r1
                r1 = r0
            L58:
                r0 = r8
                goto Lb2
            L5b:
                r2 = move-exception
                r8 = r1
                r1 = r0
            L5e:
                r0 = r8
                goto La0
            L60:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                r0.<init>()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.net.HttpURLConnection r4 = r9.zA     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L9b java.io.IOException -> L9e
            L75:
                java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L97
                if (r3 == 0) goto L7f
                r0.append(r3)     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L97
                goto L75
            L7f:
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L97
                r9.aL(r0)     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L97
                r0 = r1
                r1 = r2
            L88:
                if (r0 == 0) goto L8d
                r0.close()     // Catch: java.io.IOException -> L8d
            L8d:
                if (r1 == 0) goto Lad
                r1.close()     // Catch: java.io.IOException -> Lad
                goto Lad
            L93:
                r0 = move-exception
                r8 = r2
                r2 = r0
                goto L58
            L97:
                r0 = move-exception
                r8 = r2
                r2 = r0
                goto L5e
            L9b:
                r2 = move-exception
                r0 = r1
                goto Lb2
            L9e:
                r2 = move-exception
                r0 = r1
            La0:
                r9.c(r2)     // Catch: java.lang.Throwable -> Lb1
                if (r1 == 0) goto La8
                r1.close()     // Catch: java.io.IOException -> La8
            La8:
                if (r0 == 0) goto Lad
                r0.close()     // Catch: java.io.IOException -> Lad
            Lad:
                r9.cleanup()
                return
            Lb1:
                r2 = move-exception
            Lb2:
                if (r1 == 0) goto Lb7
                r1.close()     // Catch: java.io.IOException -> Lb7
            Lb7:
                if (r0 == 0) goto Lbc
                r0.close()     // Catch: java.io.IOException -> Lbc
            Lbc:
                r9.cleanup()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.socket.engineio.client.a.b.a.fk():void");
        }
    }
}
