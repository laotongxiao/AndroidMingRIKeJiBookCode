package com.mingrisoft;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.Broadcast);//获取布局文件中的广播按钮
        button.setOnClickListener(new View.OnClickListener() {  //为按钮设置单击事件
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(); //创建Intent对象
                intent.setAction("com.mingrisoft"); //为Intent添加动作com.mingrisoft
                sendBroadcast(intent); //发送广播
            }
        });
    }
}
