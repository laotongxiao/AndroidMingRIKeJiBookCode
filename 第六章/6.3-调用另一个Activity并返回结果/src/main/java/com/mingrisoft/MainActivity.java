package com.mingrisoft;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.btn);//获取选择头像按钮
        button.setOnClickListener(new View.OnClickListener() { //为按钮创建单机事件
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent=new Intent(MainActivity.this,HeadActivity.class);
                startActivityForResult(intent, 0x11);//启动intent对应的Activity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0x11 && resultCode==0x11){	//判断是否为待处理的结果
            Bundle bundle=data.getExtras();		//获取传递的数据包
            int imageId=bundle.getInt("imageId");	//获取选择的头像ID
            ImageView iv=(ImageView)findViewById(R.id.imageView);	//获取布局文件中添加的ImageView组件
            iv.setImageResource(imageId);	//显示选择的头像
        }
    }
}
