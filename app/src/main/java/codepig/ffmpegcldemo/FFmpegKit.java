package codepig.ffmpegcldemo;

import android.os.AsyncTask;

public class FFmpegKit {
    public interface KitInterface{
        void onStart();
        void onProgress(int progress);
        void onEnd(int result);
    }

    static{
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeginvoke");
    }

    public static int execute(String[] commands){
        return run(commands);
    }

    public static void execute(String[] commands, final KitInterface kitIntenrface){
        new AsyncTask<String[],Integer,Integer>(){
            @Override
            protected void onPreExecute() {
                if(kitIntenrface != null){
                    kitIntenrface.onStart();
                }
            }
            @Override
            protected Integer doInBackground(String[]... params) {
                return run(params[0]);
            }
            @Override
            protected void onProgressUpdate(Integer... values) {
                if(kitIntenrface != null){
                    kitIntenrface.onProgress(values[0]);
                }
            }
            @Override
            protected void onPostExecute(Integer integer) {
                if(kitIntenrface != null){
                    kitIntenrface.onEnd(integer);
                }
            }
        }.execute(commands);
    }

    public native static int run(String[] commands);
}