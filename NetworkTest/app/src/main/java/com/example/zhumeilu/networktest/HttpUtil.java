package com.example.zhumeilu.networktest;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by zhumeilu on 2017/5/5.
 */

public class HttpUtil {

    public static String sendRequest(String url){

        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            conn = (HttpURLConnection)  new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            InputStream inputStream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
                conn.disconnect();
        }

        return null;
    }
    public static void sendRequest_2(final String url,final HttpCallbackIistener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;
                BufferedReader reader = null;
                try {
                    conn = (HttpURLConnection)  new URL(url).openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(8000);
                    conn.setReadTimeout(8000);
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    InputStream inputStream = conn.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    if(listener!=null){
                        listener.onFinish(sb.toString());
                    }
                }catch (Exception e){
                    if(listener!=null)
                        listener.onError(e);
                    e.printStackTrace();
                }finally {
                    if(reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(conn!=null)
                        conn.disconnect();
                }
            }
        }).start();
    }

    public static void sendRequestWithOkHttp(String url,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
