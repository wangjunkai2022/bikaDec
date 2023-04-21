package com.orm.b;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: SugarConfig.java */
/* loaded from: classes.dex */
public class h {
    static Map<Class<?>, List<Field>> gX = new HashMap();

    public static void a(Class<?> cls, List<Field> list) {
        gX.put(cls, list);
    }

    public static List<Field> e(Class<?> cls) {
        if (gX.containsKey(cls)) {
            return Collections.synchronizedList(gX.get(cls));
        }
        return null;
    }
}
