package albion.linecutfeng.videotoascii.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.linecutfeng.lowpoly.LowPoly;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.util.List;

import albion.linecutfeng.videotoascii.R;
import albion.linecutfeng.videotoascii.app.GlideApp;
import albion.linecutfeng.videotoascii.utils.CommonUtil;
import albion.linecutfeng.videotoascii.utils.FileUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import static albion.linecutfeng.videotoascii.app.AppConfig.BASE_PATH;
import static com.luck.picture.lib.config.PictureConfig.CHOOSE_REQUEST;

public class LowPolyActivity extends BaseActivity {

    @BindView(R.id.bt_select)
    Button btSelect;
    @BindView(R.id.tv_path)
    TextView tvPath;
    @BindView(R.id.bt_old_pic)
    Button btOldPic;
    @BindView(R.id.bt_lowpoly)
    Button btLowpoly;
    @BindView(R.id.iv_show)
    ImageView ivShow;

    public static final int FILE_REQUEST_CODE = 101;
    String oldPicPath = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowpoly);
        ButterKnife.bind(this);
    }

    /**
     * 选择图片
     */
    private void selectMedia() {
        CommonUtil.choosePhoto(this, CHOOSE_REQUEST);
    }

    @OnClick({R.id.bt_select, R.id.bt_old_pic, R.id.bt_lowpoly})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_select:
                selectMedia();
                break;
            case R.id.bt_old_pic:
                if (!TextUtils.isEmpty(oldPicPath)) {
                    GlideApp.with(this)
                            .load(oldPicPath)
                            .into(ivShow);
                }
                break;
            case R.id.bt_lowpoly:
                startConvert();
                break;
        }
    }

    private void startConvert() {
        showProgress("开始转化，请稍后...可以喝杯咖啡~");
        Observable.just(oldPicPath)
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
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream((BASE_PATH + File.separator + file.getName().substring(0, file.getName().indexOf(".")) + "_lowpoly.png")));
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(oldPicPath));
                        Bitmap generate = LowPoly.generate(bis, bos);
                        return Observable.just(generate);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap s) throws Exception {
                        dismissDialog();
                        GlideApp.with(LowPolyActivity.this)
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
                            GlideApp.with(this)
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
                        GlideApp.with(this)
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
            startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_REQUEST_CODE);
        } catch (ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
        }
    }
}
