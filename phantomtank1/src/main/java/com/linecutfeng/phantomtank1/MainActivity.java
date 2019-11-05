package com.linecutfeng.phantomtank1;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Bitmap up;
    Bitmap down;
    ImageView iv;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);
        try {
            up = BitmapFactory.decodeStream(getAssets().open("img_up.png"));
            down = BitmapFactory.decodeStream(getAssets().open("img_down.png"));
            Bitmap bitmap = phantomtank(up, down);
            iv.setImageBitmap(bitmap);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "mikumikumiku.png"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bitmap phantomtank(Bitmap up, Bitmap down) {
        int[] upPix = new int[up.getWidth() * up.getHeight()];
        int[] downPix = new int[down.getWidth() * down.getHeight()];
        up.getPixels(upPix, 0, up.getWidth(), 0, 0, up.getWidth(), up.getHeight());
        down.getPixels(downPix, 0, down.getWidth(), 0, 0, down.getWidth(), down.getHeight());
        for (int i = 0; i < upPix.length; i++) {
            int upColor = upPix[i];
            int downColor = downPix[i];
            int upGray = (int) (Color.red(upColor) * 0.299 + Color.green(upColor) * 0.587 + Color.blue(upColor) * 0.114);
            int downGray = (int) (Color.red(downColor) * 0.299 + Color.green(downColor) * 0.587 + Color.blue(downColor) * 0.114);
            upGray = (int) (128 + (255 - 128) * upGray / 255.0f);
            downGray = (int) (0 + (127 - 0) * downGray / 255.0f);
            if (upGray > 255) upGray = 255;
            int alphaValue = 255 - upGray + downGray;
            int v = (int) (downGray / (alphaValue / 255f));
            downPix[i] = Color.argb(alphaValue, v, v, v);
        }
        Bitmap bitmap = Bitmap.createBitmap(down.getWidth(), down.getHeight(), Bitmap.Config.ARGB_8888);
        bitmap.setPixels(downPix, 0, down.getWidth(), 0, 0, down.getWidth(), down.getHeight());
        return bitmap;
    }
}
