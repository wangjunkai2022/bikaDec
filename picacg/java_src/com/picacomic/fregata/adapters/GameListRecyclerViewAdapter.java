package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.holders.GameListViewHolder;
import com.picacomic.fregata.objects.GameListObject;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GameListRecyclerViewAdapter extends RecyclerView.Adapter<GameListViewHolder> {
    public static final String TAG = "GameListRecyclerViewAdapter";
    private final Context context;
    ArrayList<GameListObject> ja;
    private k jb;
    private final LayoutInflater mLayoutInflater;

    public GameListRecyclerViewAdapter(Context context, ArrayList<GameListObject> arrayList, k kVar) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.ja = arrayList;
        this.jb = kVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: g */
    public GameListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GameListViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_game_recycler_view_cell, viewGroup, false), this.jb);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(GameListViewHolder gameListViewHolder, int i) {
        if (this.ja == null || this.ja.size() <= i) {
            return;
        }
        gameListViewHolder.a(this.ja.get(i));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size();
    }
}
