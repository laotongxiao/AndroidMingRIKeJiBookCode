package com.mingrisoft;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "错误信息");
        Log.w(TAG, "警告信息");
        Log.i(TAG, "普通信息");
        Log.d(TAG, "调试信息");
        Log.v(TAG, "冗余信息");
    }
}
