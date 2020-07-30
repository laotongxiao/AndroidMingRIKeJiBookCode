package com.mingrisoft;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton_phone); //获取电话图片按钮
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton_sms); //获取短信图片按钮
        imageButton.setOnClickListener(l); //为电话图片按钮设置单击事件
        imageButton1.setOnClickListener(l);//为短信图片按钮设置单击事件
    }

    //创建监听事件对象
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(); //创建Intent对象
            switch (v.getId()) {       //根据ImageButton组件的id进行判断
                case R.id.imageButton_phone:              //如果是电话图片按钮
                    intent.setAction(intent.ACTION_DIAL); //调用拨号面板
                    intent.setData(Uri.parse("tel:13800138000")); //设置要拨打的号码
                    startActivity(intent); //启动Activity
                    break;
                case R.id.imageButton_sms:             //如果是短信图片按钮
                    intent.setAction(intent.ACTION_SENDTO); //调用发送短信息
                    intent.setData(Uri.parse("smsto:5554")); //设置要发送的号码
                    intent.putExtra("sms_body", "Welcome to Android!"); //设置要发送的信息内容
                    startActivity(intent); //启动Activity
            }
        }


    };
}