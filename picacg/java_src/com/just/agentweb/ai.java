package com.just.agentweb;

import android.webkit.WebViewClient;
/* compiled from: MiddlewareWebClientBase.java */
/* loaded from: classes.dex */
public class ai extends aw {
    private String TAG;
    private ai eM;

    /* JADX INFO: Access modifiers changed from: protected */
    public ai(WebViewClient webViewClient) {
        super(webViewClient);
        this.TAG = getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ai() {
        super(null);
        this.TAG = getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ai ar() {
        return this.eM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.just.agentweb.aw
    public final void c(WebViewClient webViewClient) {
        super.c(webViewClient);
    }
}
