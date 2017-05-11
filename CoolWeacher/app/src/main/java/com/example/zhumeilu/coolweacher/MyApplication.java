package com.example.zhumeilu.coolweacher;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by zhumeilu on 2017/5/11.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }
    public static Context getContext(){
        return context;
    }
}
