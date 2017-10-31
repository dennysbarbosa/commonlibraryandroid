package br.com.commonlibraryandroid.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Dennys on 24/07/2017.
 */

public class ManageFiles {

    private static final int COD_SHARE = 100;
    private Activity activity;

    public ManageFiles(Activity activity){

        this.activity = activity;
    }
    public void shareTextImage(String mgs, boolean image, String nameFile) {

        try {

            if(image) {

                File f = new File("storage/emulated/0/DCIM/Camera/" + nameFile);
                Uri imageUri = Uri.parse("file://"+ f.getAbsolutePath());
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                activity.startActivity(Intent.createChooser(intent, "Share"));

            }else {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, mgs);
                sendIntent.setType("text/plain");
                activity.startActivityForResult(Intent.createChooser(sendIntent, "My Project"), COD_SHARE);
            }
        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(activity, "falha de compartilhamento", Toast.LENGTH_LONG).show();
        }
    }

}
