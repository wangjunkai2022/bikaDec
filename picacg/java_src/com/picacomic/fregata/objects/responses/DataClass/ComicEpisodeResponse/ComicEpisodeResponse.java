package com.picacomic.fregata.objects.responses.DataClass.ComicEpisodeResponse;
/* loaded from: classes.dex */
public class ComicEpisodeResponse {
    ComicEpisodeData eps;

    public ComicEpisodeResponse() {
    }

    public ComicEpisodeResponse(ComicEpisodeData comicEpisodeData) {
        this.eps = comicEpisodeData;
    }

    public ComicEpisodeData getEps() {
        return this.eps;
    }

    public void setEps(ComicEpisodeData comicEpisodeData) {
        this.eps = comicEpisodeData;
    }

    public String toString() {
        return "ComicEpisodeResponse{eps=" + this.eps + '}';
    }
}
