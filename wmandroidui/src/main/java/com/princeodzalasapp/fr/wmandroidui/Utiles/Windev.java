package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import fr.pcsoft.wdjava.core.WDIndirection;
import fr.pcsoft.wdjava.core.WDObjet;
import fr.pcsoft.wdjava.core.application.WDAppManager;
import fr.pcsoft.wdjava.core.application.WDCollProc;
import fr.pcsoft.wdjava.core.debug.a;
import fr.pcsoft.wdjava.ui.activite.g;
import fr.pcsoft.wdjava.ui.champs.f;

public class Windev extends WDCollProc {

    private static final String z = z(z("h3~],\r4s\u0018#LpdÑ,X ÿJ.Y9yVoI%6[ @ yK.C$6H=D>uQ?L<6\\hX>6['L=f\u0018+H cQ<\r4c\u0018,B4s\u0018!L$\u007f^"));

    public Windev() {
    }

    public static final Activity __getCtxAndroidInternal() {
        return g.a();
    }

    public static final Activity getActiviteEnCours() {
        return __getCtxAndroidInternal();
    }

    public static final Activity getCurrentActivity() {
        return getActiviteEnCours();
    }

    public static final Context getContexteApplication() {
        return WDAppManager.k();
    }

    public static final Context getApplicationContext() {
        return getContexteApplication();
    }

    public static View getView(String var0) {
        try {
            WDObjet var1 = WDIndirection.get2(var0, 4);

            try {
                if (var1 == null || !var1.isChamp()) {
                    return null;
                }
            } catch (Exception var3) {
                throw var3;
            }

            Object var2 = ((f)var1).getUIComp();
            if (var2 instanceof View) {
                return (View)var2;
            }
        } catch (Exception var4) {
            a.b(z, var4);
        }

        return null;
    }

    public static final int getIdRessource(String var0) {
        return fr.pcsoft.wdjava.core.ressources.a.h(var0);
    }

    public static final int getIdResource(String var0) {
        return getIdRessource(var0);
    }

    public static char[] z(String var0) {
        char[] var10000 = var0.toCharArray();
        if (var10000.length < 2) {
            var10000[0] = (char)(var10000[0] ^ 79);
        }

        return var10000;
    }

    public static String z(char[] var0) {
        int var10002 = var0.length;
        char[] var10001 = var0;
        int var10000 = var10002;

        for(int var1 = 0; var10000 > var1; ++var1) {
            char var10004 = var10001[var1];
            byte var10005;
            switch(var1 % 5) {
                case 0:
                    var10005 = 45;
                    break;
                case 1:
                    var10005 = 80;
                    break;
                case 2:
                    var10005 = 22;
                    break;
                case 3:
                    var10005 = 56;
                    break;
                default:
                    var10005 = 79;
            }

            var10001[var1] = (char)(var10004 ^ var10005);
        }

        return (new String(var10001)).intern();
    }

}
