package com.picacomic.fregata.holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.e;
/* loaded from: classes.dex */
public class CommentTopReplacementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final String TAG = "CommentTopReplacementViewHolder";
    e sI;
    @BindView(R.id.textView_comment_recycler_view_cell_floor)
    public TextView textView_floor;

    public CommentTopReplacementViewHolder(View view, e eVar) {
        super(view);
        ButterKnife.bind(this, view);
        this.sI = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = TAG;
        Log.d(str, "onClick--> position = " + getAdapterPosition());
    }
}
