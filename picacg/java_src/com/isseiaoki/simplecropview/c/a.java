package com.isseiaoki.simplecropview.c;

import android.util.Log;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class a {
    public static boolean enabled = false;

    public static void a(String str, Throwable th) {
        if (enabled) {
            Log.e("SimpleCropView", str, th);
        }
    }
}
