package com.lcf.simpleprocess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

public class SimpleProcess {

    public static Bitmap negative(String inputPath) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(inputPath);
            if (bitmap == null) return null;
            Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i = 0; i < pixels.length; i++) {
                int r = Color.red(pixels[i]);
                int g = Color.green(pixels[i]);
                int b = Color.blue(pixels[i]);
                pixels[i] = Color.rgb(255 - r, 255 - g, 255 - b);
            }
            outPut.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap casting(String inputPath) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(inputPath);
            if (bitmap == null) return null;
            Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i = 0; i < pixels.length; i++) {
                int r = Color.red(pixels[i]);
                int g = Color.green(pixels[i]);
                int b = Color.blue(pixels[i]);
                r = (int) (r * 128f / (g + b + 1));
                g = (int) (g * 128f / (r + b + 1));
                b = (int) (b * 128f / (r + g + 1));
                if (r < 0) r = 0;
                if (g < 0) g = 0;
                if (b < 0) b = 0;
                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (b > 255) b = 255;
                pixels[i] = Color.rgb(r, g, b);
            }
            outPut.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap frozen(String inputPath) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(inputPath);
            if (bitmap == null) return null;
            Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i = 0; i < pixels.length; i++) {
                int r = Color.red(pixels[i]);
                int g = Color.green(pixels[i]);
                int b = Color.blue(pixels[i]);
                r = (int) (Math.abs(r - g - b) * 3 / 2f);
                g = (int) (Math.abs(g - b - r) * 3 / 2f);
                b = (int) (Math.abs(b - r - g) * 3 / 2f);
                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (b > 255) b = 255;

                pixels[i] = Color.rgb(r, g, b);
            }
            outPut.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap comicbook(String inputPath) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(inputPath);
            if (bitmap == null) return null;
            Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i = 0; i < pixels.length; i++) {
                int r = Color.red(pixels[i]);
                int g = Color.green(pixels[i]);
                int b = Color.blue(pixels[i]);
                r = (int) (Math.abs(2 * g - b + r) * r / 256f);
                g = (int) (Math.abs(2 * b - g + r) * r / 256f);
                b = (int) (Math.abs(2 * b - g + r) * g / 256f);
                if (r < 0) r = 0;
                if (g < 0) g = 0;
                if (b < 0) b = 0;
                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (b > 255) b = 255;
                pixels[i] = Color.rgb(r, g, b);
            }
            outPut.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap brown(String inputPath) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(inputPath);
            if (bitmap == null) return null;
            Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for (int i = 0; i < pixels.length; i++) {
                int r = Color.red(pixels[i]);
                int g = Color.green(pixels[i]);
                int b = Color.blue(pixels[i]);
                r = (int) (r * 0.393 + g * 0.769 + b * 0.189);
                g = (int) (r * 0.349 + g * 0.686 + b * 0.168);
                b = (int) (r * 0.272 + g * 0.534 + b * 0.131);
                if (r < 0) r = 0;
                if (g < 0) g = 0;
                if (b < 0) b = 0;
                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (b > 255) b = 255;
                pixels[i] = Color.rgb(r, g, b);
            }
            outPut.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
