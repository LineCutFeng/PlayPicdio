//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.xphoto;

import java.lang.String;
import org.opencv.core.Mat;
import org.opencv.xphoto.GrayworldWB;
import org.opencv.xphoto.LearningBasedWB;
import org.opencv.xphoto.SimpleWB;

// C++: class Xphoto
//javadoc: Xphoto

public class Xphoto {

    public static final int
            HAAR = 0,
            BM3D_STEPALL = 0,
            BM3D_STEP1 = 1,
            BM3D_STEP2 = 2,
            INPAINT_SHIFTMAP = 0;


    //
    // C++:  Ptr_GrayworldWB createGrayworldWB()
    //

    //javadoc: createGrayworldWB()
    public static GrayworldWB createGrayworldWB()
    {
        
        GrayworldWB retVal = GrayworldWB.__fromPtr__(createGrayworldWB_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_LearningBasedWB createLearningBasedWB(String path_to_model = String())
    //

    //javadoc: createLearningBasedWB(path_to_model)
    public static LearningBasedWB createLearningBasedWB(String path_to_model)
    {
        
        LearningBasedWB retVal = LearningBasedWB.__fromPtr__(createLearningBasedWB_0(path_to_model));
        
        return retVal;
    }

    //javadoc: createLearningBasedWB()
    public static LearningBasedWB createLearningBasedWB()
    {
        
        LearningBasedWB retVal = LearningBasedWB.__fromPtr__(createLearningBasedWB_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_SimpleWB createSimpleWB()
    //

    //javadoc: createSimpleWB()
    public static SimpleWB createSimpleWB()
    {
        
        SimpleWB retVal = SimpleWB.__fromPtr__(createSimpleWB_0());
        
        return retVal;
    }


    //
    // C++:  void applyChannelGains(Mat src, Mat& dst, float gainB, float gainG, float gainR)
    //

    //javadoc: applyChannelGains(src, dst, gainB, gainG, gainR)
    public static void applyChannelGains(Mat src, Mat dst, float gainB, float gainG, float gainR)
    {
        
        applyChannelGains_0(src.nativeObj, dst.nativeObj, gainB, gainG, gainR);
        
        return;
    }


    //
    // C++:  void bm3dDenoising(Mat src, Mat& dst, float h = 1, int templateWindowSize = 4, int searchWindowSize = 16, int blockMatchingStep1 = 2500, int blockMatchingStep2 = 400, int groupSize = 8, int slidingStep = 1, float beta = 2.0f, int normType = cv::NORM_L2, int step = cv::xphoto::BM3D_STEPALL, int transformType = cv::xphoto::HAAR)
    //

    //javadoc: bm3dDenoising(src, dst, h, templateWindowSize, searchWindowSize, blockMatchingStep1, blockMatchingStep2, groupSize, slidingStep, beta, normType, step, transformType)
    public static void bm3dDenoising(Mat src, Mat dst, float h, int templateWindowSize, int searchWindowSize, int blockMatchingStep1, int blockMatchingStep2, int groupSize, int slidingStep, float beta, int normType, int step, int transformType)
    {
        
        bm3dDenoising_0(src.nativeObj, dst.nativeObj, h, templateWindowSize, searchWindowSize, blockMatchingStep1, blockMatchingStep2, groupSize, slidingStep, beta, normType, step, transformType);
        
        return;
    }

    //javadoc: bm3dDenoising(src, dst)
    public static void bm3dDenoising(Mat src, Mat dst)
    {
        
        bm3dDenoising_1(src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void bm3dDenoising(Mat src, Mat& dstStep1, Mat& dstStep2, float h = 1, int templateWindowSize = 4, int searchWindowSize = 16, int blockMatchingStep1 = 2500, int blockMatchingStep2 = 400, int groupSize = 8, int slidingStep = 1, float beta = 2.0f, int normType = cv::NORM_L2, int step = cv::xphoto::BM3D_STEPALL, int transformType = cv::xphoto::HAAR)
    //

    //javadoc: bm3dDenoising(src, dstStep1, dstStep2, h, templateWindowSize, searchWindowSize, blockMatchingStep1, blockMatchingStep2, groupSize, slidingStep, beta, normType, step, transformType)
    public static void bm3dDenoising(Mat src, Mat dstStep1, Mat dstStep2, float h, int templateWindowSize, int searchWindowSize, int blockMatchingStep1, int blockMatchingStep2, int groupSize, int slidingStep, float beta, int normType, int step, int transformType)
    {
        
        bm3dDenoising_2(src.nativeObj, dstStep1.nativeObj, dstStep2.nativeObj, h, templateWindowSize, searchWindowSize, blockMatchingStep1, blockMatchingStep2, groupSize, slidingStep, beta, normType, step, transformType);
        
        return;
    }

    //javadoc: bm3dDenoising(src, dstStep1, dstStep2)
    public static void bm3dDenoising(Mat src, Mat dstStep1, Mat dstStep2)
    {
        
        bm3dDenoising_3(src.nativeObj, dstStep1.nativeObj, dstStep2.nativeObj);
        
        return;
    }


    //
    // C++:  void dctDenoising(Mat src, Mat dst, double sigma, int psize = 16)
    //

    //javadoc: dctDenoising(src, dst, sigma, psize)
    public static void dctDenoising(Mat src, Mat dst, double sigma, int psize)
    {
        
        dctDenoising_0(src.nativeObj, dst.nativeObj, sigma, psize);
        
        return;
    }

    //javadoc: dctDenoising(src, dst, sigma)
    public static void dctDenoising(Mat src, Mat dst, double sigma)
    {
        
        dctDenoising_1(src.nativeObj, dst.nativeObj, sigma);
        
        return;
    }


    //
    // C++:  void inpaint(Mat src, Mat mask, Mat dst, int algorithmType)
    //

    //javadoc: inpaint(src, mask, dst, algorithmType)
    public static void inpaint(Mat src, Mat mask, Mat dst, int algorithmType)
    {
        
        inpaint_0(src.nativeObj, mask.nativeObj, dst.nativeObj, algorithmType);
        
        return;
    }




    // C++:  Ptr_GrayworldWB createGrayworldWB()
    private static native long createGrayworldWB_0();

    // C++:  Ptr_LearningBasedWB createLearningBasedWB(String path_to_model = String())
    private static native long createLearningBasedWB_0(String path_to_model);
    private static native long createLearningBasedWB_1();

    // C++:  Ptr_SimpleWB createSimpleWB()
    private static native long createSimpleWB_0();

    // C++:  void applyChannelGains(Mat src, Mat& dst, float gainB, float gainG, float gainR)
    private static native void applyChannelGains_0(long src_nativeObj, long dst_nativeObj, float gainB, float gainG, float gainR);

    // C++:  void bm3dDenoising(Mat src, Mat& dst, float h = 1, int templateWindowSize = 4, int searchWindowSize = 16, int blockMatchingStep1 = 2500, int blockMatchingStep2 = 400, int groupSize = 8, int slidingStep = 1, float beta = 2.0f, int normType = cv::NORM_L2, int step = cv::xphoto::BM3D_STEPALL, int transformType = cv::xphoto::HAAR)
    private static native void bm3dDenoising_0(long src_nativeObj, long dst_nativeObj, float h, int templateWindowSize, int searchWindowSize, int blockMatchingStep1, int blockMatchingStep2, int groupSize, int slidingStep, float beta, int normType, int step, int transformType);
    private static native void bm3dDenoising_1(long src_nativeObj, long dst_nativeObj);

    // C++:  void bm3dDenoising(Mat src, Mat& dstStep1, Mat& dstStep2, float h = 1, int templateWindowSize = 4, int searchWindowSize = 16, int blockMatchingStep1 = 2500, int blockMatchingStep2 = 400, int groupSize = 8, int slidingStep = 1, float beta = 2.0f, int normType = cv::NORM_L2, int step = cv::xphoto::BM3D_STEPALL, int transformType = cv::xphoto::HAAR)
    private static native void bm3dDenoising_2(long src_nativeObj, long dstStep1_nativeObj, long dstStep2_nativeObj, float h, int templateWindowSize, int searchWindowSize, int blockMatchingStep1, int blockMatchingStep2, int groupSize, int slidingStep, float beta, int normType, int step, int transformType);
    private static native void bm3dDenoising_3(long src_nativeObj, long dstStep1_nativeObj, long dstStep2_nativeObj);

    // C++:  void dctDenoising(Mat src, Mat dst, double sigma, int psize = 16)
    private static native void dctDenoising_0(long src_nativeObj, long dst_nativeObj, double sigma, int psize);
    private static native void dctDenoising_1(long src_nativeObj, long dst_nativeObj, double sigma);

    // C++:  void inpaint(Mat src, Mat mask, Mat dst, int algorithmType)
    private static native void inpaint_0(long src_nativeObj, long mask_nativeObj, long dst_nativeObj, int algorithmType);

}
