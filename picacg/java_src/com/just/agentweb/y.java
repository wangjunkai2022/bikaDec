package com.just.agentweb;

import android.webkit.WebView;
/* compiled from: IndicatorHandler.java */
/* loaded from: classes.dex */
public class y implements x {
    private i ex;

    @Override // com.just.agentweb.x
    public void a(WebView webView, int i) {
        if (i == 0) {
            reset();
        } else if (i > 0 && i <= 10) {
            al();
        } else if (i > 10 && i < 95) {
            setProgress(i);
        } else {
            setProgress(i);
            finish();
        }
    }

    @Override // com.just.agentweb.x
    public i ak() {
        return this.ex;
    }

    public void reset() {
        if (this.ex != null) {
            this.ex.reset();
        }
    }

    public void finish() {
        if (this.ex != null) {
            this.ex.hide();
        }
    }

    public void setProgress(int i) {
        if (this.ex != null) {
            this.ex.setProgress(i);
        }
    }

    public void al() {
        if (this.ex != null) {
            this.ex.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y am() {
        return new y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y a(i iVar) {
        this.ex = iVar;
        return this;
    }
}
