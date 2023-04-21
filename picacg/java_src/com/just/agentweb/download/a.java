package com.just.agentweb.download;

import java.util.concurrent.ConcurrentHashMap;
/* compiled from: CancelDownloadInformer.java */
/* loaded from: classes.dex */
public final class a {
    private ConcurrentHashMap<String, b> fv;

    private a() {
        this.fv = null;
        this.fv = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a aG() {
        return C0004a.fw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str) {
        b bVar = this.fv.get(str);
        if (bVar != null) {
            bVar.aI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (str == null || bVar == null) {
            return;
        }
        this.fv.put(str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(String str) {
        if (str != null) {
            this.fv.remove(str);
        }
    }

    /* compiled from: CancelDownloadInformer.java */
    /* renamed from: com.just.agentweb.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0004a {
        private static final a fw = new a();
    }
}
