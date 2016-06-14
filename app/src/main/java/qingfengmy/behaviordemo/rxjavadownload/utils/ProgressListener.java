package qingfengmy.behaviordemo.rxjavadownload.utils;


public interface ProgressListener {
    void onProgress(long currentBytes, long totalBytes, boolean isFinish);
}