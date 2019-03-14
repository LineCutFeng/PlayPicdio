package albion.linecutfeng.videotoascii.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import albion.linecutfeng.videotoascii.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends BaseActivity {

    @BindView(R.id.bt_1)
    Button bt1;
    @BindView(R.id.bt_2)
    Button bt2;
    @BindView(R.id.bt_3)
    Button bt3;
    @BindView(R.id.bt_4)
    Button bt4;
    @BindView(R.id.bt_5)
    Button bt5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.bt_2:
                startActivity(new Intent(this, LowPolyActivity.class));
                break;
            case R.id.bt_3:
                startActivity(new Intent(this, EmojiMosaicActivity.class));
                break;
            case R.id.bt_4:
                Toast.makeText(this, "敬请期待~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_5:
                Toast.makeText(this, "敬请期待~", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public static void main(String[] args) {
        double i = ((short) (0x77) | 0x42 << 8) / 32768.0 * 180;
        System.out.println(i);
    }
}
