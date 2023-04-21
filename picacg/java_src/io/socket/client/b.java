package io.socket.client;

import io.socket.client.Manager;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
/* compiled from: IO.java */
/* loaded from: classes.dex */
public class b {
    private static final Logger logger = Logger.getLogger(b.class.getName());
    private static final ConcurrentHashMap<String, Manager> wA = new ConcurrentHashMap<>();
    public static int wB = io.socket.f.c.wB;

    /* compiled from: IO.java */
    /* loaded from: classes.dex */
    public static class a extends Manager.c {
        public boolean wC;
        public boolean wD = true;
    }

    private b() {
    }

    public static d aE(String str) throws URISyntaxException {
        return a(str, (a) null);
    }

    public static d a(String str, a aVar) throws URISyntaxException {
        return a(new URI(str), aVar);
    }

    public static d a(URI uri, a aVar) {
        Manager manager;
        if (aVar == null) {
            aVar = new a();
        }
        URL a2 = e.a(uri);
        try {
            URI uri2 = a2.toURI();
            String b = e.b(a2);
            if (aVar.wC || !aVar.wD || (wA.containsKey(b) && wA.get(b).xa.containsKey(a2.getPath()))) {
                logger.fine(String.format("ignoring socket cache for %s", uri2));
                manager = new Manager(uri2, aVar);
            } else {
                if (!wA.containsKey(b)) {
                    logger.fine(String.format("new io instance for %s", uri2));
                    wA.putIfAbsent(b, new Manager(uri2, aVar));
                }
                manager = wA.get(b);
            }
            return manager.aE(a2.getPath());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
