package com.example.blair.comfyapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 100455689 on 11/27/2015.
 */
public class FontView extends View {

    Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"Rakoon_PersonalUse.ttf");

    public FontView(Context context) {
        super(context);
    }

    public FontView(Context context, AttributeSet attribs) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRGB(250, 250, 250);

        Paint font = new Paint();
        font.setTypeface(typeface);
        font.setTextSize(150f);
        font.setARGB(255, 25, 50, 100);
        font.setStyle(Paint.Style.STROKE);

        int x = 100, y = 100;

        canvas.drawText(getResources().getString(R.string.app_name), x, y, font);
    }
}
