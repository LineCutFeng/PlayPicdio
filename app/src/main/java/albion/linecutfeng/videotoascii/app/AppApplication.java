package albion.linecutfeng.videotoascii.app;

import android.app.Application;

import albion.linecutfeng.videotoascii.utils.Density;

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Density.setDensity(this, 360);//360为UI提供设计图的宽度
    }
}
