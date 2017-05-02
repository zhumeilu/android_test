package me.zhumeilu.intenttest2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //活动的跳转
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //跳转到指定的action
//                Intent intent = new Intent("com.example.activitytext.ACTION_START");
//                intent.addCategory("com.example.activitytext.MY_CATEGORY");
                //活动三，通过设置过滤器，来监听活动
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                //调用电话
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("data","你好啊");
                startActivity(intent);
            }
        });
    }
}
