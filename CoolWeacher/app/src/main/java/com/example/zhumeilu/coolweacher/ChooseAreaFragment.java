package com.example.zhumeilu.coolweacher;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhumeilu.coolweacher.db.City;
import com.example.zhumeilu.coolweacher.db.County;
import com.example.zhumeilu.coolweacher.db.Province;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by zhumeilu on 2017/5/9.
 */

public class ChooseAreaFragment extends Fragment {

    public static final int LEVLE_PROVINCE = 0;
    public static final int LEVLE_CITY = 1;
    public static final int LEVLE_COUNTY= 2;
    private ProgressDialog progressDialog;
    private TextView titleText;
    private Button backButton;
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
        View view = inflater.inflate(R.layout.choose_area,container,false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        backButton = (Button) view.findViewById(R.id.back_button);
        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentLevel == LEVLE_PROVINCE){
                    selectedProvince = provinceList.get(position);
                    queryCityList();
                }else if(currentLevel == LEVLE_CITY){
                    selectedCity = cityList.get(position);
                    queryCountList();
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(currentLevel == LEVLE_COUNTY){
                    queryCityList();
                }else if(currentLevel == LEVLE_CITY){
                    queryProvinceList();
                }
            }
        });
    }

    private void queryProvinceList(){

    }
    private void queryCityList(){

    }
    private void queryCountList(){

    }
    private void queryFromServer(String address,final String type){

    }

    /**
     * 显示进度对话框
     */
    private void showProgressDialog(){

    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog(){

    }
}
