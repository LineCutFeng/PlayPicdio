package com.linecutfeng.phantomtank1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
        int[] upPix = new int[up.getWidth() * up.getHeight()];
        int[] downPix = new int[down.getWidth() * down.getHeight()];
        int[] alpha = upPix.clone();
        up.getPixels(upPix, 0, up.getWidth(), 0, 0, up.getWidth(), up.getHeight());
        down.getPixels(downPix, 0, down.getWidth(), 0, 0, down.getWidth(), down.getHeight());
        for (int i = 0; i < upPix.length; i++) {
            int color = upPix[i];
            int r = (color >> 16) & 0xff;
            int g = (color >> 8) & 0xff;
            int b = (color) & 0xff;
            int gray = (int) (r * 0.299 + g * 0.587 + b * 0.114);
            gray = (int) (128 + (255 - 128) * gray / 255.0f);
            if (gray > 255)
                gray = 255;
            upPix[i] = Color.rgb(gray, gray, gray);
        }
        for (int i = 0; i < downPix.length; i++) {
            int color = downPix[i];
            int r = (color >> 16) & 0xff;
            int g = (color >> 8) & 0xff;
            int b = (color) & 0xff;
            int gray = (int) (r * 0.299 + g * 0.587 + b * 0.114);
            gray = (int) (0 + (127 - 0) * gray / 255.0f);
            downPix[i] = Color.rgb(gray, gray, gray);
            alpha[i] = 255 + gray - (upPix[i] & 0xff);
            downPix[i] = Color.argb(alpha[i])
        }
    }
}
