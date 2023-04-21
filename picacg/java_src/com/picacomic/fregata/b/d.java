package com.picacomic.fregata.b;

import android.content.Context;
import android.util.Log;
import com.picacomic.fregata.MyApplication;
import com.picacomic.fregata.R;
import com.picacomic.fregata.utils.g;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import okhttp3.CertificatePinner;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: RestClient.java */
/* loaded from: classes.dex */
public class d {
    public static final String TAG = "d";
    public static String tu;
    public static String tv;
    public static String version;
    String[] rA;
    public String tw;
    public int tx;
    private a ty;

    public d(final Context context) {
        tu = g.au(context);
        version = context.getString(R.string.app_version);
        tv = context.getString(R.string.app_build_version);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        if (com.picacomic.fregata.utils.e.ap(context)) {
            builder.dns(new b());
        }
        this.tx = com.picacomic.fregata.utils.e.aq(context);
        this.rA = context.getResources().getStringArray(R.array.setting_options_image_qualities_server);
        this.tw = this.rA[com.picacomic.fregata.utils.e.R(context)];
        builder.addInterceptor(new Interceptor() { // from class: com.picacomic.fregata.b.d.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                String replace = UUID.randomUUID().toString().replace("-", "");
                String replace2 = request.url().toString().replace("https://picaapi.picacomic.com/", "");
                String str = ((System.currentTimeMillis() / 1000) + com.picacomic.fregata.utils.e.J(context)) + "";
                com.picacomic.fregata.utils.f.D(d.TAG, "SYSTEM TIME = " + (System.currentTimeMillis() / 1000));
                com.picacomic.fregata.utils.f.D(d.TAG, "  PREF TIME = " + com.picacomic.fregata.utils.e.J(context));
                com.picacomic.fregata.utils.f.D(d.TAG, "  DIFF TIME = " + str);
                String c = MyApplication.bx().c(new String[]{"https://picaapi.picacomic.com/", replace2, str, replace, request.method(), "C69BAF41DA5ABD1FFEDC6D2FEA56B", d.version, d.tv});
                com.picacomic.fregata.utils.f.D(d.TAG, "Signature = " + c);
                try {
                    int modifiers = MyApplication.class.getMethods()[0].getModifiers();
                    System.out.println("Modifier of setValue():");
                    System.out.println(Modifier.toString(modifiers));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Response proceed = chain.proceed(request.newBuilder().header("api-key", "C69BAF41DA5ABD1FFEDC6D2FEA56B").header("accept", "application/vnd.picacomic.com.v1+json").header("app-channel", d.this.tx + "").header("time", str).header("nonce", replace).header("signature", c).header("app-version", d.version).header("app-uuid", d.tu).header("image-quality", d.this.tw).header("app-platform", "android").header("app-build-version", d.tv).method(request.method(), request.body()).build());
                String str2 = proceed.headers().get("Server-Time");
                com.picacomic.fregata.utils.f.D(d.TAG, "Server Time = " + str2);
                try {
                    long parseLong = Long.parseLong(str2) - (System.currentTimeMillis() / 1000);
                    com.picacomic.fregata.utils.e.a(context, parseLong);
                    com.picacomic.fregata.utils.f.D(d.TAG, "Save Diff Time = " + parseLong);
                } catch (Exception unused) {
                }
                return proceed;
            }
        });
        new CertificatePinner.Builder().build();
        try {
            f fVar = new f();
            builder.sslSocketFactory(fVar, fVar.systemDefaultTrustManager());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            Log.d(TAG, "Failed to create Socket connection ");
            e.printStackTrace();
        }
        this.ty = (a) new Retrofit.Builder().baseUrl("https://picaapi.picacomic.com/").addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(a.class);
    }

    public a dO() {
        return this.ty;
    }
}
