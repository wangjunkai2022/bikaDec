package com.picacomic.fregata.utils;

import com.picacomic.fregata.objects.databaseTable.DbComicDetailObject;
import com.picacomic.fregata.objects.databaseTable.DbComicViewRecordObject;
import com.picacomic.fregata.objects.databaseTable.DownloadComicEpisodeObject;
import com.picacomic.fregata.objects.databaseTable.DownloadComicPageObject;
import java.util.List;
/* compiled from: DBHelper.java */
/* loaded from: classes.dex */
public class b {
    public static final String TAG = "b";

    public static DbComicDetailObject aw(String str) {
        List find = DbComicDetailObject.find(DbComicDetailObject.class, "comic_id = ?", str);
        if (find == null || find.size() == 0) {
            return null;
        }
        return (DbComicDetailObject) find.get(0);
    }

    public static boolean a(DbComicDetailObject dbComicDetailObject) {
        if (dbComicDetailObject == null || dbComicDetailObject.getComicId() == null) {
            return false;
        }
        if (aw(dbComicDetailObject.getComicId()) != null) {
            DbComicDetailObject aw = aw(dbComicDetailObject.getComicId());
            aw.updateDbComicDetailObject(dbComicDetailObject);
            aw.save();
            f.D(TAG, aw.toString());
            return true;
        }
        dbComicDetailObject.save();
        f.D(TAG, dbComicDetailObject.toString());
        return true;
    }

    public static DbComicViewRecordObject ax(String str) {
        List find = DbComicViewRecordObject.find(DbComicViewRecordObject.class, "comic_id = ?", str);
        if (find == null || find.size() == 0) {
            return null;
        }
        return (DbComicViewRecordObject) find.get(0);
    }

    public static boolean a(DbComicViewRecordObject dbComicViewRecordObject) {
        if (dbComicViewRecordObject == null || dbComicViewRecordObject.getComicId() == null) {
            return false;
        }
        if (ax(dbComicViewRecordObject.getComicId()) != null) {
            DbComicViewRecordObject ax = ax(dbComicViewRecordObject.getComicId());
            ax.updateDbComicViewRecordObject(dbComicViewRecordObject);
            ax.save();
            return true;
        }
        dbComicViewRecordObject.save();
        return true;
    }

    public static DownloadComicEpisodeObject ay(String str) {
        List find = DownloadComicEpisodeObject.find(DownloadComicEpisodeObject.class, "episode_id = ?", str);
        if (find == null || find.size() == 0) {
            return null;
        }
        String str2 = TAG;
        f.E(str2, "Load Ep DB object size = " + find.size());
        return (DownloadComicEpisodeObject) find.get(0);
    }

    public static DownloadComicPageObject az(String str) {
        List find = DownloadComicPageObject.find(DownloadComicPageObject.class, "comic_page_id = ?", str);
        if (find == null || find.size() == 0) {
            return null;
        }
        String str2 = TAG;
        f.E(str2, "Load Page DB object size = " + find.size());
        return (DownloadComicPageObject) find.get(0);
    }

    public static boolean a(DownloadComicPageObject downloadComicPageObject) {
        if (downloadComicPageObject == null || downloadComicPageObject.getComicPageId() == null) {
            return false;
        }
        if (az(downloadComicPageObject.getComicPageId()) != null) {
            DownloadComicPageObject az = az(downloadComicPageObject.getComicPageId());
            az.updateWithDownloadComicPageObject(downloadComicPageObject);
            az.save();
            String str = TAG;
            f.E(str, "Update Page: " + downloadComicPageObject);
            return true;
        }
        downloadComicPageObject.save();
        String str2 = TAG;
        f.E(str2, "Save Page: " + downloadComicPageObject);
        return true;
    }
}
