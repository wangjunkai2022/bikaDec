package com.picacomic.fregata.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
import com.picacomic.fregata.objects.AnonymousChatDataObject;
/* loaded from: classes.dex */
public class AnonymousChatViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "AnonymousChatViewHolder";
    @BindView(R.id.textView_anonymous_chat_cell_message)
    TextView textView_message;

    public AnonymousChatViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void a(AnonymousChatDataObject anonymousChatDataObject) {
        if (anonymousChatDataObject == null || anonymousChatDataObject.getMessage() == null) {
            return;
        }
        TextView textView = this.textView_message;
        textView.setText(anonymousChatDataObject.getMessage() + "");
    }
}
