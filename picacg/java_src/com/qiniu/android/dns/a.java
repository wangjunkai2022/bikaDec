package com.qiniu.android.dns;

import com.qiniu.android.dns.util.LruCache;
/* compiled from: DnsManager.java */
/* loaded from: classes.dex */
public final class a {
    private volatile int index;
    private final b[] uS;
    private final LruCache<String, Object[]> uT;
    private volatile NetworkInfo uU;

    public void a(NetworkInfo networkInfo) {
        clearCache();
        if (networkInfo == null) {
            networkInfo = NetworkInfo.uW;
        }
        this.uU = networkInfo;
        synchronized (this.uS) {
            this.index = 0;
        }
    }

    private void clearCache() {
        synchronized (this.uT) {
            this.uT.clear();
        }
    }
}
