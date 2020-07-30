package com.mingrisoft;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button action_show, action_hide; //定义显示与隐藏按钮
    android.support.v7.app.ActionBar actionBar; //定义V7包下的ActionBar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar(); //获取ActionBar动作栏
        action_show = (Button) findViewById(R.id.actionBar_show); //获取显示按钮
        action_hide = (Button) findViewById(R.id.actionBar_hide); //获取隐藏按钮
        action_show.setOnClickListener(l); //为显示按钮设置监听事件
        action_hide.setOnClickListener(l); //为隐藏按钮设置监听事件
    }

    View.OnClickListener l = new View.OnClickListener() { //创建一个新的监听事件l
        @Override
        public void onClick(View v) {
            switch (v.getId()) {  //根据选择按钮的id判断
                case R.id.actionBar_show:
                    actionBar.show(); //显示ActionBar动作栏
                    break;
                case R.id.actionBar_hide:
                    actionBar.hide(); //隐藏ActionBar动作栏
                    break;
            }
        }
    };
}
