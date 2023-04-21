package com.just.agentweb;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class Action implements Parcelable {
    public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() { // from class: com.just.agentweb.Action.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Action createFromParcel(Parcel parcel) {
            return new Action(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d */
        public Action[] newArray(int i) {
            return new Action[i];
        }
    };
    private ArrayList<String> cp;
    private int cq;
    private int cr;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Action() {
        this.cp = new ArrayList<>();
    }

    public ArrayList<String> r() {
        return this.cp;
    }

    public void a(ArrayList<String> arrayList) {
        this.cp = arrayList;
    }

    public int getAction() {
        return this.cq;
    }

    public void setAction(int i) {
        this.cq = i;
    }

    protected Action(Parcel parcel) {
        this.cp = new ArrayList<>();
        this.cp = parcel.createStringArrayList();
        this.cq = parcel.readInt();
        this.cr = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.cp);
        parcel.writeInt(this.cq);
        parcel.writeInt(this.cr);
    }

    public int s() {
        return this.cr;
    }

    public static Action a(String[] strArr) {
        Action action = new Action();
        action.setAction(1);
        action.a(new ArrayList<>(Arrays.asList(strArr)));
        return action;
    }

    public Action c(int i) {
        this.cr = i;
        return this;
    }
}
