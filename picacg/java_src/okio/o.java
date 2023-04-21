package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class o {
    @Nullable
    static n AI;
    static long AK;

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n gf() {
        synchronized (o.class) {
            if (AI != null) {
                n nVar = AI;
                AI = nVar.AI;
                nVar.AI = null;
                AK -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return nVar;
            }
            return new n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(n nVar) {
        if (nVar.AI != null || nVar.AJ != null) {
            throw new IllegalArgumentException();
        }
        if (nVar.AG) {
            return;
        }
        synchronized (o.class) {
            if (AK + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            AK += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            nVar.AI = AI;
            nVar.limit = 0;
            nVar.pos = 0;
            AI = nVar;
        }
    }
}
