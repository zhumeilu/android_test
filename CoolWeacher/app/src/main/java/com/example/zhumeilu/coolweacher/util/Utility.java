package com.example.zhumeilu.coolweacher.util;

import android.text.TextUtils;

import com.example.zhumeilu.coolweacher.db.City;
import com.example.zhumeilu.coolweacher.db.County;
import com.example.zhumeilu.coolweacher.db.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


/**
 * Created by zhumeilu on 2017/5/8.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response) {

        if (!TextUtils.isEmpty(response)) {
            try {
                Gson gson = new Gson();
                List<Province> provinceList = gson.fromJson(response, new TypeToken<List<Province>>() {
                }.getType());
                for (Province province : provinceList) {
                    province.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response) {

        if (!TextUtils.isEmpty(response)) {
            try {
                Gson gson = new Gson();
                List<City> cityList = gson.fromJson(response, new TypeToken<List<City>>() {
                }.getType());
                for (City city : cityList) {
                    city.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response) {

        if (!TextUtils.isEmpty(response)) {
            try {
                Gson gson = new Gson();
                List<County> countyList = gson.fromJson(response, new TypeToken<List<County>>() {
                }.getType());
                for (County county : countyList) {
                    county.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
