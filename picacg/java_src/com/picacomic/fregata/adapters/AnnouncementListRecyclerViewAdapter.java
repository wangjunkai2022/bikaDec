package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.holders.AnnouncementViewHolder;
import com.picacomic.fregata.objects.AnnouncementObject;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AnnouncementListRecyclerViewAdapter extends RecyclerView.Adapter<AnnouncementViewHolder> {
    public static final String TAG = "AnnouncementListRecyclerViewAdapter";
    private final Context context;
    private ArrayList<AnnouncementObject> ja;
    private k jb;
    private final LayoutInflater mLayoutInflater;

    public AnnouncementListRecyclerViewAdapter(Context context, ArrayList<AnnouncementObject> arrayList, k kVar) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.jb = kVar;
        this.ja = arrayList;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public AnnouncementViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AnnouncementViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_announcement_cell, viewGroup, false), this.jb);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(AnnouncementViewHolder announcementViewHolder, int i) {
        if (this.ja == null || this.ja.size() <= i) {
            return;
        }
        announcementViewHolder.a(this.ja.get(i));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size();
    }
}
