package com.picacomic.fregata.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.activities.MainActivity;
import com.picacomic.fregata.b.c;
import com.picacomic.fregata.b.d;
import com.picacomic.fregata.objects.requests.UpdateQandABody;
import com.picacomic.fregata.objects.responses.GeneralResponse;
import com.picacomic.fregata.utils.e;
import com.picacomic.fregata.utils.views.AlertDialogCenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/* loaded from: classes.dex */
public class OneTimeUpdateQAFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "OneTimeUpdateQAFragment";
    @BindView(R.id.button_update)
    Button button_update;
    @BindView(R.id.editText_register_answer_1)
    EditText editText_answer_1;
    @BindView(R.id.editText_register_answer_2)
    EditText editText_answer_2;
    @BindView(R.id.editText_register_answer_3)
    EditText editText_answer_3;
    @BindView(R.id.editText_register_question_1)
    EditText editText_question_1;
    @BindView(R.id.editText_register_question_2)
    EditText editText_question_2;
    @BindView(R.id.editText_register_question_3)
    EditText editText_question_3;
    Call<GeneralResponse> qr;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_one_time_update_qa, viewGroup, false);
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
        this.button_update.setOnClickListener(this);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            ((MainActivity) getActivity()).t(8);
        }
        if (getActivity() != null && (getActivity() instanceof AppCompatActivity)) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(this.toolbar);
        }
        a(this.toolbar, R.string.title_one_time_update, true);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
        if ((this.editText_question_1 == null || this.editText_question_1.getText().length() >= 1) && ((this.editText_question_2 == null || this.editText_question_2.getText().length() >= 1) && ((this.editText_question_3 == null || this.editText_question_3.getText().length() >= 1) && ((this.editText_answer_1 == null || this.editText_answer_1.getText().length() >= 1) && ((this.editText_answer_2 == null || this.editText_answer_2.getText().length() >= 1) && (this.editText_answer_3 == null || this.editText_answer_3.getText().length() >= 1)))))) {
            return;
        }
        AlertDialogCenter.showCustomAlertDialog(getContext(), R.drawable.icon_exclamation_error, R.string.alert_edit_profile_question_error);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        C(getResources().getString(R.string.loading_general));
        this.qr = new d(getContext()).dO().a(e.z(getActivity()), new UpdateQandABody(str, str2, str3, str4, str5, str6));
        this.qr.enqueue(new Callback<GeneralResponse>() { // from class: com.picacomic.fregata.fragments.OneTimeUpdateQAFragment.1
            @Override // retrofit2.Callback
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                if (response.code() == 200) {
                    OneTimeUpdateQAFragment.this.getFragmentManager().beginTransaction().setCustomAnimations(R.anim.transaction_anim_enter, R.anim.transaction_anim_exit, R.anim.transaction_anim_pop_enter, R.anim.transaction_anim_pop_exit).replace(R.id.container, new OneTimeIdUpdateFragment(), OneTimeIdUpdateFragment.TAG).addToBackStack(OneTimeIdUpdateFragment.TAG).commit();
                } else {
                    try {
                        new c(OneTimeUpdateQAFragment.this.getActivity(), response.code(), response.errorBody().string()).dN();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                OneTimeUpdateQAFragment.this.bC();
                OneTimeUpdateQAFragment.this.bI();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<GeneralResponse> call, Throwable th) {
                th.printStackTrace();
                OneTimeUpdateQAFragment.this.bC();
                new c(OneTimeUpdateQAFragment.this.getActivity()).dN();
                OneTimeUpdateQAFragment.this.bI();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.button_update || this.editText_question_1 == null || this.editText_question_1.getText().length() <= 0 || this.editText_question_2 == null || this.editText_question_2.getText().length() <= 0 || this.editText_question_3 == null || this.editText_question_3.getText().length() <= 0 || this.editText_answer_1 == null || this.editText_answer_1.getText().length() <= 0 || this.editText_answer_2 == null || this.editText_answer_2.getText().length() <= 0 || this.editText_answer_3 == null || this.editText_answer_3.getText().length() <= 0) {
            return;
        }
        a(this.editText_question_1.getText().toString(), this.editText_question_2.getText().toString(), this.editText_question_3.getText().toString(), this.editText_answer_1.getText().toString(), this.editText_answer_2.getText().toString(), this.editText_answer_3.getText().toString());
    }
}
