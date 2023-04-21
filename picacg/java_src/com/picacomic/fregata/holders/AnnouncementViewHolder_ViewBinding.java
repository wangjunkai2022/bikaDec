package com.picacomic.fregata.holders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.picacomic.fregata.R;
/* loaded from: classes.dex */
public class AnnouncementViewHolder_ViewBinding implements Unbinder {
    private AnnouncementViewHolder sj;

    @UiThread
    public AnnouncementViewHolder_ViewBinding(AnnouncementViewHolder announcementViewHolder, View view) {
        this.sj = announcementViewHolder;
        announcementViewHolder.imageView_image = (ImageView) Utils.findRequiredViewAsType(view, R.id.imageView_announcement_cell_image, "field 'imageView_image'", ImageView.class);
        announcementViewHolder.textView_title = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_announcement_cell_title, "field 'textView_title'", TextView.class);
        announcementViewHolder.textView_description = (TextView) Utils.findRequiredViewAsType(view, R.id.textView_announcement_cell_description, "field 'textView_description'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AnnouncementViewHolder announcementViewHolder = this.sj;
        if (announcementViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.sj = null;
        announcementViewHolder.imageView_image = null;
        announcementViewHolder.textView_title = null;
        announcementViewHolder.textView_description = null;
    }
}
