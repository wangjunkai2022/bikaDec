package com.orm.b;

import android.content.Context;
import android.util.Log;
/* compiled from: ManifestHelper.java */
/* loaded from: classes.dex */
public class a {
    public static int k(Context context) {
        Integer c = c(context, "VERSION");
        return ((c == null || c.intValue() == 0) ? 1 : 1).intValue();
    }

    public static String l(Context context) {
        String b = b(context, "DOMAIN_PACKAGE_NAME");
        return b == null ? "" : b;
    }

    public static String m(Context context) {
        String b = b(context, "DATABASE");
        return b == null ? "Sugar.db" : b;
    }

    public static boolean n(Context context) {
        return d(context, "QUERY_LOG").booleanValue();
    }

    private static String b(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception unused) {
            Log.d("sugar", "Couldn't find config value: " + str);
            return null;
        }
    }

    private static Integer c(Context context, String str) {
        try {
            return Integer.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(str));
        } catch (Exception unused) {
            Log.d("sugar", "Couldn't find config value: " + str);
            return null;
        }
    }

    private static Boolean d(Context context, String str) {
        try {
            return Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean(str));
        } catch (Exception unused) {
            Log.d("sugar", "Couldn't find config value: " + str);
            return false;
        }
    }
}
