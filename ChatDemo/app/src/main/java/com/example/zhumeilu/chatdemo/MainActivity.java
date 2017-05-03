package com.example.zhumeilu.chatdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList= new ArrayList<>();
    Button button;
    EditText editText;
    MsgAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        editText = (EditText) findViewById(R.id.input_text);
        button = (Button) findViewById(R.id.send);
        recyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(Msg.TYPE_SEND,content);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    recyclerView.scrollToPosition(msgList.size()-1);
                    editText.setText("");
                }
            }
        });

    }

    void initMsg(){
        Msg msg = new Msg(Msg.TYPE_SEND,"你好");
        msgList.add(msg);
        Msg msg2 = new Msg(Msg.TYPE_RECEIVED,"你好");
        msgList.add(msg2);
    }
}
