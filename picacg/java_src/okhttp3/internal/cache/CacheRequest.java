package okhttp3.internal.cache;

import java.io.IOException;
import okio.p;
/* loaded from: classes.dex */
public interface CacheRequest {
    void abort();

    p body() throws IOException;
}
