package com.picacomic.fregata.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.utils.views.AlertDialogCenter;
/* loaded from: classes.dex */
public class SupportUsOfficalGroupFragment extends BaseFragment {
    public static final String TAG = "SupportUsOfficalGroupFragment";
    @BindView(R.id.textView_support_us_offical_group_warning)
    TextView textView_warning;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_support_us_offical_group, viewGroup, false);
        a(inflate);
        this.textView_warning.setOnClickListener(new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.SupportUsOfficalGroupFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SupportUsOfficalGroupFragment.this.getContext() != null) {
                    AlertDialogCenter.showFaqAlertDialog(SupportUsOfficalGroupFragment.this.getContext(), "https://www.picacomic.com/faq", null);
                }
            }
        });
        return inflate;
    }
}
