package com.picacomic.fregata.utils;

import java.io.UnsupportedEncodingException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: GenerateSignature.java */
/* loaded from: classes.dex */
public class d {
    public static final String TAG = "d";
    protected static final char[] uq = "0123456789abcdef".toCharArray();
    String uo;

    public synchronized String C(String str, String str2) {
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        try {
            bArr = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = bArr2;
        }
        String lowerCase = str.toLowerCase();
        String str3 = TAG;
        f.D(str3, "RAW SIGNATURE = " + lowerCase);
        this.uo = a(lowerCase, bArr);
        return this.uo;
    }

    protected String a(String str, byte[] bArr) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(bArr, "HmacSHA256"));
            return a(mac.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = uq[i2 >>> 4];
            cArr[i3 + 1] = uq[i2 & 15];
        }
        return new String(cArr);
    }
}
