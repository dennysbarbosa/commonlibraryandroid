package br.com.commonlibraryandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Dennys on 02/02/2017.
 */

public class Dispositivo {


    public static boolean isTablet(Context context){

        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        if(manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
            return true;
        }else{
            return false;
        }
    }

    public static boolean verifyVersionDevice(){

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            return true;
        }
        return false;
    }

    public static boolean isRedeDadosAtivada(Context context) {

        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
        return network != null && network.isConnected() && network.isAvailable();
    }

    /*
     * start setting keyboard
     */

    public static int checkConfigKeyboard(Activity activity){

        Rect rectgle= new Rect();
        Window window= activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
        return rectgle.bottom;
    }

    public static boolean keyBoardOpen(Activity activity, int screenSiza)
    {
        Rect rectgle= new Rect();
        Window window= activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
        int curheight= rectgle.bottom;

        if (curheight != screenSiza)
        {
            Log.i("teclado", "Software Keyboard was shown");
            return true;
        }
        else
        {
            Log.i("teclado", "Software Keyboard was Close");
            return false;
        }
    }

    public static void hideSoftKeyBoard(View view) {

        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftKeyBoard(final View view){

        final InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                view.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
                    }

                }, 100);

            }

        });

        view.requestFocus();
    }

    /*
     * end setting keyboard
     */
}
