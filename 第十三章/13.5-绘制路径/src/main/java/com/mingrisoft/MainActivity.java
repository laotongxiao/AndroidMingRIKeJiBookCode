package com.mingrisoft;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DrawView drawView= (DrawView) findViewById(R.id.dv);  //获取自定义的绘图视图
        ImageButton button= (ImageButton) findViewById(R.id.btn_clear);  //获取清空按钮

      button.setOnClickListener(new View.OnClickListener() {  //为按钮设置监听事件
          @Override
          public void onClick(View v) {
              drawView.clear();  //调用清除方法
          }
      });

    }

}
