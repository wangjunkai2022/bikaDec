package com.picacomic.fregata.utils.ChatroomGame;

import android.graphics.Canvas;
/* compiled from: ChatroomGameLoopThread.java */
/* loaded from: classes.dex */
public class b extends Thread {
    private ChatroomGameView tX;
    private boolean tY = false;

    public b(ChatroomGameView chatroomGameView) {
        this.tX = chatroomGameView;
    }

    public void setRunning(boolean z) {
        this.tY = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Canvas canvas;
        Throwable th;
        while (this.tY) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                canvas = this.tX.getHolder().lockCanvas();
                try {
                    synchronized (this.tX.getHolder()) {
                        this.tX.j(canvas);
                    }
                    if (canvas != null) {
                        this.tX.getHolder().unlockCanvasAndPost(canvas);
                    }
                    long currentTimeMillis2 = 33 - (System.currentTimeMillis() - currentTimeMillis);
                    if (currentTimeMillis2 > 0) {
                        try {
                            sleep(currentTimeMillis2);
                        } catch (Exception unused) {
                        }
                    } else {
                        sleep(10L);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (canvas != null) {
                        this.tX.getHolder().unlockCanvasAndPost(canvas);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                canvas = null;
                th = th3;
            }
        }
    }
}
