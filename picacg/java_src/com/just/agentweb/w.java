package com.just.agentweb;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.webkit.WebView;
/* compiled from: IWebLayout.java */
/* loaded from: classes.dex */
public interface w<T extends WebView, V extends ViewGroup> {
    @NonNull
    V aj();

    @Nullable
    T getWebView();
}
