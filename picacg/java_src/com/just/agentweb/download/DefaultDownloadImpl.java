package com.just.agentweb.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import com.just.agentweb.Action;
import com.just.agentweb.ActionActivity;
import com.just.agentweb.ag;
import com.just.agentweb.aj;
import com.just.agentweb.download.AgentWebDownloader;
import com.just.agentweb.download.j;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class DefaultDownloadImpl implements DownloadListener {
    private WeakReference<com.just.agentweb.b> dS;
    private WeakReference<Activity> dz;
    private String fA;
    private String fB;
    private ExtraServiceImpl fC;
    private String fD;
    private ExtraServiceImpl fE;
    private Pattern fF;
    private d fG;
    private String fp;
    private long fq;
    private c fy;
    private aj fz;
    private Context mContext;
    private static volatile AtomicInteger fx = new AtomicInteger(1);
    private static final String TAG = DefaultDownloadImpl.class.getSimpleName();

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        a(str, str2, str3, str4, j, null);
    }

    private synchronized void a(String str, String str2, String str3, String str4, long j, ExtraServiceImpl extraServiceImpl) {
        if (this.dz.get() != null && !this.dz.get().isFinishing()) {
            if (this.fz == null || !this.fz.a(str, com.just.agentweb.e.dD, "download")) {
                if (extraServiceImpl == null) {
                    try {
                        extraServiceImpl = this.fC.clone();
                    } catch (CloneNotSupportedException e) {
                        if (ag.ap()) {
                            e.printStackTrace();
                        }
                        ag.c(TAG, " clone object failure !!! ");
                        return;
                    }
                }
                this.fp = str;
                ExtraServiceImpl v = extraServiceImpl.v(str);
                this.fB = str4;
                ExtraServiceImpl y = v.y(str4);
                this.fA = str3;
                ExtraServiceImpl x = y.x(str3);
                this.fq = j;
                ExtraServiceImpl b = x.b(j);
                this.fD = str2;
                b.w(str2);
                this.fE = extraServiceImpl;
                if (Build.VERSION.SDK_INT >= 23) {
                    List<String> aK = aK();
                    if (aK.isEmpty()) {
                        aL();
                    } else {
                        Action a = Action.a((String[]) aK.toArray(new String[0]));
                        ActionActivity.a(aJ());
                        ActionActivity.a(this.dz.get(), a);
                    }
                } else {
                    aL();
                }
            }
        }
    }

    private ActionActivity.b aJ() {
        return new ActionActivity.b() { // from class: com.just.agentweb.download.DefaultDownloadImpl.1
            @Override // com.just.agentweb.ActionActivity.b
            public void a(@NonNull String[] strArr, @NonNull int[] iArr, Bundle bundle) {
                if (DefaultDownloadImpl.this.aK().isEmpty()) {
                    DefaultDownloadImpl.this.aL();
                    return;
                }
                if (DefaultDownloadImpl.this.dS.get() != null) {
                    ((com.just.agentweb.b) DefaultDownloadImpl.this.dS.get()).a((String[]) DefaultDownloadImpl.this.aK().toArray(new String[0]), "Storage", "Download");
                }
                ag.d(DefaultDownloadImpl.TAG, "储存权限获取失败~");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> aK() {
        ArrayList arrayList = new ArrayList();
        if (!com.just.agentweb.h.a((Context) this.dz.get(), com.just.agentweb.e.dD)) {
            arrayList.addAll(Arrays.asList(com.just.agentweb.e.dD));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL() {
        Intent c;
        if (this.fy == null || !this.fy.a(this.fp, this.fD, this.fA, this.fB, this.fq, this.fE)) {
            File e = e(this.fA, this.fp);
            if (e == null) {
                ag.d(TAG, "新建文件失败");
                return;
            }
            if (e.exists() && e.length() >= this.fq && this.fq > 0) {
                if ((this.fy != null && this.fy.c(e.getAbsolutePath(), this.fp, null)) || (c = com.just.agentweb.h.c(this.mContext, e)) == null) {
                    return;
                }
                try {
                    if (!(this.mContext instanceof Activity)) {
                        c.addFlags(268435456);
                    }
                    this.mContext.startActivity(c);
                    return;
                } catch (Throwable th) {
                    if (ag.ap()) {
                        th.printStackTrace();
                    }
                }
            }
            if (ExecuteTasksMap.aN().contains(this.fp) || ExecuteTasksMap.aN().contains(e.getAbsolutePath())) {
                if (this.dS.get() != null) {
                    this.dS.get().a(this.dz.get().getString(j.b.agentweb_download_task_has_been_exist), TAG.concat("|preDownload"));
                }
            } else if (!this.fE.az() && com.just.agentweb.h.e(this.mContext) > 1) {
                c(e);
            } else {
                e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        this.fE.d(true);
        e(file);
    }

    private void c(File file) {
        com.just.agentweb.b bVar;
        Activity activity = this.dz.get();
        if (activity == null || activity.isFinishing() || (bVar = this.dS.get()) == null) {
            return;
        }
        bVar.a(this.fp, d(file));
    }

    private Handler.Callback d(final File file) {
        return new Handler.Callback() { // from class: com.just.agentweb.download.DefaultDownloadImpl.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                DefaultDownloadImpl.this.b(file);
                return true;
            }
        };
    }

    private void e(File file) {
        try {
            ExecuteTasksMap.aN().f(this.fp, file.getAbsolutePath());
            if (this.dS.get() != null) {
                this.dS.get().a(this.dz.get().getString(j.b.agentweb_coming_soon_download) + ":" + file.getName(), TAG.concat("|performDownload"));
            }
            new f().c(new DownloadTask(fx.incrementAndGet(), this.fG, this.mContext, file, this.fE));
            this.fp = null;
            this.fA = null;
            this.fq = -1L;
            this.fB = null;
            this.fD = null;
        } catch (Throwable th) {
            if (ag.ap()) {
                th.printStackTrace();
            }
        }
    }

    private File e(String str, String str2) {
        String str3 = "";
        try {
            String t = t(str);
            try {
                if (!TextUtils.isEmpty(t) || TextUtils.isEmpty(str2)) {
                    str3 = t;
                } else {
                    Uri parse = Uri.parse(str2);
                    str3 = parse.getPath().substring(parse.getPath().lastIndexOf(47) + 1);
                }
                if (!TextUtils.isEmpty(str3) && str3.length() > 64) {
                    str3 = str3.substring(str3.length() - 64, str3.length());
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = com.just.agentweb.h.d(str2);
                }
                if (str3.contains("\"")) {
                    str3 = str3.replace("\"", "");
                }
                return com.just.agentweb.h.a(this.mContext, str3, !this.fE.aE());
            } catch (Throwable th) {
                th = th;
                str3 = t;
                if (ag.ap()) {
                    String str4 = TAG;
                    ag.c(str4, "fileName:" + str3);
                    th.printStackTrace();
                    return null;
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = this.fF.matcher(str.toLowerCase());
        return matcher.find() ? matcher.group(1) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ExecuteTasksMap extends ReentrantReadWriteLock {
        private static volatile ExecuteTasksMap fJ;
        private LinkedList<String> fI;

        private ExecuteTasksMap() {
            super(false);
            this.fI = null;
            this.fI = new LinkedList<>();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static ExecuteTasksMap aN() {
            if (fJ == null) {
                synchronized (ExecuteTasksMap.class) {
                    if (fJ == null) {
                        fJ = new ExecuteTasksMap();
                    }
                }
            }
            return fJ;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void u(String str) {
            try {
                writeLock().lock();
                int indexOf = this.fI.indexOf(str);
                if (indexOf == -1) {
                    return;
                }
                this.fI.remove(indexOf);
                this.fI.remove(indexOf - 1);
            } finally {
                writeLock().unlock();
            }
        }

        void f(String str, String str2) {
            try {
                writeLock().lock();
                this.fI.add(str);
                this.fI.add(str2);
            } finally {
                writeLock().unlock();
            }
        }

        boolean contains(String str) {
            try {
                readLock().lock();
                return this.fI.contains(str);
            } finally {
                readLock().unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ExtraServiceImpl extends AgentWebDownloader.ExtraService implements Serializable, Cloneable {
        private transient aj cQ;
        private transient WebView db;
        protected String fA;
        protected String fB;
        protected String fD;
        private boolean fK = false;
        protected String fp;
        protected long fq;
        private transient c fy;
        private transient Activity mActivity;

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public String getUrl() {
            return this.fp;
        }

        protected ExtraServiceImpl v(String str) {
            this.fp = str;
            return this;
        }

        protected ExtraServiceImpl w(String str) {
            this.fD = str;
            return this;
        }

        protected ExtraServiceImpl x(String str) {
            this.fA = str;
            return this;
        }

        protected ExtraServiceImpl y(String str) {
            this.fB = str;
            return this;
        }

        @Override // com.just.agentweb.download.AgentWebDownloader.Extra
        public long getContentLength() {
            return this.fq;
        }

        protected ExtraServiceImpl b(long j) {
            this.fq = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: aO */
        public ExtraServiceImpl clone() throws CloneNotSupportedException {
            ExtraServiceImpl extraServiceImpl = (ExtraServiceImpl) super.clone();
            extraServiceImpl.fK = true;
            extraServiceImpl.mActivity = null;
            extraServiceImpl.fy = null;
            extraServiceImpl.cQ = null;
            extraServiceImpl.db = null;
            return extraServiceImpl;
        }
    }
}
