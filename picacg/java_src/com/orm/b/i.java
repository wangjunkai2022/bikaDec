package com.orm.b;

import android.database.Cursor;
import android.database.CursorWrapper;
/* compiled from: SugarCursor.java */
/* loaded from: classes.dex */
public class i extends CursorWrapper {
    public i(Cursor cursor) {
        super(cursor);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        try {
            return super.getColumnIndexOrThrow(str);
        } catch (IllegalArgumentException e) {
            if (str.equals("_id")) {
                return super.getColumnIndexOrThrow("ID");
            }
            throw e;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndex(String str) {
        if (str.equals("_id")) {
            str = "ID";
        }
        return super.getColumnIndex(str);
    }
}
