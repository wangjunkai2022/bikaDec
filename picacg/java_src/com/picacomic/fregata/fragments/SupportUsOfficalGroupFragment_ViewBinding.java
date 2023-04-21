package com.picacomic.fregata.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class SupportUsOfficalGroupFragment_ViewBinding implements Unbinder {
    private SupportUsOfficalGroupFragment rR;

    @UiThread
    public SupportUsOfficalGroupFragment_ViewBinding(SupportUsOfficalGroupFragment supportUsOfficalGroupFragment, View view) {
        this.rR = supportUsOfficalGroupFragment;
        supportUsOfficalGroupFragment.textView_warning = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_support_us_offical_group_warning, "field 'textView_warning'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SupportUsOfficalGroupFragment supportUsOfficalGroupFragment = this.rR;
        if (supportUsOfficalGroupFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.rR = null;
        supportUsOfficalGroupFragment.textView_warning = null;
    }
}
