package com.picacomic.fregata.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.picacomic.fregata.b.d;
import com.picacomic.fregata.objects.ComicPageObject;
import com.picacomic.fregata.objects.databaseTable.DbComicDetailObject;
import com.picacomic.fregata.objects.databaseTable.DownloadComicEpisodeObject;
import com.picacomic.fregata.objects.databaseTable.DownloadComicPageObject;
import com.picacomic.fregata.objects.responses.DataClass.ComicPageResponse.ComicPagesResponse;
import com.picacomic.fregata.objects.responses.GeneralResponse;
import com.picacomic.fregata.utils.c;
import com.picacomic.fregata.utils.e;
import com.picacomic.fregata.utils.f;
import com.picacomic.fregata.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import retrofit2.Call;
import retrofit2.Response;
/* loaded from: classes.dex */
public class DownloadService extends IntentService {
    public static final String TAG = "DownloadService";
    public static final String tN = DownloadService.class.getName() + ".progress_update";
    Call<GeneralResponse<ComicPagesResponse>> hZ;
    private ExecutorService tO;
    private CompletionService<b> tP;
    private LocalBroadcastManager tQ;
    private List<a> tR;
    boolean tS;
    int tT;
    long tU;

    public DownloadService() {
        super(TAG);
        this.tS = false;
        this.tT = 4000;
        this.tO = Executors.newFixedThreadPool(1);
        this.tP = new ExecutorCompletionService(this.tO);
        this.tR = new ArrayList();
    }

    public DownloadService(String str) {
        super(str);
        this.tS = false;
        this.tT = 4000;
        this.tO = Executors.newFixedThreadPool(1);
        this.tP = new ExecutorCompletionService(this.tO);
        this.tR = new ArrayList();
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean z = this.tS;
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("COMIC_ID");
        String stringExtra2 = intent.getStringExtra("EPISODE_ID");
        if (this.tS) {
            a aVar = new a(stringExtra, stringExtra2);
            this.tR.add(aVar);
            String str = TAG;
            f.E(str, "Add Intent Task" + stringExtra2 + " Total Task " + this.tR.size());
            this.tP.submit(aVar);
            String str2 = TAG;
            f.E(str2, "Submit Intent Task" + stringExtra2 + " Total Task " + this.tR.size());
            dQ();
            String str3 = TAG;
            f.E(str3, "Finish intent Tasks - Total:" + this.tR.size());
            return;
        }
        this.tS = true;
        this.tQ = LocalBroadcastManager.getInstance(this);
        this.tR.add(new a(stringExtra, stringExtra2));
        for (a aVar2 : this.tR) {
            this.tP.submit(aVar2);
            String str4 = TAG;
            f.E(str4, "Submit Task " + this.tT + " Total Task " + this.tR.size());
        }
        for (int i = 0; i < this.tR.size(); i++) {
            dQ();
        }
        String str5 = TAG;
        f.E(str5, "Finish All Tasks - Total:" + this.tR.size());
    }

