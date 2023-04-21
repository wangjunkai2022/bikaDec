package com.picacomic.fregata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.c;
import com.picacomic.fregata.a.d;
import com.picacomic.fregata.activities.ComicViewerActivity;
import com.picacomic.fregata.adapters.ComicPageRecyclerViewAdapter;
import com.picacomic.fregata.objects.ComicPageObject;
import com.picacomic.fregata.utils.f;
import com.picacomic.fregata.utils.views.ZoomableRecyclerView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ComicViewFragment extends BaseFragment implements c {
    public static final String TAG = "ComicViewFragment";
    boolean hC;

    /* renamed from: if  reason: not valid java name */
    ArrayList<ComicPageObject> f3if;
    LinearLayoutManager jQ;
    d nV;
    ComicPageRecyclerViewAdapter nW;
    @BindView(R.id.recyclerView_comic_viewer)
    ZoomableRecyclerView recyclerView_comic_viewer;
    int nX = 0;
    boolean nY = false;
    int currentPage = 0;
    int hP = 0;
    @Deprecated
    int hF = 1;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_comic_view, viewGroup, false);
        if (getActivity() instanceof ComicViewerActivity) {
            this.nV = cX();
            a(inflate);
        }
        return inflate;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void init() {
        super.init();
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        this.currentPage = 0;
        this.f3if = new ArrayList<>();
        this.nW = new ComicPageRecyclerViewAdapter(getActivity(), this.f3if);
        this.jQ = new LinearLayoutManager(getActivity());
        this.recyclerView_comic_viewer.setLayoutManager(this.jQ);
        this.recyclerView_comic_viewer.setAdapter(this.nW);
        this.recyclerView_comic_viewer.setScreenWidth(defaultDisplay.getWidth());
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void ca() {
        super.ca();
        this.recyclerView_comic_viewer.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.picacomic.fregata.fragments.ComicViewFragment.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                    return;
                }
                ComicViewFragment.this.currentPage = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (!ComicViewFragment.this.nY && ComicViewFragment.this.currentPage != 0) {
                    ComicViewFragment.this.nY = true;
                }
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition() < 0) {
                    ComicViewFragment.this.currentPage = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                } else {
                    ComicViewFragment.this.currentPage = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                }
                ComicViewFragment.this.nV.r(ComicViewFragment.this.currentPage);
                String str = ComicViewFragment.TAG;
                f.D(str, "Current Page = " + ComicViewFragment.this.currentPage);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
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
        this.nW.notifyDataSetChanged();
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
            r4.cY()
            r0 = 0
            if (r8 == 0) goto L1a
            r4.nX = r0
            r4.nY = r0
            com.picacomic.fregata.utils.views.ZoomableRecyclerView r8 = r4.recyclerView_comic_viewer
            r8.scrollToPosition(r0)
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f3if
            r8.clear()
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f3if
            r8.addAll(r0, r5)
            goto L32
        L1a:
            int r8 = r4.hP
            if (r8 == r6) goto L27
            if (r7 != 0) goto L27
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f3if
            r8.addAll(r0, r5)
            r8 = 1
            goto L33
        L27:
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r8 = r4.f3if
            int r8 = r8.size()
            java.util.ArrayList<com.picacomic.fregata.objects.ComicPageObject> r1 = r4.f3if
            r1.addAll(r8, r5)
        L32:
            r8 = 0
        L33:
            r4.hP = r6
            com.picacomic.fregata.adapters.ComicPageRecyclerViewAdapter r1 = r4.nW
            int r2 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r2 = r6 / r2
            int r3 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r2 = r2 * r3
            r1.y(r2)
            com.picacomic.fregata.adapters.ComicPageRecyclerViewAdapter r1 = r4.nW
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
            com.picacomic.fregata.utils.views.ZoomableRecyclerView r5 = r4.recyclerView_comic_viewer
            int r7 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r7 = r6 / r7
            int r0 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            int r7 = r7 * r0
            int r6 = r6 - r7
            r5.scrollToPosition(r6)
        L7d:
            if (r8 == 0) goto L86
            com.picacomic.fregata.utils.views.ZoomableRecyclerView r5 = r4.recyclerView_comic_viewer
            int r6 = com.picacomic.fregata.activities.ComicViewerActivity.hq
            r5.scrollToPosition(r6)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.picacomic.fregata.fragments.ComicViewFragment.a(java.util.ArrayList, int, boolean, boolean):void");
    }

    @Override // com.picacomic.fregata.a.c
    public void b(int i, boolean z) {
        cY();
        this.recyclerView_comic_viewer.scrollToPosition(i);
        this.currentPage = i;
    }

    @Override // com.picacomic.fregata.a.c
    public void M(int i) {
        cY();
        if (i == 2) {
            this.nW.q(false);
        } else if (i == 1) {
            this.nW.q(true);
        }
        this.recyclerView_comic_viewer.setScreenWidth(((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getWidth());
        this.nW.notifyDataSetChanged();
        this.recyclerView_comic_viewer.invalidateItemDecorations();
    }

    @Override // com.picacomic.fregata.a.c
    public void B(boolean z) {
        cY();
        if (z) {
            this.jQ.setOrientation(1);
            this.recyclerView_comic_viewer.setVertical(true);
        } else {
            this.jQ.setOrientation(0);
            this.recyclerView_comic_viewer.setVertical(false);
        }
        this.hC = z;
        this.nW.r(z);
        this.nW.notifyDataSetChanged();
        this.recyclerView_comic_viewer.invalidateItemDecorations();
    }

    public void cY() {
        if (this.recyclerView_comic_viewer == null) {
        }
    }
}
