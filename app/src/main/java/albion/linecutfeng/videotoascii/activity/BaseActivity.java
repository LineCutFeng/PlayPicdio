package albion.linecutfeng.videotoascii.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog = null;

    void showProgress(String text) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage(text);
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    void dismissDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
