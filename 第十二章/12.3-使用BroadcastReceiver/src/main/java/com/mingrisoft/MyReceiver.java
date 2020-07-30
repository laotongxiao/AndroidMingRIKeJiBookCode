package com.mingrisoft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String action1="com.mingrisoft";//声明第一个动作
    private static final String action2="mingrisoft";   //声明第二个动作
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action1)){
            Toast.makeText(context, "MyReceiver收到:com.mingrisoft的广播",
                    Toast.LENGTH_SHORT).show(); //回复该动作收到广播
        }else if (intent.getAction().equals(action2)){
            Toast.makeText(context, "MyReceiver收到:mingrisoft的广播",
                    Toast.LENGTH_SHORT).show();//回复该动作收到广播
        }

    }
}
