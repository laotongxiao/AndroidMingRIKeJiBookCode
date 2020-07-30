package com.mingrisoft;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageButton imageButton= (ImageButton) findViewById(R.id.imageButton1); //获取ImageView组件
        //为ImageView组件设置单击事件监听器
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();  //创建Intent对象
                intent.setAction(intent.ACTION_MAIN);  //设置action动作属性
                intent.addCategory(intent.CATEGORY_HOME); //设置categoty种类显示主屏幕
                startActivity(intent); //启动Activity
            }
        });
    }
}
