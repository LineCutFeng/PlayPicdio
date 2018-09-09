package albion.linecutfeng.videotoascii.activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import albion.linecutfeng.videotoascii.R;
import albion.linecutfeng.videotoascii.app.GlideApp;
import albion.linecutfeng.videotoascii.utils.CommonUtil;
import albion.linecutfeng.videotoascii.utils.EncodeThread;
import albion.linecutfeng.videotoascii.utils.FileUtils;
import albion.linecutfeng.videotoascii.utils.MediaDecoder;
import albion.linecutfeng.videotoascii.utils.MediaFile;
import albion.linecutfeng.videotoascii.utils.ThreadPoolUtils;
import albion.linecutfeng.videotoascii.utils.ffmpegCommandCentre;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import codepig.ffmpegcldemo.FFmpegKit;
import io.reactivex.functions.Consumer;

import static com.luck.picture.lib.config.PictureConfig.CHOOSE_REQUEST;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bt_select)
    Button btSelect;
    @BindView(R.id.progress)
    public ProgressBar progressBar;
    @BindView(R.id.bt_mix)
    Button btMix;
    @BindView(R.id.layout_step2)
    LinearLayout layoutStep2;
    @BindView(R.id.tv_log)
    TextView tvLog;
    @BindView(R.id.bt_convert)
    Button btConvert;
    @BindView(R.id.tv_path)
    TextView tvPath;
    @BindView(R.id.iv_show)
    public ImageView ivShow;

    public static final int FILE_REQUEST_CODE = 101;
    Enum fileType = FILE_TYPE.none;
    public MediaDecoder mediaDecoder;
    String mediaPath = "";
    public static final String basePath = Environment.getExternalStorageDirectory().getPath() + "/albion.linecutfeng.videotoascii";
    public static final String picListPath = basePath + "/picList";
    String[] fpsStringArray = new String[]{"5fps", "10fps", "20fps", "25fps"};
    String[] formatStringArray = new String[]{"avi", "mp4", "gif"};
    int fps = 5;
    MyOnEncoderListener myOnEncoderListener = new MyOnEncoderListener();
//    int mediaWidth = 0;
//    int mediaHeight = 0;

    Handler mHander = new Handler(Looper.getMainLooper());

    enum FILE_TYPE {
        none, pic, video;
    }

    EncodeThread.OnEncoderListener onEncoderListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        checkPermissionAndMakeFile();
    }

    private void checkPermissionAndMakeFile() {
        new RxPermissions(this)
                .request(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE})
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if (granted) {
                            File file = new File(picListPath);
                            if (!file.exists()) {
                                file.mkdirs();
                            } else if (file.isFile()) {
                                file.mkdirs();
                            } else {
                                File[] files = file.listFiles();
                                for (File file1 : files) {
                                    file1.delete();
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "未获取到SD卡读写权限，玩毛线", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @OnClick({R.id.bt_select, R.id.bt_mix, R.id.bt_convert})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_select:
                selectMedia();
                break;

            case R.id.bt_convert:
                convertPic(mediaPath);
                break;
            case R.id.bt_mix:
                selectFormat();
                break;
        }
    }


    /**
     * step1
     * 选择图片
     */
    private void selectMedia() {
        CommonUtil.choosePhoto(this, CHOOSE_REQUEST);
    }

    /**
     * step2
     * 第二步图片或视频分割转化成ascii码图片/图片序列
     *
     * @param path
     */
    void convertPic(final String path) {
        if (fileType == FILE_TYPE.pic) {
            if (TextUtils.isEmpty(path)) return;
            Bitmap bitmap = CommonUtil.createAsciiPic(path, MainActivity.this);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(basePath + "/"+tvPath.getText().toString().trim());
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            ivShow.setImageBitmap(bitmap);
        } else if (fileType == FILE_TYPE.video) {
            new AlertDialog.Builder(this)
                    .setTitle("请选择视频pfs（1秒的帧数）")
                    .setSingleChoiceItems(fpsStringArray, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    fps = 5;
                                    break;
                                case 1:
                                    fps = 10;
                                    break;
                                case 2:
                                    fps = 20;
                                    break;
                                case 3:
                                    fps = 25;
                                    break;
                            }
                            mediaDecoder = new MediaDecoder(path);
                            String videoFileLength = mediaDecoder.getVideoFileLength();
                            int encodeTotalCount = 0;
                            try {
                                encodeTotalCount = Integer.valueOf(videoFileLength) / 200;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                return;
                            }
                            if (encodeTotalCount == 0) {
                                return;
                            }
                            new EncodeThread(mediaPath, fps, myOnEncoderListener, MainActivity.this).start();
                            dialog.dismiss();
                        }
                    }).show();
        }
    }

    private void selectFormat() {
        new AlertDialog.Builder(this)
                .setTitle("请选择将要合成的格式")
                .setSingleChoiceItems(formatStringArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ffmpegMerge(formatStringArray[which]);
                        dialog.dismiss();
                    }
                }).show();
    }


    /**
     * step3
     * 视频合成列表测试
     *
     * @param format
     */
    private void ffmpegMerge(String format) {
        File file = new File(mediaPath);
        if (!file.exists()) return;
        String fileName = file.getName();
        int i = fileName.lastIndexOf(".");
        if (i == -1 || i == 1) {
            Toast.makeText(this, "媒体格式不对，无法进行拼接", Toast.LENGTH_SHORT).show();
            return;
        }
        final String videoName = fileName.substring(0, i) + "." + format;
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
    }

