package com.mingrisoft;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fragment = (FrameLayout) findViewById(R.id.frameLayout);  //获取帧布局管理器
        fragment.addView(new MyView(this));  //将自定义视图的内部类添加到布局管理器中
    }

    private class MyView extends View {

        public MyView(Context context) {
            super(context);
        }


        @Override
        protected void onDraw(Canvas canvas) {  //重写onDraw()方法
            Paint paint = new Paint();           //定义一个默认的画笔
            //线性渐变
            Shader shader = new LinearGradient(0, 0, 100, 100,
                    Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
            paint.setShader(shader);                            //为画笔设置渐变器
            canvas.drawRect(10, 10, 280, 150, paint);                //绘制矩形
            super.onDraw(canvas);
        }
    }
}
