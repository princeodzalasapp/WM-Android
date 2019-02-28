package com.princeodzalasapp.fr.wmandroidui.Utiles;

import android.app.Activity;
import android.net.Uri;
import java.io.File;
import android.view.ViewGroup;
import com.github.barteksc.pdfviewer.*;

import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Pdf {

    public static boolean uri(int nIdParent, String sChemin, Activity mActivity){
        PDFView pdfView = new PDFView(getAppContext(mActivity),null);
        ViewGroup parent = (ViewGroup) mActivity.findViewById(nIdParent);
        if(parent != null)	{
            parent.removeAllViews();
            parent.addView(pdfView);
            Uri myUri = Uri.parse(sChemin);
            pdfView.fromUri(myUri).load();
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean chemin(int nIdParent, String sChemin, Activity mActivity){
        PDFView pdfView = new PDFView(getAppContext(mActivity),null);
        ViewGroup parent = (ViewGroup) mActivity.findViewById(nIdParent);
        if(parent != null)	{
            parent.removeAllViews();
            parent.addView(pdfView);
            pdfView.fromFile(new File(sChemin)).load();
            return true;
        }
        else{
            return false;
        }
    }

}
