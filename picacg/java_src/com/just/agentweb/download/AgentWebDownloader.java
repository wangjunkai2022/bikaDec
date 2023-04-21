package com.just.agentweb.download;

import android.support.annotation.DrawableRes;
import com.just.agentweb.download.AgentWebDownloader.Extra;
import com.just.agentweb.download.j;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes.dex */
public interface AgentWebDownloader<T extends Extra> extends h {

    /* loaded from: classes.dex */
    public static abstract class ExtraService extends Extra {
    }

    /* loaded from: classes.dex */
    public static abstract class Extra implements Serializable {
        protected Map<String, String> ez;
        protected String fp;
        protected long fq;
        protected boolean fm = false;
        protected boolean cB = true;
        @DrawableRes
        protected int mIcon = j.a.ic_file_download_black_24dp;
        protected boolean fn = true;
        protected boolean fo = true;
        protected boolean fr = false;
        protected long fs = Long.MAX_VALUE;
        protected int ft = 10000;
        protected int fu = 600000;

        public Map<String, String> getHeaders() {
            return this.ez;
        }

        public int ay() {
            return this.fu;
        }

        public String getUrl() {
            return this.fp;
        }

        public long getContentLength() {
            return this.fq;
        }

        public boolean az() {
            return this.fm;
        }

        public boolean aA() {
            return this.cB;
        }

        public long aB() {
            return this.fs;
        }

        public int aC() {
            return this.ft;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public boolean aD() {
            return this.fn;
        }

        public boolean aE() {
            return this.fo;
        }

        public Extra d(boolean z) {
            this.fm = z;
            return this;
        }

        public boolean aF() {
            return this.fr;
        }
    }
}
