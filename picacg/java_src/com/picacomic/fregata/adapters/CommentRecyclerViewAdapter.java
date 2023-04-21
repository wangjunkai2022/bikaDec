package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.e;
import com.picacomic.fregata.holders.CommentProfileViewHolder;
import com.picacomic.fregata.holders.CommentReplyView;
import com.picacomic.fregata.holders.CommentTopReplacementViewHolder;
import com.picacomic.fregata.holders.CommentViewHolder;
import com.picacomic.fregata.objects.CommentObject;
import com.picacomic.fregata.objects.CommentWithReplyObject;
import com.picacomic.fregata.objects.UserBasicObject;
import com.picacomic.fregata.utils.g;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = "CommentRecyclerViewAdapter";
    private final Context context;
    private e jA;
    private int jD;
    private UserBasicObject jH;
    private ArrayList<CommentWithReplyObject> jz;
    private final LayoutInflater mLayoutInflater;
    private int jB = -1;
    private int jF = -1;
    private boolean jC = true;
    private boolean jG = false;
    private int jE = 0;

    public CommentRecyclerViewAdapter(Context context, UserBasicObject userBasicObject, String str, ArrayList<CommentWithReplyObject> arrayList, e eVar) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.jH = userBasicObject;
        this.jz = arrayList;
        this.jA = eVar;
        if (arrayList != null) {
            this.jD = arrayList.size();
        } else {
            this.jD = 1;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        switch (i) {
            case 1:
                return new CommentProfileViewHolder(this.mLayoutInflater.inflate(R.layout.item_comment_profile_recycler_view_cell, viewGroup, false), this.jA);
            case 2:
                return new CommentViewHolder(this.mLayoutInflater.inflate(R.layout.item_comment_top_recycler_view_cell, viewGroup, false), this.jA);
            case 3:
                return new CommentTopReplacementViewHolder(this.mLayoutInflater.inflate(R.layout.item_comment_top_replacement_recycler_view_cell, viewGroup, false), this.jA);
            default:
                return new CommentViewHolder(this.mLayoutInflater.inflate(R.layout.item_comment_recycler_view_cell, viewGroup, false), this.jA);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.jH == null) {
            if (this.jE > i) {
                return 2;
            }
            return (this.jz == null || this.jz.size() <= i || !this.jz.get(i).isTop()) ? 0 : 3;
        }
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof CommentProfileViewHolder) {
            CommentProfileViewHolder commentProfileViewHolder = (CommentProfileViewHolder) viewHolder;
            if (this.jz == null || this.jz.size() <= i) {
                return;
            }
            TextView textView = commentProfileViewHolder.textView_content;
            textView.setText(this.jz.get(i).getContent() + "");
            TextView textView2 = commentProfileViewHolder.textView_likeCount;
            textView2.setText(this.jz.get(i).getLikesCount() + "");
            TextView textView3 = commentProfileViewHolder.textView_replyCount;
            textView3.setText(this.jz.get(i).getChildsCount() + "");
            commentProfileViewHolder.textView_createdDate.setText(g.B(this.context, this.jz.get(i).getCreatedAt()));
            if (this.jH != null) {
                if (this.jH.getCharacter() != null && !this.jH.getCharacter().equalsIgnoreCase("")) {
                    commentProfileViewHolder.imageView_userVerified.setVisibility(0);
                    Picasso.with(this.context).load(this.jH.getCharacter()).into(commentProfileViewHolder.imageView_userVerified);
                } else {
                    commentProfileViewHolder.imageView_userVerified.setVisibility(8);
                }
                TextView textView4 = commentProfileViewHolder.textView_username;
                textView4.setText(this.jH.getName() + "");
                commentProfileViewHolder.textView_title.setText("");
                TextView textView5 = commentProfileViewHolder.textView_level;
                textView5.setText(this.jH.getLevel() + "");
                if (this.jz.get(i).getComicId() != null) {
                    TextView textView6 = commentProfileViewHolder.textView_viewContentPage;
                    textView6.setText(this.context.getResources().getString(R.string.comment_profile_view_content_prefix) + this.jz.get(i).getComicId().getTitle() + this.context.getResources().getString(R.string.comment_profile_view_content_suffix) + "");
                    commentProfileViewHolder.textView_noReply.setText(R.string.comment_profile_no_reply_comic);
                } else if (this.jz.get(i).getGameId() != null) {
                    TextView textView7 = commentProfileViewHolder.textView_viewContentPage;
                    textView7.setText(this.context.getResources().getString(R.string.comment_profile_view_content_prefix) + this.jz.get(i).getGameId().getTitle() + this.context.getResources().getString(R.string.comment_profile_view_content_suffix) + "");
                    commentProfileViewHolder.textView_noReply.setText(R.string.comment_profile_no_reply_game);
                }
                Picasso.with(this.context).load(g.b(this.jH.getAvatar())).into(commentProfileViewHolder.imageView_userThumb);
            }
            if (this.jz.get(i).isLiked()) {
                commentProfileViewHolder.imageView_likeIcon.setImageResource(R.drawable.icon_comment_liked);
            } else {
                commentProfileViewHolder.imageView_likeIcon.setImageResource(R.drawable.icon_comment_like);
            }
            TextView textView8 = commentProfileViewHolder.textView_floor;
            textView8.setText((this.jD - i) + "");
            commentProfileViewHolder.linearLayout_reply.removeAllViews();
            commentProfileViewHolder.button_viewMore.setVisibility(8);
            commentProfileViewHolder.textView_noReply.setVisibility(8);
            if (this.jG && !this.jz.get(i).isHide()) {
                commentProfileViewHolder.button_hide.setVisibility(0);
            } else {
                commentProfileViewHolder.button_hide.setVisibility(8);
            }
            if (i == this.jB) {
                if (this.jz.get(i).getChildsCount() == 0) {
                    commentProfileViewHolder.textView_noReply.setVisibility(0);
                }
                if (this.jC) {
                    commentProfileViewHolder.button_viewMore.setVisibility(0);
                }
                if (this.jz.get(i).getArrayList() != null) {
                    for (int i2 = 0; i2 < this.jz.get(i).getArrayList().size(); i2++) {
                        CommentReplyView commentReplyView = new CommentReplyView(this.context, this.jA, i, i2);
                        TextView textView9 = commentReplyView.textView_username;
                        textView9.setText(this.jz.get(i).getArrayList().get(i2).getUser().getName() + "");
                        TextView textView10 = commentReplyView.textView_title;
                        textView10.setText(this.jz.get(i).getArrayList().get(i2).getUser().getTitle() + "");
                        TextView textView11 = commentReplyView.textView_content;
                        textView11.setText(this.jz.get(i).getArrayList().get(i2).getContent() + "");
                        TextView textView12 = commentReplyView.textView_floor;
                        textView12.setText((this.jz.get(i).getChildsCount() - i2) + "");
                        TextView textView13 = commentReplyView.textView_level;
                        textView13.setText(this.jz.get(i).getArrayList().get(i2).getUser().getLevel() + "");
                        TextView textView14 = commentReplyView.textView_likeCount;
                        textView14.setText(this.jz.get(i).getArrayList().get(i2).getLikesCount() + "");
                        commentReplyView.textView_createdDate.setText(g.B(this.context, this.jz.get(i).getArrayList().get(i2).getCreatedAt()));
                        if (this.jz.get(i).getArrayList().get(i2).getUser().getCharacter() != null && !this.jz.get(i).getArrayList().get(i2).getUser().getCharacter().equalsIgnoreCase("")) {
                            commentReplyView.imageView_userVerified.setVisibility(0);
                            Picasso.with(this.context).load(this.jz.get(i).getArrayList().get(i2).getUser().getCharacter()).into(commentReplyView.imageView_userVerified);
                        } else {
                            commentReplyView.imageView_userVerified.setVisibility(8);
                        }
                        if (this.jz.get(i).getArrayList().get(i2).isLiked()) {
                            commentReplyView.imageView_likeIcon.setImageResource(R.drawable.icon_comment_liked);
                        } else {
                            commentReplyView.imageView_likeIcon.setImageResource(R.drawable.icon_comment_like);
                        }
                        if (this.jG && !this.jz.get(i).getArrayList().get(i2).isHide()) {
                            commentReplyView.button_hide.setVisibility(0);
                        } else {
                            commentReplyView.button_hide.setVisibility(8);
                        }
                        Picasso.with(this.context).load(g.b(this.jz.get(i).getArrayList().get(i2).getUser().getAvatar())).into(commentReplyView.imageView_userThumb);
                        commentProfileViewHolder.linearLayout_reply.addView(commentReplyView);
                    }
                }
            }
        } else if (viewHolder instanceof CommentViewHolder) {
            CommentViewHolder commentViewHolder = (CommentViewHolder) viewHolder;
            if (this.jz == null || this.jz.size() <= i) {
                return;
            }
            TextView textView15 = commentViewHolder.textView_content;
            textView15.setText(this.jz.get(i).getContent() + "");
            TextView textView16 = commentViewHolder.textView_likeCount;
            textView16.setText(this.jz.get(i).getLikesCount() + "");
            TextView textView17 = commentViewHolder.textView_replyCount;
            textView17.setText(this.jz.get(i).getChildsCount() + "");
            commentViewHolder.textView_createdDate.setText(g.B(this.context, this.jz.get(i).getCreatedAt()));
            if (this.jz.get(i).getUser() != null) {
                if (this.jz.get(i).getUser().getCharacter() != null && !this.jz.get(i).getUser().getCharacter().equalsIgnoreCase("")) {
                    commentViewHolder.imageView_userVerified.setVisibility(0);
                    Picasso.with(this.context).load(this.jz.get(i).getUser().getCharacter()).into(commentViewHolder.imageView_userVerified);
                } else {
                    commentViewHolder.imageView_userVerified.setVisibility(8);
                }
                TextView textView18 = commentViewHolder.textView_username;
                textView18.setText(this.jz.get(i).getUser().getName() + "");
                TextView textView19 = commentViewHolder.textView_title;
                textView19.setText(this.jz.get(i).getUser().getTitle() + "");
                TextView textView20 = commentViewHolder.textView_level;
                textView20.setText(this.jz.get(i).getUser().getLevel() + "");
                Picasso.with(this.context).load(g.b(this.jz.get(i).getUser().getAvatar())).into(commentViewHolder.imageView_userThumb);
            }
            if (this.jz.get(i).isLiked()) {
                commentViewHolder.imageView_likeIcon.setImageResource(R.drawable.icon_comment_liked);
            } else {
                commentViewHolder.imageView_likeIcon.setImageResource(R.drawable.icon_comment_like);
            }
            TextView textView21 = commentViewHolder.textView_floor;
            textView21.setText((this.jD - i) + "");
            commentViewHolder.linearLayout_reply.removeAllViews();
            commentViewHolder.button_viewMore.setVisibility(8);
            commentViewHolder.textView_noReply.setVisibility(8);
            if (this.jG) {
                commentViewHolder.button_tools.setVisibility(0);
                if (i == this.jF) {
                    commentViewHolder.linearLayout_tools.setVisibility(0);
                    if (this.jG && !this.jz.get(i).isHide()) {
                        commentViewHolder.button_hide.setVisibility(0);
                    } else {
                        commentViewHolder.button_hide.setVisibility(4);
                    }
                } else {
                    commentViewHolder.linearLayout_tools.setVisibility(8);
                }
            }
            if (i == this.jB) {
                if (this.jz.get(i).getChildsCount() == 0) {
                    commentViewHolder.textView_noReply.setVisibility(0);
                }
                if (this.jC) {
                    commentViewHolder.button_viewMore.setVisibility(0);
                }
                if (this.jz.get(i).getArrayList() != null) {
                    for (int i3 = 0; i3 < this.jz.get(i).getArrayList().size(); i3++) {
                        CommentReplyView commentReplyView2 = new CommentReplyView(this.context, this.jA, i, i3);
                        TextView textView22 = commentReplyView2.textView_username;
                        textView22.setText(this.jz.get(i).getArrayList().get(i3).getUser().getName() + "");
                        TextView textView23 = commentReplyView2.textView_title;
                        textView23.setText(this.jz.get(i).getArrayList().get(i3).getUser().getTitle() + "");
                        TextView textView24 = commentReplyView2.textView_content;
                        textView24.setText(this.jz.get(i).getArrayList().get(i3).getContent() + "");
                        TextView textView25 = commentReplyView2.textView_floor;
                        textView25.setText((this.jz.get(i).getChildsCount() - i3) + "");
                        TextView textView26 = commentReplyView2.textView_level;
                        textView26.setText(this.jz.get(i).getArrayList().get(i3).getUser().getLevel() + "");
                        TextView textView27 = commentReplyView2.textView_likeCount;
                        textView27.setText(this.jz.get(i).getArrayList().get(i3).getLikesCount() + "");
                        commentReplyView2.textView_createdDate.setText(g.B(this.context, this.jz.get(i).getArrayList().get(i3).getCreatedAt()));
                        if (this.jz.get(i).getArrayList().get(i3).getUser().getCharacter() != null && !this.jz.get(i).getArrayList().get(i3).getUser().getCharacter().equalsIgnoreCase("")) {
                            commentReplyView2.imageView_userVerified.setVisibility(0);
                            Picasso.with(this.context).load(this.jz.get(i).getArrayList().get(i3).getUser().getCharacter()).into(commentReplyView2.imageView_userVerified);
                        } else {
                            commentReplyView2.imageView_userVerified.setVisibility(8);
                        }
                        if (this.jz.get(i).getArrayList().get(i3).isLiked()) {
                            commentReplyView2.imageView_likeIcon.setImageResource(R.drawable.icon_comment_liked);
                        } else {
                            commentReplyView2.imageView_likeIcon.setImageResource(R.drawable.icon_comment_like);
                        }
                        if (this.jG && !this.jz.get(i).getArrayList().get(i3).isHide()) {
                            commentReplyView2.button_hide.setVisibility(0);
                        } else {
                            commentReplyView2.button_hide.setVisibility(8);
                        }
                        Picasso.with(this.context).load(g.b(this.jz.get(i).getArrayList().get(i3).getUser().getAvatar())).into(commentReplyView2.imageView_userThumb);
                        commentViewHolder.linearLayout_reply.addView(commentReplyView2);
                    }
                }
            }
        } else {
            CommentTopReplacementViewHolder commentTopReplacementViewHolder = (CommentTopReplacementViewHolder) viewHolder;
            if (this.jz == null || this.jz.size() <= i) {
                return;
            }
            TextView textView28 = commentTopReplacementViewHolder.textView_floor;
            textView28.setText((this.jD - i) + "");
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jz == null) {
            return 0;
        }
        return this.jz.size();
    }

    public void a(int i, ArrayList<CommentObject> arrayList, boolean z) {
        this.jC = z;
        int i2 = this.jB;
        this.jB = i;
        if (i2 != -1) {
            notifyItemChanged(i2);
        }
        notifyItemChanged(this.jB);
    }

    public void z(int i) {
        this.jD = i;
    }

    public void A(int i) {
        if (this.jz == null || this.jz.size() <= i) {
            return;
        }
        this.jF = i;
        notifyItemChanged(i);
    }

    public void B(int i) {
        this.jE = i;
    }
}
