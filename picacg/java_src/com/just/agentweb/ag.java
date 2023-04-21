package com.just.agentweb;

import android.util.Log;
/* compiled from: LogUtils.java */
/* loaded from: classes.dex */
public class ag {
    public static boolean ap() {
        return c.DEBUG;
    }

    public static void c(String str, String str2) {
        if (ap()) {
            Log.i(" agentweb - ".concat(str), str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (ap()) {
            throw new RuntimeException(" agentweb - ".concat(str) + " " + str2, th);
        }
        Log.e(" agentweb - ".concat(str), str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public static void d(String str, String str2) {
        if (ap()) {
            Log.e(" agentweb - ".concat(str), str2);
        }
    }
}
