package com.example.zhumeilu.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruitList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局为水平排列
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    void initFruitList(){
        for (int i = 0 ;i<3; i++){
            Fruit fruit= new Fruit("haha",R.drawable.wechat);
            fruitList.add(fruit);
            Fruit fruit2= new Fruit("haha2",R.drawable.wechat);
            fruitList.add(fruit2);
            Fruit fruit3= new Fruit("haha3",R.drawable.wechat);
            fruitList.add(fruit3);
        }
    }
}
