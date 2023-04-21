package com.picacomic.fregata.adapters;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import com.picacomic.fregata.R;
import com.picacomic.fregata.holders.AdvertisementListSimpleViewHolder;
import com.picacomic.fregata.holders.ComicPageSimpleViewHolder;
import com.picacomic.fregata.objects.ComicPageObject;
import com.picacomic.fregata.objects.databaseTable.DownloadComicPageObject;
import com.picacomic.fregata.utils.e;
import com.picacomic.fregata.utils.f;
import com.picacomic.fregata.utils.g;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.util.ArrayList;
/* compiled from: ComicPageListViewAdapter.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    public static final String TAG = "a";
    private final Context context;
    final String defaultUrl;
    private boolean hB;
    private boolean hC;
    private ArrayList<ComicPageObject> ja;
    int jr;
    Display ju;
    boolean jv;
    private final LayoutInflater mLayoutInflater;
    final int VIEW_TYPE_NORMAL = 0;
    final int jo = 1;
    final int jp = 2;
    int hP = 0;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public a(Context context, ArrayList<ComicPageObject> arrayList) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.ja = arrayList;
        this.ju = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.jr = (arrayList.size() / 20) + 1;
        this.jv = e.x(context);
        this.defaultUrl = g.af(e.al(context));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((i == 0 || (i + 1) % 21 != 0) && i != (this.ja.size() + this.jr) + (-1)) ? 0 : 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        this.jr = (this.ja.size() / 20) + 1;
        if (this.ja == null) {
            return 0;
        }
        return this.ja.size() + this.jr;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if ((i == 0 || (i + 1) % 21 != 0) && i != (this.ja.size() + this.jr) - 1) {
            return this.ja.get(i - (i / 21));
        }
        return null;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ComicPageSimpleViewHolder comicPageSimpleViewHolder;
        String b;
        AdvertisementListSimpleViewHolder advertisementListSimpleViewHolder;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 2) {
            if (view == null || !(view.getTag() instanceof AdvertisementListSimpleViewHolder)) {
                View inflate = this.mLayoutInflater.inflate(R.layout.item_advertisement_list_cell, viewGroup, false);
                AdvertisementListSimpleViewHolder advertisementListSimpleViewHolder2 = new AdvertisementListSimpleViewHolder(inflate);
                inflate.setTag(advertisementListSimpleViewHolder2);
                view = inflate;
                advertisementListSimpleViewHolder = advertisementListSimpleViewHolder2;
            } else {
                advertisementListSimpleViewHolder = (AdvertisementListSimpleViewHolder) view.getTag();
            }
            advertisementListSimpleViewHolder.webView_ads.loadUrl(this.defaultUrl);
        } else if (itemViewType == 0) {
            if (view == null || !(view.getTag() instanceof ComicPageSimpleViewHolder)) {
                view = this.mLayoutInflater.inflate(R.layout.item_comic_page_list_view_cell, viewGroup, false);
                comicPageSimpleViewHolder = new ComicPageSimpleViewHolder(view);
                view.setTag(comicPageSimpleViewHolder);
            } else {
                comicPageSimpleViewHolder = (ComicPageSimpleViewHolder) view.getTag();
            }
            int i2 = i - (i / 21);
            if (this.ja != null && this.ja.size() > i2) {
                if (this.ja.get(i2).getMedia() == null) {
                    comicPageSimpleViewHolder.textView_page.setText("" + this.ja.get(i2).getComicPageId());
                    comicPageSimpleViewHolder.imageView_image.setImageBitmap(null);
                } else {
                    DownloadComicPageObject az = com.picacomic.fregata.utils.b.az(this.ja.get(i2).getComicPageId());
                    if (az != null) {
                        File file = new File(az.getStorageFolder(), az.getEpisodeId() + "/" + az.getMediaPath());
                        if (file.exists() && file.canRead() && file.length() > 0) {
                            f.D(TAG, "Can read local image: " + file.getAbsolutePath());
                            b = "file:" + file;
                        } else {
                            b = g.b(this.ja.get(i2).getMedia());
                            f.D(TAG, "Cannot read local image: " + file.getAbsolutePath());
                        }
                    } else {
                        f.D(TAG, "Read local image: ");
                        b = g.b(this.ja.get(i2).getMedia());
                    }
                    if (this.jv) {
                        Picasso.with(this.context).load(b).placeholder(R.drawable.placeholder_transparent_low).into(comicPageSimpleViewHolder.imageView_image);
                    } else {
                        Picasso.with(this.context).load(b).placeholder(R.drawable.placeholder_transparent_low).into(comicPageSimpleViewHolder.imageView_image);
                    }
                    comicPageSimpleViewHolder.textView_page.setText("" + (i2 + 1 + this.hP));
                }
            }
        }
        return view;
    }

    public void q(boolean z) {
        this.hB = z;
    }

    public void r(boolean z) {
        this.hC = z;
    }

    public void y(int i) {
        this.hP = i;
    }
}
