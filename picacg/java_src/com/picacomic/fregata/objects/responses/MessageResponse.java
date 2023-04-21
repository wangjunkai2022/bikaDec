package com.picacomic.fregata.objects.responses;
/* loaded from: classes.dex */
public class MessageResponse {
    String message;

    public MessageResponse(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "MessageResponse{message='" + this.message + "'}";
    }
}
