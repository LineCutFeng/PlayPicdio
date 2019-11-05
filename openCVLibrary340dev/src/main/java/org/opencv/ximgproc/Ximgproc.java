//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ximgproc;

import java.lang.String;
import org.opencv.calib3d.StereoMatcher;
import org.opencv.core.Mat;
import org.opencv.ximgproc.AdaptiveManifoldFilter;
import org.opencv.ximgproc.ContourFitting;
import org.opencv.ximgproc.DTFilter;
import org.opencv.ximgproc.DisparityWLSFilter;
import org.opencv.ximgproc.EdgeAwareInterpolator;
import org.opencv.ximgproc.EdgeBoxes;
import org.opencv.ximgproc.FastGlobalSmootherFilter;
import org.opencv.ximgproc.FastLineDetector;
import org.opencv.ximgproc.GraphSegmentation;
import org.opencv.ximgproc.GuidedFilter;
import org.opencv.ximgproc.RFFeatureGetter;
import org.opencv.ximgproc.SelectiveSearchSegmentation;
import org.opencv.ximgproc.SelectiveSearchSegmentationStrategy;
import org.opencv.ximgproc.SelectiveSearchSegmentationStrategyColor;
import org.opencv.ximgproc.SelectiveSearchSegmentationStrategyFill;
import org.opencv.ximgproc.SelectiveSearchSegmentationStrategyMultiple;
import org.opencv.ximgproc.SelectiveSearchSegmentationStrategySize;
import org.opencv.ximgproc.SelectiveSearchSegmentationStrategyTexture;
import org.opencv.ximgproc.StructuredEdgeDetection;
import org.opencv.ximgproc.SuperpixelLSC;
import org.opencv.ximgproc.SuperpixelSEEDS;
import org.opencv.ximgproc.SuperpixelSLIC;

// C++: class Ximgproc
//javadoc: Ximgproc

public class Ximgproc {

    public static final int
            THINNING_ZHANGSUEN = 0,
            THINNING_GUOHALL = 1,
            BINARIZATION_NIBLACK = 0,
            BINARIZATION_SAUVOLA = 1,
            BINARIZATION_WOLF = 2,
            BINARIZATION_NICK = 3,
            DTF_NC = 0,
            DTF_IC = 1,
            DTF_RF = 2,
            GUIDED_FILTER = 3,
            AM_FILTER = 4,
            SLIC = 100,
            SLICO = 101,
            MSLIC = 102,
            WMF_EXP = 1,
            WMF_IV1 = 1 << 1,
            WMF_IV2 = 1 << 2,
            WMF_COS = 1 << 3,
            WMF_JAC = 1 << 4,
            WMF_OFF = 1 << 5,
            ARO_0_45 = 0,
            ARO_45_90 = 1,
            ARO_90_135 = 2,
            ARO_315_0 = 3,
            ARO_315_45 = 4,
            ARO_45_135 = 5,
            ARO_315_135 = 6,
            ARO_CTR_HOR = 7,
            ARO_CTR_VER = 8,
            FHT_MIN = 0,
            FHT_MAX = 1,
            FHT_ADD = 2,
            FHT_AVE = 3,
            HDO_RAW = 0,
            HDO_DESKEW = 1;


    //
    // C++:  Ptr_AdaptiveManifoldFilter createAMFilter(double sigma_s, double sigma_r, bool adjust_outliers = false)
    //

    //javadoc: createAMFilter(sigma_s, sigma_r, adjust_outliers)
    public static AdaptiveManifoldFilter createAMFilter(double sigma_s, double sigma_r, boolean adjust_outliers)
    {
        
        AdaptiveManifoldFilter retVal = AdaptiveManifoldFilter.__fromPtr__(createAMFilter_0(sigma_s, sigma_r, adjust_outliers));
        
        return retVal;
    }

    //javadoc: createAMFilter(sigma_s, sigma_r)
    public static AdaptiveManifoldFilter createAMFilter(double sigma_s, double sigma_r)
    {
        
        AdaptiveManifoldFilter retVal = AdaptiveManifoldFilter.__fromPtr__(createAMFilter_1(sigma_s, sigma_r));
        
        return retVal;
    }


    //
    // C++:  Ptr_ContourFitting createContourFitting(int ctr = 1024, int fd = 16)
    //

    //javadoc: createContourFitting(ctr, fd)
    public static ContourFitting createContourFitting(int ctr, int fd)
    {
        
        ContourFitting retVal = ContourFitting.__fromPtr__(createContourFitting_0(ctr, fd));
        
        return retVal;
    }

