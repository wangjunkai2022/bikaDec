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
public class NotificationFragment_ViewBinding implements Unbinder {
    private NotificationFragment qm;

    @UiThread
    public NotificationFragment_ViewBinding(NotificationFragment notificationFragment, View view) {
        this.qm = notificationFragment;
        notificationFragment.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        notificationFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView_notification, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NotificationFragment notificationFragment = this.qm;
        if (notificationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.qm = null;
        notificationFragment.toolbar = null;
        notificationFragment.recyclerView = null;
    }
}
