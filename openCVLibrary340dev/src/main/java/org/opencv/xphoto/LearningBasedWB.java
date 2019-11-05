//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.xphoto;

import org.opencv.core.Mat;
import org.opencv.xphoto.WhiteBalancer;

// C++: class LearningBasedWB
//javadoc: LearningBasedWB

public class LearningBasedWB extends WhiteBalancer {

    protected LearningBasedWB(long addr) { super(addr); }

    // internal usage only
    public static LearningBasedWB __fromPtr__(long addr) { return new LearningBasedWB(addr); }

    //
    // C++:  float getSaturationThreshold()
    //

    //javadoc: LearningBasedWB::getSaturationThreshold()
    public  float getSaturationThreshold()
    {
        
        float retVal = getSaturationThreshold_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getHistBinNum()
    //

    //javadoc: LearningBasedWB::getHistBinNum()
    public  int getHistBinNum()
    {
        
        int retVal = getHistBinNum_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getRangeMaxVal()
    //

    //javadoc: LearningBasedWB::getRangeMaxVal()
    public  int getRangeMaxVal()
    {
        
        int retVal = getRangeMaxVal_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  void extractSimpleFeatures(Mat src, Mat& dst)
    //

    //javadoc: LearningBasedWB::extractSimpleFeatures(src, dst)
    public  void extractSimpleFeatures(Mat src, Mat dst)
    {
        
        extractSimpleFeatures_0(nativeObj, src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void setHistBinNum(int val)
    //

    //javadoc: LearningBasedWB::setHistBinNum(val)
    public  void setHistBinNum(int val)
    {
        
        setHistBinNum_0(nativeObj, val);
        
        return;
    }


    //
    // C++:  void setRangeMaxVal(int val)
    //

    //javadoc: LearningBasedWB::setRangeMaxVal(val)
    public  void setRangeMaxVal(int val)
    {
        
        setRangeMaxVal_0(nativeObj, val);
        
        return;
    }


    //
    // C++:  void setSaturationThreshold(float val)
    //

    //javadoc: LearningBasedWB::setSaturationThreshold(val)
    public  void setSaturationThreshold(float val)
    {
        
        setSaturationThreshold_0(nativeObj, val);
        
        return;
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  float getSaturationThreshold()
    private static native float getSaturationThreshold_0(long nativeObj);

    // C++:  int getHistBinNum()
    private static native int getHistBinNum_0(long nativeObj);

    // C++:  int getRangeMaxVal()
    private static native int getRangeMaxVal_0(long nativeObj);

    // C++:  void extractSimpleFeatures(Mat src, Mat& dst)
    private static native void extractSimpleFeatures_0(long nativeObj, long src_nativeObj, long dst_nativeObj);

    // C++:  void setHistBinNum(int val)
    private static native void setHistBinNum_0(long nativeObj, int val);

    // C++:  void setRangeMaxVal(int val)
    private static native void setRangeMaxVal_0(long nativeObj, int val);

    // C++:  void setSaturationThreshold(float val)
    private static native void setSaturationThreshold_0(long nativeObj, float val);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
