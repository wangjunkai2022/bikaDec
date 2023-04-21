package io.socket.a;

import java.math.BigDecimal;
import java.math.BigInteger;
/* compiled from: Backoff.java */
/* loaded from: classes.dex */
public class a {
    private double wy;
    private int wz;
    private long ww = 100;
    private long wx = 10000;
    private int factor = 2;

    public long et() {
        BigInteger valueOf = BigInteger.valueOf(this.ww);
        BigInteger valueOf2 = BigInteger.valueOf(this.factor);
        int i = this.wz;
        this.wz = i + 1;
        BigInteger multiply = valueOf.multiply(valueOf2.pow(i));
        if (this.wy != 0.0d) {
            double random = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(random).multiply(BigDecimal.valueOf(this.wy)).multiply(new BigDecimal(multiply)).toBigInteger();
            multiply = (((int) Math.floor(random * 10.0d)) & 1) == 0 ? multiply.subtract(bigInteger) : multiply.add(bigInteger);
        }
        return multiply.min(BigInteger.valueOf(this.wx)).longValue();
    }

    public void reset() {
        this.wz = 0;
    }

    public a e(long j) {
        this.ww = j;
        return this;
    }

    public a f(long j) {
        this.wx = j;
        return this;
    }

    public a a(double d) {
        this.wy = d;
        return this;
    }

    public int eu() {
        return this.wz;
    }
}
