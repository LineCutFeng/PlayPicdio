//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.bgsegm;

import org.opencv.video.BackgroundSubtractor;

// C++: class BackgroundSubtractorGMG
//javadoc: BackgroundSubtractorGMG

public class BackgroundSubtractorGMG extends BackgroundSubtractor {

    protected BackgroundSubtractorGMG(long addr) { super(addr); }

    // internal usage only
    public static BackgroundSubtractorGMG __fromPtr__(long addr) { return new BackgroundSubtractorGMG(addr); }

    //
    // C++:  bool getUpdateBackgroundModel()
    //

    //javadoc: BackgroundSubtractorGMG::getUpdateBackgroundModel()
    public  boolean getUpdateBackgroundModel()
    {
        
        boolean retVal = getUpdateBackgroundModel_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  double getBackgroundPrior()
    //

    //javadoc: BackgroundSubtractorGMG::getBackgroundPrior()
    public  double getBackgroundPrior()
    {
        
        double retVal = getBackgroundPrior_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  double getDecisionThreshold()
    //

    //javadoc: BackgroundSubtractorGMG::getDecisionThreshold()
    public  double getDecisionThreshold()
    {
        
        double retVal = getDecisionThreshold_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  double getDefaultLearningRate()
    //

    //javadoc: BackgroundSubtractorGMG::getDefaultLearningRate()
    public  double getDefaultLearningRate()
    {
        
        double retVal = getDefaultLearningRate_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  double getMaxVal()
    //

    //javadoc: BackgroundSubtractorGMG::getMaxVal()
    public  double getMaxVal()
    {
        
        double retVal = getMaxVal_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  double getMinVal()
    //

    //javadoc: BackgroundSubtractorGMG::getMinVal()
    public  double getMinVal()
    {
        
        double retVal = getMinVal_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getMaxFeatures()
    //

    //javadoc: BackgroundSubtractorGMG::getMaxFeatures()
    public  int getMaxFeatures()
    {
        
        int retVal = getMaxFeatures_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getNumFrames()
    //

    //javadoc: BackgroundSubtractorGMG::getNumFrames()
    public  int getNumFrames()
    {
        
        int retVal = getNumFrames_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getQuantizationLevels()
    //

    //javadoc: BackgroundSubtractorGMG::getQuantizationLevels()
    public  int getQuantizationLevels()
    {
        
        int retVal = getQuantizationLevels_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getSmoothingRadius()
    //

    //javadoc: BackgroundSubtractorGMG::getSmoothingRadius()
    public  int getSmoothingRadius()
    {
        
        int retVal = getSmoothingRadius_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  void setBackgroundPrior(double bgprior)
    //

    //javadoc: BackgroundSubtractorGMG::setBackgroundPrior(bgprior)
    public  void setBackgroundPrior(double bgprior)
    {
        
        setBackgroundPrior_0(nativeObj, bgprior);
        
        return;
    }


    //
    // C++:  void setDecisionThreshold(double thresh)
    //

    //javadoc: BackgroundSubtractorGMG::setDecisionThreshold(thresh)
    public  void setDecisionThreshold(double thresh)
    {
        
        setDecisionThreshold_0(nativeObj, thresh);
        
        return;
    }


    //
    // C++:  void setDefaultLearningRate(double lr)
    //

    //javadoc: BackgroundSubtractorGMG::setDefaultLearningRate(lr)
    public  void setDefaultLearningRate(double lr)
    {
        
        setDefaultLearningRate_0(nativeObj, lr);
        
        return;
    }


    //
    // C++:  void setMaxFeatures(int maxFeatures)
    //

    //javadoc: BackgroundSubtractorGMG::setMaxFeatures(maxFeatures)
    public  void setMaxFeatures(int maxFeatures)
    {
        
        setMaxFeatures_0(nativeObj, maxFeatures);
        
        return;
    }


    //
    // C++:  void setMaxVal(double val)
    //

    //javadoc: BackgroundSubtractorGMG::setMaxVal(val)
    public  void setMaxVal(double val)
    {
        
        setMaxVal_0(nativeObj, val);
        
        return;
    }


    //
    // C++:  void setMinVal(double val)
    //

    //javadoc: BackgroundSubtractorGMG::setMinVal(val)
    public  void setMinVal(double val)
    {
        
        setMinVal_0(nativeObj, val);
        
        return;
    }


    //
    // C++:  void setNumFrames(int nframes)
    //

    //javadoc: BackgroundSubtractorGMG::setNumFrames(nframes)
    public  void setNumFrames(int nframes)
    {
        
        setNumFrames_0(nativeObj, nframes);
        
        return;
    }


    //
    // C++:  void setQuantizationLevels(int nlevels)
    //

    //javadoc: BackgroundSubtractorGMG::setQuantizationLevels(nlevels)
    public  void setQuantizationLevels(int nlevels)
    {
        
        setQuantizationLevels_0(nativeObj, nlevels);
        
        return;
    }


    //
    // C++:  void setSmoothingRadius(int radius)
    //

    //javadoc: BackgroundSubtractorGMG::setSmoothingRadius(radius)
    public  void setSmoothingRadius(int radius)
    {
        
        setSmoothingRadius_0(nativeObj, radius);
        
        return;
    }


    //
    // C++:  void setUpdateBackgroundModel(bool update)
    //

    //javadoc: BackgroundSubtractorGMG::setUpdateBackgroundModel(update)
    public  void setUpdateBackgroundModel(boolean update)
    {
        
        setUpdateBackgroundModel_0(nativeObj, update);
        
        return;
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  bool getUpdateBackgroundModel()
    private static native boolean getUpdateBackgroundModel_0(long nativeObj);

    // C++:  double getBackgroundPrior()
    private static native double getBackgroundPrior_0(long nativeObj);

    // C++:  double getDecisionThreshold()
    private static native double getDecisionThreshold_0(long nativeObj);

    // C++:  double getDefaultLearningRate()
    private static native double getDefaultLearningRate_0(long nativeObj);

    // C++:  double getMaxVal()
    private static native double getMaxVal_0(long nativeObj);

    // C++:  double getMinVal()
    private static native double getMinVal_0(long nativeObj);

    // C++:  int getMaxFeatures()
    private static native int getMaxFeatures_0(long nativeObj);

    // C++:  int getNumFrames()
    private static native int getNumFrames_0(long nativeObj);

    // C++:  int getQuantizationLevels()
    private static native int getQuantizationLevels_0(long nativeObj);

    // C++:  int getSmoothingRadius()
    private static native int getSmoothingRadius_0(long nativeObj);

    // C++:  void setBackgroundPrior(double bgprior)
    private static native void setBackgroundPrior_0(long nativeObj, double bgprior);

    // C++:  void setDecisionThreshold(double thresh)
    private static native void setDecisionThreshold_0(long nativeObj, double thresh);

    // C++:  void setDefaultLearningRate(double lr)
    private static native void setDefaultLearningRate_0(long nativeObj, double lr);

    // C++:  void setMaxFeatures(int maxFeatures)
    private static native void setMaxFeatures_0(long nativeObj, int maxFeatures);

    // C++:  void setMaxVal(double val)
    private static native void setMaxVal_0(long nativeObj, double val);

    // C++:  void setMinVal(double val)
    private static native void setMinVal_0(long nativeObj, double val);

    // C++:  void setNumFrames(int nframes)
    private static native void setNumFrames_0(long nativeObj, int nframes);

    // C++:  void setQuantizationLevels(int nlevels)
    private static native void setQuantizationLevels_0(long nativeObj, int nlevels);

    // C++:  void setSmoothingRadius(int radius)
    private static native void setSmoothingRadius_0(long nativeObj, int radius);

    // C++:  void setUpdateBackgroundModel(bool update)
    private static native void setUpdateBackgroundModel_0(long nativeObj, boolean update);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
