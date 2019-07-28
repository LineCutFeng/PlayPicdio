package albion.linecutfeng.videotoascii.utils;


import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Log;

/**
 * 预览视频帧
 */
public class MediaDecoder {
    private static final String TAG = "MediaDecoder";
    private MediaMetadataRetriever retriever = null;
    private String fileLength;

    public MediaDecoder(String file) {
        if (CommonUtil.checkFile(file)) {
            retriever = new MediaMetadataRetriever();
            retriever.setDataSource(file);
            fileLength = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            Log.i(TAG, "fileLength : " + fileLength);
        }
    }

    /**
     * 获取视频某一帧
     *
     * @param timeMs 毫秒
     */
    public Bitmap decodeFrame(long timeMs) {
        if (retriever == null) return null;
        Bitmap bitmap = retriever.getFrameAtTime(timeMs * 1000, MediaMetadataRetriever.OPTION_CLOSEST);
        return bitmap;
    }

    /**
     * 取得视频文件播放长度
     *
     * @return
     */
    public String getVideoFileLength() {
        return fileLength;
    }

}
