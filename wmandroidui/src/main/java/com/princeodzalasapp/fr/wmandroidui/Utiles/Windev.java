package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class Windev extends Application {

    private static Context q;

    public Windev() {
    }

    public static final Context getContexteApp() {
        return k();
    }

    public static final Context getAppContext() {
        return getContexteApp();
    }

    public static final Context k() {
        return q;
    }
    public static final Resources d() {
        return q.getResources();
    }
    public static void appelProcedureWL(String var0, String var1) {
        a(var0, var1);
    }

    private static final String[] z;

    private static int a(String var0, String var1) {
        Resources var2 = d();
        String var3 = k().getPackageName();
        int var4 = var2.getIdentifier(var0, var1, var3);
        if (var4 == 0) {
            String var5 = aa(z[4], new String[]{var3, var1, var0});
            var4 = var2.getIdentifier(var5, (String)null, (String)null);
        }

        return var4;
    }

    public static String aa(String var0, String... var1) {
        StringBuffer var2 = new StringBuffer(var0.length());
        if (var1 == null) {
            var1 = new String[0];
        }

        int var3 = 0;

        int var6;
        for(int var4 = var0.indexOf(37); var4 != -1; var4 = var0.indexOf(37, var6)) {
            String var5 = "";

            for(var6 = var4 + 1; var6 < var0.length() && Character.isDigit(var0.charAt(var6)); ++var6) {
                var5 = var5 + var0.charAt(var6);
            }

            var2.append(var0.substring(var3, var4));
            if (!var5.equals("")) {
                int var7 = Integer.parseInt(var5);
                if (var7 > 0 && var7 <= var1.length) {
                    if (var1[var7 - 1] == null) {
                        for(int var8 = var7; var8 < var1.length; ++var8) {
                            if (var1[var8] != null) {
                                var2.append(var1[var8]);
                            }
                        }

                        return var2.toString();
                    }

                    var2.append(var1[var7 - 1]);
                }

                var3 = var6;
            } else if (var6 < var0.length() && var0.charAt(var6) == '%') {
                var2.append('%');
                ++var6;
                var3 = var6;
            } else {
                var3 = var6 - 1;
            }
        }

        var2.append(var0.substring(var3, var0.length()));
        return var2.toString();
    }

    public static final String c;
    public static final String d;
    public static final String r;
    public static final String b;
    public static final String g;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String i;
    public static final String j;
    public static final String h;
    public static final String f;

    static {
        String[] var10000 = new String[20];
        g = z(z("^BAVF,\u0016"));
        m = z(z("^BAVA&\u0016"));
        f = z(z("^BAVAf"));
        i = z(z("^BAVDA\u0013I"));
        d = z(z("^BAV"));
        r = z(z("^BAVD(\u0016"));
        b = z(z("^BAVG*\u0016"));
        j = z(z("^BAVGf"));
        h = z(z("^BAVFf"));
        o = z(z("^BAVDf"));
        c = z(z("=\u0005bf&Jc|\u001cV"));
        n = z(z("^BAVC*\u0016"));
        var10000[0] = z(z("zTPH\u0014|JT"));
        var10000[1] = z(z("sC_J"));
        var10000[2] = z(z("\u007fHXR"));
        var10000[3] = z(z("mRHS\u0010"));
        var10000[4] = z(z(";\u0017\u000b\u001aG1\u0003\u0002"));
        var10000[5] = z(z("_SRJ\u001b{\u0006XR\u0014yC\u0011[\u0010>J\u0016^\u0005nJX\\\u0014jO^QUpC\u0011\\\u001alTTL\u0005qHU\u001f\u0014k\u0006_P\u0018>\u001c\u0011"));
        var10000[6] = z(z("rGHP\u0000j"));
        var10000[7] = z(z("\u0013,"));
        var10000[8] = z(z("[EYZ\u0016>BT\u001f\u00199CIK\u0007\u007fEEV\u001ap\u0006PJ\u0001qKPK\u001coST\u001f\u0011{\u0006]^UlCBL\u001akTRZU"));
        var10000[9] = z(z("$\t\u001e"));
        var10000[10] = z(z("\u007fHUM\u001awB\u001fM\u0010mIDM\u0016{\u001c\u001e\u0010"));
        var10000[11] = z(z("WKAP\u0006mOSS\u0010>B\u0016P\u0000hTXMUkH\u0011Y\u0019k^\u0011Z\u001b>JT\\\u0001kTT\u001f\u0006kT\u0011S\u0014>TTL\u0006qSC\\\u0010>\u001c\u0011"));
        var10000[12] = z(z("lGF"));
        var10000[13] = z(z("ACIZ\u0016"));
        var10000[14] = z(z("=h~r*Lcaz'Jixm0Ao\u007fi4Rouz"));
        var10000[15] = z(z("=ttl&Qsc|0Ao\u007fk'Qsg~7Rc"));
        var10000[16] = z(z("rOSL"));
        var10000[17] = z(z("=cik'_eev:Pycz&Midm6[yxr%Qubv7Rc"));
        var10000[18] = z(z("WKAP\u0006mOSS\u0010>BT\u001f\u0016vGCX\u0010l\u0006]^UnI]V\u0016{\u0006AZ\u0007mI_Q\u0014rOBÖ\u00100"));
        var10000[19] = z(z("wB"));
        z = var10000;
        q = null;
    }

    private static char[] z(String var0) {
        char[] var10000 = var0.toCharArray();
        if (var10000.length < 2) {
            var10000[0] = (char)(var10000[0] ^ 117);
        }

        return var10000;
    }

    private static String z(char[] var0) {
        int var10002 = var0.length;
        char[] var10001 = var0;
        int var10000 = var10002;

        for(int var1 = 0; var10000 > var1; ++var1) {
            char var10004 = var10001[var1];
            byte var10005;
            switch(var1 % 5) {
                case 0:
                    var10005 = 30;
                    break;
                case 1:
                    var10005 = 38;
                    break;
                case 2:
                    var10005 = 49;
                    break;
                case 3:
                    var10005 = 63;
                    break;
                default:
                    var10005 = 117;
            }

            var10001[var1] = (char)(var10004 ^ var10005);
        }

        return (new String(var10001)).intern();
    }


}
