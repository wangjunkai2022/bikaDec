package com.picacomic.fregata.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.objects.ComicEpisodeObject;
/* loaded from: classes.dex */
public class EpisodeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final String TAG = "EpisodeViewHolder";
    @BindView(R.id.button_episode_recycler_view_cell_episode_title)
    public Button button_epsiodeTitle;
    Context context;
    k je;

    public EpisodeViewHolder(Context context, View view, k kVar) {
        super(view);
        ButterKnife.bind(this, view);
        this.context = context;
        this.je = kVar;
        this.button_epsiodeTitle.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.je.C(getAdapterPosition());
        String str = TAG;
        Log.d(str, "onClick--> position = " + getAdapterPosition());
    }

    public void a(ComicEpisodeObject comicEpisodeObject) {
        this.button_epsiodeTitle.setText(comicEpisodeObject.getTitle());
    }
}
