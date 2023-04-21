package com.picacomic.fregata.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.gson.Gson;
import com.picacomic.fregata.a.g;
import com.picacomic.fregata.activities.LoginActivity;
import com.picacomic.fregata.objects.NetworkErrorObject;
import com.picacomic.fregata.utils.views.AlertDialogCenter;
/* compiled from: NetworkErrorHandler.java */
/* loaded from: classes.dex */
public class c {
    public static final String TAG = "c";
    public int code;
    public String ta;
    public NetworkErrorObject tb;
    public g tc;
    public g td;
    public g te;
    public g tf;
    public g tg;
    public g th;
    public g ti;
    public g tj;
    public g tk;
    public g tl;
    public g tm;
    public g tn;
    public g tp;
    public g tq;
    public g tr;
    public g ts;

    public c(final Context context, int i, String str) {
        this.code = i;
        this.ta = str;
        this.tb = av(this.ta);
        this.tc = new g() { // from class: com.picacomic.fregata.b.c.1
            @Override // com.picacomic.fregata.a.g
            public void a(int i2, NetworkErrorObject networkErrorObject) {
                com.picacomic.fregata.utils.f.aA("Run default Alert");
                if (networkErrorObject != null) {
                    String error = c.this.tb.getError() == null ? "" : c.this.tb.getError();
                    String message = c.this.tb.getMessage() == null ? "" : c.this.tb.getMessage();
                    String detail = c.this.tb.getDetail() == null ? "" : c.this.tb.getDetail();
                    Context context2 = context;
                    AlertDialogCenter.generalError(context2, error + " " + message, detail);
                    return;
                }
                AlertDialogCenter.generalError(context);
            }
        };
        t(context);
    }

    public c(final Context context) {
        this.tc = new g() { // from class: com.picacomic.fregata.b.c.10
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.generalError(context);
            }
        };
    }

    public c(Context context, int i, String str, g gVar) {
        this.code = i;
        this.ta = str;
        this.tb = av(this.ta);
        this.tc = gVar;
        t(context);
    }

    public void t(final Context context) {
        this.td = new g() { // from class: com.picacomic.fregata.b.c.11
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.validation(context);
            }
        };
        this.te = new g() { // from class: com.picacomic.fregata.b.c.12
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.invalidEmailOrPassword(context);
            }
        };
        this.tf = new g() { // from class: com.picacomic.fregata.b.c.13
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                com.picacomic.fregata.utils.e.h(context, "");
                if (context instanceof Activity) {
                    context.startActivity(new Intent(context, LoginActivity.class));
                    ((Activity) context).finish();
                }
            }
        };
        this.tg = new g() { // from class: com.picacomic.fregata.b.c.14
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.accountNotActivated(context);
            }
        };
        this.th = new g() { // from class: com.picacomic.fregata.b.c.15
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.notFound(context);
            }
        };
        this.ti = new g() { // from class: com.picacomic.fregata.b.c.16
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.emailExist(context);
            }
        };
        this.tj = new g() { // from class: com.picacomic.fregata.b.c.17
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.usernameExist(context);
            }
        };
        this.tk = new g() { // from class: com.picacomic.fregata.b.c.2
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.invalidEmailOrPassword(context);
            }
        };
        this.tl = new g() { // from class: com.picacomic.fregata.b.c.3
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.underReview(context);
            }
        };
        this.tm = new g() { // from class: com.picacomic.fregata.b.c.4
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.cannotComment(context);
            }
        };
        this.tn = new g() { // from class: com.picacomic.fregata.b.c.5
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.tooManyRequests(context);
            }
        };
        this.tp = new g() { // from class: com.picacomic.fregata.b.c.6
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.notSupportEmail(context);
            }
        };
        this.tq = new g() { // from class: com.picacomic.fregata.b.c.7
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.cannotStartWithPica(context);
            }
        };
        this.tr = new g() { // from class: com.picacomic.fregata.b.c.8
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.fakeEmail(context);
            }
        };
        this.ts = new g() { // from class: com.picacomic.fregata.b.c.9
            @Override // com.picacomic.fregata.a.g
            public void a(int i, NetworkErrorObject networkErrorObject) {
                AlertDialogCenter.timeIsNotSynchronize(context);
            }
        };
    }

    public NetworkErrorObject av(String str) {
        if (str != null) {
            return (NetworkErrorObject) new Gson().fromJson(str, (Class<Object>) NetworkErrorObject.class);
        }
        return null;
    }

    public void dN() {
        if (this.code != 200 && this.tb != null) {
            String error = this.tb.getError();
            char c = 65535;
            int hashCode = error.hashCode();
            if (hashCode != 1507425) {
                if (hashCode != 1507454) {
                    if (hashCode != 1507458) {
                        if (hashCode != 1507463) {
                            if (hashCode != 1507494) {
                                switch (hashCode) {
                                    case 1507427:
                                        if (error.equals("1004")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case 1507428:
                                        if (error.equals("1005")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case 1507429:
                                        if (error.equals("1006")) {
                                            c = 3;
                                            break;
                                        }
                                        break;
                                    case 1507430:
                                        if (error.equals("1007")) {
                                            c = 4;
                                            break;
                                        }
                                        break;
                                    case 1507431:
                                        if (error.equals("1008")) {
                                            c = 5;
                                            break;
                                        }
                                        break;
                                    case 1507432:
                                        if (error.equals("1009")) {
                                            c = 6;
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 1507488:
                                                if (error.equals("1023")) {
                                                    c = '\t';
                                                    break;
                                                }
                                                break;
                                            case 1507489:
                                                if (error.equals("1024")) {
                                                    c = 11;
                                                    break;
                                                }
                                                break;
                                            case 1507490:
                                                if (error.equals("1025")) {
                                                    c = '\f';
                                                    break;
                                                }
                                                break;
                                            case 1507491:
                                                if (error.equals("1026")) {
                                                    c = '\r';
                                                    break;
                                                }
                                                break;
                                        }
                                }
                            } else if (error.equals("1029")) {
                                c = 14;
                            }
                        } else if (error.equals("1019")) {
                            c = '\n';
                        }
                    } else if (error.equals("1014")) {
                        c = '\b';
                    }
                } else if (error.equals("1010")) {
                    c = 7;
                }
            } else if (error.equals("1002")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    a(this.td);
                    break;
                case 1:
                    a(this.te);
                    break;
                case 2:
                    a(this.tf);
                    break;
                case 3:
                    a(this.tg);
                    break;
                case 4:
                    a(this.th);
                    break;
                case 5:
                    a(this.ti);
                    break;
                case 6:
                    a(this.tj);
                    break;
                case 7:
                    a(this.tk);
                    break;
                case '\b':
                    a(this.tl);
                    break;
                case '\t':
                    a(this.tn);
                    break;
                case '\n':
                    a(this.tm);
                    break;
                case 11:
                    a(this.tp);
                    break;
                case '\f':
                    a(this.tq);
                    break;
                case '\r':
                    a(this.tr);
                    break;
                case 14:
                    a(this.ts);
                    break;
                default:
                    if (this.code == 400) {
                        this.tc.a(444, this.tb);
                        break;
                    } else {
                        this.tc.a(444, null);
                        break;
                    }
            }
            String str = TAG;
            Log.e(str, this.tb.getCode() + "\n" + this.tb.getError() + "\n" + this.tb.getMessage() + "\n" + this.tb.getDetail());
            return;
        }
        this.tc.a(444, null);
    }

    public void a(g gVar) {
        if (gVar == null) {
            this.tc.a(this.code, this.tb);
        } else {
            gVar.a(this.code, this.tb);
        }
    }
}
