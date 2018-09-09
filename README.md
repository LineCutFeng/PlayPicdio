# VideoToAscii
### Android picture or video to ascii pic or video.
### 安卓 图片或者视频转化成 ascii码的图片或视频。

- 第一步选择媒体文件。

这里使用了一个选择图片的类库  'com.github.LuckSiege.PictureSelector:picture_library:v2.2.3'

```java
public static void choosePhoto(Activity context, int requestCode) {
        PictureSelector.create(context)
                .openGallery(PictureMimeType.ofAll())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                .theme()//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(1)// 最大图片选择数量 int
//                .minSelectNum()// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
//                .previewImage()// 是否可预览图片 true or false
//                .previewVideo()// 是否可预览视频 true or false
//                .enablePreviewAudio() // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
//                .enableCrop(true)// 是否裁剪 true or false
//                .compress(false)// 是否压缩 true or false
//                .glideOverride()// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                .hideBottomControls()// 是否显示uCrop工具栏，默认不显示 true or false
//                .isGif()// 是否显示gif图片 true or false
//                .compressSavePath(context.getFilesDir().getAbsolutePath())//压缩图片保存地址
//                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
//                .circleDimmedLayer(true)// 是否圆形裁剪 true or false
//                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(true)// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs()// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality(90)// 裁剪压缩质量 默认90 int
                .minimumCompressSize(500)// 小于100kb的图片不压缩
//                .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled() // 裁剪是否可旋转图片 true or false
//                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
//                .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
//                .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
//                .isDragFrame(false)// 是否可拖动裁剪框(固定)
                .forResult(requestCode);//结果回调onActivityResult code
    }
```

- 第二步进行媒体文件ascii码化。
如果媒体文件是图片，直接进行转化,这里首先对Bitmap的全部像素点进行了灰度转化，因为对图片进行了采样式缩放1:7的话，就是每7个点采集一个，这样大概会按照一个ascii码对应7没有缩放的像素点的尺寸，不同灰度采用不同的ascii码替换，代码如下：
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
- 第三步将ascii码化的图片进行处理，如果是视频就就行合并。
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
子线程内跑调用ffmpeg的本地方法
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
