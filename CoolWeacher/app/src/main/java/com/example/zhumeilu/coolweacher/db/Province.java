package com.example.zhumeilu.coolweacher.db;

import org.litepal.crud.DataSupport;

/**
 * Created by zhumeilu on 2017/5/8.
 */

public class Province extends DataSupport {

    private int id ;
    private String provinceName;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public String getProvinceName() {
        return provinceName;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