//    /**
//     * 打开视频目录
//     *不知道为啥显示目录无效，所以注释了
//     * @param mediaPath
//     */
//    private void showOpenDialog(String mediaPath) {
//        File file = new File(mediaPath);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
////        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        Uri uri = null;
//        if (Build.VERSION.SDK_INT >= 24) {
//            uri = FileProvider.getUriForFile(this, "albion.linecutfeng.videotoascii.provider", file);
//        } else {
//            uri = Uri.fromFile(file);
//        }
//        intent.setDataAndType(uri, "video/*");
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//        startActivity(intent);
//    }

    /**
     * 调用系统的文件选择器
     */
    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("video/;image/");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_REQUEST_CODE);
        } catch (ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 图片或视频资源预览
     *
     * @param path
     * @param isPic
     */
    public void showMedia(String path, boolean isPic) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                mediaPath = path;
                if (isPic) {
                    tvPath.setText(file.getName());
                    GlideApp
                            .with(this)
                            .load(path)
                            .into(ivShow);
                } else {
                    mediaDecoder = new MediaDecoder(path);
                    String videoFileLength = mediaDecoder.getVideoFileLength();
                    if (TextUtils.isEmpty(videoFileLength)) return;
                    if (Integer.parseInt(videoFileLength) > 0) {
                        Bitmap bitmap = mediaDecoder.decodeFrame(0);
                        GlideApp
                                .with(this)
                                .load(bitmap)
                                .into(ivShow);
                    }
                }
            }
        }
    }

    /**
     * 接收图片选择器返回的结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        layoutStep2.setVisibility(View.GONE);
        switch (requestCode) {
            case CHOOSE_REQUEST:
                if (resultCode == RESULT_OK) {
                    if (requestCode == CHOOSE_REQUEST) {
                        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                        String path = "";
                        if (selectList != null && selectList.size() > 0) {
                            LocalMedia localMedia = selectList.get(0);
                            if (localMedia.isCompressed()) {
                                path = localMedia.getCompressPath();
                            } else if (localMedia.isCut()) {
                                path = localMedia.getCutPath();
                            } else {
                                path = localMedia.getPath();
                            }
                        }
                        if (TextUtils.isEmpty(path)) {
                            Toast.makeText(this, "请选择有效文件！", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (MediaFile.isPictureFileType(path)) {
                            fileType = FILE_TYPE.pic;
                            path = CommonUtil.amendRotatePhoto(path, MainActivity.this);
                            showMedia(path, true);
                            Toast.makeText(this, "是图片", Toast.LENGTH_SHORT).show();
                        } else if (MediaFile.isVideoFileType(path)) {
                            fileType = FILE_TYPE.video;
                            showMedia(path, false);
                            Toast.makeText(this, "是视频", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else if (resultCode == RESULT_CANCELED) {
                    new AlertDialog.Builder(this)
                            .setMessage("没找到心仪的图片？是否进入到文件选择器选择？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showFileChooser();
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
                break;
            case FILE_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    Log.d("icv", "File Uri: " + uri.toString());
                    // Get the path
                    String path = null;
                    try {
                        path = FileUtils.getPath(this, uri);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                        return;
                    }

                    if (MediaFile.isPictureFileType(path)) {
                        fileType = FILE_TYPE.pic;
                        path = CommonUtil.amendRotatePhoto(path, MainActivity.this);
                        showMedia(path, true);
                        Toast.makeText(this, "图片资源", Toast.LENGTH_SHORT).show();
                    } else if (MediaFile.isVideoFileType(path)) {
                        fileType = FILE_TYPE.video;
                        showMedia(path, false);
                        Toast.makeText(this, "视频资源", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("icv", "File Path: " + path);
                }

                break;
        }
    }

    public class MyOnEncoderListener implements EncodeThread.OnEncoderListener {

        @Override
        public void onProgress(int progress) {
            progressBar.setProgress(progress);
        }

        @Override
        public void onComplish() {
            Toast.makeText(MainActivity.this, "视频转换完成，请接下来进行视频拼接", Toast.LENGTH_SHORT).show();
            progressBar.setProgress(100);
            layoutStep2.setVisibility(View.VISIBLE);
        }

        @Override
        public void showImg(Bitmap bitmapTemp) {
            ivShow.setImageBitmap(bitmapTemp);
        }
    }

    @Override
    protected void onDestroy() {
        myOnEncoderListener = null;
        super.onDestroy();
    }
}
