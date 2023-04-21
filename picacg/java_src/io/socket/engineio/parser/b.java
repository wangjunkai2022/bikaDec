package io.socket.engineio.parser;
/* compiled from: Packet.java */
/* loaded from: classes.dex */
public class b<T> {
    public T data;
    public String type;

    public b(String str) {
        this(str, null);
    }

    public b(String str, T t) {
        this.type = str;
        this.data = t;
    }
}
