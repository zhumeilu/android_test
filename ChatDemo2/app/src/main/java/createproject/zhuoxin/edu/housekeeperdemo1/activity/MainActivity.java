package createproject.zhuoxin.edu.housekeeperdemo1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import createproject.zhuoxin.edu.housekeeperdemo1.R;
import createproject.zhuoxin.edu.housekeeperdemo1.adapter.ListviewAdapter;
import createproject.zhuoxin.edu.housekeeperdemo1.entity.MsgInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListviewAdapter adapter = null;

    private ListView listview;
    private Button btn_left;
    private EditText et_meg;
    private Button btn_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        adapter = new ListviewAdapter(this);
        listview.setAdapter(adapter);

    }


    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        btn_left = (Button) findViewById(R.id.btn_left);
        et_meg = (EditText) findViewById(R.id.et_meg);
        btn_right = (Button) findViewById(R.id.btn_right);

        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String msg = et_meg.getText().toString().trim();

        switch (v.getId()) {
            case R.id.btn_left:
                adapter.addDataToAdapter(new MsgInfo(msg,null));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_right:
                adapter.addDataToAdapter(new MsgInfo(null, msg));
                adapter.notifyDataSetChanged();
                break;
        }

        listview.smoothScrollToPosition(listview.getCount() - 1);

        et_meg.setText("");

    }

}
