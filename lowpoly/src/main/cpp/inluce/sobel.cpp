//
// Created by PC on 2019/2/18.
//

#include "sobel.h"
#include <iostream>
#include <math.h>
#include "android/log.h"
#include <vector>
#include <stdlib.h>

using std::cout;
using std::endl;
using std::vector;
using namespace std;


#define TAG "tc_jni" // 这个是自定义的LOG的标识
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型


#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT void JNICALL
Java_com_linecutfeng_lowpoly_Sobel_sobelFromNative(JNIEnv *env, jclass jclass1,
                                                   jintArray pixel, jint width, jint height,
                                                   jobject backList) {
    LOGI("进入jni方法开始特征提取");
    int w = width;
    int h = height;
    vector<int[]> backVector;
    for (int y = 0; y < h; ++y) {
        for (int x = 0; x < w; ++x) {
            int *pPixel = (*env).GetIntArrayElements(pixel, 0);
            int pixelX = (
                    (kernelX[0][0] * getAvg(pPixel, width, height, x - 1, y - 1)) +
                    (kernelX[0][1] * getAvg(pPixel, width, height, x, y - 1)) +
                    (kernelX[0][2] * getAvg(pPixel, width, height, x + 1, y - 1)) +
                    (kernelX[1][0] * getAvg(pPixel, width, height, x - 1, y)) +
                    (kernelX[1][1] * getAvg(pPixel, width, height, x, y)) +
                    (kernelX[1][2] * getAvg(pPixel, width, height, x + 1, y)) +
                    (kernelX[2][0] * getAvg(pPixel, width, height, x - 1, y + 1)) +
                    (kernelX[2][1] * getAvg(pPixel, width, height, x, y + 1)) +
                    (kernelX[2][2] * getAvg(pPixel, width, height, x + 1, y + 1))
            );
            int pixelY = (
                    (kernelY[0][0] * getAvg(pPixel, width, height, x - 1, y - 1)) +
                    (kernelY[0][1] * getAvg(pPixel, width, height, x, y - 1)) +
                    (kernelY[0][2] * getAvg(pPixel, width, height, x + 1, y - 1)) +
                    (kernelY[1][0] * getAvg(pPixel, width, height, x - 1, y)) +
                    (kernelY[1][1] * getAvg(pPixel, width, height, x, y)) +
                    (kernelY[1][2] * getAvg(pPixel, width, height, x + 1, y)) +
                    (kernelY[2][0] * getAvg(pPixel, width, height, x - 1, y + 1)) +
                    (kernelY[2][1] * getAvg(pPixel, width, height, x, y + 1)) +
                    (kernelY[2][2] * getAvg(pPixel, width, height, x + 1, y + 1))
            );
            int magnitude = (int) sqrt((pixelX * pixelX) + (pixelY * pixelY));
            if (magnitude > 40) {
                backVector.push_back({pixelX, pixelY});
            }
        }
    }

//    backVector.shrink_to_fit();
//    int **back2Pointer = (int **) (malloc(sizeof(int *) * (backVector.size())));
//    for (int i = 0; i < backVector.size(); ++i) {
//        *back2Pointer = (int *) (malloc(sizeof(int) * 2));
//    }

    jclass intArrCls = env->FindClass("[J");
    jobjectArray returnArray = env->NewObjectArray(10, intArrCls, NULL);


}
#ifdef __cplusplus
}
#endif

