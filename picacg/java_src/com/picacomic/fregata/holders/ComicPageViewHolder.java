package com.picacomic.fregata.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class ComicPageViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.frameLayout_comic_page_recycler_view_cell_container)
    public FrameLayout frameLayout_container;
    @BindView(R.id.imageView_comic_page_recycler_view_cell_image)
    public ImageView imageView_image;
    @BindView(R.id.textView_comic_page_recycler_view_cell_page)
    public TextView textView_page;

    public ComicPageViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
