package com.example.zhumeilu.coolweacher.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhumeilu on 2017/5/9.
 */

public class Suggestion {
    public Comfort comfort;
    public CarWash carWash;
    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }
    public class CarWash{
        @SerializedName("txt")
        public String info;
    }
    public class Sport{

        @SerializedName("txt")
        public String info;
    }
}
