package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.holders.LeaderboardKnightViewHolder;
import com.picacomic.fregata.objects.LeaderboardKnightObject;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LeaderboardKnightRecyclerViewAdapter extends RecyclerView.Adapter<LeaderboardKnightViewHolder> {
    private final Context context;
    private ArrayList<LeaderboardKnightObject> ja;
    private k jb;
    private final LayoutInflater mLayoutInflater;

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 2 ? 3 : 0;
    }

    public LeaderboardKnightRecyclerViewAdapter(Context context, ArrayList<LeaderboardKnightObject> arrayList, k kVar) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.ja = arrayList;
        this.jb = kVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: i */
    public LeaderboardKnightViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new LeaderboardKnightViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_leaderboard_knight_1st_recycler_view_cell, viewGroup, false), this.jb);
            case 2:
                return new LeaderboardKnightViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_leaderboard_knight_2nd_recycler_view_cell, viewGroup, false), this.jb);
            case 3:
                return new LeaderboardKnightViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_leaderboard_knight_3rd_recycler_view_cell, viewGroup, false), this.jb);
            default:
                return new LeaderboardKnightViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_leaderboard_knight_order_recycler_view_cell, viewGroup, false), this.jb);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(LeaderboardKnightViewHolder leaderboardKnightViewHolder, int i) {
        if (this.ja == null || this.ja.size() <= i) {
            return;
        }
        leaderboardKnightViewHolder.a(this.ja.get(i), i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size();
    }
}
