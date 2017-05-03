package com.example.zhumeilu.listviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zhumeilu.listviewtest.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = new String[]{
            "abc", "zml", "maylor"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(arrayAdapter);
        List<Fruit> fruitList = new ArrayList<>();
        Fruit fruit = null;
        fruit = new Fruit("苹果1",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果2",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果3",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        fruit = new Fruit("苹果4",R.drawable.wechat);
        fruitList.add(fruit);
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView  = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
