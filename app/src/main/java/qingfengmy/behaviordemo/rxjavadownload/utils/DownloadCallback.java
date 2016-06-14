package qingfengmy.behaviordemo.rxjavadownload.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class DownloadCallback implements ProgressListener, Callback {

    private boolean isFirst = false;
    private String mDestFileDir;
    private String mDestFileName;

    public DownloadCallback(String mDestFileDir, String mDestFileName) {
        this.mDestFileDir = mDestFileDir;
        this.mDestFileName = mDestFileName;
    }

    protected abstract void success();

    protected abstract void failed();

    protected abstract void start();

    public File saveFile(Response response) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            File dir = new File(mDestFileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, mDestFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            return file;
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void onProgress(long currentBytes, long totalBytes, boolean isFinish) {

        if (!isFirst) {
            isFirst = true;
            start();
        }
        update((int) (currentBytes * 100f / totalBytes));

        if (isFinish) {
            success();
        }
    }

    protected abstract void update(int progress);

    @Override
    public void onFailure(Call call, IOException e) {
        failed();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        try {
            saveFile(response);
        } catch (final IOException e) {
            failed();
        }
    }
}
