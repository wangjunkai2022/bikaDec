package com.picacomic.fregata.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.picacomic.fregata.R;
import com.picacomic.fregata.utils.e;
/* loaded from: classes.dex */
public class LockDialogFragment extends DialogFragment {
    public static final String TAG = "LockDialogFragment";
    int count = 0;
    EditText[] pP;
    TextView pQ;
    String pR;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 16973834);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_lock_dialog, (ViewGroup) null, false);
        this.pQ = (TextView) inflate.findViewById(R.id.textView_lock_title);
        this.pP = new EditText[4];
        this.pP[0] = (EditText) inflate.findViewById(R.id.editText_lock_pin_1);
        this.pP[1] = (EditText) inflate.findViewById(R.id.editText_lock_pin_2);
        this.pP[2] = (EditText) inflate.findViewById(R.id.editText_lock_pin_3);
        this.pP[3] = (EditText) inflate.findViewById(R.id.editText_lock_pin_4);
        this.count = 0;
        this.pR = e.y(getContext());
        if (this.pR == null || this.pR.equalsIgnoreCase("")) {
            dismiss();
        }
        this.pQ.setOnClickListener(new View.OnClickListener() { // from class: com.picacomic.fregata.fragments.LockDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LockDialogFragment.this.count > 30) {
                    LockDialogFragment.this.dismiss();
                    return;
                }
                LockDialogFragment.this.count++;
                if (30 - LockDialogFragment.this.count < 4) {
                    LockDialogFragment.this.pQ.setText(((30 - LockDialogFragment.this.count) + 2) + "");
                }
            }
        });
        this.pP[0].addTextChangedListener(new TextWatcher() { // from class: com.picacomic.fregata.fragments.LockDialogFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    LockDialogFragment.this.pP[1].requestFocus();
                }
            }
        });
        this.pP[1].addTextChangedListener(new TextWatcher() { // from class: com.picacomic.fregata.fragments.LockDialogFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    LockDialogFragment.this.pP[2].requestFocus();
                }
            }
        });
        this.pP[2].addTextChangedListener(new TextWatcher() { // from class: com.picacomic.fregata.fragments.LockDialogFragment.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    LockDialogFragment.this.pP[3].requestFocus();
                }
            }
        });
        this.pP[3].addTextChangedListener(new TextWatcher() { // from class: com.picacomic.fregata.fragments.LockDialogFragment.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 1) {
                    String str = "";
                    for (int i = 0; i < LockDialogFragment.this.pP.length; i++) {
                        if (LockDialogFragment.this.pP[i] != null && LockDialogFragment.this.pP[i].getText() != null && LockDialogFragment.this.pP[i].getText().toString() != null) {
                            str = str + LockDialogFragment.this.pP[i].getText().toString();
                        }
                    }
                    if (LockDialogFragment.this.pR.equalsIgnoreCase(str)) {
                        LockDialogFragment.this.dismiss();
                        return;
                    }
                    for (int i2 = 0; i2 < LockDialogFragment.this.pP.length; i2++) {
                        LockDialogFragment.this.pP[i2].setText("");
                    }
                    LockDialogFragment.this.pP[0].requestFocus();
                }
            }
        });
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        onCreateDialog.setCancelable(false);
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.picacomic.fregata.fragments.LockDialogFragment.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 || i == 84;
            }
        });
        return onCreateDialog;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDetach() {
        System.gc();
        super.onDetach();
    }
}
