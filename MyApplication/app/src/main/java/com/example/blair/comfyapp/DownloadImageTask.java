package com.example.blair.comfyapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.net.URL;

import java.io.InputStream;

/**
 * Created by 100455689 on 11/29/2015.
 */
public class DownloadImageTask  extends AsyncTask<String, Void, Bitmap> {

    ImageListener listener;

    public DownloadImageTask(ImageListener listener) {
        this.listener = listener;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap image = null;

        try {
            InputStream in = new URL(url).openStream();
            image = BitmapFactory.decodeStream(in);

        } catch (Exception e) {
            Log.e("error", e.getMessage());
            e.printStackTrace();
        }

        return image;
    }

    protected void onPostExecute(Bitmap result) {
        listener.setImage(result);
    }
}
