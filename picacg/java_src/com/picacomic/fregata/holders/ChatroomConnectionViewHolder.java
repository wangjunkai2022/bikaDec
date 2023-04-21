package com.picacomic.fregata.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class ChatroomConnectionViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.textView_chatroom_recycler_view_cell_connection)
    public TextView textView_connection;

    public ChatroomConnectionViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
