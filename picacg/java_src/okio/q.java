package okio;

import java.io.Closeable;
import java.io.IOException;
/* compiled from: Source.java */
/* loaded from: classes.dex */
public interface q extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    r timeout();
}
