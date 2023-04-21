package com.just.agentweb;

import android.os.SystemClock;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: JsCallJava.java */
/* loaded from: classes.dex */
public class ac {
    private static final String[] eD = {"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};
    private HashMap<String, Method> eE;
    private Object eF;
    private String eG;
    private String eH;

    public ac(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.eF = obj;
            this.eG = str;
            this.eE = new HashMap<>();
            Method[] methods = this.eF.getClass().getMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.eG);
            sb.append(" init begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : methods) {
                Log.i("Info", "method:" + method);
                String a = a(method);
                if (a != null) {
                    this.eE.put(a, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.eG);
            sb.append(" call result, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var k = new Date().getTime();var l = f.shift();var m=prompt('");
            sb.append("AgentWeb:");
            sb.append("'+JSON.stringify(");
            sb.append(a("'" + this.eG + "'", "l", com.picacomic.fregata.b.e.TAG, com.picacomic.fregata.utils.f.TAG));
            sb.append("));console.log(\"invoke \"+l+\", time: \"+(new Date().getTime()-k));var g=JSON.parse(m);if(g.CODE!=200){throw\"");
            sb.append(this.eG);
            sb.append(" call result, CODE:\"+g.CODE+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.eG);
            sb.append("=a;console.log(\"");
            sb.append(this.eG);
            sb.append(" init end\")})(window)");
            this.eH = sb.toString();
            sb.setLength(0);
        } catch (Exception e) {
            if (ag.ap()) {
                Log.e("JsCallJava", "init js result:" + e.getMessage());
            }
        }
    }

    private String a(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (String str : eD) {
            if (str.equals(name)) {
                if (ag.ap()) {
                    Log.w("JsCallJava", "method(" + name + ") is unsafe, will be pass");
                    return null;
                }
                return null;
            }
        }
        for (Class<?> cls : parameterTypes) {
            if (cls == String.class) {
                name = name + "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                name = name + "_N";
            } else if (cls == Boolean.TYPE) {
                name = name + "_B";
            } else if (cls == JSONObject.class) {
                name = name + "_O";
            } else if (cls == ad.class) {
                name = name + "_F";
            } else {
                name = name + "_P";
            }
        }
        return name;
    }

    public String ao() {
        return this.eH;
    }

    public String a(WebView webView, JSONObject jSONObject) {
        long uptimeMillis = ag.ap() ? SystemClock.uptimeMillis() : 0L;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString("method");
                JSONArray jSONArray = jSONObject.getJSONArray("types");
                JSONArray jSONArray2 = jSONObject.getJSONArray("args");
                int length = jSONArray.length();
                Object[] objArr = new Object[length];
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = jSONArray.optString(i2);
                    Object obj = null;
                    if ("string".equals(optString)) {
                        string = string + "_S";
                        if (!jSONArray2.isNull(i2)) {
                            obj = jSONArray2.getString(i2);
                        }
                        objArr[i2] = obj;
                    } else if ("number".equals(optString)) {
                        string = string + "_N";
                        i = (i * 10) + i2 + 1;
                    } else if ("boolean".equals(optString)) {
                        string = string + "_B";
                        objArr[i2] = Boolean.valueOf(jSONArray2.getBoolean(i2));
                    } else if ("object".equals(optString)) {
                        string = string + "_O";
                        if (!jSONArray2.isNull(i2)) {
                            obj = jSONArray2.getJSONObject(i2);
                        }
                        objArr[i2] = obj;
                    } else if ("function".equals(optString)) {
                        string = string + "_F";
                        objArr[i2] = new ad(webView, this.eG, jSONArray2.getInt(i2));
                    } else {
                        string = string + "_P";
                    }
                }
                Method method = this.eE.get(string);
                if (method == null) {
                    return a(jSONObject, 500, "not found method(" + string + ") with valid parameters", uptimeMillis);
                }
                if (i > 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    while (i > 0) {
                        int i3 = (i - ((i / 10) * 10)) - 1;
                        Class<?> cls = parameterTypes[i3];
                        if (cls == Integer.TYPE) {
                            objArr[i3] = Integer.valueOf(jSONArray2.getInt(i3));
                        } else if (cls == Long.TYPE) {
                            objArr[i3] = Long.valueOf(Long.parseLong(jSONArray2.getString(i3)));
                        } else {
                            objArr[i3] = Double.valueOf(jSONArray2.getDouble(i3));
                        }
                        i /= 10;
                    }
                }
                return a(jSONObject, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, method.invoke(this.eF, objArr), uptimeMillis);
            } catch (Exception e) {
                ag.a("JsCallJava", "call", e);
                if (e.getCause() != null) {
                    return a(jSONObject, 500, "method execute result:" + e.getCause().getMessage(), uptimeMillis);
                }
                return a(jSONObject, 500, "method execute result:" + e.getMessage(), uptimeMillis);
            }
        }
        return a(jSONObject, 500, "call data empty", uptimeMillis);
    }

    private String a(JSONObject jSONObject, int i, Object obj, long j) {
        String valueOf;
        if (obj == null) {
            valueOf = "null";
        } else if (obj instanceof String) {
            valueOf = "\"".concat(String.valueOf(((String) obj).replace("\"", "\\\""))).concat("\"");
        } else {
            valueOf = String.valueOf(obj);
        }
        String format = String.format("{\"CODE\": %d, \"result\": %s}", Integer.valueOf(i), valueOf);
        if (ag.ap()) {
            Log.d("JsCallJava", "call time: " + (SystemClock.uptimeMillis() - j) + ", request: " + jSONObject + ", result:" + format);
        }
        return format;
    }

    private static String a(String str, String str2, String str3, String str4) {
        return "{obj:" + str + ",method:" + str2 + ",types:" + str3 + ",args:" + str4 + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o(String str) {
        return str.startsWith("AgentWeb:");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject p(String str) {
        try {
            return new JSONObject(str.substring("AgentWeb:".length()));
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(JSONObject jSONObject) {
        return jSONObject.optString("obj");
    }
}
