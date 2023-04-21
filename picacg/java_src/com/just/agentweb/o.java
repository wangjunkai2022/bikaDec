package com.just.agentweb;

import android.os.Build;
import android.webkit.WebView;
/* compiled from: DefaultWebLifeCycleImpl.java */
/* loaded from: classes.dex */
public class o implements aq {
    private WebView db;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(WebView webView) {
        this.db = webView;
    }

    @Override // com.just.agentweb.aq
    public void onResume() {
        if (this.db != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.db.onResume();
            }
            this.db.resumeTimers();
        }
    }

    @Override // com.just.agentweb.aq
    public void onPause() {
        if (this.db != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.db.onPause();
            }
            this.db.pauseTimers();
        }
    }

    @Override // com.just.agentweb.aq
    public void onDestroy() {
        if (this.db != null) {
            this.db.resumeTimers();
        }
        h.c(this.db);
    }
}
