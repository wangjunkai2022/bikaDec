package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.h;
import com.picacomic.fregata.holders.NotificationViewHolder;
import com.picacomic.fregata.objects.NotificationObject;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NotificationRecyclerViewAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    public static final String TAG = "NotificationRecyclerViewAdapter";
    Context context;
    h jN;
    ArrayList<NotificationObject> ja;
    LayoutInflater jc;

    public NotificationRecyclerViewAdapter(Context context, ArrayList<NotificationObject> arrayList, h hVar) {
        this.context = context;
        this.jc = LayoutInflater.from(this.context);
        this.ja = arrayList;
        this.jN = hVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new NotificationViewHolder(this.context, this.jc.inflate(R.layout.item_notification_cell, viewGroup, false), this.jN);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(NotificationViewHolder notificationViewHolder, int i) {
        if (this.ja == null || this.ja.size() <= i) {
            return;
        }
        notificationViewHolder.a(this.ja.get(i));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size();
    }
}
