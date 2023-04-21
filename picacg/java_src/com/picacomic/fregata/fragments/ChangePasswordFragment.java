package com.picacomic.fregata.fragments;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.activities.MainActivity;
import com.picacomic.fregata.b.c;
import com.picacomic.fregata.b.d;
import com.picacomic.fregata.objects.requests.ChangePasswordBody;
import com.picacomic.fregata.objects.responses.RegisterResponse;
import com.picacomic.fregata.utils.e;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/* loaded from: classes.dex */
public class ChangePasswordFragment extends BaseFragment {
    public static final String TAG = "ChangePasswordFragment";
    @BindView(R.id.button_change_password)
    Button button_changePassword;
    @BindView(R.id.checkBox_change_password_show_password)
    CheckBox checkBox_showPassword;
    @BindView(R.id.editText_change_password_new)
    EditText editText_password;
    @BindView(R.id.editText_change_password_new_confirm)
    EditText editText_passwordConfirm;
    boolean kK;
    boolean kL;
    Call<RegisterResponse> kM;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_change_password, viewGroup, false);
        a(inflate);
        return inflate;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void init() {
        super.init();
        this.kK = false;
        this.kL = false;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void ca() {
        super.ca();
        this.button_changePassword.setOnClickListener(new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.ChangePasswordFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ChangePasswordFragment.this.kK || !ChangePasswordFragment.this.kL || ChangePasswordFragment.this.editText_password == null || ChangePasswordFragment.this.editText_password.getText() == null) {
                    return;
                }
                ChangePasswordFragment.this.L(ChangePasswordFragment.this.editText_password.getText().toString());
            }
        });
        this.checkBox_showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.picacomic.fregata.fragments.ChangePasswordFragment.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    ChangePasswordFragment.this.editText_password.setInputType(129);
                    ChangePasswordFragment.this.editText_passwordConfirm.setInputType(129);
                    return;
                }
                ChangePasswordFragment.this.editText_password.setInputType(128);
                ChangePasswordFragment.this.editText_passwordConfirm.setInputType(128);
            }
        });
        this.editText_password.addTextChangedListener(new TextWatcher() { // from class: com.picacomic.fregata.fragments.ChangePasswordFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ChangePasswordFragment.this.editText_password.getText().toString().length() < 8) {
                    ChangePasswordFragment.this.editText_password.setError(ChangePasswordFragment.this.getString(R.string.alert_empty_password));
                    ChangePasswordFragment.this.kK = false;
                    return;
                }
                ChangePasswordFragment.this.editText_password.setError(null);
                ChangePasswordFragment.this.kK = true;
            }
        });
        this.editText_passwordConfirm.addTextChangedListener(new TextWatcher() { // from class: com.picacomic.fregata.fragments.ChangePasswordFragment.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!ChangePasswordFragment.this.editText_password.getText().toString().equals(ChangePasswordFragment.this.editText_passwordConfirm.getText().toString())) {
                    ChangePasswordFragment.this.editText_passwordConfirm.setError(ChangePasswordFragment.this.getString(R.string.alert_not_same_password));
                    ChangePasswordFragment.this.kL = false;
                    return;
                }
                ChangePasswordFragment.this.editText_passwordConfirm.setError(null);
                ChangePasswordFragment.this.kL = true;
            }
        });
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
        a(this.toolbar, R.string.title_setting, true);
        if (getActivity() == null || !(getActivity() instanceof MainActivity)) {
            return;
        }
        ((MainActivity) getActivity()).t(8);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        if (this.kM != null) {
            this.kM.cancel();
        }
        super.onDetach();
    }

    public void L(final String str) {
        this.kM = new d(getContext()).dO().a(e.z(getActivity()), new ChangePasswordBody(e.v(getActivity()), str));
        this.kM.enqueue(new Callback<RegisterResponse>() { // from class: com.picacomic.fregata.fragments.ChangePasswordFragment.5
            @Override // retrofit2.Callback
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.code() == 200) {
                    if (ChangePasswordFragment.this.getActivity() != null && ChangePasswordFragment.this.getFragmentManager() != null) {
                        Toast.makeText(ChangePasswordFragment.this.getActivity(), (int) R.string.change_password_success, 0).show();
                        e.f(ChangePasswordFragment.this.getActivity(), str);
                        ChangePasswordFragment.this.getFragmentManager().popBackStack();
                    }
                } else {
                    try {
                        new c(ChangePasswordFragment.this.getActivity(), response.code(), response.errorBody().string()).dN();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ChangePasswordFragment.this.bI();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<RegisterResponse> call, Throwable th) {
                th.printStackTrace();
                new c(ChangePasswordFragment.this.getActivity()).dN();
                ChangePasswordFragment.this.bI();
            }
        });
    }
}
