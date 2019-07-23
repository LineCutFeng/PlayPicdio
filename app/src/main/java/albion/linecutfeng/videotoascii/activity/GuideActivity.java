package albion.linecutfeng.videotoascii.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import albion.linecutfeng.videotoascii.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4, R.id.bt_5, R.id.bt_6, R.id.bt_7, R.id.bt_8,R.id.bt_9})
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
        }
    }

    public void wati(View view) {
        Toast.makeText(this, "敬请期待~", Toast.LENGTH_SHORT).show();
    }
}
