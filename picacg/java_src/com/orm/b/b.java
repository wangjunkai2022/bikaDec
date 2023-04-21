package com.orm.b;
/* compiled from: MigrationFileParser.java */
/* loaded from: classes.dex */
public class b {
    private String content;

    public b(String str) {
        this.content = str.replaceAll("(\\/\\*([\\s\\S]*?)\\*\\/)|(--(.)*)|(\n)", "");
    }

    public String[] br() {
        return this.content.split(";");
    }
}
