//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ximgproc;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.utils.Converters;

// C++: class EdgeBoxes
//javadoc: EdgeBoxes

public class EdgeBoxes extends Algorithm {

    protected EdgeBoxes(long addr) { super(addr); }

    // internal usage only
    public static EdgeBoxes __fromPtr__(long addr) { return new EdgeBoxes(addr); }

    //
    // C++:  float getAlpha()
    //

    //javadoc: EdgeBoxes::getAlpha()
    public  float getAlpha()
    {
        
        float retVal = getAlpha_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getBeta()
    //

    //javadoc: EdgeBoxes::getBeta()
    public  float getBeta()
    {
        
        float retVal = getBeta_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getClusterMinMag()
    //

    //javadoc: EdgeBoxes::getClusterMinMag()
    public  float getClusterMinMag()
    {
        
        float retVal = getClusterMinMag_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getEdgeMergeThr()
    //

    //javadoc: EdgeBoxes::getEdgeMergeThr()
    public  float getEdgeMergeThr()
    {
        
        float retVal = getEdgeMergeThr_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getEdgeMinMag()
    //

    //javadoc: EdgeBoxes::getEdgeMinMag()
    public  float getEdgeMinMag()
    {
        
        float retVal = getEdgeMinMag_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getEta()
    //

    //javadoc: EdgeBoxes::getEta()
    public  float getEta()
    {
        
        float retVal = getEta_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getGamma()
    //

    //javadoc: EdgeBoxes::getGamma()
    public  float getGamma()
    {
        
        float retVal = getGamma_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getKappa()
    //

    //javadoc: EdgeBoxes::getKappa()
    public  float getKappa()
    {
        
        float retVal = getKappa_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getMaxAspectRatio()
    //

    //javadoc: EdgeBoxes::getMaxAspectRatio()
    public  float getMaxAspectRatio()
    {
        
        float retVal = getMaxAspectRatio_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getMinBoxArea()
    //

    //javadoc: EdgeBoxes::getMinBoxArea()
    public  float getMinBoxArea()
    {
        
        float retVal = getMinBoxArea_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getMinScore()
    //

    //javadoc: EdgeBoxes::getMinScore()
    public  float getMinScore()
    {
        
        float retVal = getMinScore_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  int getMaxBoxes()
    //

    //javadoc: EdgeBoxes::getMaxBoxes()
    public  int getMaxBoxes()
    {
        
        int retVal = getMaxBoxes_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  void getBoundingBoxes(Mat edge_map, Mat orientation_map, vector_Rect& boxes)
    //

    //javadoc: EdgeBoxes::getBoundingBoxes(edge_map, orientation_map, boxes)
    public  void getBoundingBoxes(Mat edge_map, Mat orientation_map, MatOfRect boxes)
    {
        Mat boxes_mat = boxes;
        getBoundingBoxes_0(nativeObj, edge_map.nativeObj, orientation_map.nativeObj, boxes_mat.nativeObj);
        
        return;
    }


    //
    // C++:  void setAlpha(float value)
    //

    //javadoc: EdgeBoxes::setAlpha(value)
    public  void setAlpha(float value)
    {
        
        setAlpha_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setBeta(float value)
    //

    //javadoc: EdgeBoxes::setBeta(value)
    public  void setBeta(float value)
    {
        
        setBeta_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setClusterMinMag(float value)
    //

    //javadoc: EdgeBoxes::setClusterMinMag(value)
    public  void setClusterMinMag(float value)
    {
        
        setClusterMinMag_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setEdgeMergeThr(float value)
    //

    //javadoc: EdgeBoxes::setEdgeMergeThr(value)
    public  void setEdgeMergeThr(float value)
    {
        
        setEdgeMergeThr_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setEdgeMinMag(float value)
    //

    //javadoc: EdgeBoxes::setEdgeMinMag(value)
    public  void setEdgeMinMag(float value)
    {
        
        setEdgeMinMag_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setEta(float value)
    //

    //javadoc: EdgeBoxes::setEta(value)
    public  void setEta(float value)
    {
        
        setEta_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setGamma(float value)
    //

    //javadoc: EdgeBoxes::setGamma(value)
    public  void setGamma(float value)
    {
        
        setGamma_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setKappa(float value)
    //

    //javadoc: EdgeBoxes::setKappa(value)
    public  void setKappa(float value)
    {
        
        setKappa_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setMaxAspectRatio(float value)
    //

    //javadoc: EdgeBoxes::setMaxAspectRatio(value)
    public  void setMaxAspectRatio(float value)
    {
        
        setMaxAspectRatio_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setMaxBoxes(int value)
    //

    //javadoc: EdgeBoxes::setMaxBoxes(value)
    public  void setMaxBoxes(int value)
    {
        
        setMaxBoxes_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setMinBoxArea(float value)
    //

    //javadoc: EdgeBoxes::setMinBoxArea(value)
    public  void setMinBoxArea(float value)
    {
        
        setMinBoxArea_0(nativeObj, value);
        
        return;
    }


    //
    // C++:  void setMinScore(float value)
    //

    //javadoc: EdgeBoxes::setMinScore(value)
    public  void setMinScore(float value)
    {
        
        setMinScore_0(nativeObj, value);
        
        return;
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  float getAlpha()
    private static native float getAlpha_0(long nativeObj);

    // C++:  float getBeta()
    private static native float getBeta_0(long nativeObj);

    // C++:  float getClusterMinMag()
    private static native float getClusterMinMag_0(long nativeObj);

    // C++:  float getEdgeMergeThr()
    private static native float getEdgeMergeThr_0(long nativeObj);

    // C++:  float getEdgeMinMag()
    private static native float getEdgeMinMag_0(long nativeObj);

    // C++:  float getEta()
    private static native float getEta_0(long nativeObj);

    // C++:  float getGamma()
    private static native float getGamma_0(long nativeObj);

    // C++:  float getKappa()
    private static native float getKappa_0(long nativeObj);

    // C++:  float getMaxAspectRatio()
    private static native float getMaxAspectRatio_0(long nativeObj);

    // C++:  float getMinBoxArea()
    private static native float getMinBoxArea_0(long nativeObj);

    // C++:  float getMinScore()
    private static native float getMinScore_0(long nativeObj);

    // C++:  int getMaxBoxes()
    private static native int getMaxBoxes_0(long nativeObj);

    // C++:  void getBoundingBoxes(Mat edge_map, Mat orientation_map, vector_Rect& boxes)
    private static native void getBoundingBoxes_0(long nativeObj, long edge_map_nativeObj, long orientation_map_nativeObj, long boxes_mat_nativeObj);

    // C++:  void setAlpha(float value)
    private static native void setAlpha_0(long nativeObj, float value);

    // C++:  void setBeta(float value)
    private static native void setBeta_0(long nativeObj, float value);

    // C++:  void setClusterMinMag(float value)
    private static native void setClusterMinMag_0(long nativeObj, float value);

    // C++:  void setEdgeMergeThr(float value)
    private static native void setEdgeMergeThr_0(long nativeObj, float value);

    // C++:  void setEdgeMinMag(float value)
    private static native void setEdgeMinMag_0(long nativeObj, float value);

    // C++:  void setEta(float value)
    private static native void setEta_0(long nativeObj, float value);

    // C++:  void setGamma(float value)
    private static native void setGamma_0(long nativeObj, float value);

    // C++:  void setKappa(float value)
    private static native void setKappa_0(long nativeObj, float value);

    // C++:  void setMaxAspectRatio(float value)
    private static native void setMaxAspectRatio_0(long nativeObj, float value);

    // C++:  void setMaxBoxes(int value)
    private static native void setMaxBoxes_0(long nativeObj, int value);

    // C++:  void setMinBoxArea(float value)
    private static native void setMinBoxArea_0(long nativeObj, float value);

    // C++:  void setMinScore(float value)
    private static native void setMinScore_0(long nativeObj, float value);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
