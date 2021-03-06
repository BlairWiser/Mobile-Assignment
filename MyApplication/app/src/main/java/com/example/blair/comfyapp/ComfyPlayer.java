package com.example.blair.comfyapp;

/**
 * ComfyPlayer activity allows the user to play various ambient sounds.
 * An image is also displayed that the user can change by giving a url in the preferences activity
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class ComfyPlayer extends AppCompatActivity implements ImageListener {

    MediaPlayer songPlayer;
    MediaPlayer rainPlayer;
    MediaPlayer firePlayer;

    @Override
    /**
     *  Initialize MediaPlayer objects and call a DownloadImageTask
     *  to get an image to display
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfy_player);
        firePlayer = new MediaPlayer();
        rainPlayer = new MediaPlayer();
        songPlayer = new MediaPlayer();

        String name = "ComfyApp";
        SharedPreferences prefs = getSharedPreferences(name, Activity.MODE_PRIVATE);
        String urlName = prefs.getString("urlName", "http://i.imgur.com/q9wAxs7.jpg");

        DownloadImageTask task = new DownloadImageTask(this);
        task.execute(urlName);
    }

    /**
     * Handler function for fireplace button.
     * Starts/stops the fireplace audio
     * @param view The calling button
     */
    public void playFire(View view){
        if(firePlayer.isPlaying()){
            firePlayer.stop();
        }else{
            try{
                firePlayer.reset();
                AssetFileDescriptor fd;
                fd = getAssets().openFd("fireplace.mp3");
                firePlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                firePlayer.prepare();
                firePlayer.setLooping(true);
                firePlayer.start();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Handler function for rain button.
     * Starts/stops the rain audio
     * @param view The calling button
     */
    public void playRain(View view){
        if(rainPlayer.isPlaying()){
            rainPlayer.stop();
        }else{
            try{
                rainPlayer.reset();
                AssetFileDescriptor fd;
                fd = getAssets().openFd("rain.mp3");
                rainPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                rainPlayer.prepare();
                rainPlayer.setVolume(0.6f, 0.6f);
                rainPlayer.setLooping(true);
                rainPlayer.start();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Handler function for song button.
     * Starts/stops the song audio
     * @param view The calling button
     */
    public void playSong(View view) {
        if(songPlayer.isPlaying()){
            songPlayer.stop();
        }else{
            try{
                songPlayer.reset();
                AssetFileDescriptor fd;
                fd = getAssets().openFd("soothing.mp3");
                songPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                songPlayer.prepare();
                songPlayer.setLooping(true);
                songPlayer.start();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Handler function for the return button
     * Closes media resources and returns to MainMenu activity
     * @param view
     */
    public void back(View view) {
        songPlayer.stop();
        songPlayer.release();
        firePlayer.stop();
        firePlayer.release();
        rainPlayer.stop();
        rainPlayer.release();
        finish();
    }

    /**
     * Listener function that responds to DownloadImageTask async task
     * Sets the resulting image to be the content of the image view
     * @param image The resulting image from DownloadImageTask
     */
    public void setImage(Bitmap image) {
        if (image == null){
            SharedPreferences pref = getSharedPreferences("ComfyApp", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("urlName", "http://i.imgur.com/q9wAxs7.jpg");
            editor.apply();
        }
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(image);
    }
}
