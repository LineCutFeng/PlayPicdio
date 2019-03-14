//
// Created by PC on 2019/2/18.
//

#include "sobel.h"

#include <iostream>
#include <math.h>
#include <vector>
#include <stdlib.h>

using std::cout;
using std::endl;
using std::vector;


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
    jsize i = (*env).GetArrayLength(pixel);
    LOGI("数组长度为%d", i);
//    vector<int[]> backVector;
    jclass j_backList = env->GetObjectClass(backList);
    if (j_backList == NULL) {
        LOGI("没找到java类");
        return;
    }
    jmethodID list_add = env->GetMethodID(j_backList, "add", "(Ljava/lang/Object;)Z");
    if (list_add == NULL) {
        LOGI("没找到java方法");
        return;
    }
    int *pPixel = (*env).GetIntArrayElements(pixel, 0);
    for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
            int pixelX = (
                    (kernelX[0][0] * getAvg(pPixel, w, h, x - 1, y - 1)) +
                    (kernelX[0][1] * getAvg(pPixel, w, h, x, y - 1)) +
                    (kernelX[0][2] * getAvg(pPixel, w, h, x + 1, y - 1)) +
                    (kernelX[1][0] * getAvg(pPixel, w, h, x - 1, y)) +
                    (kernelX[1][1] * getAvg(pPixel, w, h, x, y)) +
                    (kernelX[1][2] * getAvg(pPixel, w, h, x + 1, y)) +
                    (kernelX[2][0] * getAvg(pPixel, w, h, x - 1, y + 1)) +
                    (kernelX[2][1] * getAvg(pPixel, w, h, x, y + 1)) +
                    (kernelX[2][2] * getAvg(pPixel, w, h, x + 1, y + 1))
            );
            int pixelY = (
                    (kernelY[0][0] * getAvg(pPixel, w, h, x - 1, y - 1)) +
                    (kernelY[0][1] * getAvg(pPixel, w, h, x, y - 1)) +
                    (kernelY[0][2] * getAvg(pPixel, w, h, x + 1, y - 1)) +
                    (kernelY[1][0] * getAvg(pPixel, w, h, x - 1, y)) +
                    (kernelY[1][1] * getAvg(pPixel, w, h, x, y)) +
                    (kernelY[1][2] * getAvg(pPixel, w, h, x + 1, y)) +
                    (kernelY[2][0] * getAvg(pPixel, w, h, x - 1, y + 1)) +
                    (kernelY[2][1] * getAvg(pPixel, w, h, x, y + 1)) +
                    (kernelY[2][2] * getAvg(pPixel, w, h, x + 1, y + 1))
            );
            int magnitude = (int) sqrt((pixelX * pixelX) + (pixelY * pixelY));
            if (magnitude > 20) {
                jintArray pArray = env->NewIntArray(2);
                jboolean jb = JNI_FALSE;
                jint *pInt = env->GetIntArrayElements(pArray, NULL);
                pInt[0] = x;
                pInt[1] = y;
                env->CallBooleanMethod(backList, list_add, pArray);
                env->ReleaseIntArrayElements(pArray, pInt, 0);
            }
        }

    }
//    backVector.shrink_to_fit();
//    int **back2Pointer = (int **) (malloc(sizeof(int *) * (backVector.size())));
//    for (int i = 0; i < backVector.size(); ++i) {
//        *back2Pointer = (int *) (malloc(sizeof(int) * 2));
//    }

}
#ifdef __cplusplus
}
#endif

