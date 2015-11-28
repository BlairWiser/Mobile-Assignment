package com.example.blair.comfyapp;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
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

import java.io.IOException;

public class ComfyPlayer extends AppCompatActivity {
    MediaPlayer songPlayer;
    MediaPlayer rainPlayer;
    MediaPlayer firePlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfy_player);
        firePlayer = new MediaPlayer();
        rainPlayer = new MediaPlayer();
        songPlayer = new MediaPlayer();
    }

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
                firePlayer.start();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

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
                rainPlayer.start();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

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
                songPlayer.start();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void back(View view) {
        songPlayer.release();
        firePlayer.release();
        rainPlayer.release();
        finish();
    }
}
