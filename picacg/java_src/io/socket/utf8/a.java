package io.socket.utf8;

import java.util.ArrayList;
import java.util.List;
/* compiled from: UTF8.java */
/* loaded from: classes.dex */
public final class a {
    private static int[] Ae;
    private static int Af;
    private static int Ag;

    public static String encode(String str) throws UTF8Exception {
        int[] aT = aT(str);
        int length = aT.length;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (true) {
            i++;
            if (i < length) {
                sb.append(aj(aT[i]));
            } else {
                return sb.toString();
            }
        }
    }

    public static String decode(String str) throws UTF8Exception {
        Ae = aT(str);
        Af = Ae.length;
        Ag = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int fu = fu();
            if (fu != -1) {
                arrayList.add(Integer.valueOf(fu));
            } else {
                return a(c(arrayList));
            }
        }
    }

    private static int[] aT(String str) {
        int length = str.length();
        int i = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    private static String aj(int i) throws UTF8Exception {
        StringBuilder sb = new StringBuilder();
        if ((i & (-128)) == 0) {
            sb.append(Character.toChars(i));
            return sb.toString();
        }
        if ((i & (-2048)) == 0) {
            sb.append(Character.toChars(((i >> 6) & 31) | 192));
        } else if (((-65536) & i) == 0) {
            ak(i);
            sb.append(Character.toChars(((i >> 12) & 15) | 224));
            sb.append(l(i, 6));
        } else if (((-2097152) & i) == 0) {
            sb.append(Character.toChars(((i >> 18) & 7) | 240));
            sb.append(l(i, 12));
            sb.append(l(i, 6));
        }
        sb.append(Character.toChars((i & 63) | 128));
        return sb.toString();
    }

    private static char[] l(int i, int i2) {
        return Character.toChars(((i >> i2) & 63) | 128);
    }

    private static int fu() throws UTF8Exception {
        if (Ag > Af) {
            throw new UTF8Exception("Invalid byte index");
        }
        if (Ag == Af) {
            return -1;
        }
        int i = Ae[Ag] & 255;
        Ag++;
        if ((i & 128) == 0) {
            return i;
        }
        if ((i & 224) == 192) {
            int fv = ((i & 31) << 6) | fv();
            if (fv >= 128) {
                return fv;
            }
            throw new UTF8Exception("Invalid continuation byte");
        } else if ((i & 240) == 224) {
            int fv2 = ((i & 15) << 12) | (fv() << 6) | fv();
            if (fv2 >= 2048) {
                ak(fv2);
                return fv2;
            }
            throw new UTF8Exception("Invalid continuation byte");
        } else {
            if ((i & 248) == 240) {
                int fv3 = ((i & 15) << 18) | (fv() << 12) | (fv() << 6) | fv();
                if (fv3 >= 65536 && fv3 <= 1114111) {
                    return fv3;
                }
            }
            throw new UTF8Exception("Invalid continuation byte");
        }
    }

    private static int fv() throws UTF8Exception {
        if (Ag >= Af) {
            throw new UTF8Exception("Invalid byte index");
        }
        int i = Ae[Ag] & 255;
        Ag++;
        if ((i & 192) == 128) {
            return i & 63;
        }
        throw new UTF8Exception("Invalid continuation byte");
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.appendCodePoint(i);
        }
        return sb.toString();
    }

    private static void ak(int i) throws UTF8Exception {
        if (i < 55296 || i > 57343) {
            return;
        }
        throw new UTF8Exception("Lone surrogate U+" + Integer.toHexString(i).toUpperCase() + " is not a scalar value");
    }

    private static int[] c(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
