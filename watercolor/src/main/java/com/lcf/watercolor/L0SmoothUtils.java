package com.lcf.watercolor;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.Arrays;

public class L0SmoothUtils {

    int[] rgbi;
    int[] rgbr;
    int[] rgbH;
    int[] rgbV;
    int[] rgNr;
    int[] rgbNi;

    public Bitmap LOSMooth(Bitmap imageData) {
        int rw = getCeilPower2(imageData.getWidth());
        int rh = getCeilPower2(imageData.getHeight());
        int maxWidth = 1 << rw;
        int maxHeight = 1 << rh;
        int[] pixels = new int[imageData.getWidth() * imageData.getHeight()];
        initRGB(pixels, imageData.getWidth(), imageData.getHeight(), maxWidth, maxHeight);
        initRGBHV(maxWidth, maxHeight);
        return null;
    }

    private static int getCeilPower2(int number) {
        int r = 1;
        while (Math.pow(2, r) < number) {
            ++r;
        }
        return r;
    }

    private void initRGB(int[] pixels, int width, int height, int maxWidth, int maxHeight) {
        int size = maxWidth * maxHeight;
        rgbi = new int[size];
        rgbr = new int[size];
        Arrays.fill(rgbi, Color.BLACK);
        Arrays.fill(rgbr, Color.BLACK);
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                int index1 = y * maxWidth + x;
                int index2 = y * width + x;
                rgbr[index1] = pixels[index2];
            }
        }
    }

    private void initRGBHV(int maxWidth, int maxHeight) {
        int size = maxWidth * maxHeight;
        rgbH = new int[size];
        rgbV = new int[size];
        rgNr = new int[size];
        rgbNi = new int[size];
    }
}
