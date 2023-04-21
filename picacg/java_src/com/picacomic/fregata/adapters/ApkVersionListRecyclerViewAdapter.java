package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.holders.ApkVersionListViewHolder;
import com.picacomic.fregata.objects.LatestApplicationObject;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ApkVersionListRecyclerViewAdapter extends RecyclerView.Adapter<ApkVersionListViewHolder> {
    public static final String TAG = "ApkVersionListRecyclerViewAdapter";
    private final Context context;
    private ArrayList<LatestApplicationObject> ja;
    private k jb;
    private final LayoutInflater mLayoutInflater;

    public ApkVersionListRecyclerViewAdapter(Context context, ArrayList<LatestApplicationObject> arrayList, k kVar) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.jb = kVar;
        this.ja = arrayList;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public ApkVersionListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ApkVersionListViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_apk_version_list_recycler_view_cell, viewGroup, false), this.jb);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ApkVersionListViewHolder apkVersionListViewHolder, int i) {
        if (this.ja == null || this.ja.size() <= i) {
            return;
        }
        apkVersionListViewHolder.a(this.ja.get(i));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size();
    }
}
