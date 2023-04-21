package com.picacomic.fregata.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.k;
import com.picacomic.fregata.adapters.SupportUsPayPalRecyclerViewAdapter;
import com.picacomic.fregata.objects.SupportUsPayPalObject;
import com.picacomic.fregata.utils.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SupportUsPayPalFragment extends BaseFragment implements k {
    public static final String TAG = "SupportUsPayPalFragment";
    ArrayList<SupportUsPayPalObject> arrayList;
    String description;
    LinearLayoutManager jQ;
    String priceUnit;
    SupportUsPayPalRecyclerViewAdapter rS;
    String[] rT = {"https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MB2YUFR74MDJC", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=SLMX9KT5QG2TJ", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=CZ9ZGGEV5JFC8", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=BP6DZ5GMR4A9N", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=6U3R7MRUR5HZJ", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=UFRC5P8VGMPWU"};
    String[] rU;
    String[] rV;
    @BindView(R.id.recyclerView_support_us_paypal)
    RecyclerView recyclerView_paypal;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_support_us_pay_pal, viewGroup, false);
        a(inflate);
        return inflate;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void init() {
        super.init();
        this.rU = getResources().getStringArray(R.array.support_us_paypal_titles);
        this.rV = getResources().getStringArray(R.array.support_us_paypal_prices);
        this.priceUnit = getResources().getString(R.string.support_us_paypal_price_unit);
        this.description = getResources().getString(R.string.support_us_paypal_description_default);
        this.jQ = new LinearLayoutManager(getActivity(), 1, false);
        this.arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.arrayList.add(new SupportUsPayPalObject(-1, this.rU[i], this.priceUnit, this.rV[i], this.description));
        }
        this.rS = new SupportUsPayPalRecyclerViewAdapter(getActivity(), this.arrayList, this);
        this.recyclerView_paypal.setLayoutManager(this.jQ);
        this.recyclerView_paypal.setAdapter(this.rS);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void ca() {
        super.ca();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
    }

    @Override // com.picacomic.fregata.a.k
    public void C(int i) {
        if (getActivity() != null) {
            g.A(getActivity(), this.rT[i]);
        }
    }
}
