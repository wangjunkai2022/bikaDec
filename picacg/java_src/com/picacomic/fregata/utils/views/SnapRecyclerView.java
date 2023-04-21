package com.picacomic.fregata.utils.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class SnapRecyclerView extends RecyclerView {
    int screenWidth;

    public SnapRecyclerView(Context context) {
        super(context);
        setScreenWidth(context);
    }

    public SnapRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setScreenWidth(context);
    }

    public SnapRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScreenWidth(context);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
        View findViewByPosition2 = linearLayoutManager.findViewByPosition(findLastVisibleItemPosition);
        if (findViewByPosition2 != null && findViewByPosition != null) {
            int left = findViewByPosition2.getLeft() - ((this.screenWidth - findViewByPosition2.getWidth()) / 2);
            int width = (((this.screenWidth - findViewByPosition.getWidth()) / 2) + findViewByPosition.getWidth()) - findViewByPosition.getRight();
            if (i > 0) {
                smoothScrollBy(left, 0);
                return true;
            }
            smoothScrollBy(-width, 0);
            return true;
        }
        return super.fling(i, i2);
    }

    private void setScreenWidth(Context context) {
        this.screenWidth = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }
}
