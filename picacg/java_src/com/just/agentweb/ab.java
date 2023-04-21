package com.just.agentweb;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.just.agentweb.AgentWeb;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/* compiled from: JsBaseInterfaceHolder.java */
/* loaded from: classes.dex */
public abstract class ab implements ae {
    private AgentWeb.SecurityType cJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(AgentWeb.SecurityType securityType) {
        this.cJ = securityType;
    }

    public boolean a(Object obj) {
        if (Build.VERSION.SDK_INT >= 17 && c.dv != 2) {
            boolean z = false;
            for (Method method : obj.getClass().getMethods()) {
                Annotation[] annotations = method.getAnnotations();
                int length = annotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (annotations[i] instanceof JavascriptInterface) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    break;
                }
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean an() {
        return this.cJ != AgentWeb.SecurityType.STRICT_CHECK || c.dv == 2 || Build.VERSION.SDK_INT > 17;
    }
}
