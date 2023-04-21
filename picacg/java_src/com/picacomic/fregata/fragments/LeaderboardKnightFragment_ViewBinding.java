package com.picacomic.fregata.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class LeaderboardKnightFragment_ViewBinding implements Unbinder {
    private LeaderboardKnightFragment pH;

    @UiThread
    public LeaderboardKnightFragment_ViewBinding(LeaderboardKnightFragment leaderboardKnightFragment, View view) {
        this.pH = leaderboardKnightFragment;
        leaderboardKnightFragment.recyclerView_knight = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView_leaderboard_knight, "field 'recyclerView_knight'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LeaderboardKnightFragment leaderboardKnightFragment = this.pH;
        if (leaderboardKnightFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.pH = null;
        leaderboardKnightFragment.recyclerView_knight = null;
    }
}
