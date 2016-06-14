package qingfengmy.behaviordemo.okhttp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;

import qingfengmy.behaviordemo.R;

public class OkHttpActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    TextView textView;
    String url = "http://gdown.baidu.com/data/wisegame/d5e850fc388599f4/nishinayiweitonghuagongzhu_1.apk?crazycache=1";

    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        textView = (TextView) findViewById(R.id.text);

        mProgressBar = (ProgressBar) findViewById(R.id.id_progress);
        mProgressBar.setMax(100);

        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), "gz.apk")//
                {

                    @Override
                    public void onBefore(okhttp3.Request request, int id)
                    {
                        Log.e(TAG, "onBefore : id=" + id);
                    }

                    @Override
                    public void inProgress(float progress, long total, int id)
                    {
                        mProgressBar.setProgress((int) (100 * progress));
                        Log.e(TAG, "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id)
                    {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id)
                    {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }
}
