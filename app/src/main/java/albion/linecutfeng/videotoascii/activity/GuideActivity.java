package albion.linecutfeng.videotoascii.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.luck.picture.lib.permissions.RxPermissions;

import java.io.File;

import albion.linecutfeng.videotoascii.R;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static albion.linecutfeng.videotoascii.app.AppConfig.AUDIO_PATH;
import static albion.linecutfeng.videotoascii.app.AppConfig.PIC_LIST_PATH;

public class GuideActivity extends BaseActivity {

    Handler mHander = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        ButterKnife.bind(this);
        checkPermissionAndMakeFile();
//        try {
//            CommonUtil.createAsciiByDrawText();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void checkPermissionAndMakeFile() {
        new RxPermissions(this)
                .request(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE})
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if (granted) {
                            File picPath = new File(PIC_LIST_PATH);
                            File audioPath = new File(AUDIO_PATH);
                            mkUseDir(picPath);
                            mkUseDir(audioPath);
                        } else {
                            Toast.makeText(GuideActivity.this, "不给SD卡读写权限，玩毛线", Toast.LENGTH_SHORT).show();
                            mHander.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    finish();
                                }
                            }, 1000);
                        }
                    }
                });
    }

    private void mkUseDir(File picPath) {
        if (!picPath.exists()) {
            picPath.mkdirs();
        } else if (picPath.isFile()) {
            picPath.mkdirs();
        }
    }

    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4, R.id.bt_5, R.id.bt_6, R.id.bt_7, R.id.bt_8, R.id.bt_9, R.id.bt_10})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.bt_1:
                intent = new Intent(this, AsciiActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_2:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "lowpoly");
                startActivity(intent);
                break;
            case R.id.bt_3:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "emoji");
                startActivity(intent);
                break;
            case R.id.bt_4:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "negative");
                startActivity(intent);
                break;
            case R.id.bt_5:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "casting");
                startActivity(intent);
                break;
            case R.id.bt_6:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "frozen");
                startActivity(intent);
                break;

            case R.id.bt_7:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "comicbook");
                startActivity(intent);
                break;

            case R.id.bt_8:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "brown");
                startActivity(intent);
                break;
            case R.id.bt_9:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "tilerefectrgb");
                startActivity(intent);
                break;
            case R.id.bt_10:
                intent = new Intent(this, SingleProcessActivity.class);
                intent.putExtra("type", "circleLine");
                startActivity(intent);
                break;
        }
    }

    public void wati(View view) {
        Toast.makeText(this, "敬请期待~", Toast.LENGTH_SHORT).show();
    }
}
