package com.lcf.simpleprocess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;

import com.lcf.simpleprocess.util.ValueUtils;

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
                r = ValueUtils.FClamp(r, 0, 255);
                g = ValueUtils.FClamp(g, 0, 255);
                b = ValueUtils.FClamp(b, 0, 255);
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
                r = ValueUtils.FClamp(r, 0, 255);
                g = ValueUtils.FClamp(g, 0, 255);
                b = ValueUtils.FClamp(b, 0, 255);
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
                r = ValueUtils.FClamp(r, 0, 255);
                g = ValueUtils.FClamp(g, 0, 255);
                b = ValueUtils.FClamp(b, 0, 255);
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
                r = ValueUtils.FClamp(r, 0, 255);
                g = ValueUtils.FClamp(g, 0, 255);
                b = ValueUtils.FClamp(b, 0, 255);
                pixels[i] = Color.rgb(r, g, b);
            }
            outPut.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Bitmap tilerefectrgb(String inputPath/*, int nAngle, int nCount, int nSquareSize*/) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(inputPath);
            if (bitmap == null) return null;
            Bitmap outPut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            int[] pOutput = pixels.clone();
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            TileRefectHelper tileRefectHelper = new TileRefectHelper(bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth() / 20, 3, 17, 45);
            for (int i = 0; i < pOutput.length; i++) {
                pOutput[i] = tileRefectHelper.tileRefectOnePixel(pixels, i % bitmap.getWidth(), i / bitmap.getWidth());
            }
            outPut.setPixels(pOutput, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            return outPut;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static class TileRefectHelper {
        private final int aasamples;
        private final int width, height;
        private final double m_sin, m_cos;
        private final double m_scale;
        private final double m_curvature;
        private final double PI = Math.PI;
        private final PointF[] m_aapt;

        public TileRefectHelper(int width, int height, int nSquareSize, int nCurvature, int aasamples, int nAngle) {
            this.width = width;
            this.height = height;
            this.aasamples = aasamples;
            nAngle = ValueUtils.FClamp(nAngle, -45, 45);
            m_sin = Math.sin(Math.toRadians(nAngle));
            m_cos = Math.cos(Math.toRadians(nAngle));
            nSquareSize = ValueUtils.FClamp(nSquareSize, 2, 200);
            m_scale = PI / nSquareSize;
            nCurvature = ValueUtils.FClamp(nCurvature, -20, 20);
            if (nCurvature == 0)
                nCurvature = 1;
            m_curvature = nCurvature * nCurvature / 10.0 * (Math.abs(nCurvature) / nCurvature);
            m_aapt = new PointF[aasamples];
            for (int i = 0; i < m_aapt.length; i++) {
                double x = (i * 4) / (double) aasamples,
                        y = i / (double) aasamples;
                x = x - (int) x;
                m_aapt[i] = new PointF(((float) (m_cos * x + m_sin * y)), (float) (m_cos * y - m_sin * x));
            }
        }

        int tileRefectOnePixel(int[] pPixel, int x, int y) {
            double hw = width / 2.0,
                    hh = height / 2.0,
                    i = x - hw,
                    j = y - hh;
            int b = 0;
            int g = 0;
            int r = 0;
            int a = 0;
            for (int mm = 0; mm < aasamples; mm++) {
                double u = i + m_aapt[mm].x;
                double v = j - m_aapt[mm].y;

                double s = m_cos * u + m_sin * v;
                double t = -m_sin * u + m_cos * v;

                s += m_curvature * Math.tan(s * m_scale);
                t += m_curvature * Math.tan(t * m_scale);
                u = m_cos * s - m_sin * t;
                v = m_sin * s + m_cos * t;

                int xSample = (int) (hw + u);
                int ySample = (int) (hh + v);

                xSample = ValueUtils.FClamp(xSample, 0, width - 1);
                ySample = ValueUtils.FClamp(ySample, 0, height - 1);

                a += Color.alpha(pPixel[ySample * width + xSample]);
                r += Color.red(pPixel[ySample * width + xSample]);
                g += Color.green(pPixel[ySample * width + xSample]);
                b += Color.blue(pPixel[ySample * width + xSample]);
            }
            a = (ValueUtils.FClamp(((float) a) / aasamples, 0f, 255f)).intValue();
            r = (ValueUtils.FClamp(((float) r) / aasamples, 0f, 255f)).intValue();
            g = (ValueUtils.FClamp(((float) g) / aasamples, 0f, 255f)).intValue();
            b = (ValueUtils.FClamp(((float) b) / aasamples, 0f, 255f)).intValue();
            return Color.argb(a, r, g, b);
        }
    }


}
