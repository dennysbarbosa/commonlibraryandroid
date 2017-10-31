package br.com.commonlibraryandroid;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Dennys on 26/09/2017.
 */

public class MsgApresentation {

    private Context context;

    public MsgApresentation(Context context) {
        this.context = context;
    }

    public void showToast(String msg){

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public void showSnack(){

//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
    }
}
