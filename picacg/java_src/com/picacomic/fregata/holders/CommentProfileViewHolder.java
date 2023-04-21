package com.picacomic.fregata.holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.e;
/* loaded from: classes.dex */
public class CommentProfileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final String TAG = "CommentProfileViewHolder";
    @BindView(R.id.button_comment_recycler_view_cell_hide)
    public Button button_hide;
    @BindView(R.id.button_comment_recycler_view_cell_view_more)
    public Button button_viewMore;
    @BindView(R.id.imageView_comment_recycler_view_cell_like_icon)
    public ImageView imageView_likeIcon;
    @BindView(R.id.imageView_comment_recycler_view_cell_user_thumb)
    public ImageView imageView_userThumb;
    @BindView(R.id.imageView_comment_recycler_view_cell_user_thumb_verified)
    public ImageView imageView_userVerified;
    @BindView(R.id.linearLayout_comment_recycler_view_cell_reply)
    public LinearLayout linearLayout_reply;
    e sI;
    @BindView(R.id.textView_comment_recycler_view_cell_content)
    public TextView textView_content;
    @BindView(R.id.textView_comment_recycler_view_cell_created_date)
    public TextView textView_createdDate;
    @BindView(R.id.textView_comment_recycler_view_cell_floor)
    public TextView textView_floor;
    @BindView(R.id.textView_comment_recycler_view_cell_level)
    public TextView textView_level;
    @BindView(R.id.textView_comment_recycler_view_cell_like_count)
    public TextView textView_likeCount;
    @BindView(R.id.textView_comment_recycler_view_cell_no_reply)
    public TextView textView_noReply;
    @BindView(R.id.textView_comment_recycler_view_cell_reply_count)
    public TextView textView_replyCount;
    @BindView(R.id.textView_comment_recycler_view_cell_title)
    public TextView textView_title;
    @BindView(R.id.textView_comment_recycler_view_cell_username)
    public TextView textView_username;
    @BindView(R.id.textView_comment_recycler_view_cell_view_content_page)
    public TextView textView_viewContentPage;

    public CommentProfileViewHolder(View view, e eVar) {
        super(view);
        ButterKnife.bind(this, view);
        this.sI = eVar;
        view.setOnClickListener(this);
        this.button_viewMore.setOnClickListener(this);
        this.imageView_userThumb.setOnClickListener(this);
        this.textView_viewContentPage.setOnClickListener(this);
        this.imageView_likeIcon.setOnClickListener(this);
        this.textView_likeCount.setOnClickListener(this);
        this.button_hide.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.imageView_comment_recycler_view_cell_like_icon || view.getId() == R.id.textView_comment_recycler_view_cell_like_count) {
            this.sI.Q(getAdapterPosition());
        } else if (view.getId() == R.id.button_comment_recycler_view_cell_view_more) {
            this.sI.N(getAdapterPosition());
        } else if (view.getId() == R.id.imageView_comment_recycler_view_cell_user_thumb) {
            this.sI.P(getAdapterPosition());
        } else if (view.getId() == R.id.textView_comment_recycler_view_cell_view_content_page) {
            this.sI.O(getAdapterPosition());
        } else if (view.getId() == R.id.button_comment_recycler_view_cell_hide) {
            this.sI.S(getAdapterPosition());
        } else {
            this.sI.C(getAdapterPosition());
        }
        String str = TAG;
        Log.d(str, "onClick--> position = " + getAdapterPosition());
    }
}
