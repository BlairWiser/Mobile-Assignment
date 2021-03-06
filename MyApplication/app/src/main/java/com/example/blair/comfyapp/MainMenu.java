package com.example.blair.comfyapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    /**
     * Handler function for Play button
     * Calls the ComfyPlayer Activity
     * @param view The calling button
     */
   public void callPlayer(View view) {
       Intent playerIntent = new Intent(this, ComfyPlayer.class);
       startActivity(playerIntent);

   }

    public void openPreferences(View view){
        Intent preferencesIntent = new Intent(this, Preferences.class);
        startActivity(preferencesIntent);
    }

}
