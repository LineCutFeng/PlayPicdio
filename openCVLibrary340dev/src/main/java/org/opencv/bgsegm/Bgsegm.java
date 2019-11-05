//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.bgsegm;

import org.opencv.bgsegm.BackgroundSubtractorCNT;
import org.opencv.bgsegm.BackgroundSubtractorGMG;
import org.opencv.bgsegm.BackgroundSubtractorGSOC;
import org.opencv.bgsegm.BackgroundSubtractorLSBP;
import org.opencv.bgsegm.BackgroundSubtractorMOG;
import org.opencv.bgsegm.SyntheticSequenceGenerator;
import org.opencv.core.Mat;

// C++: class Bgsegm
//javadoc: Bgsegm

public class Bgsegm {

    public static final int
            LSBP_CAMERA_MOTION_COMPENSATION_NONE = 0,
            LSBP_CAMERA_MOTION_COMPENSATION_LK = 0+1;


    //
    // C++:  Ptr_BackgroundSubtractorCNT createBackgroundSubtractorCNT(int minPixelStability = 15, bool useHistory = true, int maxPixelStability = 15*60, bool isParallel = true)
    //

    //javadoc: createBackgroundSubtractorCNT(minPixelStability, useHistory, maxPixelStability, isParallel)
    public static BackgroundSubtractorCNT createBackgroundSubtractorCNT(int minPixelStability, boolean useHistory, int maxPixelStability, boolean isParallel)
    {
        
        BackgroundSubtractorCNT retVal = BackgroundSubtractorCNT.__fromPtr__(createBackgroundSubtractorCNT_0(minPixelStability, useHistory, maxPixelStability, isParallel));
        
        return retVal;
    }

