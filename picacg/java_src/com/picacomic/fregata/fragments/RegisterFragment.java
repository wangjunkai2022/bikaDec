package com.picacomic.fregata.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.BindViews;
import com.picacomic.fregata.R;
import com.picacomic.fregata.a.g;
import com.picacomic.fregata.activities.MainActivity;
import com.picacomic.fregata.b.c;
import com.picacomic.fregata.b.d;
import com.picacomic.fregata.c.a;
import com.picacomic.fregata.objects.NetworkErrorObject;
import com.picacomic.fregata.objects.requests.RegisterBody;
import com.picacomic.fregata.objects.requests.SignInBody;
import com.picacomic.fregata.objects.responses.GeneralResponse;
import com.picacomic.fregata.objects.responses.RegisterResponse;
import com.picacomic.fregata.objects.responses.SignInResponse;
import com.picacomic.fregata.utils.e;
import com.picacomic.fregata.utils.views.AlertDialogCenter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/* loaded from: classes.dex */
public class RegisterFragment extends BaseFragment {
    public static final String TAG = "RegisterFragment";
    String birthday;
    @BindView(R.id.button_register_register_button)
    Button button_register;
    @BindViews({R.id.button_register_gender_m, R.id.button_register_gender_f, R.id.button_register_gender_bot})
    AppCompatButton[] buttons_gender;
    @BindView(R.id.editText_register_answer_1)
    EditText editText_answer_1;
    @BindView(R.id.editText_register_answer_2)
    EditText editText_answer_2;
    @BindView(R.id.editText_register_answer_3)
    EditText editText_answer_3;
    @BindView(R.id.editText_register_email)
    EditText editText_email;
    @BindView(R.id.editText_register_password)
    EditText editText_password;
    @BindView(R.id.editText_register_password_confirm)
    EditText editText_passwordConfirm;
    @BindView(R.id.editText_register_question_1)
    EditText editText_question_1;
    @BindView(R.id.editText_register_question_2)
    EditText editText_question_2;
    @BindView(R.id.editText_register_question_3)
    EditText editText_question_3;
    @BindView(R.id.editText_register_username)
    EditText editText_username;
    @BindView(R.id.frameLayout_register_background_white)
    FrameLayout frameLayout_backgroundWhite;
    @BindArray(R.array.register_genders)
    String[] genders;
    Animation iE;
    Call<GeneralResponse<SignInResponse>> pU;
    String rg;
    private int rh;
    private int ri;
    private int rj;
    private int rk;
    private int rl;
    private int rm;
    private int rn;
    Call<RegisterResponse> ro;
    @BindView(R.id.textView_register_birthday)
    TextView textView_birthday;

