package com.picacomic.fregata.holders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class ChatroomGameMessageViewHolder_ViewBinding implements Unbinder {
    private ChatroomGameMessageViewHolder sv;

    @UiThread
    public ChatroomGameMessageViewHolder_ViewBinding(ChatroomGameMessageViewHolder chatroomGameMessageViewHolder, View view) {
        this.sv = chatroomGameMessageViewHolder;
        chatroomGameMessageViewHolder.textView_message = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_chatroom_game_message_recycler_view_cell_message, "field 'textView_message'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatroomGameMessageViewHolder chatroomGameMessageViewHolder = this.sv;
        if (chatroomGameMessageViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.sv = null;
        chatroomGameMessageViewHolder.textView_message = null;
    }
}
