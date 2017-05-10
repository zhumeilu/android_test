package com.example.zhumeilu.coolweacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("weather",null)!=null){
            Log.d("MainActivity","数据库不为空");
            Intent intent  =new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }else{
            Log.d("MainActivity","数据库为空");
        }


=======
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        if(prefs.getString("weather",null)!=null){
//            Intent intent  =new Intent(this,WeatherActivity.class);
//            startActivity(intent);
//            finish();
//        }
>>>>>>> c5039b5fb50b729fc562771b35259c97630fdf8e
    }
}
