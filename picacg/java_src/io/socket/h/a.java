package io.socket.h;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Yeast.java */
/* loaded from: classes.dex */
public final class a {
    private static String Aj;
    private static char[] Ah = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
    private static int length = Ah.length;
    private static int Ai = 0;
    private static Map<Character, Integer> map = new HashMap(length);

    static {
        for (int i = 0; i < length; i++) {
            map.put(Character.valueOf(Ah[i]), Integer.valueOf(i));
        }
    }

    public static String k(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, Ah[(int) (j % length)]);
            j /= length;
        } while (j > 0);
        return sb.toString();
    }

    public static String fw() {
        String k = k(new Date().getTime());
        if (!k.equals(Aj)) {
            Ai = 0;
            Aj = k;
            return k;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        sb.append(".");
        int i = Ai;
        Ai = i + 1;
        sb.append(k(i));
        return sb.toString();
    }
}
