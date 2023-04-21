package com.picacomic.fregata.objects.responses.DataClass.ProfileCommentsResponse;
/* loaded from: classes.dex */
public class ProfileCommentsResponse {
    ProfileCommentsData comments;

    public ProfileCommentsResponse(ProfileCommentsData profileCommentsData) {
        this.comments = profileCommentsData;
    }

    public ProfileCommentsData getComments() {
        return this.comments;
    }

    public void setComments(ProfileCommentsData profileCommentsData) {
        this.comments = profileCommentsData;
    }
}