    public void dQ() {
        try {
            b bVar = this.tP.take().get();
            if (bVar == null || !bVar.tW) {
                return;
            }
            String str = TAG;
            f.E(str, "Download Success /" + this.tR.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        boolean tW;

        private b(boolean z) {
            this.tW = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Callable<b> {
        String comicId;
        String episodeId;

        public a(String str, String str2) {
            this.comicId = str;
            this.episodeId = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: dR */
        public b call() throws Exception {
            DownloadService.this.B(this.comicId, this.episodeId);
            String str = DownloadService.TAG;
            f.E(str, "Finish TaskId " + this.episodeId);
            return new b(true);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f.E(TAG, "Run Destroy and ShutDown");
        if (this.hZ != null) {
            this.hZ.cancel();
        }
        this.tO.shutdown();
    }

    public void B(String str, String str2) {
        int i;
        int i2;
        boolean z;
        Response<GeneralResponse<ComicPagesResponse>> execute;
        int total;
        int limit;
        String title;
        f.D(TAG, "Call Comic Page ?");
        d dVar = new d(this);
        DbComicDetailObject aw = com.picacomic.fregata.utils.b.aw(str);
        String title2 = aw != null ? aw.getTitle() : "";
        DownloadComicEpisodeObject ay = com.picacomic.fregata.utils.b.ay(str2);
        boolean z2 = false;
        int i3 = 1;
        boolean z3 = false;
        int i4 = 0;
        while (i4 < i3) {
            if (ay != null) {
                ay.setStatus(2);
                ay.save();
            } else {
                String str3 = TAG;
                f.D(str3, "DB error, missing DownloadComicEpisodeObject, episodeId = " + str2);
            }
            int i5 = i4 + 1;
            this.hZ = dVar.dO().e(e.z(this), str2, i5);
            try {
                execute = this.hZ.execute();
            } catch (IOException e) {
                e = e;
                i = i5;
                i2 = i3;
            }
            if (execute == null || execute.code() != 200) {
                i = i5;
                i4 = i;
                z2 = false;
            } else {
                f.F(TAG, execute.body().data.getPages().toString());
                i2 = execute.body().data.getPages().getPages();
                try {
                    total = execute.body().data.getPages().getTotal();
                    limit = execute.body().data.getPages().getLimit();
                    title = execute.body().data.getEp().getTitle();
                    if (z3 || ay == null) {
                        z = z3;
                    } else {
                        try {
                            ay.setTotal(total);
                            ay.save();
                            z = true;
                        } catch (IOException e2) {
                            e = e2;
                            z = z3;
                            i = i5;
                            e.printStackTrace();
                            i3 = i2;
                            z3 = z;
                            i4 = i;
                            z2 = false;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    i = i5;
                    z = z3;
                    e.printStackTrace();
                    i3 = i2;
                    z3 = z;
                    i4 = i;
                    z2 = false;
                }
                try {
                    if (execute.body().data == null || execute.body().data.getPages().getDocs() == null) {
                        i = i5;
                    } else {
                        if (ay != null) {
                            ay.setStatus(2);
                            ay.save();
                        } else {
                            String str4 = TAG;
                            f.D(str4, "DB error, missing DownloadComicEpisodeObject, episodeId = " + str2);
                        }
                        int i6 = 0;
                        while (i6 < execute.body().data.getPages().getDocs().size()) {
                            ComicPageObject comicPageObject = execute.body().data.getPages().getDocs().get(i6);
                            String ec = c.ec();
                            File file = new File(ec, str2 + "/" + comicPageObject.getMedia().getPath());
                            if (!file.exists() && !file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            try {
                                g.a(g.b(comicPageObject.getMedia()), file, z2);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            DownloadComicPageObject downloadComicPageObject = new DownloadComicPageObject(str, str2, ec, comicPageObject);
                            com.picacomic.fregata.utils.b.a(downloadComicPageObject);
                            String str5 = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Downloaded ");
                            sb.append(str2);
                            sb.append(" Image");
                            int i7 = i6 + 1;
                            sb.append(i7);
                            sb.append("/");
                            sb.append(total);
                            sb.append(": ");
                            sb.append(file.getAbsolutePath());
                            sb.append("\n");
                            sb.append(downloadComicPageObject);
                            f.F(str5, sb.toString());
                            int i8 = total;
                            i = i5;
                            try {
                                a(str, str2, title2, title, (i4 * limit) + i6 + 1, i8);
                                i6 = i7;
                                total = i8;
                                i5 = i;
                                z2 = false;
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                                i3 = i2;
                                z3 = z;
                                i4 = i;
                                z2 = false;
                            }
                        }
                        i = i5;
                        if (ay != null) {
                            ay.setStatus(4);
                            ay.save();
                        } else {
                            String str6 = TAG;
                            f.D(str6, "DB error, missing DownloadComicEpisodeObject, episodeId = " + str2);
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    i = i5;
                    e.printStackTrace();
                    i3 = i2;
                    z3 = z;
                    i4 = i;
                    z2 = false;
                }
                i3 = i2;
                z3 = z;
                i4 = i;
                z2 = false;
            }
        }
    }

    private synchronized void a(String str, String str2, String str3, String str4, int i, int i2) {
        this.tU = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(tN);
        intent.putExtra("COMIC_ID", str);
        intent.putExtra("EPISODE_ID", str2);
        intent.putExtra("COMIC_NAME", str3);
        intent.putExtra("EPISODE_TITLE", str4);
        intent.putExtra("PROGRESS_CURRENT", i);
        intent.putExtra("PROGRESS_TOTAL", i2);
        this.tQ.sendBroadcast(intent);
    }
}
