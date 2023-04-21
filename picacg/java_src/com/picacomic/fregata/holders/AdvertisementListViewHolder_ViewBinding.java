package com.picacomic.fregata.holders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class AdvertisementListViewHolder_ViewBinding implements Unbinder {
    private AdvertisementListViewHolder sd;

    @UiThread
    public AdvertisementListViewHolder_ViewBinding(AdvertisementListViewHolder advertisementListViewHolder, View view) {
        this.sd = advertisementListViewHolder;
        advertisementListViewHolder.webView_ads = (WebView) Utils.findRequiredViewAsType(view, R.id.webView_ads_list, "field 'webView_ads'", WebView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AdvertisementListViewHolder advertisementListViewHolder = this.sd;
        if (advertisementListViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.sd = null;
        advertisementListViewHolder.webView_ads = null;
    }
}
