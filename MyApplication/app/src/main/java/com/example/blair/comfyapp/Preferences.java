package com.example.blair.comfyapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

public class Preferences extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

    }

    public void setImageCall(View view){
        EditText url = (EditText)findViewById(R.id.imageName);
        String urlName = url.getText().toString();

        SharedPreferences pref = getSharedPreferences("ComfyApp", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("urlName", urlName);
        boolean result = editor.commit();
        finish();
    }

    public void resetPref(View view){
        SharedPreferences pref = getSharedPreferences("ComfyApp", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("urlName", null);
        boolean result = editor.commit();
        finish();
    }

    public void backToMenu(View view) {
        finish();
    }
}

//Non implemented pick image from device

/*
    public void pickImage(View view){
        Intent pickPicIntent = new Intent(Intent.ACTION_PICK);
        pickPicIntent.setType("image/*");
        startActivityForResult(pickPicIntent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                Uri selectedPic = intent.getData();
                String uriName = selectedPic.getPath();
                SharedPreferences pref = getSharedPreferences("ComfyApp", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("urlName", uriName);
                boolean result = editor.commit();
                finish();
            }
        }
    }

    */