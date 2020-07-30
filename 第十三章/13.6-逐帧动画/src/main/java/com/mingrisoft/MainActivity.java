package com.mingrisoft;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.linearLayout); //获取布局管理器
        //获取AnimationDrawable对象
       final AnimationDrawable anim= (AnimationDrawable) linearLayout.getBackground();
        linearLayout.setOnClickListener(new View.OnClickListener() {  //为布局管理器添加单击事件
            @Override
            public void onClick(View v) {
                if(flag){
                    anim.start(); //开始播放动画
                    flag=false;
                }else {
                    anim.stop();  //停止播放动画
                    flag=true;
                }
            }
        });
    }
}
