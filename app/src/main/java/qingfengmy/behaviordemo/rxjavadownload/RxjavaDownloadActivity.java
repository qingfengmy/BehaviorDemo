package qingfengmy.behaviordemo.rxjavadownload;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import qingfengmy.behaviordemo.R;
import qingfengmy.behaviordemo.rxjavadownload.utils.DownloadCallback;
import qingfengmy.behaviordemo.rxjavadownload.utils.DownloadHelper;

public class RxjavaDownloadActivity extends AppCompatActivity {
    String url = "http://gdown.baidu.com/data/wisegame/d5e850fc388599f4/nishinayiweitonghuagongzhu_1.apk";
    ProgressBar progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_download);
        progressDialog = (ProgressBar) findViewById(R.id.id_progress);
        progressDialog.setMax(100);

        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });


    }

    private void download() {
        String desFileDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        DownloadHelper.download(url, new DownloadCallback(desFileDir, "a.apk") {
            @Override
            protected void success() {
                Log.e("aaa", "success");

            }

            @Override
            protected void failed() {
                Log.e("aaa", "failed");

            }

            @Override
            protected void start() {
                Log.e("aaa", "start");
            }

            @Override
            protected void update(int progress) {
                Log.e("aaa", progress + "%");
                progressDialog.setProgress(progress);
            }
        });

    }
}
