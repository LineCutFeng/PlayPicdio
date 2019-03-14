# VideoToAscii
### Android picture or video to ascii pic or video.
简书：https://www.jianshu.com/p/a14f1ac558e1
</br>
csdn：https://blog.csdn.net/u010308894/article/details/82689023
### 安卓 图片或者视频转化成 ascii码的图片或视频。
### ascii码效果图
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/step.jpg"  width=40%/>
</br>
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/lenna.jpg"  width=40%/>
</br>
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/zhuangbi.jpg"  width=40%/>
</br>
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/beach.jpg"  width=40%/>

### 低多边形效果图
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/me.png"  width=40%/>
</br>
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/girl_lowpoly.png"  width=40%/>

### emoji-masic效果图
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/miku.png"  width=40%/>
</br>
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/kubaki.png"  width=40%/>
</br>

- 进行媒体文件ascii码化。
如果媒体文件是图片，直接进行转化,这里首先对Bitmap的全部像素点进行了灰度转化，因为对图片进行了采样式缩放1:7的话，就是每7个点采集一个，这样大概会按照一个ascii码对应一个的像素点的，不同灰度采用不同的ascii码替换，代码如下：

```java
public static Bitmap createAsciiPic(final String path, Context context) {
        final String base = "#8XOHLTI)i=+;:,.";// 字符串由复杂到简单
//        final String base = "#,.0123456789:;@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";// 字符串由复杂到简单
        StringBuilder text = new StringBuilder();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        Bitmap image = BitmapFactory.decodeFile(path);  //读取图片
        int width0 = image.getWidth();
        int height0 = image.getHeight();
        int width1, height1;
        int scale = 7;
        if (width0 <= width / scale) {
            width1 = width0;
            height1 = height0;
        } else {
            width1 = width / scale;
            height1 = width1 * height0 / width0;
        }
        image = scale(path, width1, height1);  //读取图片
        //输出到指定文件中
        for (int y = 0; y < image.getHeight(); y += 2) {
            for (int x = 0; x < image.getWidth(); x++) {
                final int pixel = image.getPixel(x, y);
                final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                final int index = Math.round(gray * (base.length() + 1) / 255);
                String s = index >= base.length() ? " " : String.valueOf(base.charAt(index));
                text.append(s);
            }
            text.append("\n");
        }
        return textAsBitmap(text, context);
//        return image;
    }
```
- 将ascii码化的图片进行处理，如果是视频就就行合并。
使用了ffmpeg进行视频合并，先拼ffmpeg命令
```java
public static String[] concatVideo(String _filePath, String _outPath,String fps) {//-f concat -i list.txt -c copy concat.mp4
        ArrayList<String> _commands = new ArrayList<>();

        {

            _commands.add("ffmpeg");
            _commands.add("-f");
            _commands.add("image2");
            _commands.add("-framerate");
            _commands.add(fps);
            _commands.add("-i");
            _commands.add(_filePath+"/test%05d.png");
//            _commands.add("-filter_complex");
//            _commands.add("[1:v]scale=1920:1080[s];[0:v][s]overlay=0:0");
            _commands.add("-b");
            _commands.add("1000k");
//            _commands.add("-s");
//            _commands.add("640x360");
            _commands.add("-ss");
            _commands.add("0:00:00");
            _commands.add("-r");
            _commands.add("50");
            _commands.add(_outPath);
        }


        String[] commands = new String[_commands.size()];
        String _pr = "";
        for (int i = 0; i < _commands.size(); i++) {
            commands[i] = _commands.get(i);
            _pr += commands[i];
        }
        Log.d("LOGCAT", "ffmpeg command:" + _pr + "-" + commands.length);
        return commands;

    }
```
封装到线程池里,内部跑一个AsyncTask
```java
 String[] commands = ffmpegCommandCentre.concatVideo(picListPath, basePath + "/" + videoName, fps + "");
        final String[] _commands = commands;
        Runnable compoundRun = new Runnable() {
            @Override
            public void run() {
                FFmpegKit.execute(_commands, new FFmpegKit.KitInterface() {
                    @Override
                    public void onStart() {
                        mHander.post(new Runnable() {
                            @Override
                            public void run() {
                                showProgress("正在合成视频，时长视fps大概为视频时长的2到3倍请稍后...");
                            }
                        });

                        Log.d("FFmpegLog LOGCAT", "FFmpeg 命令行开始执行了...");
                    }

                    @Override
                    public void onProgress(int progress) {
                        Log.d("FFmpegLog LOGCAT", "done com" + "FFmpeg 命令行执行进度..." + progress);
                    }

                    @Override
                    public void onEnd(int result) {
                        mHander.post(new Runnable() {
                            @Override
                            public void run() {
                                dismissDialog();
                                Toast.makeText(MainActivity.this, "合并完成，请进入目录" + "SD卡下/albion.linecutfeng.videotoascii/目录" + "查看", Toast.LENGTH_SHORT).show();
//                                showOpenDialog(basePath + "/" + videoName);
                            }
                        });
                        Log.d("FFmpegLog LOGCAT", "FFmpeg 命令行执行完成...");
                    }
                });
            }
        };
        ThreadPoolUtils.execute(compoundRun);
```
子线程内跑调用ffmpeg的本地方法将图片序列合并成视频
```java
public native static int run(String[] commands);
```
本地方法如下
```c
JNIEXPORT jint JNICALL Java_codepig_ffmpegcldemo_FFmpegKit_run
(JNIEnv *env, jclass obj, jobjectArray commands){
    //FFmpeg av_log() callback
    int argc = (*env)->GetArrayLength(env, commands);
    char *argv[argc];

    LOGD("Kit argc %d\n", argc);
    int i;
    for (i = 0; i < argc; i++) {
        jstring js = (jstring) (*env)->GetObjectArrayElement(env, commands, i);
        argv[i] = (char*) (*env)->GetStringUTFChars(env, js, 0);
        LOGD("Kit argv %s\n", argv[i]);
    }
    return run(argc, argv);
}
```
最后得到视频
</br>
<img src="https://github.com/GodFengShen/PicOrVideoToAscii/blob/master/pic/fzk.gif"  width=40%/>
</br>
小小的遗憾，调用Intent打开视频，显示文件不存在- -，其实文件在那个目录下呢- -!
