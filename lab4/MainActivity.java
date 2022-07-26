package com.example.changing_wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
        changewallpaper = findViewById(R.id.button);
        changewallpaper.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               setWallpaper();
           }
        });
    }

    private void setWallpaper(){
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1){
                    drawable = getResources().getDrawable(R.drawable.one);
                    prev = 2;
                } else if(prev==2){
                    drawable = getResources().getDrawable(R.drawable.two);
                    prev=3;
                } else if(prev==3) {
                    drawable = getResources().getDrawable(R.drawable.three);
                    prev = 4;
                }
                Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 30000);
    }
}