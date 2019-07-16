package com.linecutfeng.phantomtank1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Bitmap up;
    Bitmap down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            up = BitmapFactory.decodeStream(getAssets().open("img_up.png"));
            down = BitmapFactory.decodeStream(getAssets().open("img_down.png"));
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {

    }
}
