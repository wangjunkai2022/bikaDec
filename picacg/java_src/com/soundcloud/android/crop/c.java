package com.soundcloud.android.crop;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MonitoredActivity.java */
/* loaded from: classes.dex */
public abstract class c extends Activity {
    private final ArrayList<b> wv = new ArrayList<>();

    /* compiled from: MonitoredActivity.java */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // com.soundcloud.android.crop.c.b
        public void a(c cVar) {
        }

        @Override // com.soundcloud.android.crop.c.b
        public void b(c cVar) {
        }

        @Override // com.soundcloud.android.crop.c.b
        public void c(c cVar) {
        }

        @Override // com.soundcloud.android.crop.c.b
        public void d(c cVar) {
        }
    }

    /* compiled from: MonitoredActivity.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar);

        void b(c cVar);

        void c(c cVar);

        void d(c cVar);
    }

    public void b(b bVar) {
        if (this.wv.contains(bVar)) {
            return;
        }
        this.wv.add(bVar);
    }

    public void a(b bVar) {
        this.wv.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<b> it = this.wv.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<b> it = this.wv.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator<b> it = this.wv.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator<b> it = this.wv.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }
}
