package com.just.agentweb;

import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* compiled from: WebListenerManager.java */
/* loaded from: classes.dex */
public interface ar {
    ar a(WebView webView, DownloadListener downloadListener);

    ar a(WebView webView, WebChromeClient webChromeClient);

    ar a(WebView webView, WebViewClient webViewClient);
}
