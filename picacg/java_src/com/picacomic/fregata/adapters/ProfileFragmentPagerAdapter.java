package com.picacomic.fregata.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.picacomic.fregata.fragments.CommentFragment;
import com.picacomic.fregata.fragments.ProfileComicFragment;
import com.picacomic.fregata.objects.UserBasicObject;
/* loaded from: classes.dex */
public class ProfileFragmentPagerAdapter extends FragmentPagerAdapter {
    UserBasicObject jH;

    public ProfileFragmentPagerAdapter(FragmentManager fragmentManager, UserBasicObject userBasicObject) {
        super(fragmentManager);
        this.jH = userBasicObject;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ProfileComicFragment();
            case 1:
                return CommentFragment.a("575e28eafec093bf19360331", this.jH);
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.jH == null ? 1 : 2;
    }
}
