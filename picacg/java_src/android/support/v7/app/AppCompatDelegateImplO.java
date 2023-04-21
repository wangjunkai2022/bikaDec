package android.support.v7.app;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.Window;
/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(26)
/* loaded from: classes.dex */
public class AppCompatDelegateImplO extends AppCompatDelegateImplN {
    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public boolean checkActionBarFocusKey(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImplO(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }
}
