package com.just.agentweb;

import android.app.Activity;
import android.webkit.DownloadListener;
import android.webkit.WebView;
/* compiled from: AgentWebSettingsImpl.java */
/* loaded from: classes.dex */
public class f extends a {
    private AgentWeb mAgentWeb;

    @Override // com.just.agentweb.a
    protected void b(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }

    @Override // com.just.agentweb.a, com.just.agentweb.ar
    public ar a(WebView webView, DownloadListener downloadListener) {
        DownloadListener downloadListener2 = null;
        try {
            downloadListener2 = Class.forName("com.just.agentweb.download.DefaultDownloadImpl").getDeclaredMethod("create", Activity.class, WebView.class, Class.forName("com.just.agentweb.download.c"), Class.forName("com.just.agentweb.download.g"), aj.class).invoke(null, (Activity) webView.getContext(), webView, null, null, this.mAgentWeb.w());
        } catch (Throwable th) {
            if (ag.ap()) {
                th.printStackTrace();
            }
        }
        if (downloadListener2 != null) {
            downloadListener = downloadListener2;
        }
        return super.a(webView, downloadListener);
    }
}
