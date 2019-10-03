package albion.linecutfeng.videotoascii.activity

import albion.linecutfeng.videotoascii.R
import albion.linecutfeng.videotoascii.app.AppConfig.AUDIO_PATH
import albion.linecutfeng.videotoascii.app.AppConfig.PIC_LIST_PATH
import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.luck.picture.lib.permissions.RxPermissions
import kotlinx.android.synthetic.main.guide.*
import java.io.File

class GuideActivity : BaseActivity(), View.OnClickListener {

    private var mHander = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guide)
        checkPermissionAndMakeFile()
        initView()
        //        try {
        //            CommonUtil.createAsciiByDrawText();
        //        } catch (FileNotFoundException e) {
        //            e.printStackTrace();
        //        }
    }

    private fun initView() {
        bt_1.setOnClickListener(this)
        bt_2.setOnClickListener(this)
        bt_3.setOnClickListener(this)
        bt_4.setOnClickListener(this)
        bt_5.setOnClickListener(this)
        bt_6.setOnClickListener(this)
        bt_7.setOnClickListener(this)
        bt_8.setOnClickListener(this)
        bt_9.setOnClickListener(this)
        bt_10.setOnClickListener(this)
        bt_11.setOnClickListener(this)
    }

    private fun checkPermissionAndMakeFile() {
        var subscribe = RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe { granted ->
                    if (granted == true) {
                        val picPath = File(PIC_LIST_PATH)
                        val audioPath = File(AUDIO_PATH)
                        mkUseDir(picPath)
                        mkUseDir(audioPath)
                    } else {
                        Toast.makeText(this@GuideActivity, "不给SD卡读写权限，玩毛线", Toast.LENGTH_SHORT).show()
                        mHander.postDelayed({ finish() }, 1000)
                    }
                }
    }

    private fun mkUseDir(picPath: File) {
        if (!picPath.exists()) {
            picPath.mkdirs()
        } else if (picPath.isFile) {
            picPath.mkdirs()
        }
    }

    override fun onClick(view: View?) {
        val intent: Intent?
        when (view?.id) {
            R.id.bt_1 -> {
                intent = Intent(this, AsciiActivity::class.java)
                startActivity(intent)
            }
            R.id.bt_2 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "lowpoly")
                startActivity(intent)
            }
            R.id.bt_3 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "emoji")
                startActivity(intent)
            }
            R.id.bt_4 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "negative")
                startActivity(intent)
            }
            R.id.bt_5 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "casting")
                startActivity(intent)
            }
            R.id.bt_6 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "frozen")
                startActivity(intent)
            }

            R.id.bt_7 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "comicbook")
                startActivity(intent)
            }

            R.id.bt_8 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "brown")
                startActivity(intent)
            }
            R.id.bt_9 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "tilerefectrgb")
                startActivity(intent)
            }
            R.id.bt_10 -> {
                intent = Intent(this, SingleProcessActivity::class.java)
                intent.putExtra("type", "circleLine")
                startActivity(intent)
            }
            R.id.bt_11 -> {
                intent = Intent(this,  DFTProcessActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun wati(view: View?) {
        Toast.makeText(this, "敬请期待~", Toast.LENGTH_SHORT).show()
    }
}