    //javadoc: createBackgroundSubtractorCNT()
    public static BackgroundSubtractorCNT createBackgroundSubtractorCNT()
    {
        
        BackgroundSubtractorCNT retVal = BackgroundSubtractorCNT.__fromPtr__(createBackgroundSubtractorCNT_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_BackgroundSubtractorGMG createBackgroundSubtractorGMG(int initializationFrames = 120, double decisionThreshold = 0.8)
    //

    //javadoc: createBackgroundSubtractorGMG(initializationFrames, decisionThreshold)
    public static BackgroundSubtractorGMG createBackgroundSubtractorGMG(int initializationFrames, double decisionThreshold)
    {
        
        BackgroundSubtractorGMG retVal = BackgroundSubtractorGMG.__fromPtr__(createBackgroundSubtractorGMG_0(initializationFrames, decisionThreshold));
        
        return retVal;
    }

    //javadoc: createBackgroundSubtractorGMG()
    public static BackgroundSubtractorGMG createBackgroundSubtractorGMG()
    {
        
        BackgroundSubtractorGMG retVal = BackgroundSubtractorGMG.__fromPtr__(createBackgroundSubtractorGMG_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_BackgroundSubtractorGSOC createBackgroundSubtractorGSOC(int mc = LSBP_CAMERA_MOTION_COMPENSATION_NONE, int nSamples = 20, float replaceRate = 0.003f, float propagationRate = 0.01f, int hitsThreshold = 32, float alpha = 0.01f, float beta = 0.0022f, float blinkingSupressionDecay = 0.1f, float blinkingSupressionMultiplier = 0.1f, float noiseRemovalThresholdFacBG = 0.0004f, float noiseRemovalThresholdFacFG = 0.0008f)
    //

    //javadoc: createBackgroundSubtractorGSOC(mc, nSamples, replaceRate, propagationRate, hitsThreshold, alpha, beta, blinkingSupressionDecay, blinkingSupressionMultiplier, noiseRemovalThresholdFacBG, noiseRemovalThresholdFacFG)
    public static BackgroundSubtractorGSOC createBackgroundSubtractorGSOC(int mc, int nSamples, float replaceRate, float propagationRate, int hitsThreshold, float alpha, float beta, float blinkingSupressionDecay, float blinkingSupressionMultiplier, float noiseRemovalThresholdFacBG, float noiseRemovalThresholdFacFG)
    {
        
        BackgroundSubtractorGSOC retVal = BackgroundSubtractorGSOC.__fromPtr__(createBackgroundSubtractorGSOC_0(mc, nSamples, replaceRate, propagationRate, hitsThreshold, alpha, beta, blinkingSupressionDecay, blinkingSupressionMultiplier, noiseRemovalThresholdFacBG, noiseRemovalThresholdFacFG));
        
        return retVal;
    }

    //javadoc: createBackgroundSubtractorGSOC()
    public static BackgroundSubtractorGSOC createBackgroundSubtractorGSOC()
    {
        
        BackgroundSubtractorGSOC retVal = BackgroundSubtractorGSOC.__fromPtr__(createBackgroundSubtractorGSOC_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_BackgroundSubtractorLSBP createBackgroundSubtractorLSBP(int mc = LSBP_CAMERA_MOTION_COMPENSATION_NONE, int nSamples = 20, int LSBPRadius = 16, float Tlower = 2.0f, float Tupper = 32.0f, float Tinc = 1.0f, float Tdec = 0.05f, float Rscale = 10.0f, float Rincdec = 0.005f, float noiseRemovalThresholdFacBG = 0.0004f, float noiseRemovalThresholdFacFG = 0.0008f, int LSBPthreshold = 8, int minCount = 2)
    //

    //javadoc: createBackgroundSubtractorLSBP(mc, nSamples, LSBPRadius, Tlower, Tupper, Tinc, Tdec, Rscale, Rincdec, noiseRemovalThresholdFacBG, noiseRemovalThresholdFacFG, LSBPthreshold, minCount)
    public static BackgroundSubtractorLSBP createBackgroundSubtractorLSBP(int mc, int nSamples, int LSBPRadius, float Tlower, float Tupper, float Tinc, float Tdec, float Rscale, float Rincdec, float noiseRemovalThresholdFacBG, float noiseRemovalThresholdFacFG, int LSBPthreshold, int minCount)
    {
        
        BackgroundSubtractorLSBP retVal = BackgroundSubtractorLSBP.__fromPtr__(createBackgroundSubtractorLSBP_0(mc, nSamples, LSBPRadius, Tlower, Tupper, Tinc, Tdec, Rscale, Rincdec, noiseRemovalThresholdFacBG, noiseRemovalThresholdFacFG, LSBPthreshold, minCount));
        
        return retVal;
    }

    //javadoc: createBackgroundSubtractorLSBP()
    public static BackgroundSubtractorLSBP createBackgroundSubtractorLSBP()
    {
        
        BackgroundSubtractorLSBP retVal = BackgroundSubtractorLSBP.__fromPtr__(createBackgroundSubtractorLSBP_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_BackgroundSubtractorMOG createBackgroundSubtractorMOG(int history = 200, int nmixtures = 5, double backgroundRatio = 0.7, double noiseSigma = 0)
    //

    //javadoc: createBackgroundSubtractorMOG(history, nmixtures, backgroundRatio, noiseSigma)
    public static BackgroundSubtractorMOG createBackgroundSubtractorMOG(int history, int nmixtures, double backgroundRatio, double noiseSigma)
    {
        
        BackgroundSubtractorMOG retVal = BackgroundSubtractorMOG.__fromPtr__(createBackgroundSubtractorMOG_0(history, nmixtures, backgroundRatio, noiseSigma));
        
        return retVal;
    }

    //javadoc: createBackgroundSubtractorMOG()
    public static BackgroundSubtractorMOG createBackgroundSubtractorMOG()
    {
        
        BackgroundSubtractorMOG retVal = BackgroundSubtractorMOG.__fromPtr__(createBackgroundSubtractorMOG_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_SyntheticSequenceGenerator createSyntheticSequenceGenerator(Mat background, Mat object, double amplitude = 2.0, double wavelength = 20.0, double wavespeed = 0.2, double objspeed = 6.0)
    //

    //javadoc: createSyntheticSequenceGenerator(background, object, amplitude, wavelength, wavespeed, objspeed)
    public static SyntheticSequenceGenerator createSyntheticSequenceGenerator(Mat background, Mat object, double amplitude, double wavelength, double wavespeed, double objspeed)
    {
        
        SyntheticSequenceGenerator retVal = SyntheticSequenceGenerator.__fromPtr__(createSyntheticSequenceGenerator_0(background.nativeObj, object.nativeObj, amplitude, wavelength, wavespeed, objspeed));
        
        return retVal;
    }

    //javadoc: createSyntheticSequenceGenerator(background, object)
    public static SyntheticSequenceGenerator createSyntheticSequenceGenerator(Mat background, Mat object)
    {
        
        SyntheticSequenceGenerator retVal = SyntheticSequenceGenerator.__fromPtr__(createSyntheticSequenceGenerator_1(background.nativeObj, object.nativeObj));
        
        return retVal;
    }




    // C++:  Ptr_BackgroundSubtractorCNT createBackgroundSubtractorCNT(int minPixelStability = 15, bool useHistory = true, int maxPixelStability = 15*60, bool isParallel = true)
    private static native long createBackgroundSubtractorCNT_0(int minPixelStability, boolean useHistory, int maxPixelStability, boolean isParallel);
    private static native long createBackgroundSubtractorCNT_1();

    // C++:  Ptr_BackgroundSubtractorGMG createBackgroundSubtractorGMG(int initializationFrames = 120, double decisionThreshold = 0.8)
    private static native long createBackgroundSubtractorGMG_0(int initializationFrames, double decisionThreshold);
    private static native long createBackgroundSubtractorGMG_1();

    // C++:  Ptr_BackgroundSubtractorGSOC createBackgroundSubtractorGSOC(int mc = LSBP_CAMERA_MOTION_COMPENSATION_NONE, int nSamples = 20, float replaceRate = 0.003f, float propagationRate = 0.01f, int hitsThreshold = 32, float alpha = 0.01f, float beta = 0.0022f, float blinkingSupressionDecay = 0.1f, float blinkingSupressionMultiplier = 0.1f, float noiseRemovalThresholdFacBG = 0.0004f, float noiseRemovalThresholdFacFG = 0.0008f)
    private static native long createBackgroundSubtractorGSOC_0(int mc, int nSamples, float replaceRate, float propagationRate, int hitsThreshold, float alpha, float beta, float blinkingSupressionDecay, float blinkingSupressionMultiplier, float noiseRemovalThresholdFacBG, float noiseRemovalThresholdFacFG);
    private static native long createBackgroundSubtractorGSOC_1();

    // C++:  Ptr_BackgroundSubtractorLSBP createBackgroundSubtractorLSBP(int mc = LSBP_CAMERA_MOTION_COMPENSATION_NONE, int nSamples = 20, int LSBPRadius = 16, float Tlower = 2.0f, float Tupper = 32.0f, float Tinc = 1.0f, float Tdec = 0.05f, float Rscale = 10.0f, float Rincdec = 0.005f, float noiseRemovalThresholdFacBG = 0.0004f, float noiseRemovalThresholdFacFG = 0.0008f, int LSBPthreshold = 8, int minCount = 2)
    private static native long createBackgroundSubtractorLSBP_0(int mc, int nSamples, int LSBPRadius, float Tlower, float Tupper, float Tinc, float Tdec, float Rscale, float Rincdec, float noiseRemovalThresholdFacBG, float noiseRemovalThresholdFacFG, int LSBPthreshold, int minCount);
    private static native long createBackgroundSubtractorLSBP_1();

    // C++:  Ptr_BackgroundSubtractorMOG createBackgroundSubtractorMOG(int history = 200, int nmixtures = 5, double backgroundRatio = 0.7, double noiseSigma = 0)
    private static native long createBackgroundSubtractorMOG_0(int history, int nmixtures, double backgroundRatio, double noiseSigma);
    private static native long createBackgroundSubtractorMOG_1();

    // C++:  Ptr_SyntheticSequenceGenerator createSyntheticSequenceGenerator(Mat background, Mat object, double amplitude = 2.0, double wavelength = 20.0, double wavespeed = 0.2, double objspeed = 6.0)
    private static native long createSyntheticSequenceGenerator_0(long background_nativeObj, long object_nativeObj, double amplitude, double wavelength, double wavespeed, double objspeed);
    private static native long createSyntheticSequenceGenerator_1(long background_nativeObj, long object_nativeObj);

}
