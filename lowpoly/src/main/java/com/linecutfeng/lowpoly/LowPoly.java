package com.linecutfeng.lowpoly;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 16-5-11.
 * <p/>
 * LowPoly图片生成器
 */
public final class LowPoly {
    public static Bitmap generate(String inputFile) throws IOException {
        return generate(inputFile, 50, 1, true, Bitmap.CompressFormat.PNG, 100, false);
    }

    /**
     * 生成low poly风格的图片
     *
     * @param inputFile    源图片
     * @param accuracy     精度值，越小精度越高
     * @param scale        缩放，源图片和目标图片的尺寸比例
     * @param fill         是否填充颜色，为false时只绘制线条
     * @param format       输出图片格
     * @param quality      图片质量
     * @param antiAliasing 是否抗锯齿
     * @throws IOException
     */
    public static Bitmap generate(String inputFile, int accuracy, float scale, boolean fill, Bitmap.CompressFormat format, int quality, boolean antiAliasing) throws IOException {
        if (TextUtils.isEmpty(inputFile)) {
            return null;
        }
        Bitmap image = BitmapFactory.decodeFile(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();

        final ArrayList<int[]> collectors = new ArrayList<>();
        ArrayList<int[]> particles = new ArrayList<>();

        int[] pixels = new int[width * height];
        Log.i("icv", "数组大小为：" + pixels.length);
        image.getPixels(pixels, 0, width, 0, 0, width, height);
        Sobel.sobelFromNative(pixels, width, height, collectors);
//        Sobel.sobel(image, new Sobel.SobelCallback() {
//            @Override
//            public void call(int magnitude, int x, int y) {
//                if (magnitude > 20) {
//                    collectors.add(new int[]{x, y});
//                }
//            }
//        });
        Log.i("icv", "特征点处理完成，数目为：" + collectors.size());


        for (int i = 0; i < 100; i++) {
            particles.add(new int[]{(int) (Math.random() * width), (int) (Math.random() * height)});
        }

        int len = collectors.size() / accuracy;
        for (int i = 0; i < len; i++) {
            int random = (int) (Math.random() * collectors.size());
            particles.add(collectors.get(random));
            collectors.remove(random);
        }

        //添加上下左右四个点
        particles.add(new int[]{0, 0});
        particles.add(new int[]{0, height});
        particles.add(new int[]{width, 0});
        particles.add(new int[]{width, height});


        List<Integer> triangles = Delaunay.triangulate(particles);
        Log.i("icv", "三角形处理完成");

        float x1, x2, x3, y1, y2, y3, cx, cy;

        Bitmap out = Bitmap.createBitmap((int) (width * scale), (int) (height * scale), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(out);
        Paint paint = new Paint();
        paint.setAntiAlias(antiAliasing);
        paint.setStyle(fill ? Paint.Style.FILL : Paint.Style.STROKE);

        for (int i = 0; i < triangles.size(); i += 3) {
            x1 = particles.get(triangles.get(i))[0];
            x2 = particles.get(triangles.get(i + 1))[0];
            x3 = particles.get(triangles.get(i + 2))[0];
            y1 = particles.get(triangles.get(i))[1];
            y2 = particles.get(triangles.get(i + 1))[1];
            y3 = particles.get(triangles.get(i + 2))[1];

            cx = (x1 + x2 + x3) / 3;
            cy = (y1 + y2 + y3) / 3;

            Path path = new Path();
            path.moveTo(x1, y1);
            path.lineTo(x2, y2);
            path.lineTo(x3, y3);
            path.close();

            paint.setColor(image.getPixel((int) cx, (int) cy));

            canvas.drawPath(path, paint);
        }
        Log.i("icv", "绘制完成");
        return out;
    }
}
