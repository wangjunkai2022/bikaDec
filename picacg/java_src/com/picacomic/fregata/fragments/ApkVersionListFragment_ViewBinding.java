package com.picacomic.fregata.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class ApkVersionListFragment_ViewBinding implements Unbinder {
    private ApkVersionListFragment kp;

    @UiThread
    public ApkVersionListFragment_ViewBinding(ApkVersionListFragment apkVersionListFragment, View view) {
        this.kp = apkVersionListFragment;
        apkVersionListFragment.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        apkVersionListFragment.recyclerView_apkVersions = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView_apk_version_list, "field 'recyclerView_apkVersions'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ApkVersionListFragment apkVersionListFragment = this.kp;
        if (apkVersionListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.kp = null;
        apkVersionListFragment.toolbar = null;
        apkVersionListFragment.recyclerView_apkVersions = null;
    }
}
