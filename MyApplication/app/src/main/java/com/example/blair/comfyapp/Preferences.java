package com.example.blair.comfyapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public void backToMenu(View view) {
        finish();
    }
}
