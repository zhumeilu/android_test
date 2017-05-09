package com.example.zhumeilu.coolweacher.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhumeilu on 2017/5/9.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;
    public  Update update;


    public class Update{
        @SerializedName("loc")
        public String updateTime;

    }
}
