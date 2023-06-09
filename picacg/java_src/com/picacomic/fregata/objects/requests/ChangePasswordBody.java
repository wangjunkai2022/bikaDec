package com.picacomic.fregata.objects.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class ChangePasswordBody {
    @SerializedName("new_password")
    String newPassword;
    @SerializedName("old_password")
    String oldPassword;

    public ChangePasswordBody(String str, String str2) {
        this.oldPassword = str;
        this.newPassword = str2;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setOldPassword(String str) {
        this.oldPassword = str;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    public String toString() {
        return "ChangePasswordBody{oldPassword='" + this.oldPassword + "', newPassword='" + this.newPassword + "'}";
    }
}
