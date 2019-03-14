package albion.linecutfeng.videotoascii.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import albion.linecutfeng.videotoascii.utils.Density;

public class AppApplication extends Application {

    private static  AppApplication appApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        appApplication = this;
        Density.setDensity(this, 360);//360为UI提供设计图的宽度
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static AppApplication getApplication(){
        return appApplication;
    }

}
