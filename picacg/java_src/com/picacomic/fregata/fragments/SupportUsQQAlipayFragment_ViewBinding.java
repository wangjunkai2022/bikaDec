package com.picacomic.fregata.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class SupportUsQQAlipayFragment_ViewBinding implements Unbinder {
    private SupportUsQQAlipayFragment rX;

    @UiThread
    public SupportUsQQAlipayFragment_ViewBinding(SupportUsQQAlipayFragment supportUsQQAlipayFragment, View view) {
        this.rX = supportUsQQAlipayFragment;
        supportUsQQAlipayFragment.textView_alipay = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_support_us_alipay, "field 'textView_alipay'", TextView.class);
        supportUsQQAlipayFragment.textView_alipayTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_support_us_alipay_title, "field 'textView_alipayTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SupportUsQQAlipayFragment supportUsQQAlipayFragment = this.rX;
        if (supportUsQQAlipayFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.rX = null;
        supportUsQQAlipayFragment.textView_alipay = null;
        supportUsQQAlipayFragment.textView_alipayTitle = null;
    }
}
