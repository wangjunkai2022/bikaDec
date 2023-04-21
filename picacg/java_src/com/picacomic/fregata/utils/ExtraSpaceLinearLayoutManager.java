package com.picacomic.fregata.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class ExtraSpaceLinearLayoutManager extends LinearLayoutManager {
    @Override // android.support.v7.widget.LinearLayoutManager
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        return 2;
    }

    public ExtraSpaceLinearLayoutManager(Context context) {
        super(context);
    }

    public ExtraSpaceLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public ExtraSpaceLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