    //javadoc: createContourFitting()
    public static ContourFitting createContourFitting()
    {
        
        ContourFitting retVal = ContourFitting.__fromPtr__(createContourFitting_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_DTFilter createDTFilter(Mat guide, double sigmaSpatial, double sigmaColor, int mode = DTF_NC, int numIters = 3)
    //

    //javadoc: createDTFilter(guide, sigmaSpatial, sigmaColor, mode, numIters)
    public static DTFilter createDTFilter(Mat guide, double sigmaSpatial, double sigmaColor, int mode, int numIters)
    {
        
        DTFilter retVal = DTFilter.__fromPtr__(createDTFilter_0(guide.nativeObj, sigmaSpatial, sigmaColor, mode, numIters));
        
        return retVal;
    }

    //javadoc: createDTFilter(guide, sigmaSpatial, sigmaColor)
    public static DTFilter createDTFilter(Mat guide, double sigmaSpatial, double sigmaColor)
    {
        
        DTFilter retVal = DTFilter.__fromPtr__(createDTFilter_1(guide.nativeObj, sigmaSpatial, sigmaColor));
        
        return retVal;
    }


    //
    // C++:  Ptr_DisparityWLSFilter createDisparityWLSFilter(Ptr_StereoMatcher matcher_left)
    //

    //javadoc: createDisparityWLSFilter(matcher_left)
    public static DisparityWLSFilter createDisparityWLSFilter(StereoMatcher matcher_left)
    {
        
        DisparityWLSFilter retVal = DisparityWLSFilter.__fromPtr__(createDisparityWLSFilter_0(matcher_left.getNativeObjAddr()));
        
        return retVal;
    }


    //
    // C++:  Ptr_DisparityWLSFilter createDisparityWLSFilterGeneric(bool use_confidence)
    //

    //javadoc: createDisparityWLSFilterGeneric(use_confidence)
    public static DisparityWLSFilter createDisparityWLSFilterGeneric(boolean use_confidence)
    {
        
        DisparityWLSFilter retVal = DisparityWLSFilter.__fromPtr__(createDisparityWLSFilterGeneric_0(use_confidence));
        
        return retVal;
    }


    //
    // C++:  Ptr_EdgeAwareInterpolator createEdgeAwareInterpolator()
    //

    //javadoc: createEdgeAwareInterpolator()
    public static EdgeAwareInterpolator createEdgeAwareInterpolator()
    {
        
        EdgeAwareInterpolator retVal = EdgeAwareInterpolator.__fromPtr__(createEdgeAwareInterpolator_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_EdgeBoxes createEdgeBoxes(float alpha = 0.65f, float beta = 0.75f, float eta = 1, float minScore = 0.01f, int maxBoxes = 10000, float edgeMinMag = 0.1f, float edgeMergeThr = 0.5f, float clusterMinMag = 0.5f, float maxAspectRatio = 3, float minBoxArea = 1000, float gamma = 2, float kappa = 1.5f)
    //

    //javadoc: createEdgeBoxes(alpha, beta, eta, minScore, maxBoxes, edgeMinMag, edgeMergeThr, clusterMinMag, maxAspectRatio, minBoxArea, gamma, kappa)
    public static EdgeBoxes createEdgeBoxes(float alpha, float beta, float eta, float minScore, int maxBoxes, float edgeMinMag, float edgeMergeThr, float clusterMinMag, float maxAspectRatio, float minBoxArea, float gamma, float kappa)
    {
        
        EdgeBoxes retVal = EdgeBoxes.__fromPtr__(createEdgeBoxes_0(alpha, beta, eta, minScore, maxBoxes, edgeMinMag, edgeMergeThr, clusterMinMag, maxAspectRatio, minBoxArea, gamma, kappa));
        
        return retVal;
    }

    //javadoc: createEdgeBoxes()
    public static EdgeBoxes createEdgeBoxes()
    {
        
        EdgeBoxes retVal = EdgeBoxes.__fromPtr__(createEdgeBoxes_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_FastGlobalSmootherFilter createFastGlobalSmootherFilter(Mat guide, double lambda, double sigma_color, double lambda_attenuation = 0.25, int num_iter = 3)
    //

    //javadoc: createFastGlobalSmootherFilter(guide, lambda, sigma_color, lambda_attenuation, num_iter)
    public static FastGlobalSmootherFilter createFastGlobalSmootherFilter(Mat guide, double lambda, double sigma_color, double lambda_attenuation, int num_iter)
    {
        
        FastGlobalSmootherFilter retVal = FastGlobalSmootherFilter.__fromPtr__(createFastGlobalSmootherFilter_0(guide.nativeObj, lambda, sigma_color, lambda_attenuation, num_iter));
        
        return retVal;
    }

    //javadoc: createFastGlobalSmootherFilter(guide, lambda, sigma_color)
    public static FastGlobalSmootherFilter createFastGlobalSmootherFilter(Mat guide, double lambda, double sigma_color)
    {
        
        FastGlobalSmootherFilter retVal = FastGlobalSmootherFilter.__fromPtr__(createFastGlobalSmootherFilter_1(guide.nativeObj, lambda, sigma_color));
        
        return retVal;
    }


    //
    // C++:  Ptr_FastLineDetector createFastLineDetector(int _length_threshold = 10, float _distance_threshold = 1.414213562f, double _canny_th1 = 50.0, double _canny_th2 = 50.0, int _canny_aperture_size = 3, bool _do_merge = false)
    //

    //javadoc: createFastLineDetector(_length_threshold, _distance_threshold, _canny_th1, _canny_th2, _canny_aperture_size, _do_merge)
    public static FastLineDetector createFastLineDetector(int _length_threshold, float _distance_threshold, double _canny_th1, double _canny_th2, int _canny_aperture_size, boolean _do_merge)
    {
        
        FastLineDetector retVal = FastLineDetector.__fromPtr__(createFastLineDetector_0(_length_threshold, _distance_threshold, _canny_th1, _canny_th2, _canny_aperture_size, _do_merge));
        
        return retVal;
    }

    //javadoc: createFastLineDetector()
    public static FastLineDetector createFastLineDetector()
    {
        
        FastLineDetector retVal = FastLineDetector.__fromPtr__(createFastLineDetector_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_GraphSegmentation createGraphSegmentation(double sigma = 0.5, float k = 300, int min_size = 100)
    //

    //javadoc: createGraphSegmentation(sigma, k, min_size)
    public static GraphSegmentation createGraphSegmentation(double sigma, float k, int min_size)
    {
        
        GraphSegmentation retVal = GraphSegmentation.__fromPtr__(createGraphSegmentation_0(sigma, k, min_size));
        
        return retVal;
    }

    //javadoc: createGraphSegmentation()
    public static GraphSegmentation createGraphSegmentation()
    {
        
        GraphSegmentation retVal = GraphSegmentation.__fromPtr__(createGraphSegmentation_1());
        
        return retVal;
    }


    //
    // C++:  Ptr_GuidedFilter createGuidedFilter(Mat guide, int radius, double eps)
    //

    //javadoc: createGuidedFilter(guide, radius, eps)
    public static GuidedFilter createGuidedFilter(Mat guide, int radius, double eps)
    {
        
        GuidedFilter retVal = GuidedFilter.__fromPtr__(createGuidedFilter_0(guide.nativeObj, radius, eps));
        
        return retVal;
    }


    //
    // C++:  Ptr_RFFeatureGetter createRFFeatureGetter()
    //

    //javadoc: createRFFeatureGetter()
    public static RFFeatureGetter createRFFeatureGetter()
    {
        
        RFFeatureGetter retVal = RFFeatureGetter.__fromPtr__(createRFFeatureGetter_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentation createSelectiveSearchSegmentation()
    //

    //javadoc: createSelectiveSearchSegmentation()
    public static SelectiveSearchSegmentation createSelectiveSearchSegmentation()
    {
        
        SelectiveSearchSegmentation retVal = SelectiveSearchSegmentation.__fromPtr__(createSelectiveSearchSegmentation_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyColor createSelectiveSearchSegmentationStrategyColor()
    //

    //javadoc: createSelectiveSearchSegmentationStrategyColor()
    public static SelectiveSearchSegmentationStrategyColor createSelectiveSearchSegmentationStrategyColor()
    {
        
        SelectiveSearchSegmentationStrategyColor retVal = SelectiveSearchSegmentationStrategyColor.__fromPtr__(createSelectiveSearchSegmentationStrategyColor_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyFill createSelectiveSearchSegmentationStrategyFill()
    //

    //javadoc: createSelectiveSearchSegmentationStrategyFill()
    public static SelectiveSearchSegmentationStrategyFill createSelectiveSearchSegmentationStrategyFill()
    {
        
        SelectiveSearchSegmentationStrategyFill retVal = SelectiveSearchSegmentationStrategyFill.__fromPtr__(createSelectiveSearchSegmentationStrategyFill_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1, Ptr_SelectiveSearchSegmentationStrategy s2, Ptr_SelectiveSearchSegmentationStrategy s3, Ptr_SelectiveSearchSegmentationStrategy s4)
    //

    //javadoc: createSelectiveSearchSegmentationStrategyMultiple(s1, s2, s3, s4)
    public static SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(SelectiveSearchSegmentationStrategy s1, SelectiveSearchSegmentationStrategy s2, SelectiveSearchSegmentationStrategy s3, SelectiveSearchSegmentationStrategy s4)
    {
        
        SelectiveSearchSegmentationStrategyMultiple retVal = SelectiveSearchSegmentationStrategyMultiple.__fromPtr__(createSelectiveSearchSegmentationStrategyMultiple_0(s1.getNativeObjAddr(), s2.getNativeObjAddr(), s3.getNativeObjAddr(), s4.getNativeObjAddr()));
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1, Ptr_SelectiveSearchSegmentationStrategy s2, Ptr_SelectiveSearchSegmentationStrategy s3)
    //

    //javadoc: createSelectiveSearchSegmentationStrategyMultiple(s1, s2, s3)
    public static SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(SelectiveSearchSegmentationStrategy s1, SelectiveSearchSegmentationStrategy s2, SelectiveSearchSegmentationStrategy s3)
    {
        
        SelectiveSearchSegmentationStrategyMultiple retVal = SelectiveSearchSegmentationStrategyMultiple.__fromPtr__(createSelectiveSearchSegmentationStrategyMultiple_1(s1.getNativeObjAddr(), s2.getNativeObjAddr(), s3.getNativeObjAddr()));
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1, Ptr_SelectiveSearchSegmentationStrategy s2)
    //

    //javadoc: createSelectiveSearchSegmentationStrategyMultiple(s1, s2)
    public static SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(SelectiveSearchSegmentationStrategy s1, SelectiveSearchSegmentationStrategy s2)
    {
        
        SelectiveSearchSegmentationStrategyMultiple retVal = SelectiveSearchSegmentationStrategyMultiple.__fromPtr__(createSelectiveSearchSegmentationStrategyMultiple_2(s1.getNativeObjAddr(), s2.getNativeObjAddr()));
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1)
    //

    //javadoc: createSelectiveSearchSegmentationStrategyMultiple(s1)
    public static SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(SelectiveSearchSegmentationStrategy s1)
    {
        
        SelectiveSearchSegmentationStrategyMultiple retVal = SelectiveSearchSegmentationStrategyMultiple.__fromPtr__(createSelectiveSearchSegmentationStrategyMultiple_3(s1.getNativeObjAddr()));
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple()
    //

    //javadoc: createSelectiveSearchSegmentationStrategyMultiple()
    public static SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple()
    {
        
        SelectiveSearchSegmentationStrategyMultiple retVal = SelectiveSearchSegmentationStrategyMultiple.__fromPtr__(createSelectiveSearchSegmentationStrategyMultiple_4());
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategySize createSelectiveSearchSegmentationStrategySize()
    //

    //javadoc: createSelectiveSearchSegmentationStrategySize()
    public static SelectiveSearchSegmentationStrategySize createSelectiveSearchSegmentationStrategySize()
    {
        
        SelectiveSearchSegmentationStrategySize retVal = SelectiveSearchSegmentationStrategySize.__fromPtr__(createSelectiveSearchSegmentationStrategySize_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_SelectiveSearchSegmentationStrategyTexture createSelectiveSearchSegmentationStrategyTexture()
    //

    //javadoc: createSelectiveSearchSegmentationStrategyTexture()
    public static SelectiveSearchSegmentationStrategyTexture createSelectiveSearchSegmentationStrategyTexture()
    {
        
        SelectiveSearchSegmentationStrategyTexture retVal = SelectiveSearchSegmentationStrategyTexture.__fromPtr__(createSelectiveSearchSegmentationStrategyTexture_0());
        
        return retVal;
    }


    //
    // C++:  Ptr_StereoMatcher createRightMatcher(Ptr_StereoMatcher matcher_left)
    //

    //javadoc: createRightMatcher(matcher_left)
    public static StereoMatcher createRightMatcher(StereoMatcher matcher_left)
    {
        
        StereoMatcher retVal = StereoMatcher.__fromPtr__(createRightMatcher_0(matcher_left.getNativeObjAddr()));
        
        return retVal;
    }


    //
    // C++:  Ptr_StructuredEdgeDetection createStructuredEdgeDetection(String model, Ptr_RFFeatureGetter howToGetFeatures = Ptr<RFFeatureGetter>())
    //

    //javadoc: createStructuredEdgeDetection(model, howToGetFeatures)
    public static StructuredEdgeDetection createStructuredEdgeDetection(String model, RFFeatureGetter howToGetFeatures)
    {
        
        StructuredEdgeDetection retVal = StructuredEdgeDetection.__fromPtr__(createStructuredEdgeDetection_0(model, howToGetFeatures.getNativeObjAddr()));
        
        return retVal;
    }

    //javadoc: createStructuredEdgeDetection(model)
    public static StructuredEdgeDetection createStructuredEdgeDetection(String model)
    {
        
        StructuredEdgeDetection retVal = StructuredEdgeDetection.__fromPtr__(createStructuredEdgeDetection_1(model));
        
        return retVal;
    }


    //
    // C++:  Ptr_SuperpixelLSC createSuperpixelLSC(Mat image, int region_size = 10, float ratio = 0.075f)
    //

    //javadoc: createSuperpixelLSC(image, region_size, ratio)
    public static SuperpixelLSC createSuperpixelLSC(Mat image, int region_size, float ratio)
    {
        
        SuperpixelLSC retVal = SuperpixelLSC.__fromPtr__(createSuperpixelLSC_0(image.nativeObj, region_size, ratio));
        
        return retVal;
    }

    //javadoc: createSuperpixelLSC(image)
    public static SuperpixelLSC createSuperpixelLSC(Mat image)
    {
        
        SuperpixelLSC retVal = SuperpixelLSC.__fromPtr__(createSuperpixelLSC_1(image.nativeObj));
        
        return retVal;
    }


    //
    // C++:  Ptr_SuperpixelSEEDS createSuperpixelSEEDS(int image_width, int image_height, int image_channels, int num_superpixels, int num_levels, int prior = 2, int histogram_bins = 5, bool double_step = false)
    //

    //javadoc: createSuperpixelSEEDS(image_width, image_height, image_channels, num_superpixels, num_levels, prior, histogram_bins, double_step)
    public static SuperpixelSEEDS createSuperpixelSEEDS(int image_width, int image_height, int image_channels, int num_superpixels, int num_levels, int prior, int histogram_bins, boolean double_step)
    {
        
        SuperpixelSEEDS retVal = SuperpixelSEEDS.__fromPtr__(createSuperpixelSEEDS_0(image_width, image_height, image_channels, num_superpixels, num_levels, prior, histogram_bins, double_step));
        
        return retVal;
    }

    //javadoc: createSuperpixelSEEDS(image_width, image_height, image_channels, num_superpixels, num_levels)
    public static SuperpixelSEEDS createSuperpixelSEEDS(int image_width, int image_height, int image_channels, int num_superpixels, int num_levels)
    {
        
        SuperpixelSEEDS retVal = SuperpixelSEEDS.__fromPtr__(createSuperpixelSEEDS_1(image_width, image_height, image_channels, num_superpixels, num_levels));
        
        return retVal;
    }


    //
    // C++:  Ptr_SuperpixelSLIC createSuperpixelSLIC(Mat image, int algorithm = SLICO, int region_size = 10, float ruler = 10.0f)
    //

    //javadoc: createSuperpixelSLIC(image, algorithm, region_size, ruler)
    public static SuperpixelSLIC createSuperpixelSLIC(Mat image, int algorithm, int region_size, float ruler)
    {
        
        SuperpixelSLIC retVal = SuperpixelSLIC.__fromPtr__(createSuperpixelSLIC_0(image.nativeObj, algorithm, region_size, ruler));
        
        return retVal;
    }

    //javadoc: createSuperpixelSLIC(image)
    public static SuperpixelSLIC createSuperpixelSLIC(Mat image)
    {
        
        SuperpixelSLIC retVal = SuperpixelSLIC.__fromPtr__(createSuperpixelSLIC_1(image.nativeObj));
        
        return retVal;
    }


    //
    // C++:  void PeiLinNormalization(Mat I, Mat& T)
    //

    //javadoc: PeiLinNormalization(I, T)
    public static void PeiLinNormalization(Mat I, Mat T)
    {
        
        PeiLinNormalization_0(I.nativeObj, T.nativeObj);
        
        return;
    }


    //
    // C++:  void amFilter(Mat joint, Mat src, Mat& dst, double sigma_s, double sigma_r, bool adjust_outliers = false)
    //

    //javadoc: amFilter(joint, src, dst, sigma_s, sigma_r, adjust_outliers)
    public static void amFilter(Mat joint, Mat src, Mat dst, double sigma_s, double sigma_r, boolean adjust_outliers)
    {
        
        amFilter_0(joint.nativeObj, src.nativeObj, dst.nativeObj, sigma_s, sigma_r, adjust_outliers);
        
        return;
    }

    //javadoc: amFilter(joint, src, dst, sigma_s, sigma_r)
    public static void amFilter(Mat joint, Mat src, Mat dst, double sigma_s, double sigma_r)
    {
        
        amFilter_1(joint.nativeObj, src.nativeObj, dst.nativeObj, sigma_s, sigma_r);
        
        return;
    }


    //
    // C++:  void anisotropicDiffusion(Mat src, Mat& dst, float alpha, float K, int niters)
    //

    //javadoc: anisotropicDiffusion(src, dst, alpha, K, niters)
    public static void anisotropicDiffusion(Mat src, Mat dst, float alpha, float K, int niters)
    {
        
        anisotropicDiffusion_0(src.nativeObj, dst.nativeObj, alpha, K, niters);
        
        return;
    }


    //
    // C++:  void bilateralTextureFilter(Mat src, Mat& dst, int fr = 3, int numIter = 1, double sigmaAlpha = -1., double sigmaAvg = -1.)
    //

    //javadoc: bilateralTextureFilter(src, dst, fr, numIter, sigmaAlpha, sigmaAvg)
    public static void bilateralTextureFilter(Mat src, Mat dst, int fr, int numIter, double sigmaAlpha, double sigmaAvg)
    {
        
        bilateralTextureFilter_0(src.nativeObj, dst.nativeObj, fr, numIter, sigmaAlpha, sigmaAvg);
        
        return;
    }

    //javadoc: bilateralTextureFilter(src, dst)
    public static void bilateralTextureFilter(Mat src, Mat dst)
    {
        
        bilateralTextureFilter_1(src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void contourSampling(Mat src, Mat& out, int nbElt)
    //

    //javadoc: contourSampling(src, out, nbElt)
    public static void contourSampling(Mat src, Mat out, int nbElt)
    {
        
        contourSampling_0(src.nativeObj, out.nativeObj, nbElt);
        
        return;
    }


    //
    // C++:  void covarianceEstimation(Mat src, Mat& dst, int windowRows, int windowCols)
    //

    //javadoc: covarianceEstimation(src, dst, windowRows, windowCols)
    public static void covarianceEstimation(Mat src, Mat dst, int windowRows, int windowCols)
    {
        
        covarianceEstimation_0(src.nativeObj, dst.nativeObj, windowRows, windowCols);
        
        return;
    }


    //
    // C++:  void dtFilter(Mat guide, Mat src, Mat& dst, double sigmaSpatial, double sigmaColor, int mode = DTF_NC, int numIters = 3)
    //

    //javadoc: dtFilter(guide, src, dst, sigmaSpatial, sigmaColor, mode, numIters)
    public static void dtFilter(Mat guide, Mat src, Mat dst, double sigmaSpatial, double sigmaColor, int mode, int numIters)
    {
        
        dtFilter_0(guide.nativeObj, src.nativeObj, dst.nativeObj, sigmaSpatial, sigmaColor, mode, numIters);
        
        return;
    }

    //javadoc: dtFilter(guide, src, dst, sigmaSpatial, sigmaColor)
    public static void dtFilter(Mat guide, Mat src, Mat dst, double sigmaSpatial, double sigmaColor)
    {
        
        dtFilter_1(guide.nativeObj, src.nativeObj, dst.nativeObj, sigmaSpatial, sigmaColor);
        
        return;
    }


    //
    // C++:  void fastGlobalSmootherFilter(Mat guide, Mat src, Mat& dst, double lambda, double sigma_color, double lambda_attenuation = 0.25, int num_iter = 3)
    //

    //javadoc: fastGlobalSmootherFilter(guide, src, dst, lambda, sigma_color, lambda_attenuation, num_iter)
    public static void fastGlobalSmootherFilter(Mat guide, Mat src, Mat dst, double lambda, double sigma_color, double lambda_attenuation, int num_iter)
    {
        
        fastGlobalSmootherFilter_0(guide.nativeObj, src.nativeObj, dst.nativeObj, lambda, sigma_color, lambda_attenuation, num_iter);
        
        return;
    }

    //javadoc: fastGlobalSmootherFilter(guide, src, dst, lambda, sigma_color)
    public static void fastGlobalSmootherFilter(Mat guide, Mat src, Mat dst, double lambda, double sigma_color)
    {
        
        fastGlobalSmootherFilter_1(guide.nativeObj, src.nativeObj, dst.nativeObj, lambda, sigma_color);
        
        return;
    }


    //
    // C++:  void fourierDescriptor(Mat src, Mat& dst, int nbElt = -1, int nbFD = -1)
    //

    //javadoc: fourierDescriptor(src, dst, nbElt, nbFD)
    public static void fourierDescriptor(Mat src, Mat dst, int nbElt, int nbFD)
    {
        
        fourierDescriptor_0(src.nativeObj, dst.nativeObj, nbElt, nbFD);
        
        return;
    }

    //javadoc: fourierDescriptor(src, dst)
    public static void fourierDescriptor(Mat src, Mat dst)
    {
        
        fourierDescriptor_1(src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void guidedFilter(Mat guide, Mat src, Mat& dst, int radius, double eps, int dDepth = -1)
    //

    //javadoc: guidedFilter(guide, src, dst, radius, eps, dDepth)
    public static void guidedFilter(Mat guide, Mat src, Mat dst, int radius, double eps, int dDepth)
    {
        
        guidedFilter_0(guide.nativeObj, src.nativeObj, dst.nativeObj, radius, eps, dDepth);
        
        return;
    }

    //javadoc: guidedFilter(guide, src, dst, radius, eps)
    public static void guidedFilter(Mat guide, Mat src, Mat dst, int radius, double eps)
    {
        
        guidedFilter_1(guide.nativeObj, src.nativeObj, dst.nativeObj, radius, eps);
        
        return;
    }


    //
    // C++:  void jointBilateralFilter(Mat joint, Mat src, Mat& dst, int d, double sigmaColor, double sigmaSpace, int borderType = BORDER_DEFAULT)
    //

    //javadoc: jointBilateralFilter(joint, src, dst, d, sigmaColor, sigmaSpace, borderType)
    public static void jointBilateralFilter(Mat joint, Mat src, Mat dst, int d, double sigmaColor, double sigmaSpace, int borderType)
    {
        
        jointBilateralFilter_0(joint.nativeObj, src.nativeObj, dst.nativeObj, d, sigmaColor, sigmaSpace, borderType);
        
        return;
    }

    //javadoc: jointBilateralFilter(joint, src, dst, d, sigmaColor, sigmaSpace)
    public static void jointBilateralFilter(Mat joint, Mat src, Mat dst, int d, double sigmaColor, double sigmaSpace)
    {
        
        jointBilateralFilter_1(joint.nativeObj, src.nativeObj, dst.nativeObj, d, sigmaColor, sigmaSpace);
        
        return;
    }


    //
    // C++:  void l0Smooth(Mat src, Mat& dst, double lambda = 0.02, double kappa = 2.0)
    //

    //javadoc: l0Smooth(src, dst, lambda, kappa)
    public static void l0Smooth(Mat src, Mat dst, double lambda, double kappa)
    {
        
        l0Smooth_0(src.nativeObj, dst.nativeObj, lambda, kappa);
        
        return;
    }

    //javadoc: l0Smooth(src, dst)
    public static void l0Smooth(Mat src, Mat dst)
    {
        
        l0Smooth_1(src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void niBlackThreshold(Mat _src, Mat& _dst, double maxValue, int type, int blockSize, double k, int binarizationMethod = BINARIZATION_NIBLACK)
    //

    //javadoc: niBlackThreshold(_src, _dst, maxValue, type, blockSize, k, binarizationMethod)
    public static void niBlackThreshold(Mat _src, Mat _dst, double maxValue, int type, int blockSize, double k, int binarizationMethod)
    {
        
        niBlackThreshold_0(_src.nativeObj, _dst.nativeObj, maxValue, type, blockSize, k, binarizationMethod);
        
        return;
    }

    //javadoc: niBlackThreshold(_src, _dst, maxValue, type, blockSize, k)
    public static void niBlackThreshold(Mat _src, Mat _dst, double maxValue, int type, int blockSize, double k)
    {
        
        niBlackThreshold_1(_src.nativeObj, _dst.nativeObj, maxValue, type, blockSize, k);
        
        return;
    }


    //
    // C++:  void rollingGuidanceFilter(Mat src, Mat& dst, int d = -1, double sigmaColor = 25, double sigmaSpace = 3, int numOfIter = 4, int borderType = BORDER_DEFAULT)
    //

    //javadoc: rollingGuidanceFilter(src, dst, d, sigmaColor, sigmaSpace, numOfIter, borderType)
    public static void rollingGuidanceFilter(Mat src, Mat dst, int d, double sigmaColor, double sigmaSpace, int numOfIter, int borderType)
    {
        
        rollingGuidanceFilter_0(src.nativeObj, dst.nativeObj, d, sigmaColor, sigmaSpace, numOfIter, borderType);
        
        return;
    }

    //javadoc: rollingGuidanceFilter(src, dst, d, sigmaColor, sigmaSpace, numOfIter)
    public static void rollingGuidanceFilter(Mat src, Mat dst, int d, double sigmaColor, double sigmaSpace, int numOfIter)
    {
        
        rollingGuidanceFilter_1(src.nativeObj, dst.nativeObj, d, sigmaColor, sigmaSpace, numOfIter);
        
        return;
    }

    //javadoc: rollingGuidanceFilter(src, dst)
    public static void rollingGuidanceFilter(Mat src, Mat dst)
    {
        
        rollingGuidanceFilter_2(src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void thinning(Mat src, Mat& dst, int thinningType = THINNING_ZHANGSUEN)
    //

    //javadoc: thinning(src, dst, thinningType)
    public static void thinning(Mat src, Mat dst, int thinningType)
    {
        
        thinning_0(src.nativeObj, dst.nativeObj, thinningType);
        
        return;
    }

    //javadoc: thinning(src, dst)
    public static void thinning(Mat src, Mat dst)
    {
        
        thinning_1(src.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void transformFD(Mat src, Mat t, Mat& dst, bool fdContour = true)
    //

    //javadoc: transformFD(src, t, dst, fdContour)
    public static void transformFD(Mat src, Mat t, Mat dst, boolean fdContour)
    {
        
        transformFD_0(src.nativeObj, t.nativeObj, dst.nativeObj, fdContour);
        
        return;
    }

    //javadoc: transformFD(src, t, dst)
    public static void transformFD(Mat src, Mat t, Mat dst)
    {
        
        transformFD_1(src.nativeObj, t.nativeObj, dst.nativeObj);
        
        return;
    }


    //
    // C++:  void weightedMedianFilter(Mat joint, Mat src, Mat& dst, int r, double sigma = 25.5, int weightType = WMF_EXP, Mat mask = Mat())
    //

    //javadoc: weightedMedianFilter(joint, src, dst, r, sigma, weightType, mask)
    public static void weightedMedianFilter(Mat joint, Mat src, Mat dst, int r, double sigma, int weightType, Mat mask)
    {
        
        weightedMedianFilter_0(joint.nativeObj, src.nativeObj, dst.nativeObj, r, sigma, weightType, mask.nativeObj);
        
        return;
    }

    //javadoc: weightedMedianFilter(joint, src, dst, r, sigma, weightType)
    public static void weightedMedianFilter(Mat joint, Mat src, Mat dst, int r, double sigma, int weightType)
    {
        
        weightedMedianFilter_1(joint.nativeObj, src.nativeObj, dst.nativeObj, r, sigma, weightType);
        
        return;
    }

    //javadoc: weightedMedianFilter(joint, src, dst, r)
    public static void weightedMedianFilter(Mat joint, Mat src, Mat dst, int r)
    {
        
        weightedMedianFilter_2(joint.nativeObj, src.nativeObj, dst.nativeObj, r);
        
        return;
    }




    // C++:  Ptr_AdaptiveManifoldFilter createAMFilter(double sigma_s, double sigma_r, bool adjust_outliers = false)
    private static native long createAMFilter_0(double sigma_s, double sigma_r, boolean adjust_outliers);
    private static native long createAMFilter_1(double sigma_s, double sigma_r);

    // C++:  Ptr_ContourFitting createContourFitting(int ctr = 1024, int fd = 16)
    private static native long createContourFitting_0(int ctr, int fd);
    private static native long createContourFitting_1();

    // C++:  Ptr_DTFilter createDTFilter(Mat guide, double sigmaSpatial, double sigmaColor, int mode = DTF_NC, int numIters = 3)
    private static native long createDTFilter_0(long guide_nativeObj, double sigmaSpatial, double sigmaColor, int mode, int numIters);
    private static native long createDTFilter_1(long guide_nativeObj, double sigmaSpatial, double sigmaColor);

    // C++:  Ptr_DisparityWLSFilter createDisparityWLSFilter(Ptr_StereoMatcher matcher_left)
    private static native long createDisparityWLSFilter_0(long matcher_left_nativeObj);

    // C++:  Ptr_DisparityWLSFilter createDisparityWLSFilterGeneric(bool use_confidence)
    private static native long createDisparityWLSFilterGeneric_0(boolean use_confidence);

    // C++:  Ptr_EdgeAwareInterpolator createEdgeAwareInterpolator()
    private static native long createEdgeAwareInterpolator_0();

    // C++:  Ptr_EdgeBoxes createEdgeBoxes(float alpha = 0.65f, float beta = 0.75f, float eta = 1, float minScore = 0.01f, int maxBoxes = 10000, float edgeMinMag = 0.1f, float edgeMergeThr = 0.5f, float clusterMinMag = 0.5f, float maxAspectRatio = 3, float minBoxArea = 1000, float gamma = 2, float kappa = 1.5f)
    private static native long createEdgeBoxes_0(float alpha, float beta, float eta, float minScore, int maxBoxes, float edgeMinMag, float edgeMergeThr, float clusterMinMag, float maxAspectRatio, float minBoxArea, float gamma, float kappa);
    private static native long createEdgeBoxes_1();

    // C++:  Ptr_FastGlobalSmootherFilter createFastGlobalSmootherFilter(Mat guide, double lambda, double sigma_color, double lambda_attenuation = 0.25, int num_iter = 3)
    private static native long createFastGlobalSmootherFilter_0(long guide_nativeObj, double lambda, double sigma_color, double lambda_attenuation, int num_iter);
    private static native long createFastGlobalSmootherFilter_1(long guide_nativeObj, double lambda, double sigma_color);

    // C++:  Ptr_FastLineDetector createFastLineDetector(int _length_threshold = 10, float _distance_threshold = 1.414213562f, double _canny_th1 = 50.0, double _canny_th2 = 50.0, int _canny_aperture_size = 3, bool _do_merge = false)
    private static native long createFastLineDetector_0(int _length_threshold, float _distance_threshold, double _canny_th1, double _canny_th2, int _canny_aperture_size, boolean _do_merge);
    private static native long createFastLineDetector_1();

    // C++:  Ptr_GraphSegmentation createGraphSegmentation(double sigma = 0.5, float k = 300, int min_size = 100)
    private static native long createGraphSegmentation_0(double sigma, float k, int min_size);
    private static native long createGraphSegmentation_1();

    // C++:  Ptr_GuidedFilter createGuidedFilter(Mat guide, int radius, double eps)
    private static native long createGuidedFilter_0(long guide_nativeObj, int radius, double eps);

    // C++:  Ptr_RFFeatureGetter createRFFeatureGetter()
    private static native long createRFFeatureGetter_0();

    // C++:  Ptr_SelectiveSearchSegmentation createSelectiveSearchSegmentation()
    private static native long createSelectiveSearchSegmentation_0();

    // C++:  Ptr_SelectiveSearchSegmentationStrategyColor createSelectiveSearchSegmentationStrategyColor()
    private static native long createSelectiveSearchSegmentationStrategyColor_0();

    // C++:  Ptr_SelectiveSearchSegmentationStrategyFill createSelectiveSearchSegmentationStrategyFill()
    private static native long createSelectiveSearchSegmentationStrategyFill_0();

    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1, Ptr_SelectiveSearchSegmentationStrategy s2, Ptr_SelectiveSearchSegmentationStrategy s3, Ptr_SelectiveSearchSegmentationStrategy s4)
    private static native long createSelectiveSearchSegmentationStrategyMultiple_0(long s1_nativeObj, long s2_nativeObj, long s3_nativeObj, long s4_nativeObj);

    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1, Ptr_SelectiveSearchSegmentationStrategy s2, Ptr_SelectiveSearchSegmentationStrategy s3)
    private static native long createSelectiveSearchSegmentationStrategyMultiple_1(long s1_nativeObj, long s2_nativeObj, long s3_nativeObj);

    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1, Ptr_SelectiveSearchSegmentationStrategy s2)
    private static native long createSelectiveSearchSegmentationStrategyMultiple_2(long s1_nativeObj, long s2_nativeObj);

    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple(Ptr_SelectiveSearchSegmentationStrategy s1)
    private static native long createSelectiveSearchSegmentationStrategyMultiple_3(long s1_nativeObj);

    // C++:  Ptr_SelectiveSearchSegmentationStrategyMultiple createSelectiveSearchSegmentationStrategyMultiple()
    private static native long createSelectiveSearchSegmentationStrategyMultiple_4();

    // C++:  Ptr_SelectiveSearchSegmentationStrategySize createSelectiveSearchSegmentationStrategySize()
    private static native long createSelectiveSearchSegmentationStrategySize_0();

    // C++:  Ptr_SelectiveSearchSegmentationStrategyTexture createSelectiveSearchSegmentationStrategyTexture()
    private static native long createSelectiveSearchSegmentationStrategyTexture_0();

    // C++:  Ptr_StereoMatcher createRightMatcher(Ptr_StereoMatcher matcher_left)
    private static native long createRightMatcher_0(long matcher_left_nativeObj);

    // C++:  Ptr_StructuredEdgeDetection createStructuredEdgeDetection(String model, Ptr_RFFeatureGetter howToGetFeatures = Ptr<RFFeatureGetter>())
    private static native long createStructuredEdgeDetection_0(String model, long howToGetFeatures_nativeObj);
    private static native long createStructuredEdgeDetection_1(String model);

    // C++:  Ptr_SuperpixelLSC createSuperpixelLSC(Mat image, int region_size = 10, float ratio = 0.075f)
    private static native long createSuperpixelLSC_0(long image_nativeObj, int region_size, float ratio);
    private static native long createSuperpixelLSC_1(long image_nativeObj);

    // C++:  Ptr_SuperpixelSEEDS createSuperpixelSEEDS(int image_width, int image_height, int image_channels, int num_superpixels, int num_levels, int prior = 2, int histogram_bins = 5, bool double_step = false)
    private static native long createSuperpixelSEEDS_0(int image_width, int image_height, int image_channels, int num_superpixels, int num_levels, int prior, int histogram_bins, boolean double_step);
    private static native long createSuperpixelSEEDS_1(int image_width, int image_height, int image_channels, int num_superpixels, int num_levels);

    // C++:  Ptr_SuperpixelSLIC createSuperpixelSLIC(Mat image, int algorithm = SLICO, int region_size = 10, float ruler = 10.0f)
    private static native long createSuperpixelSLIC_0(long image_nativeObj, int algorithm, int region_size, float ruler);
    private static native long createSuperpixelSLIC_1(long image_nativeObj);

    // C++:  void PeiLinNormalization(Mat I, Mat& T)
    private static native void PeiLinNormalization_0(long I_nativeObj, long T_nativeObj);

    // C++:  void amFilter(Mat joint, Mat src, Mat& dst, double sigma_s, double sigma_r, bool adjust_outliers = false)
    private static native void amFilter_0(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, double sigma_s, double sigma_r, boolean adjust_outliers);
    private static native void amFilter_1(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, double sigma_s, double sigma_r);

    // C++:  void anisotropicDiffusion(Mat src, Mat& dst, float alpha, float K, int niters)
    private static native void anisotropicDiffusion_0(long src_nativeObj, long dst_nativeObj, float alpha, float K, int niters);

    // C++:  void bilateralTextureFilter(Mat src, Mat& dst, int fr = 3, int numIter = 1, double sigmaAlpha = -1., double sigmaAvg = -1.)
    private static native void bilateralTextureFilter_0(long src_nativeObj, long dst_nativeObj, int fr, int numIter, double sigmaAlpha, double sigmaAvg);
    private static native void bilateralTextureFilter_1(long src_nativeObj, long dst_nativeObj);

    // C++:  void contourSampling(Mat src, Mat& out, int nbElt)
    private static native void contourSampling_0(long src_nativeObj, long out_nativeObj, int nbElt);

    // C++:  void covarianceEstimation(Mat src, Mat& dst, int windowRows, int windowCols)
    private static native void covarianceEstimation_0(long src_nativeObj, long dst_nativeObj, int windowRows, int windowCols);

    // C++:  void dtFilter(Mat guide, Mat src, Mat& dst, double sigmaSpatial, double sigmaColor, int mode = DTF_NC, int numIters = 3)
    private static native void dtFilter_0(long guide_nativeObj, long src_nativeObj, long dst_nativeObj, double sigmaSpatial, double sigmaColor, int mode, int numIters);
    private static native void dtFilter_1(long guide_nativeObj, long src_nativeObj, long dst_nativeObj, double sigmaSpatial, double sigmaColor);

    // C++:  void fastGlobalSmootherFilter(Mat guide, Mat src, Mat& dst, double lambda, double sigma_color, double lambda_attenuation = 0.25, int num_iter = 3)
    private static native void fastGlobalSmootherFilter_0(long guide_nativeObj, long src_nativeObj, long dst_nativeObj, double lambda, double sigma_color, double lambda_attenuation, int num_iter);
    private static native void fastGlobalSmootherFilter_1(long guide_nativeObj, long src_nativeObj, long dst_nativeObj, double lambda, double sigma_color);

    // C++:  void fourierDescriptor(Mat src, Mat& dst, int nbElt = -1, int nbFD = -1)
    private static native void fourierDescriptor_0(long src_nativeObj, long dst_nativeObj, int nbElt, int nbFD);
    private static native void fourierDescriptor_1(long src_nativeObj, long dst_nativeObj);

    // C++:  void guidedFilter(Mat guide, Mat src, Mat& dst, int radius, double eps, int dDepth = -1)
    private static native void guidedFilter_0(long guide_nativeObj, long src_nativeObj, long dst_nativeObj, int radius, double eps, int dDepth);
    private static native void guidedFilter_1(long guide_nativeObj, long src_nativeObj, long dst_nativeObj, int radius, double eps);

    // C++:  void jointBilateralFilter(Mat joint, Mat src, Mat& dst, int d, double sigmaColor, double sigmaSpace, int borderType = BORDER_DEFAULT)
    private static native void jointBilateralFilter_0(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, int d, double sigmaColor, double sigmaSpace, int borderType);
    private static native void jointBilateralFilter_1(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, int d, double sigmaColor, double sigmaSpace);

    // C++:  void l0Smooth(Mat src, Mat& dst, double lambda = 0.02, double kappa = 2.0)
    private static native void l0Smooth_0(long src_nativeObj, long dst_nativeObj, double lambda, double kappa);
    private static native void l0Smooth_1(long src_nativeObj, long dst_nativeObj);

    // C++:  void niBlackThreshold(Mat _src, Mat& _dst, double maxValue, int type, int blockSize, double k, int binarizationMethod = BINARIZATION_NIBLACK)
    private static native void niBlackThreshold_0(long _src_nativeObj, long _dst_nativeObj, double maxValue, int type, int blockSize, double k, int binarizationMethod);
    private static native void niBlackThreshold_1(long _src_nativeObj, long _dst_nativeObj, double maxValue, int type, int blockSize, double k);

    // C++:  void rollingGuidanceFilter(Mat src, Mat& dst, int d = -1, double sigmaColor = 25, double sigmaSpace = 3, int numOfIter = 4, int borderType = BORDER_DEFAULT)
    private static native void rollingGuidanceFilter_0(long src_nativeObj, long dst_nativeObj, int d, double sigmaColor, double sigmaSpace, int numOfIter, int borderType);
    private static native void rollingGuidanceFilter_1(long src_nativeObj, long dst_nativeObj, int d, double sigmaColor, double sigmaSpace, int numOfIter);
    private static native void rollingGuidanceFilter_2(long src_nativeObj, long dst_nativeObj);

    // C++:  void thinning(Mat src, Mat& dst, int thinningType = THINNING_ZHANGSUEN)
    private static native void thinning_0(long src_nativeObj, long dst_nativeObj, int thinningType);
    private static native void thinning_1(long src_nativeObj, long dst_nativeObj);

    // C++:  void transformFD(Mat src, Mat t, Mat& dst, bool fdContour = true)
    private static native void transformFD_0(long src_nativeObj, long t_nativeObj, long dst_nativeObj, boolean fdContour);
    private static native void transformFD_1(long src_nativeObj, long t_nativeObj, long dst_nativeObj);

    // C++:  void weightedMedianFilter(Mat joint, Mat src, Mat& dst, int r, double sigma = 25.5, int weightType = WMF_EXP, Mat mask = Mat())
    private static native void weightedMedianFilter_0(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, int r, double sigma, int weightType, long mask_nativeObj);
    private static native void weightedMedianFilter_1(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, int r, double sigma, int weightType);
    private static native void weightedMedianFilter_2(long joint_nativeObj, long src_nativeObj, long dst_nativeObj, int r);

}
