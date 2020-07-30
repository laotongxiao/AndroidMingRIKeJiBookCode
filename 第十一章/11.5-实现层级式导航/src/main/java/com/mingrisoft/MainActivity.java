package com.mingrisoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView; //定义 ImageView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView); //获取朋友圈图片
        imageView.setOnClickListener(new View.OnClickListener() { //为图片设置单击事件
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FriendsActivity.class); //创建Intent对象
                startActivity(intent); //启动Activity

            }
        });
    }
}
