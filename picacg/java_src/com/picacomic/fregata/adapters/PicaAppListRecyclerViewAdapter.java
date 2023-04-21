package com.picacomic.fregata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.holders.ChatroomListViewHolder;
import com.picacomic.fregata.objects.PicaAppObject;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PicaAppListRecyclerViewAdapter extends RecyclerView.Adapter<ChatroomListViewHolder> {
    public static final String TAG = "PicaAppListRecyclerViewAdapter";
    private final Context context;
    ArrayList<PicaAppObject> ja;
    private k jb;
    private final LayoutInflater mLayoutInflater;

    public PicaAppListRecyclerViewAdapter(Context context, ArrayList<PicaAppObject> arrayList, k kVar) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.ja = arrayList;
        this.jb = kVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ChatroomListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ChatroomListViewHolder(this.context, this.mLayoutInflater.inflate(R.layout.item_chatroom_list_cell, viewGroup, false), this.jb);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ChatroomListViewHolder chatroomListViewHolder, int i) {
        if (this.ja == null || this.ja.size() <= i) {
            return;
        }
        Picasso.with(this.context).load(this.ja.get(i).getIcon()).placeholder(R.drawable.placeholder_avatar_2).into(chatroomListViewHolder.imageView_image);
        TextView textView = chatroomListViewHolder.textView_title;
        textView.setText(this.ja.get(i).getTitle() + "");
        chatroomListViewHolder.textView_description.setText(R.string.title_pica_app);
        TextView textView2 = chatroomListViewHolder.textView_description;
        textView2.setText(this.ja.get(i).getDescription() + "");
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size();
    }
}
