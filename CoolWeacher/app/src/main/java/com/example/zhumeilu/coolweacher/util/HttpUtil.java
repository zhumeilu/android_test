package com.example.zhumeilu.coolweacher.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by zhumeilu on 2017/5/8.
 */

public class HttpUtil {


    public static void sendRequestByOkHttp(String url, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
