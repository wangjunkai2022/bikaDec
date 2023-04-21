package com.picacomic.fregata.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.objects.LeaderboardComicListObject;
import com.picacomic.fregata.utils.g;
import com.squareup.picasso.Picasso;
/* loaded from: classes.dex */
public class LeaderboardPopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final String TAG = "LeaderboardPopularViewHolder";
    Context context;
    @BindView(R.id.imageView_leaderboard_popular_order_recycler_view_cell_image)
    public ImageView imageView_image;
    @BindView(R.id.imageView_leaderboard_popular_order_recycler_view_cell_order)
    public ImageView imageView_order;
    k je;
    @BindView(R.id.textView_leaderboard_popular_order_recycler_view_cell_author)
    public TextView textView_author;
    @BindView(R.id.textView_leaderboard_popular_order_recycler_view_cell_category)
    public TextView textView_category;
    @BindView(R.id.textView_leaderboard_popular_order_recycler_view_cell_name)
    public TextView textView_name;
    @BindView(R.id.textView_leaderboard_popular_order_recycler_view_cell_order)
    public TextView textView_order;
    @BindView(R.id.textView_leaderboard_popular_order_recycler_view_cell_view_count)
    public TextView textView_viewCount;
    @BindView(R.id.textView_leaderboard_popular_order_recycler_view_cell_view_count_title)
    public TextView textView_viewCountTitle;

    public LeaderboardPopularViewHolder(Context context, View view, k kVar) {
        super(view);
        ButterKnife.bind(this, view);
        this.context = context;
        this.je = kVar;
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.je.C(getAdapterPosition());
        String str = TAG;
        Log.d(str, "onClick--> position = " + getAdapterPosition());
    }

    public void a(LeaderboardComicListObject leaderboardComicListObject, int i, String str) {
        TextView textView = this.textView_order;
        textView.setText((i + 1) + "");
        Picasso.with(this.context).load(g.b(leaderboardComicListObject.getThumb())).into(this.imageView_image);
        TextView textView2 = this.textView_name;
        textView2.setText(leaderboardComicListObject.getTitle() + "");
        TextView textView3 = this.textView_author;
        textView3.setText(leaderboardComicListObject.getAuthor() + "");
        this.textView_category.setText(leaderboardComicListObject.getCategories().toString());
        if (str != null && str.equals("D7")) {
            this.textView_viewCountTitle.setText(R.string.leaderboard_view_count_title_7days);
        } else if (str != null && str.equals("D30")) {
            this.textView_viewCountTitle.setText(R.string.leaderboard_view_count_title_30days);
        } else {
            this.textView_viewCountTitle.setText(R.string.leaderboard_view_count_title_24hr);
        }
        TextView textView4 = this.textView_viewCount;
        textView4.setText(leaderboardComicListObject.getLeaderboardCount() + "");
    }
}
