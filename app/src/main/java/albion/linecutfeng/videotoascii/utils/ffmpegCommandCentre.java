package albion.linecutfeng.videotoascii.utils;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

/**
 * 拼装ffmpeg命令行文本
 * Created by QZD on 2017/4/18.
 */

public class ffmpegCommandCentre {
//    /**
//     * 图片水印
//     */
//    public static String[] addImageMark(String imageUrl, String videoUrl, String outputUrl) {
////        Log.d("LOGCAT","add picmask");
//        String[] commands = new String[9];
//        commands[0] = "ffmpeg";
//        //输入
//        commands[1] = "-i";
//        commands[2] = videoUrl;
//        //水印
//        commands[3] = "-i";
//        commands[4] = imageUrl;//此处的图片地址换成带透明通道的视频就可以合成动态视频遮罩。
//        commands[5] = "-filter_complex";
//        commands[6] = "[1:v]scale=" + deviceInfo.screenWidth + ":" + deviceInfo.screenHeight + "[s];[0:v][s]overlay=0:0";
//        //覆盖输出
//        commands[7] = "-y";//直接覆盖输出文件
//        //输出文件
//        commands[8] = outputUrl;
//        return commands;
//    }

//    /**
//     * 背景音乐
//     */
//    public static String[] addMusic(String musicUrl, String videoUrl, String outputUrl) {
////        Log.d("LOGCAT","add music");
//        String[] commands = new String[7];
//        commands[0] = "ffmpeg";
//        //输入
//        commands[1] = "-i";
//        commands[2] = videoUrl;
//        //音乐
//        commands[3] = "-i";
//        commands[4] = musicUrl;
//        //覆盖输出
//        commands[5] = "-y";
//        //输出文件
//        commands[6] = outputUrl;
//        return commands;
//    }

    /**
     * 使用ffmpeg命令行进行抽取音频
     *
     * @param srcFile    原文件
     * @param targetFile 目标文件
     * @return 抽取后的音频文件
     */
    public static String[] extractAudio(String srcFile, String targetFile) {
        //-vn:video not
        String mixAudioCmd = "ffmpeg -i %s -f wav %s";
        mixAudioCmd = String.format(mixAudioCmd, srcFile, targetFile);
        return mixAudioCmd.split(" ");//以空格分割为字符串数组
    }

    /**
     * 使用ffmpeg命令行进行音视频合成
     *
     * @param videoFile 视频文件
     * @param audioFile 音频文件
     *                  //     * @param duration 视频时长
     * @param muxFile   目标文件
     * @return 合成后的文件
     */
    public static String[] mediaMux(String videoFile, String audioFile, String muxFile) {
        //-t:时长  如果忽略音视频时长，则把"-t %d"去掉
//        String mixAudioCmd = "ffmpeg -i %s -i %s -t %d %s";
//        mixAudioCmd = String.format(mixAudioCmd, videoFile, audioFile, duration, muxFile);
        String mixAudioCmd = "ffmpeg -i %s -i %s %s";
        mixAudioCmd = String.format(mixAudioCmd, videoFile, audioFile, muxFile);
        return mixAudioCmd.split(" ");//以空格分割为字符串数组
    }

    /**
     * 文字水印
     */
    public static String[] addTextMark(String imageUrl, String videoUrl, String outputUrl) {
        ArrayList<String> _commands = new ArrayList<>();
        _commands.add("ffmpeg");
        //输入
        _commands.add("-i");
        _commands.add(videoUrl);
        //水印
        _commands.add("-i");
        _commands.add(imageUrl);
        _commands.add("-filter_complex");
        _commands.add("overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2");
        //覆盖输出
        _commands.add("-y");//直接覆盖输出文件
        //输出文件
        _commands.add(outputUrl);
        String[] commands = new String[_commands.size()];
        for (int i = 0; i < _commands.size(); i++) {
            commands[i] = _commands.get(i);
        }
        return commands;
    }

    /**
     * 拼接视频
     */
    public static String[] concatVideo(String _filePath, String audioPath, String _outPath, String fps) {//-f concat -i list.txt -c copy concat.mp4
        ArrayList<String> _commands = new ArrayList<>();

        {

            _commands.add("ffmpeg");
            _commands.add("-f");
            _commands.add("image2");
            _commands.add("-framerate");
            _commands.add(fps);
            _commands.add("-i");
            _commands.add(_filePath + "/test%05d.png");
            if (!TextUtils.isEmpty(audioPath)) {
                _commands.add("-i");
                _commands.add(audioPath);
            }
//            _commands.add("-filter_complex");
//            _commands.add("[1:v]scale=1920:1080[s];[0:v][s]overlay=0:0");
//            –bf 0 –g 25
//            _commands.add("-bf");
//            _commands.add("0");
//            _commands.add("-keyint_min");
//            _commands.add("60");
//            _commands.add("-sc_threshold");
//            _commands.add("0");
//            _commands.add("-g");
//            _commands.add("-60");
//            _commands.add("-b");
//            _commands.add("500k");
//            _commands.add("-s");
//            _commands.add("640x360");
            _commands.add("-ss");
            _commands.add("0:00:00");
//            _commands.add("-r");
//            _commands.add(fps);
            _commands.add(_outPath);
        }


        String[] commands = new String[_commands.size()];
        String _pr = "";
        for (int i = 0; i < _commands.size(); i++) {
            commands[i] = _commands.get(i);
            _pr += commands[i];
        }
        Log.d("LOGCAT", "ffmpeg command:" + _pr + "-" + commands.length);
        return commands;

    }
}