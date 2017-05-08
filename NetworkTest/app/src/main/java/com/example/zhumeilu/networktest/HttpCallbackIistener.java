package com.example.zhumeilu.networktest;

/**
 * Created by zhumeilu on 2017/5/5.
 */

public interface HttpCallbackIistener {

    void onFinish(String response);
    void onError(Exception e);
}
