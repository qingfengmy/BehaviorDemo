package qingfengmy.behaviordemo.rxjavadownload.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/6/12.
 */
public class DownloadHelper {

    public static void download(String url, final DownloadCallback callback) {
        Request request = new Request.Builder().url(url).build();
        OkHttpClient newClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        return originalResponse.newBuilder()
                                .body(new ResponseProgressBody(originalResponse.body(), callback))
                                .build();
                    }
                }).build();
        Call call = newClient.newCall(request);
        call.enqueue(callback);
    }
}
