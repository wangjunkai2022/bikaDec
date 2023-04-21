package com.picacomic.fregata.fragments;

import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.b.d;
import com.picacomic.fregata.c.c;
import com.picacomic.fregata.holders.ComicCollectionView;
import com.picacomic.fregata.objects.ComicListObject;
import com.picacomic.fregata.objects.databaseTable.DbComicDetailObject;
import com.picacomic.fregata.objects.databaseTable.DbComicViewRecordObject;
import com.picacomic.fregata.objects.responses.DataClass.ComicListResponse.ComicListResponse;
import com.picacomic.fregata.objects.responses.GeneralResponse;
import com.picacomic.fregata.utils.e;
import com.picacomic.fregata.utils.f;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/* loaded from: classes.dex */
public class ProfileComicFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "ProfileComicFragment";
    @BindView(R.id.linearLayout_profile_comic_bookmarked)
    LinearLayout linearLayout_bookmarked;
    @BindView(R.id.linearLayout_profile_comic_downloaded)
    LinearLayout linearLayout_downloaded;
    @BindView(R.id.linearLayout_profile_comic_recent_view)
    LinearLayout linearLayout_recentView;
    Call<GeneralResponse<ComicListResponse>> qF;
    ArrayList<ComicListObject> qG;
    int qH;
    ArrayList<ComicListObject> qI;
    long qJ;
    ArrayList<ComicListObject> qK;
    long qL;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile_comic, viewGroup, false);
        a(inflate);
        return inflate;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void init() {
        super.init();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void ca() {
        super.ca();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
        if (this.qG != null) {
            bI();
        } else {
            dz();
        }
        if (this.qI != null) {
            dw();
        } else {
            dv();
        }
        if (this.qK != null) {
            dy();
        } else {
            dx();
        }
    }

    public void dv() {
        List findWithQuery = DbComicViewRecordObject.findWithQuery(DbComicViewRecordObject.class, "SELECT * FROM db_comic_view_record_object WHERE last_view_timestamp > 0 ORDER BY last_view_timestamp DESC LIMIT 4", new String[0]);
        if (findWithQuery != null) {
            this.qI = new ArrayList<>();
            for (int i = 0; i < findWithQuery.size(); i++) {
                List find = DbComicDetailObject.find(DbComicDetailObject.class, "comic_id = ?", ((DbComicViewRecordObject) findWithQuery.get(i)).getComicId());
                if (find != null && find.size() > 0) {
                    this.qI.add(new ComicListObject((DbComicDetailObject) find.get(0)));
                    String str = TAG;
                    f.D(str, "recent View " + i + " = " + ((DbComicViewRecordObject) findWithQuery.get(i)).toString());
                }
            }
            this.qJ = DbComicViewRecordObject.count(DbComicViewRecordObject.class);
            dw();
        }
    }

    public void dw() {
        if (this.qI != null) {
            try {
                ComicCollectionView comicCollectionView = new ComicCollectionView(getActivity(), this.qI, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, this, new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.ProfileComicFragment.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ProfileComicFragment.this.getParentFragment() != null) {
                            ProfileComicFragment.this.getParentFragment().getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, ComicListFragment.a("CATEGORY_RECENT_VIEW", null, null, null, null, null, null, null, null), ComicListFragment.TAG).addToBackStack(ComicListFragment.TAG).commit();
                        }
                    }
                });
                TextView textView_count = comicCollectionView.getTextView_count();
                textView_count.setText(this.qJ + "");
                comicCollectionView.getTextView_title().setText(R.string.recent_view);
                this.linearLayout_recentView.addView(comicCollectionView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dx() {
        List findWithQuery = DbComicDetailObject.findWithQuery(DbComicDetailObject.class, "SELECT * FROM db_comic_detail_object WHERE download_status > 0 ORDER BY downloaded_at DESC LIMIT 4 ", new String[0]);
        if (findWithQuery != null) {
            this.qK = new ArrayList<>();
            for (int i = 0; i < findWithQuery.size(); i++) {
                this.qK.add(new ComicListObject((DbComicDetailObject) findWithQuery.get(i)));
            }
            this.qL = DbComicDetailObject.count(DbComicDetailObject.class, "download_status > 0", null);
            dy();
        }
    }

    public void dy() {
        if (this.qK != null) {
            try {
                ComicCollectionView comicCollectionView = new ComicCollectionView(getActivity(), this.qK, 300, this, new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.ProfileComicFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ProfileComicFragment.this.getParentFragment() != null) {
                            ProfileComicFragment.this.getParentFragment().getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, ComicListFragment.a("CATEGORY_DOWNLOADED", null, null, null, null, null, null, null, null), ComicListFragment.TAG).addToBackStack(ComicListFragment.TAG).commit();
                        }
                    }
                });
                TextView textView_count = comicCollectionView.getTextView_count();
                textView_count.setText(this.qL + "");
                comicCollectionView.getTextView_title().setText(R.string.downloaded);
                this.linearLayout_downloaded.addView(comicCollectionView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
        if (this.qG != null) {
            try {
                ComicCollectionView comicCollectionView = new ComicCollectionView(getActivity(), this.qG, 100, this, new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.ProfileComicFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ProfileComicFragment.this.getParentFragment() != null) {
                            ProfileComicFragment.this.getParentFragment().getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, ComicListFragment.a("CATEGORY_USER_FAVOURITE", null, null, null, null, null, null, null, null), ComicListFragment.TAG).addToBackStack(ComicListFragment.TAG).commit();
                        }
                    }
                });
                TextView textView_count = comicCollectionView.getTextView_count();
                textView_count.setText(this.qH + "");
                comicCollectionView.getTextView_title().setText(R.string.bookmarked);
                this.linearLayout_bookmarked.addView(comicCollectionView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dz() {
        C(getResources().getString(R.string.loading_general));
        f.aA("Show Progress");
        this.qF = new d(getContext()).dO().a(e.z(getActivity()), c.uQ[0], 1);
        this.qF.enqueue(new Callback<GeneralResponse<ComicListResponse>>() { // from class: com.picacomic.fregata.fragments.ProfileComicFragment.4
            @Override // retrofit2.Callback
            public void onResponse(Call<GeneralResponse<ComicListResponse>> call, Response<GeneralResponse<ComicListResponse>> response) {
                if (response.code() == 200) {
                    if (response.body() != null && response.body().data != null && response.body().data.getComics() != null && ProfileComicFragment.this.qG == null) {
                        ProfileComicFragment.this.qG = new ArrayList<>();
                        ProfileComicFragment.this.qG.addAll(0, response.body().data.getComics().getDocs());
                        ProfileComicFragment.this.qH = response.body().data.getComics().getTotal();
                        ProfileComicFragment.this.bI();
                    }
                } else {
                    try {
                        new com.picacomic.fregata.b.c(ProfileComicFragment.this.getActivity(), response.code(), response.errorBody().string()).dN();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                f.aA("dismiss progress");
                ProfileComicFragment.this.bC();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<GeneralResponse<ComicListResponse>> call, Throwable th) {
                th.printStackTrace();
                f.aA("dismiss progress");
                ProfileComicFragment.this.bC();
                new com.picacomic.fregata.b.c(ProfileComicFragment.this.getActivity()).dN();
            }
        });
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        if (this.qF != null) {
            this.qF.cancel();
        }
        super.onDetach();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = TAG;
        f.D(str, "CLICK TAG = " + view.getTag());
        if (((Integer) view.getTag()).intValue() / 300 == 1) {
            if (getParentFragment() != null) {
                getParentFragment().getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, ComicDetailFragment.a(new ComicListObject(this.qK.get(((Integer) view.getTag()).intValue() % 300).getComicId() + "")), ComicDetailFragment.TAG).addToBackStack(ComicListFragment.TAG).commit();
            }
        } else if (((Integer) view.getTag()).intValue() / ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION == 1) {
            if (getParentFragment() != null) {
                getParentFragment().getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, ComicDetailFragment.a(new ComicListObject(this.qI.get(((Integer) view.getTag()).intValue() % ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION).getComicId() + "")), ComicDetailFragment.TAG).addToBackStack(ComicListFragment.TAG).commit();
            }
        } else if (((Integer) view.getTag()).intValue() / 100 != 1 || getParentFragment() == null) {
        } else {
            getParentFragment().getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, ComicDetailFragment.a(new ComicListObject(this.qG.get(((Integer) view.getTag()).intValue() % 100).getComicId() + "")), ComicDetailFragment.TAG).addToBackStack(ComicListFragment.TAG).commit();
        }
    }
}
