package com.lcf.watercolor;

import android.graphics.Bitmap;

public class L0SmoothUtils {


    public static Bitmap LOSMooth(int width, int height, Bitmap imageData) {
        int rw = getCeilPower2(width);
        int rh = getCeilPower2(height);
        int maxWidth = 1 << rw;
        int maxHeight = 1 << rh;
        return null;
    }

    private static int getCeilPower2(int number) {
        int r = 1;
        while (Math.pow(2, r) < number) {
            ++r;
        }
        return r;
    }

//    private static void initRGB(imageData, int width, int height, int maxWidth, int maxHeight){
//
//    }
}
