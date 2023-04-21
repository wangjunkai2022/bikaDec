package com.orm.b;

import java.lang.reflect.Field;
/* compiled from: NamingHelper.java */
/* loaded from: classes.dex */
public class d {
    public static String z(String str) {
        if (str.equalsIgnoreCase("_id")) {
            return "_id";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = i > 0 ? charArray[i - 1] : (char) 0;
            char c2 = charArray[i];
            char c3 = i < charArray.length - 1 ? charArray[i + 1] : (char) 0;
            if ((i == 0) || Character.isLowerCase(c2) || Character.isDigit(c2)) {
                sb.append(Character.toUpperCase(c2));
            } else if (Character.isUpperCase(c2)) {
                if (Character.isLetterOrDigit(c)) {
                    if (Character.isLowerCase(c)) {
                        sb.append('_');
                        sb.append(c2);
                    } else if (c3 > 0 && Character.isLowerCase(c3)) {
                        sb.append('_');
                        sb.append(c2);
                    } else {
                        sb.append(c2);
                    }
                } else {
                    sb.append(c2);
                }
            }
            i++;
        }
        return sb.toString();
    }

    public static String a(Field field) {
        if (field.isAnnotationPresent(com.orm.a.a.class)) {
            return ((com.orm.a.a) field.getAnnotation(com.orm.a.a.class)).name();
        }
        return z(field.getName());
    }

    public static String b(Class<?> cls) {
        if (cls.isAnnotationPresent(com.orm.a.e.class)) {
            com.orm.a.e eVar = (com.orm.a.e) cls.getAnnotation(com.orm.a.e.class);
            if ("".equals(eVar.name())) {
                return z(cls.getSimpleName());
            }
            return eVar.name();
        }
        return z(cls.getSimpleName());
    }
}
