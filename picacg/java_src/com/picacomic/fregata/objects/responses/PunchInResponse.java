package com.picacomic.fregata.objects.responses;
/* loaded from: classes.dex */
public class PunchInResponse {
    PunchInObject res;

    public PunchInResponse(PunchInObject punchInObject) {
        this.res = punchInObject;
    }

    public PunchInObject getRes() {
        return this.res;
    }

    public void setRes(PunchInObject punchInObject) {
        this.res = punchInObject;
    }

    public String toString() {
        return "PunchInResponse{res=" + this.res + '}';
    }
}
