package com.picacomic.fregata.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class SupportUsContainerFragment_ViewBinding implements Unbinder {
    private SupportUsContainerFragment rP;

    @UiThread
    public SupportUsContainerFragment_ViewBinding(SupportUsContainerFragment supportUsContainerFragment, View view) {
        this.rP = supportUsContainerFragment;
        supportUsContainerFragment.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        supportUsContainerFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tabs, "field 'tabLayout'", TabLayout.class);
        supportUsContainerFragment.viewPager_tags = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewPager_support_us, "field 'viewPager_tags'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SupportUsContainerFragment supportUsContainerFragment = this.rP;
        if (supportUsContainerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.rP = null;
        supportUsContainerFragment.toolbar = null;
        supportUsContainerFragment.tabLayout = null;
        supportUsContainerFragment.viewPager_tags = null;
    }
}
