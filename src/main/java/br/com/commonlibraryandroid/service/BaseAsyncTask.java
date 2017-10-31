package br.com.commonlibraryandroid.service;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Dennys on 03/07/2017.
 */

public abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    Context context;

    public BaseAsyncTask(Context context){

        this.context = context;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Toast.makeText(context, "Erro de Conexão!", Toast.LENGTH_LONG).show();
    }
}
