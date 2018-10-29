package com.linecutfeng.lowpoly;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by zhou on 16-5-11.
 * <p/>
 * 边缘检测算法
 */
final class Sobel {

    private static final int[][] kernelX = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};

    private static final int[][] kernelY = {{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};

    static void sobel(Bitmap image, SobelCallback callback) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixelX = (
                        (kernelX[0][0] * getAvg(image, x - 1, y - 1)) +
                                (kernelX[0][1] * getAvg(image, x, y - 1)) +
                                (kernelX[0][2] * getAvg(image, x + 1, y - 1)) +
                                (kernelX[1][0] * getAvg(image, x - 1, y)) +
                                (kernelX[1][1] * getAvg(image, x, y)) +
                                (kernelX[1][2] * getAvg(image, x + 1, y)) +
                                (kernelX[2][0] * getAvg(image, x - 1, y + 1)) +
                                (kernelX[2][1] * getAvg(image, x, y + 1)) +
                                (kernelX[2][2] * getAvg(image, x + 1, y + 1))
                );
                int pixelY = (
                        (kernelY[0][0] * getAvg(image, x - 1, y - 1)) +
                                (kernelY[0][1] * getAvg(image, x, y - 1)) +
                                (kernelY[0][2] * getAvg(image, x + 1, y - 1)) +
                                (kernelY[1][0] * getAvg(image, x - 1, y)) +
                                (kernelY[1][1] * getAvg(image, x, y)) +
                                (kernelY[1][2] * getAvg(image, x + 1, y)) +
                                (kernelY[2][0] * getAvg(image, x - 1, y + 1)) +
                                (kernelY[2][1] * getAvg(image, x, y + 1)) +
                                (kernelY[2][2] * getAvg(image, x + 1, y + 1))
                );

                int magnitude = (int) Math.sqrt((pixelX * pixelX) + (pixelY * pixelY));
                callback.call(magnitude, x, y);
            }
        }

    }

    /**
     * 计算一个bitmap一像素的rgb平均值
     * @param image
     * @param x
     * @param y
     * @return
     */
    private static int getAvg(Bitmap image, int x, int y) {
        if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight()) {
            return 0;
        }
        int color = image.getPixel(x, y);
        // 计算rgb值
        int blue = 0xFF & color;
        int green = (color >> 8) & 0xFF;
        int red = (color >> 16) & 0xFF;
//        int alpha = (color >> 24) & 0xFF;
        return (blue + green + red) / 3;
    }

    protected interface SobelCallback {
        void call(int magnitude, int x, int y);
    }

}
