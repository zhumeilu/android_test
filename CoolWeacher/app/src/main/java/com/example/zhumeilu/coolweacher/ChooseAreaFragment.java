package com.example.zhumeilu.coolweacher;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhumeilu.coolweacher.db.City;
import com.example.zhumeilu.coolweacher.db.County;
import com.example.zhumeilu.coolweacher.db.Province;
import com.example.zhumeilu.coolweacher.gson.Weather;
import com.example.zhumeilu.coolweacher.util.HttpUtil;
import com.example.zhumeilu.coolweacher.util.Utility;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by zhumeilu on 2017/5/9.
 */

public class ChooseAreaFragment extends Fragment {

    public static final int LEVLE_PROVINCE = 0;
    public static final int LEVLE_CITY = 1;
    public static final int LEVLE_COUNTY = 2;
    private ProgressDialog progressDialog;
    private TextView titleText;
    private TextView backButton;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    private List<Province> provinceList;
    private List<City> cityList;
    private List<County> countyList;
    private Province selectedProvince;
    private City selectedCity;
    private int currentLevel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_area, container, false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        backButton = (TextView) view.findViewById(R.id.back_button);
        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVLE_PROVINCE) {
                    selectedProvince = provinceList.get(position);
                    queryCityList();
                } else if (currentLevel == LEVLE_CITY) {
                    selectedCity = cityList.get(position);
                    queryCountList();
                } else if(currentLevel == LEVLE_COUNTY){
                    String weatherId = countyList.get(position).getWeatherId();
                    if(getActivity() instanceof MainActivity){
                        Intent intent = new Intent(getActivity(), WeatherActivity.class);
                        intent.putExtra("weather_id",weatherId);
                        startActivity(intent);
                        getActivity().finish();

                    }else if(getActivity() instanceof WeatherActivity){
                       WeatherActivity weatherActivity = (WeatherActivity) getActivity();
                        weatherActivity.draw
                    }
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentLevel == LEVLE_COUNTY) {
                    queryCityList();
                } else if (currentLevel == LEVLE_CITY) {
                    queryProvinceList();
                }

            }
        });
        queryProvinceList();
    }

    private void queryProvinceList() {
        Log.d("ChooseAreaFragment","查询省份信息");
        titleText.setText("中国");
        backButton.setVisibility(View.GONE);
        provinceList = DataSupport.findAll(Province.class);
        Log.d("ChooseAreaFragment","查询的list"+provinceList.size());
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList
                    ) {
                Log.d("ChooseAreaFragment","查询的province"+province.getProvinceName());
                if(province.getProvinceName()==null)
                    break;
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVLE_PROVINCE;
        }else{
            String address = "http://guolin.tech/api/china";
            queryFromServer(address,"province");
        }
    }

    private void queryCityList() {
        titleText.setText(selectedProvince.getProvinceName());
        backButton.setVisibility(View.VISIBLE);
        cityList = DataSupport.where("provinceid = ?",String.valueOf(selectedProvince.getId())).find(City.class);
        if(cityList.size()>0){
            dataList.clear();
            for (City city:cityList
                 ) {
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVLE_CITY;
        }else{
            int provinceCode = selectedProvince.getProvinceCode();
            String address = "http://guolin.tech/api/china/"+provinceCode;
            queryFromServer(address,"city");
        }
    }

    private void queryCountList() {

        titleText.setText(selectedCity.getCityName());
        backButton.setVisibility(View.VISIBLE);
        countyList = DataSupport.where("cityid = ?",String.valueOf(selectedCity.getId())).find(County.class);
        if(countyList.size()>0){
            dataList.clear();
            for (County county:countyList
                    ) {
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVLE_COUNTY;
        }else{
            int provinceCode = selectedProvince.getProvinceCode();
            int cityCode = selectedCity.getCityCode();
            String address = "http://guolin.tech/api/china/"+provinceCode+"/"+cityCode;
            queryFromServer(address,"county");
        }
    }

    private void queryFromServer(String address, final String type) {

        Log.d("ChooseAreaFragment","发送请求获取地址");
        showProgressDialog();
        HttpUtil.sendRequestByOkHttp(address, new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("ChooseAreaFragment","province body:"+response.body());
                String responseText = response.body().string();
                boolean result = false;
                if("province".equals(type)){
                    Log.d("ChooseAreaFragment","province json字符串:"+responseText);
                    result = Utility.handleProvinceResponse(responseText);
                }else if("city".equals(type)){
                    result = Utility.handleCityResponse(responseText,selectedProvince.getId());
                }else if("county".equals(type)){
                    result = Utility.handleCountyResponse(responseText,selectedCity.getId());
                }
                if(result){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            if("province".equals(type)){
                                queryProvinceList();
                            }else if("city".equals(type)){
                                queryCityList();
                            }else if("county".equals(type)){
                                queryCountList();
                            }
                        }
                    });
                }else{
                    Toast.makeText(getContext(), "处理参数出错", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, IOException e) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(getContext(),"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 显示进度对话框
     */
    private void showProgressDialog() {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载中...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
