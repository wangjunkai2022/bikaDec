package android.support.v7.app;

import android.app.Notification;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
@RequiresApi(24)
/* loaded from: classes.dex */
class NotificationCompatImpl24 {
    NotificationCompatImpl24() {
    }

    public static void addDecoratedCustomViewStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
    }

    public static void addDecoratedMediaCustomViewStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedMediaCustomViewStyle());
    }
}
