package albion.linecutfeng.videotoascii.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lcf.emojimosaic.EmojiMosaic;
import com.lcf.simpleprocess.SimpleProcess;
import com.linecutfeng.lowpoly.LowPoly;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;

import albion.linecutfeng.videotoascii.R;
import albion.linecutfeng.videotoascii.interfaces.SimpleProcessInterface;
import albion.linecutfeng.videotoascii.utils.CommonUtil;
import albion.linecutfeng.videotoascii.utils.FileUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import static albion.linecutfeng.videotoascii.app.AppConfig.BASE_PATH;
import static com.luck.picture.lib.config.PictureConfig.CHOOSE_REQUEST;

/**
 * 简单的图片处理，目前支持低多边形图，emoji-mosaic图，以及各种颜色滤镜
 */
public class SingleProcessActivity extends BaseActivity implements SimpleProcessInterface {

    @BindView(R.id.bt_select)
    Button btSelect;
    @BindView(R.id.tv_path)
    TextView tvPath;
    @BindView(R.id.bt_old_pic)
    Button btOldPic;
    @BindView(R.id.bt_simple_process)
    Button simpleProcess;
    @BindView(R.id.iv_show)
    ImageView ivShow;

    public static final int FILE_REQUEST_CODE = 101;
    String oldPicPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/abc.png";
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_single_process);
        ButterKnife.bind(this);
        Glide.with(SingleProcessActivity.this)
                .load(oldPicPath)
                .into(ivShow);
    }
    /**
     * 选择图片
     */
    private void selectMedia() {
        CommonUtil.choosePhoto(this, CHOOSE_REQUEST);
    }

    @OnClick({R.id.bt_select, R.id.bt_old_pic, R.id.bt_simple_process})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_select:
                selectMedia();
                break;
            case R.id.bt_old_pic:
                if (!TextUtils.isEmpty(oldPicPath)) {
                    Glide.with(this)
                            .load(oldPicPath)
                            .into(ivShow);
                }
                break;
            case R.id.bt_simple_process:
                startConvert();
                break;
        }
    }

    private void startConvert() {
        showProgress("开始转化，请稍后...可以喝杯咖啡~");
        Disposable subscribe = Observable.just(oldPicPath)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return (!TextUtils.isEmpty(oldPicPath));
                    }
                })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        File file = new File(s);
                        return file.exists();
                    }
                })
                .flatMap(new Function<String, ObservableSource<Bitmap>>() {
                    @Override
                    public ObservableSource<Bitmap> apply(String s) throws Exception {
                        File file = new File(s);
                        String outPutPath = BASE_PATH + File.separator + file.getName().substring(0, file.getName().indexOf(".")) + "_" + type + ".png";
                        Bitmap generate = selectProcessFunction(outPutPath);
                        generate.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(outPutPath));
                        return Observable.just(generate);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap s) throws Exception {
                        dismissDialog();
                        Glide.with(SingleProcessActivity.this)
                                .load(s)
                                .into(ivShow);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        dismissDialog();
                        throwable.printStackTrace();
                    }
                });
    }

    private Bitmap selectProcessFunction(String outputPath) {
        Method[] declaredMethods = this.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(type)) {
                Annotation[] annotations = declaredMethod.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType() == ProcessFunction.class) {
                        try {
                            return (Bitmap) declaredMethod.invoke(this, this, outputPath);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }
        return null;
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
                            Log.i("icv", "path=" + path);
                            oldPicPath = path;
                            Glide.with(this)
                                    .load(oldPicPath)
                                    .into(ivShow);
                        }
                        if (TextUtils.isEmpty(path)) {
                            Toast.makeText(this, "请选择有效文件！", Toast.LENGTH_SHORT).show();
                            return;
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
                        oldPicPath = path;
                        Glide.with(this)
                                .load(oldPicPath)
                                .into(ivShow);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                        return;
                    }
                    Log.d("icv", "File Path: " + path);

                }

                break;
        }
    }

    /**
     * 调用系统的文件选择器
     */
    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "Select a File to process"), FILE_REQUEST_CODE);
        } catch (ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
        }
    }

    @ProcessFunction
    @Override
    public Bitmap lowpoly(Context context, String outputPath) {
        try {
            return LowPoly.generate(oldPicPath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ProcessFunction
    @Override
    public Bitmap emoji(Context context, String outputPath) {
        try {
            return new EmojiMosaic().generate(context, oldPicPath);
        } catch (IOException e) {
            return null;
        }
    }

    @ProcessFunction
    @Override
    public Bitmap negative(Context context, String outputPath) {
        return SimpleProcess.negative(oldPicPath);
    }

    @ProcessFunction
    @Override
    public Bitmap casting(Context context, String outputPath) {
        return SimpleProcess.casting(oldPicPath);
    }

    @ProcessFunction
    @Override
    public Bitmap frozen(Context context, String outputPath) {
        return SimpleProcess.frozen(oldPicPath);
    }

    @ProcessFunction
    @Override
    public Bitmap comicbook(Context context, String outputPath) {
        return SimpleProcess.comicbook(oldPicPath);
    }

    @ProcessFunction
    @Override
    public Bitmap brown(Context context, String outputPath) {
        return SimpleProcess.brown(oldPicPath);
    }

    @ProcessFunction
    @Override
    public Bitmap tilerefectrgb(Context context, String outputPath) {
        return SimpleProcess.tilerefectrgb(oldPicPath);
    }

    @ProcessFunction
    @Override
    public Bitmap circleLine(Context context, String outputPath) {
        return SimpleProcess.circleLine(oldPicPath);
    }

}
