package albion.linecutfeng.videotoascii.activity

import albion.linecutfeng.videotoascii.R
import albion.linecutfeng.videotoascii.app.AppConfig.BASE_PATH
import albion.linecutfeng.videotoascii.utils.CommonUtil
import albion.linecutfeng.videotoascii.utils.FileUtils
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.lcf.simpleprocess.SimpleProcess
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig.CHOOSE_REQUEST
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_fdt.*
import org.opencv.android.OpenCVLoader
import java.io.File
import java.io.FileOutputStream
import java.net.URISyntaxException

/**
 * 傅里叶变换和傅里叶反变换
 */
class DFTProcessActivity : BaseActivity() {

    internal var oldPicPath: String? = Environment.getExternalStorageDirectory().absolutePath + "/abc.png"
    internal var encodePath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fdt)
        setClickEvent()
        Glide.with(this@DFTProcessActivity)
                .load(oldPicPath)
                .into(iv_show!!)
        staticLoadCVLibraries()
    }

    private fun staticLoadCVLibraries() {
        val load = OpenCVLoader.initDebug()
        if (load) {
            Log.i("CV", "Open CV Libraries loaded...")
        } else {
            finish()
        }
    }

    /**
     * 选择图片
     */
    private fun selectMedia() {
        CommonUtil.choosePhoto(this, CHOOSE_REQUEST)
    }

    fun setClickEvent() {
        bt_select.setOnClickListener { selectMedia() }
        bt_encode.setOnClickListener { startConvert(true) }
        bt_decode.setOnClickListener { startConvert(false) }
    }

    private fun startConvert(isEncoder: Boolean) {
        showProgress("开始转化，请稍后...可以喝杯咖啡~")
        val subscribe = Observable.just(oldPicPath)
                .filter { !TextUtils.isEmpty(oldPicPath) }
                .filter { s -> File(s).exists() }
                .flatMap { s ->
                    val file = File(s)
                    val outPutPath = "${BASE_PATH}${File.separator}${file.name.substring(0, file.name.indexOf("."))}_${if (isEncoder) "fft" else "ifft"}.png"
                    val generate = if (isEncoder) fft(oldPicPath, et_water_text.text.toString()) else ifft(if (encodePath == null) oldPicPath else encodePath)
                    generate?.compress(Bitmap.CompressFormat.PNG, 100, FileOutputStream(outPutPath))
                    if (isEncoder) {
                        encodePath = outPutPath
                    }
                    Observable.just(generate)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ s ->
                    dismissDialog()
                    Glide.with(this@DFTProcessActivity)
                            .load(s)
                            .into(iv_show!!)
                }, { throwable ->
                    dismissDialog()
                    throwable.printStackTrace()
                })
    }

    /**
     * 接收图片选择器返回的结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CHOOSE_REQUEST -> if (resultCode == Activity.RESULT_OK) {
                if (requestCode == CHOOSE_REQUEST) {
                    val selectList = PictureSelector.obtainMultipleResult(data)
                    if (selectList != null && selectList.size > 0) {
                        val localMedia = selectList[0]
                        when {
                            localMedia.isCompressed -> oldPicPath = localMedia.compressPath
                            localMedia.isCut -> oldPicPath = localMedia.cutPath
                            else -> oldPicPath = localMedia.path
                        }
                        Log.i("icv", "path=$oldPicPath")
                        Glide.with(this)
                                .load(oldPicPath)
                                .into(iv_show!!)
                    }
                    if (TextUtils.isEmpty(oldPicPath)) {
                        Toast.makeText(this, "请选择有效文件！", Toast.LENGTH_SHORT).show()
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                AlertDialog.Builder(this)
                        .setMessage("没找到心仪的图片？是否进入到文件选择器选择？")
                        .setPositiveButton("确定") { dialog, which ->
                            showFileChooser()
                            dialog.dismiss()
                        }
                        .setNegativeButton("取消") { dialog, which -> dialog.dismiss() }.show()
            }
            FILE_REQUEST_CODE ->
                if (resultCode == Activity.RESULT_OK) {
                    // Get the Uri of the selected file
                    val uri = data?.data
                    Log.d("icv", "File Uri: $uri")
                    // Get the path
                    try {
                        oldPicPath = FileUtils.getPath(this, uri)
                        Log.d("icv", "File Path: $oldPicPath")
                        Glide.with(this)
                                .load(oldPicPath)
                                .into(iv_show!!)
                    } catch (e: URISyntaxException) {
                        e.printStackTrace()
                    }
                }
        }
    }

    /**
     * 调用系统的文件选择器
     */
    private fun showFileChooser() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/"
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        try {
            startActivityForResult(Intent.createChooser(intent, "Select a File to process"), FILE_REQUEST_CODE)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show()
        }

    }

    fun fft(inputPath: String?, waterText: String?): Bitmap? {
        return SimpleProcess.FFT(inputPath, waterText)
    }

    fun ifft(inputPath: String?): Bitmap? {
        return SimpleProcess.IFFT(inputPath)
    }

    companion object {

        val FILE_REQUEST_CODE = 101
    }
}
