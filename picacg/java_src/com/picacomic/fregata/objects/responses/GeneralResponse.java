package com.picacomic.fregata.objects.responses;

import android.support.annotation.Nullable;
/* loaded from: classes.dex */
public class GeneralResponse<DataClass> {
    public int code;
    @Nullable
    public DataClass data;
    public String message;

    public GeneralResponse(DataClass dataclass) {
        this.data = dataclass;
    }

    public String toString() {
        return "GeneralResponse{code=" + this.code + ", message='" + this.message + "', data=" + this.data + '}';
    }
}
