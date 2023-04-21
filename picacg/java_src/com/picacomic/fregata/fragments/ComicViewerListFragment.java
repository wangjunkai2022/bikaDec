package com.picacomic.fregata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.c;
import com.picacomic.fregata.a.d;
import com.picacomic.fregata.activities.ComicViewerActivity;
import com.picacomic.fregata.adapters.a;
import com.picacomic.fregata.objects.ComicPageObject;
import com.picacomic.fregata.utils.f;
import com.picacomic.fregata.utils.views.ZoomableListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ComicViewerListFragment extends BaseFragment implements c {
    public static final String TAG = "ComicViewerListFragment";
    boolean hC;

    /* renamed from: if  reason: not valid java name */
    ArrayList<ComicPageObject> f4if;
    LinearLayoutManager jQ;
    @BindView(R.id.listView_comic_viewer)
    ZoomableListView listView_comic_viewer;
    d nV;
    a ob;
    int nX = 0;
    boolean nY = false;
    int currentPage = 0;
    int hP = 0;
    @Deprecated
    int hF = 1;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_comic_viewer_list, viewGroup, false);
        if (getActivity() instanceof ComicViewerActivity) {
            this.nV = cX();
            a(inflate);
        }
        return inflate;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void init() {
        super.init();
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        this.currentPage = 0;
        this.f4if = new ArrayList<>();
        this.ob = new a(getActivity(), this.f4if);
        this.jQ = new LinearLayoutManager(getActivity());
        this.listView_comic_viewer.setAdapter((ListAdapter) this.ob);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void ca() {
        super.ca();
        this.listView_comic_viewer.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.picacomic.fregata.fragments.ComicViewerListFragment.1
            int oc;
            int od;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    da();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.oc = i;
                this.od = i2;
            }

            public void da() {
                ComicViewerListFragment.this.currentPage = this.oc;
                if (!ComicViewerListFragment.this.nY && ComicViewerListFragment.this.currentPage != 0) {
                    ComicViewerListFragment.this.nY = true;
                }
                if (this.oc != 0 && this.od > 1) {
                    ComicViewerListFragment.this.currentPage = (this.oc + this.od) - 1;
                }
                ComicViewerListFragment.this.nV.r(ComicViewerListFragment.this.currentPage);
                String str = ComicViewerListFragment.TAG;
                f.D(str, "Current Page = " + ComicViewerListFragment.this.currentPage);
            }
        });
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
        if (isAdded() && (getActivity() instanceof ComicViewerActivity)) {
            cX().bL();
            cX().bH();
        }
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
        this.ob.notifyDataSetChanged();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComicViewerActivity) {
            ((ComicViewerActivity) context).a((c) this);
        }
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        if (getActivity() instanceof ComicViewerActivity) {
            ((ComicViewerActivity) getActivity()).a((c) null);
        }
        super.onDetach();
    }

    public ComicViewerActivity cX() {
        if (isAdded() && (getActivity() instanceof ComicViewerActivity)) {
            return (ComicViewerActivity) getActivity();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d A[LOOP:0: B:12:0x0047->B:14:0x004d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.picacomic.fregata.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r5, int r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            r4.cZ()
            r0 = 0
            r4.nY = r0
            if (r8 == 0) goto L1a
            r4.nX = r0
            com.picacomic.fregata.utils.views.ZoomableListView r8 = r4.listView_comic_viewer
            r8.smoothScrollToPosition(r0)
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f4if
            r8.clear()
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f4if
            r8.addAll(r0, r5)
            goto L32
        L1a:
            int r8 = r4.hP
            if (r8 == r6) goto L27
            if (r7 != 0) goto L27
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f4if
            r8.addAll(r0, r5)
            r8 = 1
            goto L33
        L27:
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f4if
            int r8 = r8.size()
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r1 = r4.f4if
            r1.addAll(r8, r5)
        L32:
            r8 = 0
        L33:
            r4.hP = r6
            com.picacomic.fregata.adapters.a r1 = r4.ob
            int r2 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r2 = r6 / r2
            int r3 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r2 = r2 * r3
            r1.y(r2)
            com.picacomic.fregata.adapters.a r1 = r4.ob
            r1.notifyDataSetChanged()
        L47:
            int r1 = r5.size()
            if (r0 >= r1) goto L6d
            android.content.Context r1 = r4.getContext()
            com.squareup.picasso.Picasso r1 = com.squareup.picasso.Picasso.with(r1)
            java.lang.Object r2 = r5.get(r0)
            com.picacomic.fregata.objects.ComicPageObject r2 = (com.picacomic.fregata.objects.ComicPageObject) r2
            com.picacomic.fregata.objects.ThumbnailObject r2 = r2.getMedia()
            java.lang.String r2 = com.picacomic.fregata.utils.g.b(r2)
            com.squareup.picasso.RequestCreator r1 = r1.load(r2)
            r1.fetch()
            int r0 = r0 + 1
            goto L47
        L6d:
            if (r7 == 0) goto L7d
            com.picacomic.fregata.utils.views.ZoomableListView r5 = r4.listView_comic_viewer
            int r7 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r7 = r6 / r7
            int r0 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r7 = r7 * r0
            int r6 = r6 - r7
            r5.setSelection(r6)
        L7d:
            if (r8 == 0) goto L86
            com.picacomic.fregata.utils.views.ZoomableListView r5 = r4.listView_comic_viewer
            int r6 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            r5.setSelection(r6)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.picacomic.fregata.fragments.ComicViewerListFragment.a(java.util.ArrayList, int, boolean, boolean):void");
    }

    @Override // com.picacomic.fregata.a.c
    public void b(int i, boolean z) {
        cZ();
        this.listView_comic_viewer.setSelection(i);
        this.currentPage = i;
    }

    @Override // com.picacomic.fregata.a.c
    public void M(int i) {
        cZ();
        if (i == 2) {
            this.ob.q(false);
        } else if (i == 1) {
            this.ob.q(true);
        }
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        this.ob.notifyDataSetChanged();
    }

    @Override // com.picacomic.fregata.a.c
    public void B(boolean z) {
        cZ();
        if (z) {
            this.jQ.setOrientation(1);
        } else {
            this.jQ.setOrientation(0);
        }
        this.hC = z;
        this.ob.r(z);
        this.ob.notifyDataSetChanged();
    }

    public void cZ() {
        if (this.listView_comic_viewer == null) {
        }
    }
}
