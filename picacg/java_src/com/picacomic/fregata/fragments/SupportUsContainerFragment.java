package com.picacomic.fregata.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.activities.MainActivity;
import com.picacomic.fregata.adapters.SupportUsFragmentPagerAdapter;
import com.picacomic.fregata.utils.views.AlertDialogCenter;
/* loaded from: classes.dex */
public class SupportUsContainerFragment extends BaseFragment {
    public static final String TAG = "SupportUsContainerFragment";
    SupportUsFragmentPagerAdapter rO;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager_support_us)
    ViewPager viewPager_tags;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_support_us_container, viewGroup, false);
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
        this.rO = new SupportUsFragmentPagerAdapter(getChildFragmentManager());
        this.viewPager_tags.setAdapter(this.rO);
        this.tabLayout.setupWithViewPager(this.viewPager_tags);
        TabLayout.Tab tabAt = this.tabLayout.getTabAt(0);
        this.tabLayout.getTabAt(0).setText(R.string.support_us_tab_qq);
        tabAt.setText(R.string.support_us_tab_qq);
        TabLayout.Tab tabAt2 = this.tabLayout.getTabAt(1);
        this.tabLayout.getTabAt(1).setText(R.string.support_us_tab_group);
        tabAt2.setText(R.string.support_us_tab_group);
        TabLayout.Tab tabAt3 = this.tabLayout.getTabAt(2);
        this.tabLayout.getTabAt(2).setText(R.string.support_us_tab_ads);
        tabAt3.setText(R.string.support_us_tab_ads);
        this.tabLayout.setTabMode(0);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
        a(this.toolbar, R.string.title_support_us, true);
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            ((MainActivity) getActivity()).t(8);
        }
        AlertDialogCenter.showCustomAlertDialog(getActivity(), (int) R.drawable.icon_success, (int) R.string.alert_support_us_title, (int) R.string.alert_support_us);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
    }
}
