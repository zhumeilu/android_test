package com.example.zhumeilu.coolweacher.db;

import org.litepal.crud.DataSupport;

/**
 * Created by zhumeilu on 2017/5/8.
 */

public class City extends DataSupport{

    private int id;
    private String cityName;
    private int cityCdde;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCdde() {
        return cityCdde;
    }

    public void setCityCdde(int cityCdde) {
        this.cityCdde = cityCdde;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
