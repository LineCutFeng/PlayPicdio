package com.lcf.emojimosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncBitmapMacher {

    Canvas canvas = null;
    Paint paint = null;
    AtomicInteger lastPointNotProcess = new AtomicInteger(0);
    BitmapCache bitmapLruCache;
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    Bitmap out;

    {
        int maxMemory = (int) (Runtime.getRuntime().totalMemory() / 1024);
        int cacheSize = maxMemory / 4;
        bitmapLruCache = new BitmapCache(cacheSize);
    }

    public AsyncBitmapMacher(boolean antiAliasing, boolean fill, int width, int height) {
        Canvas canvas = new Canvas(out);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3f);
        paint.setAntiAlias(antiAliasing);
        paint.setStyle(fill ? Paint.Style.FILL : Paint.Style.STROKE);
        out = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    }

    Bitmap SynicMatchBitmap(final Context context, final Bitmap image, List<EmojiPoint> emojiList) {
        lastPointNotProcess.set(emojiList.size());
        for (final EmojiPoint emojiPoint : emojiList) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = matcBitmap(context, emojiPoint.getMatchPosition());
                    bitmap = matcBitmap(context, emojiPoint.getMatchPosition());
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    drawOnCanvas(canvas, image, bitmap, emojiPoint);
                }
            });
        }
        while (lastPointNotProcess.get() > 0) {

        }
        return null;
    }

    public synchronized void drawOnCanvas(Canvas canvas, final Bitmap image, Bitmap bitmap, EmojiPoint emojiPoint) {
        Matrix matrix = new Matrix();
        float picWidth = image.getWidth() / 30f;
        float picHeight = image.getWidth() / 30f;
        matrix.postScale(picWidth / bitmap.getWidth(), picHeight / bitmap.getHeight());
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        canvas.save();
        canvas.rotate(new Random().nextInt() * 360, ((float) emojiPoint.getPoint().getX()), ((float) emojiPoint.getPoint().getY()));
        canvas.drawBitmap(bitmap, ((float) emojiPoint.getPoint().getX() + picWidth / 2f), ((float) emojiPoint.getPoint().getY() + picHeight / 2f), paint);
        canvas.restore();
    }

    public synchronized Bitmap matcBitmap(Context context, int matchPostion) {
//
        Bitmap bitmap = bitmapLruCache.get(matchPostion);
        if (bitmap == null) {
            String format = (String.format("%04d", matchPostion + 1) + ".png");
            InputStream open = null;
            try {
                open = context.getResources().getAssets().open("matchPic/" + format);
                bitmap = BitmapFactory.decodeStream(open);
                bitmapLruCache.put(matchPostion, bitmap);
                open.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }
}
