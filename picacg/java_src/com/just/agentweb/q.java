package com.just.agentweb;

import java.util.Map;
/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public class q {
    private Map<String, String> ez;

    public Map<String, String> getHeaders() {
        return this.ez;
    }

    public boolean ai() {
        return this.ez == null || this.ez.isEmpty();
    }

    public String toString() {
        return "HttpHeaders{mHeaders=" + this.ez + '}';
    }
}
