package io.socket.f;
/* compiled from: Packet.java */
/* loaded from: classes.dex */
public class b<T> {
    public T data;
    public int id;
    public int type;
    public String xC;
    public int zU;

    public b() {
        this.type = -1;
        this.id = -1;
    }

    public b(int i) {
        this.type = -1;
        this.id = -1;
        this.type = i;
    }

    public b(int i, T t) {
        this.type = -1;
        this.id = -1;
        this.type = i;
        this.data = t;
    }
}
