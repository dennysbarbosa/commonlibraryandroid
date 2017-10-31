package br.com.commonlibraryandroid.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static android.view.View.LAYER_TYPE_SOFTWARE;

/**
 * Created by Dennys on 04/07/2017.
 */

public class SettingsImages {

    private Context context;

    public SettingsImages(Context context) {
        this.context = context;
    }

    public String getNameImageById(int idDrawable){

        return context.getResources().getResourceEntryName(idDrawable);
    }

    public Drawable getDrawableByName(String imgName){

        Resources res = context.getResources();
        int resID = getIdImageByName(imgName);

        return res.getDrawable(resID);
    }

    public int getIdImageByName(String name){

        return context.getResources().getIdentifier(name , "drawable", context.getPackageName());
    }

    public void configImage(ImageView imageView, int value){

        Picasso.with(context)
                .load(value)
                .into(imageView);
    }

    public void configImageUrl(ImageView imageView, String url){

        if (url != null &&  !url.equals("")) {

            Picasso.with(context)
                    .load(url)
                    .into(imageView);

        }
    }
}
