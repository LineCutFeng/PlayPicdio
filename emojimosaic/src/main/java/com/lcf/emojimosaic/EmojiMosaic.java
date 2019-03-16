package com.lcf.emojimosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

import com.lcf.emojimosaic.quadtree.Point;
import com.lcf.emojimosaic.quadtree.PoissonDiscSampler;
import com.lcf.emojimosaic.quadtree.QuadTree;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhou on 16-5-11.
 * <p/>
 * LowPoly图片生成器
 */
public final class EmojiMosaic {

    BitmapCache bitmapLruCache;
    final String emojiColors[] = {"#859fb8", "#819cb6", "#7b98b4", "#7f9bb6", "#7e9ab4", "#7e9ab5", "#7e9ab5", "#819cb6", "#7a97b2", "#809cb6", "#7f9ab5", "#313131", "#313131", "#c9291a", "#c72b1c", "#353535", "#819ab1", "#89a0b5", "#88a0b5", "#88a1ba", "#88a1b9", "#87a1ba", "#87a1b9", "#869eb4", "#859db3", "#878787", "false", "#8ba4bc", "#86a1ba", "#889fb5", "#8da3b8", "false", "false", "#3eabd0", "#343434", "#cfcfcf", "#849fb8", "#819cb6", "#cfcfcf", "#333333", "#cacaca", "#383838", "#eba52c", "#bfc3cf", "#a72c31", "#6f6f6f", "false", "false", "#ba8d6a", "#dea635", "#a55ebc", "#a45fbb", "#a764bd", "#a05cb8", "#a561bb", "#a764bd", "#aa68bf", "#a862be", "#a35dba", "#a764bd", "#a664bc", "#a660bd", "#2d2d2d", "#282828", "#d45d4e", "#c84838", "#cb2d1d", "#2d8e3a", "#367ddc", "#45607d", "#cfb235", "#efa631", "#cacaca", "#474747", "false", "false", "#8b878c", "#d9c4a3", "#a865be", "false", "#83776c", "false", "#6a7014", "false", "false", "#7e3524", "false", "#31b836", "false", "#c8c8c8", "#c39875", "#c3a080", "#bb906d", "false", "false", "#212121", "#262626", "#eaa41a", "#39b351", "#f19b49", "#a6c1e2", "#39b551", "#cf2b1b", "#45bb4a", "#d53020", "#c6c6c6", "#b9b9b9", "#c92919", "#ca4535", "#262626", "#252525", "#262626", "#89a2bb", "#292929", "#3393dd", "#8099b1", "#819ab1", "#86a0b9", "#849eb7", "#87a1b9", "#333333", "#e0e0e0", "#deb967", "#ca2a1a", "#272727", "#cc971c", "#db5542", "#da5a48", "false", "#c6a48f", "#a19b98", "#d04b3c", "#d15243", "#d14e3f", "#337edd", "#d35e50", "#cb4c42", "#829db7", "#859db4", "#a677c1", "#88a1b9", "#809ab4", "#809bb5", "#ca4b40", "#849cb3", "#f19842", "#d83c16", "false", "false", "false", "false", "false", "#dab0ac", "#a79ea4", "false", "false", "#849eb8", "#347edd", "#f19e52", "#41b758", "#d45849", "#6954bd", "#d75544", "#e26856", "#f29c4e", "#f39b48", "#f29d4c", "#db6595", "#f29d4f", "#db0000", "#cb8943", "#175cda", "#adbec3", "#b73b57", "false", "false", "false", "false", "false", "false", "false", "#4d5e7b", "false", "false", "false", "false", "false", "#6386a3", "#494c5a", "#6d6a60", "false", "false", "#e8d476", "false", "false", "false", "#e9be4b", "#606372", "#d4b955", "#d5ba56", "#ddc458", "#daa02b", "false", "false", "false", "#2e8818", "#5b680f", "#637312", "#457b2b", "#3f7e2a", "false", "#c88d95", "#9c3415", "false", "false", "#c09422", "false", "#54732a", "false", "#3ca32b", "false", "false", "#639328", "false", "false", "false", "false", "false", "#c27165", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "#9d652e", "false", "false", "#946141", "false", "#848678", "#bfbfbf", "false", "false", "false", "false", "false", "#8d634d", "false", "false", "#ae4133", "false", "#dfc9d5", "false", "false", "#bcb3a6", "#5e3413", "false", "false", "false", "false", "false", "false", "#c49583", "false", "false", "#524e40", "false", "false", "false", "false", "false", "false", "false", "false", "#c0c6b0", "#b84281", "false", "#c4afac", "#b56a15", "#63741c", "false", "false", "false", "#b4333c", "false", "false", "false", "#ab9693", "false", "false", "false", "#7a9ab1", "false", "#88202c", "#3e3933", "false", "false", "#9e8d92", "false", "false", "#262626", "#8ca4bb", "false", "false", "false", "false", "#aaa566", "false", "false", "#3e3e3f", "false", "false", "#414141", "#c0bebe", "false", "#628565", "#7977c4", "#171717", "false", "#8d4c20", "#8f8f91", "false", "false", "#232323", "#4daada", "false", "#17b290", "false", "false", "#b1a999", "false", "false", "false", "false", "false", "false", "#3f9fa0", "#8d866e", "false", "#9fa6ad", "#998e7e", "false", "#9a8d8e", "#718487", "false", "#907774", "#9a6d85", "false", "#9c965b", "#8e9199", "false", "false", "#8aa49b", "false", "#938986", "#d8cac9", "#a26d3a", "#453d3e", "#7d7774", "false", "false", "#d2c9c7", "false", "#447d4e", "#5f8159", "#7f92aa", "false", "#017633", "#4a3f15", "#c4bd9d", "#cac7b4", "#a7997c", "#665335", "#cdaaa1", "#b38b78", "#be9860", "#d2a685", "false", "#867a7e", "#884147", "#ab9e9c", "false", "#242423", "false", "false", "false", "false", "false", "#447536", "false", "false", "false", "false", "false", "false", "false", "#b58a52", "false", "#157a82", "#9d9194", "false", "#987c30", "#897f81", "#b39338", "#497547", "#35708d", "#675735", "false", "false", "#b7848e", "#176a30", "false", "false", "#8f6e33", "#868685", "#b96e81", "#c32226", "#9f9d98", "#c7a080", "#c9a07e", "false", "#9f6573", "#bf9e7f", "#c8a586", "#c2a081", "#c2a082", "#c39a78", "#bc9d80", "#bd9473", "#c29876", "#c69d7c", "#c49872", "#c19f80", "false", "false", "#5d6368", "false", "#5a6f91", "#38437b", "#0f8e81", "#ac6e23", "#c85873", "#9a5f82", "#bf6a8e", "false", "#c69c66", "#452e26", "#9a9998", "false", "#a59069", "false", "#b01b1e", "#576e88", "#4b5f78", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "#a9876c", "false", "false", "#7b3523", "false", "false", "false", "#687374", "#67557e", "false", "false", "false", "#463d33", "#942217", "false", "#c2858c", "false", "false", "false", "false", "false", "#c3123b", "#cca39b", "false", "#7abfe7", "false", "false", "false", "#8b6769", "false", "#c43b2a", "false", "false", "#ce4893", "false", "#2e7edf", "false", "#eabe4e", "false", "false", "false", "#dc77ca", "false", "#bfb499", "#b52618", "false", "#002f7f", "#f47845", "false", "false", "#a6b7d5", "#7e5a3a", "#c39874", "#cab160", "#cacaca", "#dddddd", "#bc2210", "#c40000", "false", "#2b2b2b", "#161616", "#a59f88", "false", "#9c9782", "false", "false", "false", "#31b54b", "false", "false", "#64524f", "false", "#86898c", "#c7c7c1", "#d0c49d", "#a5adb5", "#98a2aa", "#d4d4d4", "#d9d9d9", "#bd9999", "false", "#979696", "#d2ccd0", "#c7d0de", "#b7bfc5", "#bda994", "#9d261c", "#a8312d", "#898989", "#758198", "#8993a9", "#ced1d5", "#c6af2f", "false", "#bb9a60", "#8d2d2b", "#808f9b", "#658537", "#316388", "#b67327", "false", "false", "#c8ae8f", "#beb4a4", "#464646", "false", "#b0ac9a", "false", "false", "false", "#bba8b1", "#bba4ab", "#99754c", "#a9b0cb", "#c7bfbe", "#c9b5b0", "false", "false", "false", "false", "#9f3e2f", "false", "#b2b2b1", "#474949", "#3e4c56", "#f19949", "#f2a151", "false", "#88a2bb", "false", "false", "false", "false", "#4b4d52", "#86a1bb", "#88a3bd", "#89a3bc", "#212121", "#89a2bc", "#dfb041", "#e5b544", "false", "false", "false", "false", "false", "#302f2a", "false", "false", "false", "false", "#b77931", "false", "false", "false", "false", "#c09993", "#787878", "false", "#282828", "#272727", "#292929", "#292929", "#262626", "false", "#8aa1b6", "#859db3", "#829ab1", "#7f98b0", "#849db3", "#7f98b0", "#e3992c", "#737b85", "#9fa1a4", "false", "#6d6d6d", "#868686", "false", "false", "#909192", "false", "#a263b8", "false", "#cbb23c", "#606060", "#919191", "false", "false", "#e8953b", "#3a73e3", "false", "#3469cf", "false", "false", "#869eb4", "#879eb4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c5c5c5", "#c3c3c3", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c4c4c4", "#c5c5c5", "#c4c4c4", "#c3c3c3", "#c4c4c4", "#c3c3c3", "#c5c5c5", "#c3c3c3", "false", "#b6a8ad", "false", "#638cb5", "#747474", "#ce9c3a", "#d2a347", "false", "#cc9938", "#cc9939", "false", "false", "#be9e48", "false", "#ddab37", "#dda334", "#daa53c", "#dfac36", "#d68c2e", "#a68333", "#dbaa37", "#e1ac37", "#e5b13a", "#dcaa37", "#cfab46", "#dca936", "#e3af38", "#d2a033", "#e4af38", "#d79932", "#e1ad37", "#dea534", "#d89d3e", "false", "#d4993c", "#e0ad38", "#dca835", "#dca837", "#c4591d", "#d5aa42", "#d8a635", "#dab14f", "#d6ab41", "#deaa37", "#d8a534", "false", "#cb9934", "#cca03f", "#cc9a34", "#d5a548", "false", "#e4af39", "#dca936", "false", "false", "#d1a034", "false", "#cea33d", "#cd9a30", "#e7b239", "false", "#a28534", "false", "#a78935", "#aa7b2c", "#b29131", "#b78e2f", "#b79533", "#ac913b", "#a98d3b", "false", "false", "false", "false", "#8d744d", "false", "false", "#b39d83", "false", "false", "false", "false", "false", "false", "false", "false", "#7f88b0", "false", "#525959", "false", "#575853", "#4f5553", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "#346387", "false", "#2e614e", "false", "false", "false", "false", "false", "#5f5c43", "false", "false", "false", "false", "#5b574e", "false", "false", "#cb5640", "#a3723d", "#c6291a", "false", "#3b82dd", "#7d97b2", "false", "#3077d8", "false", "false", "false", "false", "false", "false", "false", "#97850b", "#2d79db", "#d964c3", "#89a2bb", "#f29c4c", "#a5a5a5", "#3b83de", "false", "false", "#878787", "#347bd9", "#387cd9", "#4989dc", "#3e81db"};

    {
        int maxMemory = (int) (Runtime.getRuntime().totalMemory() / 1024);
        int cacheSize = maxMemory / 4;
        bitmapLruCache = new BitmapCache(cacheSize);
    }

    public Bitmap generate(Context context, InputStream inputStream, OutputStream outputStream) throws IOException {
        return generate(context, inputStream, outputStream, 200, true, Bitmap.CompressFormat.PNG, 100, true);
    }

    /**
     * 生成low poly风格的图片
     *
     * @param inputStream  源图片
     * @param outputStream 输出图片流
     * @param fill         是否填充颜色，为false时只绘制线条
     * @param format       输出图片格
     * @param quality      图片质量
     * @param antiAliasing 是否抗锯齿
     * @throws IOException
     */
    public Bitmap generate(Context context, InputStream inputStream, OutputStream outputStream, float rowCount, boolean fill, Bitmap.CompressFormat format, int quality, boolean antiAliasing) throws IOException {
        try {
            if (inputStream == null) {
                return null;
            }
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            int width = image.getWidth();
            int height = image.getHeight();

            Bitmap out = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(out);
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3f);
            paint.setAntiAlias(antiAliasing);
            paint.setStyle(fill ? Paint.Style.FILL : Paint.Style.STROKE);

            QuadTree quadTree = new QuadTree(width, height);
            PoissonDiscSampler sampler = new PoissonDiscSampler(quadTree);
            sampler.addNumPoints((int) (rowCount * rowCount * height / width));
//        sampler.setNumCandidates(100);
            Point[] points = sampler.toArray();
            Log.i("icv", "特征点提取为：" + points.length);
            Bitmap bitmap = null;
            List<EmojiPoint> emojiList = new ArrayList<>();
            for (Point point : points) {
                int color = image.getPixel(((int) point.getX()), ((int) point.getY()));
                int matchedPosition = matchPosition(context, color);
                EmojiPoint emojiPoint = new EmojiPoint();
                emojiPoint.setPoint(point);
                emojiPoint.setMatchPosition(matchedPosition);
                emojiList.add(emojiPoint);
            }
            Log.i("icv", "匹配图形完成");
            for (EmojiPoint emojiPoint : emojiList) {
                bitmap = matcBitmap(context, emojiPoint.getMatchPosition());
                if (bitmap.isRecycled()) continue;
                Matrix matrix = new Matrix();
                float picWidth = width / 40f;
                float picHeight = width / 40f;
                matrix.postScale(picWidth / bitmap.getWidth(), picHeight / bitmap.getHeight());
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                canvas.save();
                canvas.rotate(new Random().nextInt() * 360, ((float) emojiPoint.getPoint().getX()), ((float) emojiPoint.getPoint().getY()));
                canvas.drawBitmap(bitmap, ((float) emojiPoint.getPoint().getX() + picWidth / 2f), ((float) emojiPoint.getPoint().getY() + picHeight / 2f), paint);
                canvas.restore();
            }
//        for (Point point : points) {
//            int color = image.getPixel(((int) point.getX()), ((int) point.getY()));
//            bitmap = matchPic(context, color);
//            Matrix matrix = new Matrix();
//            float picWidth = width / 48f;
//            float picHeight = width / 48f;
//            matrix.postScale(picWidth / bitmap.getWidth(), picHeight / bitmap.getHeight());
//            bitmap = Bitmap.createBitmap(matchPic(context, color), 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
//            if (bitmap.isRecycled()) continue;
//            canvas.save();
//            canvas.rotate(new Random().nextInt() * 360, ((float) point.getX()), ((float) point.getY()));
//            canvas.drawBitmap(bitmap, ((float) point.getX() + picWidth / 2f), ((float) point.getY() + picHeight / 2f), paint);
//            canvas.restore();
//        }
            Log.i("icv", "绘制完成");
            if (outputStream == null) {
                return out;
            } else {
                out.compress(format, quality, outputStream);
                return out;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bitmapLruCache != null) {
                try {
                    bitmapLruCache.evictAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public int matchPosition(Context context, int color) {
//        String[] stringArray = context.getResources().getStringArray(R.array.emojiColor);
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        int matchPostion = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < emojiColors.length; i++) {
            if (emojiColors[i].equals("false")) {
                continue;
            }
            int matchColor = Color.parseColor(emojiColors[i]);
            int matchRed = (matchColor & 0xff0000) >> 16;
            int matchGreen = (matchColor & 0x00ff00) >> 8;
            int matchBlue = (matchColor & 0x0000ff);
            double tempDistance = Math.pow(matchRed - red, 2) + Math.pow(matchGreen - green, 2) + Math.pow(matchBlue - blue, 2);
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                matchPostion = i;
            }
        }
        return matchPostion;
    }


    public Bitmap matcBitmap(Context context, int matchPostion) {
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
