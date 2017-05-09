package com.example.zhumeilu.coolweacher.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhumeilu on 2017/5/9.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
