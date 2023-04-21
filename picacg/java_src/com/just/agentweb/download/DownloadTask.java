package com.just.agentweb.download;

import android.content.Context;
import android.support.annotation.DrawableRes;
import com.just.agentweb.ag;
import com.just.agentweb.download.AgentWebDownloader;
import com.just.agentweb.download.DefaultDownloadImpl;
import com.just.agentweb.download.j;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class DownloadTask extends AgentWebDownloader.Extra implements Serializable {
    private WeakReference<d> fP;
    private WeakReference<DefaultDownloadImpl.ExtraServiceImpl> fR;
    private DefaultDownloadImpl.ExtraServiceImpl fS;
    private Context mContext;
    private File mFile;
    private int mId;
    private AtomicBoolean fQ = new AtomicBoolean(false);
    private String TAG = getClass().getSimpleName();

    public DownloadTask(int i, d dVar, Context context, File file, DefaultDownloadImpl.ExtraServiceImpl extraServiceImpl) {
        this.fP = null;
        this.fR = null;
        this.mId = i;
        this.mContext = context;
        this.mFile = file;
        this.fP = new WeakReference<>(dVar);
        this.fn = extraServiceImpl.aD();
        try {
            this.fS = extraServiceImpl.clone();
            this.fR = new WeakReference<>(extraServiceImpl);
        } catch (CloneNotSupportedException e) {
            if (ag.ap()) {
                e.printStackTrace();
            }
            this.fS = extraServiceImpl;
        }
    }

    public DefaultDownloadImpl.ExtraServiceImpl aT() {
        return this.fR.get();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public boolean aD() {
        return this.fS.aD();
    }

    public int getId() {
        return this.mId;
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public String getUrl() {
        return this.fS.getUrl();
    }

    public boolean aU() {
        return this.fS.az();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public boolean aA() {
        return this.fS.aA();
    }

    public Context getContext() {
        return this.mContext;
    }

    public File aV() {
        return this.mFile;
    }

    public long getLength() {
        return this.fS.getContentLength();
    }

    @DrawableRes
    public int aW() {
        return this.fS.getIcon() == -1 ? j.a.ic_file_download_black_24dp : this.fS.getIcon();
    }

    public d aX() {
        return this.fP.get();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public int ay() {
        return this.fS.ay();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public int aC() {
        return this.fS.aC();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public long aB() {
        return this.fS.aB();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public boolean aF() {
        return this.fS.aF();
    }

    public void destroy() {
        this.fQ.set(true);
        this.mId = -1;
        this.fp = null;
        this.mContext = null;
        this.mFile = null;
        this.fP = null;
        this.fn = false;
        if (this.fR.get() != null) {
            this.fR.clear();
        }
        this.fR = null;
        this.fQ = null;
        this.fS = null;
    }
}
