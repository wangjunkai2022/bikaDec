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
public class ChatroomListFragment_ViewBinding implements Unbinder {
    private ChatroomListFragment mR;

    @UiThread
    public ChatroomListFragment_ViewBinding(ChatroomListFragment chatroomListFragment, View view) {
        this.mR = chatroomListFragment;
        chatroomListFragment.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        chatroomListFragment.recyclerView_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView_chatroom_list, "field 'recyclerView_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatroomListFragment chatroomListFragment = this.mR;
        if (chatroomListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.mR = null;
        chatroomListFragment.toolbar = null;
        chatroomListFragment.recyclerView_list = null;
    }
}
