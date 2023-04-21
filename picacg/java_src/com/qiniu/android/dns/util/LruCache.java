package com.qiniu.android.dns.util;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.size;
    }
}
