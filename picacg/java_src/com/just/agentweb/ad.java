package com.just.agentweb;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* compiled from: JsCallback.java */
/* loaded from: classes.dex */
public class ad {
    private boolean eI = true;
    private WeakReference<WebView> eJ;
    private String eK;
    private int mIndex;

    public ad(WebView webView, String str, int i) {
        this.eJ = new WeakReference<>(webView);
        this.eK = str;
        this.mIndex = i;
    }
}
