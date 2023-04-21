package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {
    private static final byte EXCEPTION_MARKER = 33;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private static final byte[] WILDCARD_LABEL = {42};
    private static final String[] EMPTY_RULE = new String[0];
    private static final String[] PREVAILING_RULE = {"*"};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static PublicSuffixDatabase get() {
        return instance;
    }

    public String getEffectiveTldPlusOne(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] findMatchingRule = findMatchingRule(split);
        if (split.length != findMatchingRule.length || findMatchingRule[0].charAt(0) == '!') {
            if (findMatchingRule[0].charAt(0) == '!') {
                length = split.length - findMatchingRule.length;
            } else {
                length = split.length - (findMatchingRule.length + 1);
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            while (length < split2.length) {
                sb.append(split2[length]);
                sb.append('.');
                length++;
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return null;
    }

    private String[] findMatchingRule(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheList();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(Util.UTF_8);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                str = null;
                break;
            }
            str = binarySearchBytes(this.publicSuffixListBytes, bArr, i2);
            if (str != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = WILDCARD_LABEL;
                str2 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i3);
                if (str2 != null) {
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                str3 = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            return ("!" + str3).split("\\.");
        } else if (str == null && str2 == null) {
            return PREVAILING_RULE;
        } else {
            if (str != null) {
                strArr2 = str.split("\\.");
            } else {
                strArr2 = EMPTY_RULE;
            }
            if (str2 != null) {
                strArr3 = str2.split("\\.");
            } else {
                strArr3 = EMPTY_RULE;
            }
            return strArr2.length > strArr3.length ? strArr2 : strArr3;
        }
    }

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, Util.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void readTheList() {
        /*
            r6 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            r1 = 0
            if (r0 == 0) goto L48
            okio.i r2 = new okio.i
            okio.q r0 = okio.k.a(r0)
            r2.<init>(r0)
            okio.e r0 = okio.k.b(r2)
            int r2 = r0.readInt()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r0.readFully(r2)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            int r3 = r0.readInt()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r0.readFully(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            okhttp3.internal.Util.closeQuietly(r0)
            r1 = r2
            goto L49
        L33:
            r1 = move-exception
            goto L44
        L35:
            r2 = move-exception
            okhttp3.internal.platform.Platform r3 = okhttp3.internal.platform.Platform.get()     // Catch: java.lang.Throwable -> L33
            r4 = 5
            java.lang.String r5 = "Failed to read public suffix list"
            r3.log(r4, r5, r2)     // Catch: java.lang.Throwable -> L33
            okhttp3.internal.Util.closeQuietly(r0)
            goto L48
        L44:
            okhttp3.internal.Util.closeQuietly(r0)
            throw r1
        L48:
            r3 = r1
        L49:
            monitor-enter(r6)
            r6.publicSuffixListBytes = r1     // Catch: java.lang.Throwable -> L55
            r6.publicSuffixExceptionListBytes = r3     // Catch: java.lang.Throwable -> L55
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L55
            java.util.concurrent.CountDownLatch r0 = r6.readCompleteLatch
            r0.countDown()
            return
        L55:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L55
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
