package com.orm;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.orm.b.e;
import com.orm.b.f;
import com.orm.b.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: SchemaGenerator.java */
/* loaded from: classes.dex */
public class a {
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        for (Class cls : g.r(this.context)) {
            b(cls, sQLiteDatabase);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (Class cls : g.r(this.context)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("select count(*) from sqlite_master where type='table' and name='%s';", com.orm.b.d.b(cls)), null);
            if (rawQuery.moveToFirst() && rawQuery.getInt(0) == 0) {
                b(cls, sQLiteDatabase);
            } else {
                a(cls, sQLiteDatabase);
            }
        }
        b(sQLiteDatabase, i, i2);
    }

    private ArrayList<String> a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(str, null, null, null, null, null, null);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < query.getColumnCount(); i++) {
            arrayList.add(query.getColumnName(i));
        }
        query.close();
        return arrayList;
    }

    private boolean b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z = false;
        try {
            List<String> asList = Arrays.asList(this.context.getAssets().list("sugar_upgrades"));
            Collections.sort(asList, new e());
            for (String str : asList) {
                Log.i(d.SUGAR, "filename : " + str);
                try {
                    int intValue = Integer.valueOf(str.replace(".sql", "")).intValue();
                    if (intValue > i && intValue <= i2) {
                        b(sQLiteDatabase, str);
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                    Log.i(d.SUGAR, "not a sugar script. ignored." + str);
                }
            }
        } catch (IOException e) {
            Log.e(d.SUGAR, e.getMessage());
        }
        return z;
    }

    private void b(SQLiteDatabase sQLiteDatabase, String str) {
        String[] br;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.context.getAssets().open("sugar_upgrades/" + str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            for (String str2 : new com.orm.b.b(sb.toString()).br()) {
                Log.i("Sugar script", str2);
                if (!str2.isEmpty()) {
                    sQLiteDatabase.execSQL(str2);
                }
            }
        } catch (IOException e) {
            Log.e(d.SUGAR, e.getMessage());
        }
        Log.i(d.SUGAR, "Script executed");
    }

    private void a(Class<?> cls, SQLiteDatabase sQLiteDatabase) {
        List<Field> d = g.d(cls);
        String b = com.orm.b.d.b(cls);
        ArrayList<String> a = a(sQLiteDatabase, b);
        ArrayList arrayList = new ArrayList();
        for (Field field : d) {
            String a2 = com.orm.b.d.a(field);
            String c = f.c(field.getType());
            if (field.isAnnotationPresent(com.orm.a.a.class)) {
                a2 = ((com.orm.a.a) field.getAnnotation(com.orm.a.a.class)).name();
            }
            if (!a.contains(a2)) {
                StringBuilder sb = new StringBuilder("ALTER TABLE ");
                sb.append(b);
                sb.append(" ADD COLUMN ");
                sb.append(a2);
                sb.append(" ");
                sb.append(c);
                if (field.isAnnotationPresent(com.orm.a.d.class)) {
                    if (c.endsWith(" NULL")) {
                        sb.delete(sb.length() - 5, sb.length());
                    }
                    sb.append(" NOT NULL");
                }
                arrayList.add(sb.toString());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Log.i(d.SUGAR, str);
            sQLiteDatabase.execSQL(str);
        }
    }

    protected String a(Class<?> cls) {
        Log.i(d.SUGAR, "Create table if not exists");
        List<Field> d = g.d(cls);
        String b = com.orm.b.d.b(cls);
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(b);
        sb.append(" ( ID INTEGER PRIMARY KEY AUTOINCREMENT ");
        for (Field field : d) {
            String a = com.orm.b.d.a(field);
            String c = f.c(field.getType());
            if (c != null && !a.equalsIgnoreCase("Id")) {
                if (field.isAnnotationPresent(com.orm.a.a.class)) {
                    com.orm.a.a aVar = (com.orm.a.a) field.getAnnotation(com.orm.a.a.class);
                    String name = aVar.name();
                    sb.append(", ");
                    sb.append(name);
                    sb.append(" ");
                    sb.append(c);
                    if (aVar.bq()) {
                        if (c.endsWith(" NULL")) {
                            sb.delete(sb.length() - 5, sb.length());
                        }
                        sb.append(" NOT NULL");
                    }
                    if (aVar.bp()) {
                        sb.append(" UNIQUE");
                    }
                } else {
                    sb.append(", ");
                    sb.append(a);
                    sb.append(" ");
                    sb.append(c);
                    if (field.isAnnotationPresent(com.orm.a.d.class)) {
                        if (c.endsWith(" NULL")) {
                            sb.delete(sb.length() - 5, sb.length());
                        }
                        sb.append(" NOT NULL");
                    }
                    if (field.isAnnotationPresent(com.orm.a.f.class)) {
                        sb.append(" UNIQUE");
                    }
                }
            }
        }
        if (cls.isAnnotationPresent(com.orm.a.c.class)) {
            String value = ((com.orm.a.c) cls.getAnnotation(com.orm.a.c.class)).value();
            sb.append(", UNIQUE(");
            String[] split = value.split(",");
            for (int i = 0; i < split.length; i++) {
                sb.append(com.orm.b.d.z(split[i]));
                if (i < split.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(") ON CONFLICT REPLACE");
        }
        sb.append(" ) ");
        Log.i(d.SUGAR, "Creating table " + b);
        return sb.toString();
    }

    private void b(Class<?> cls, SQLiteDatabase sQLiteDatabase) {
        String a = a(cls);
        if (a.isEmpty()) {
            return;
        }
        try {
            sQLiteDatabase.execSQL(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