    static /* synthetic */ int c(RegisterFragment registerFragment) {
        int i = registerFragment.rk;
        registerFragment.rk = i - 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_register, viewGroup, false);
        a(inflate);
        return inflate;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void init() {
        super.init();
        this.rh = Calendar.getInstance().get(1);
        this.ri = Calendar.getInstance().get(2);
        this.rj = Calendar.getInstance().get(5);
        this.iE = AnimationUtils.loadAnimation(getActivity(), R.anim.register_bg_white_fade_in);
        this.rl = this.rh;
        this.rm = this.ri;
        this.rn = this.rj;
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void ca() {
        super.ca();
        this.button_register.setOnClickListener(new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.RegisterFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RegisterFragment.this.dI();
            }
        });
        this.textView_birthday.setOnClickListener(new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.RegisterFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new DatePickerDialog(RegisterFragment.this.getActivity(), new DatePickerDialog.OnDateSetListener() { // from class: com.picacomic.fregata.fragments.RegisterFragment.2.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        StringBuilder sb = new StringBuilder();
                        int i4 = i2 + 1;
                        sb.append(i4);
                        sb.append("");
                        String sb2 = sb.toString();
                        String str = i3 + "";
                        if (i4 < 10) {
                            sb2 = "0" + i4;
                        }
                        if (i3 < 10) {
                            str = "0" + i3;
                        }
                        RegisterFragment.this.birthday = i + "-" + sb2 + "-" + str;
                        RegisterFragment.this.rk = RegisterFragment.this.rh - i;
                        if (i2 <= RegisterFragment.this.ri) {
                            if (i2 == RegisterFragment.this.ri && i3 > RegisterFragment.this.rj) {
                                RegisterFragment.c(RegisterFragment.this);
                            }
                        } else {
                            RegisterFragment.c(RegisterFragment.this);
                        }
                        RegisterFragment.this.rl = i;
                        RegisterFragment.this.rm = i2;
                        RegisterFragment.this.rn = i3;
                        RegisterFragment.this.textView_birthday.setText(((Object) RegisterFragment.this.getResources().getText(R.string.register_date_of_birth_prefix)) + RegisterFragment.this.birthday + "（" + RegisterFragment.this.rk + ((Object) RegisterFragment.this.getResources().getText(R.string.register_age)) + "）");
                    }
                }, RegisterFragment.this.rl, RegisterFragment.this.rm, RegisterFragment.this.rn).show();
            }
        });
        for (final int i = 0; i < this.buttons_gender.length; i++) {
            this.buttons_gender[i].setOnClickListener(new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.RegisterFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RegisterFragment.this.aa(i);
                }
            });
        }
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bH() {
        super.bH();
        this.frameLayout_backgroundWhite.startAnimation(this.iE);
        aa(0);
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment
    public void bI() {
        super.bI();
    }

    public void aa(int i) {
        if (this.buttons_gender != null) {
            for (int i2 = 0; i2 < this.buttons_gender.length; i2++) {
                this.buttons_gender[i2].setEnabled(true);
                this.buttons_gender[i2].setText(this.genders[i2]);
            }
            this.buttons_gender[i].setEnabled(false);
            this.rg = a.uN[i];
        }
    }

    public void dI() {
        if (this.editText_username == null || this.editText_username.getText() == null) {
            return;
        }
        Matcher matcher = Pattern.compile("^嗶\\s*咔(.*)").matcher(this.editText_username.getText().toString());
        if (this.editText_username.getText().length() < 2 || this.editText_username.getText().length() > 50) {
            AlertDialogCenter.usernameLength(getActivity());
        } else if (matcher.matches()) {
            AlertDialogCenter.cannotStartWithPica(getActivity());
        } else if (this.editText_password.getText().length() < 8) {
            AlertDialogCenter.passwordLength(getActivity());
        } else if (!this.editText_passwordConfirm.getText().toString().equals(this.editText_password.getText().toString())) {
            AlertDialogCenter.passwordNotMatch(getActivity());
        } else if (this.editText_question_1.getText().length() == 0 || this.editText_question_2.getText().length() == 0 || this.editText_question_3.getText().length() == 0 || this.editText_answer_1.getText().length() == 0 || this.editText_answer_2.getText().length() == 0 || this.editText_answer_3.getText().length() == 0) {
        } else {
            if (this.birthday == null || this.birthday.equalsIgnoreCase("")) {
                AlertDialogCenter.birthday(getActivity());
            } else if (this.rk < 18) {
                AlertDialogCenter.ageNotEnough(getActivity());
            } else {
                dJ();
            }
        }
    }

    public void dJ() {
        C(getResources().getString(R.string.loading_register));
        this.ro = new d(getContext()).dO().a(new RegisterBody(this.editText_username.getText().toString(), this.editText_email.getText().toString(), this.editText_password.getText().toString(), this.birthday, this.rg, this.editText_question_1.getText().toString(), this.editText_question_2.getText().toString(), this.editText_question_3.getText().toString(), this.editText_answer_1.getText().toString(), this.editText_answer_2.getText().toString(), this.editText_answer_3.getText().toString()));
        this.ro.enqueue(new Callback<RegisterResponse>() { // from class: com.picacomic.fregata.fragments.RegisterFragment.4
            @Override // retrofit2.Callback
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.code() == 200) {
                    AlertDialogCenter.showCustomAlertDialog(RegisterFragment.this.getActivity(), (int) R.drawable.icon_success, (int) R.string.alert_register_success_title, (int) R.string.alert_register_success, new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.RegisterFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            e.e(RegisterFragment.this.getActivity(), RegisterFragment.this.editText_email.getText().toString());
                            e.f(RegisterFragment.this.getActivity(), RegisterFragment.this.editText_password.getText().toString());
                            RegisterFragment.this.dr();
                        }
                    }, (View.OnClickListener) null);
                } else {
                    try {
                        new c(RegisterFragment.this.getActivity(), response.code(), response.errorBody().string()).dN();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                RegisterFragment.this.bC();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<RegisterResponse> call, Throwable th) {
                th.printStackTrace();
                RegisterFragment.this.bC();
                new c(RegisterFragment.this.getActivity()).dN();
            }
        });
    }

    public void dr() {
        C(getResources().getString(R.string.loading_sign_in));
        this.pU = new d(getContext()).dO().a(new SignInBody(this.editText_email.getText().toString(), this.editText_password.getText().toString()));
        this.pU.enqueue(new Callback<GeneralResponse<SignInResponse>>() { // from class: com.picacomic.fregata.fragments.RegisterFragment.5
            @Override // retrofit2.Callback
            public void onResponse(Call<GeneralResponse<SignInResponse>> call, Response<GeneralResponse<SignInResponse>> response) {
                if (response.code() == 200) {
                    if (RegisterFragment.this.getActivity() != null) {
                        e.e(RegisterFragment.this.getActivity(), RegisterFragment.this.editText_email.getText().toString());
                        e.f(RegisterFragment.this.getActivity(), RegisterFragment.this.editText_password.getText().toString());
                        e.h(RegisterFragment.this.getActivity(), response.body().data.getToken());
                    }
                    RegisterFragment.this.dq();
                } else {
                    if (RegisterFragment.this.getActivity() != null) {
                        RegisterFragment.this.getActivity().onBackPressed();
                    }
                    try {
                        new c(RegisterFragment.this.getActivity(), response.code(), response.errorBody().string(), new g() { // from class: com.picacomic.fregata.fragments.RegisterFragment.5.1
                            @Override // com.picacomic.fregata.a.g
                            public void a(int i, NetworkErrorObject networkErrorObject) {
                                AlertDialog.Builder title = new AlertDialog.Builder(RegisterFragment.this.getActivity()).setTitle(networkErrorObject.getError());
                                title.setMessage(networkErrorObject.getMessage() + "\n" + networkErrorObject.getDetail()).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.picacomic.fregata.fragments.RegisterFragment.5.1.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        dialogInterface.dismiss();
                                    }
                                }).show();
                            }
                        }).dN();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    RegisterFragment.this.bI();
                }
                RegisterFragment.this.bC();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<GeneralResponse<SignInResponse>> call, Throwable th) {
                th.printStackTrace();
                RegisterFragment.this.bI();
                RegisterFragment.this.bC();
                new c(RegisterFragment.this.getActivity()).dN();
            }
        });
    }

    public void dq() {
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

    @Override // com.picacomic.fregata.fragments.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.ro != null) {
            this.ro.cancel();
        }
        if (this.pU != null) {
            this.pU.cancel();
        }
    }
}
