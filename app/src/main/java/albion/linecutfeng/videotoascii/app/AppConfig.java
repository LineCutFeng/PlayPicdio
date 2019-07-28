package albion.linecutfeng.videotoascii.app;

import android.os.Environment;

public class AppConfig {

    public static final String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + "/albion.linecutfeng.videotoascii";
    public static final String PIC_LIST_PATH = BASE_PATH + "/picList";
    public static final String AUDIO_PATH = BASE_PATH + "/audio";
}
