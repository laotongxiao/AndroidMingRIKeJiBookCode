package com.mingrisoft;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局文件中添加的帧布局管理器
        FrameLayout frameLayout=(FrameLayout)findViewById(R.id.frameLayout);
        //将自定义的MyView视图添加到帧布局管理器中
        frameLayout.addView(new MyView(this));

    }
    private class MyView extends View{

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paintText=new Paint();						//创建一个采用默认设置的画笔
            paintText.setColor(Color.BLACK);						//设置画笔颜色
            paintText.setTextAlign(Paint.Align.LEFT);				//设置文字左对齐
            paintText.setTextSize(12);								//设置文字大小
            paintText.setAntiAlias(true);						  //使用抗锯齿功能
            canvas.drawText("不，我不想去！", 245, 45, paintText);	//通过drawText()方法绘制文字
            canvas.drawText("你想和我一起",175,160,paintText);  //通过drawText()方法绘制文字
            canvas.drawText("去探险吗？",175,175,paintText);    //通过drawText()方法绘制文字
        }
    }
}
