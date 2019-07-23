package albion.linecutfeng.videotoascii.interfaces;

import android.content.Context;
import android.graphics.Bitmap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface SimpleProcessInterface {

    @ProcessFunction
    Bitmap lowpoly(Context context,String outputPath);

    @ProcessFunction
    Bitmap emoji(Context context, String outputPath);

    @ProcessFunction
    Bitmap negative(Context context, String outputPath);

    @ProcessFunction
    Bitmap casting(Context context, String outputPath);

    @ProcessFunction
    Bitmap frozen(Context context, String outputPath);

    @ProcessFunction
    Bitmap comicbook(Context context, String outputPath);

    @ProcessFunction
    Bitmap brown(Context context, String outputPath);

    @ProcessFunction
    Bitmap tilerefectrgb(Context context, String outputPath);

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ProcessFunction {
    }
}
