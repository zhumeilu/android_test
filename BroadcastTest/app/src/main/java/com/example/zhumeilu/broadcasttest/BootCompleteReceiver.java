package com.example.zhumeilu.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 接收系统启动广播
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BootCompleteReceiver","系统启动");
        Toast.makeText(context,"系统启动",Toast.LENGTH_SHORT).show();
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
    }
}
