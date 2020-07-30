package com.mingrisoft;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout); // 获取相对局管理器
        final HatView hat = new HatView(MainActivity.this); // 创建并实例化HatView类
        // 为帽子添加触摸事件监听
        hat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hat.bitmapX = event.getX()-80; // 设置帽子显示位置的X坐标
                hat.bitmapY = event.getY()-50; // 设置帽子显示位置的Y坐标
                hat.invalidate(); // 重绘hat组件
                return true;
            }
        });
        relativeLayout.addView(hat); //将hat添加到布局管理器中
    }
}
