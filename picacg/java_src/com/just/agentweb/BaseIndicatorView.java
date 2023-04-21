package com.just.agentweb;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public abstract class BaseIndicatorView extends FrameLayout implements i {
    public FrameLayout.LayoutParams Y() {
        return null;
    }

    @Override // com.just.agentweb.i
    public void hide() {
    }

    @Override // com.just.agentweb.i
    public void reset() {
    }

    @Override // com.just.agentweb.i
    public void setProgress(int i) {
    }

    @Override // com.just.agentweb.i
    public void show() {
    }

    public BaseIndicatorView(Context context) {
        super(context);
    }

    public BaseIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
