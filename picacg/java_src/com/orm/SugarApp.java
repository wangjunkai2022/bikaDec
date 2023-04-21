package com.orm;

import android.app.Application;
/* loaded from: classes.dex */
public class SugarApp extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        b.init(this);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        b.bk();
    }
}
