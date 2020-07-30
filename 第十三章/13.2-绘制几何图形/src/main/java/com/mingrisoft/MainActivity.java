package com.mingrisoft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
        FrameLayout frameLayout= (FrameLayout) findViewById(R.id.frameLayout);  //获取帧布局管理器
        frameLayout.addView(new MyView(this));  //将自定义视图的内部类添加到布局管理器中
    }

    private class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint=new Paint();	//默认设置创建一个画笔
            paint.setAntiAlias(true);	//使用抗锯齿功能
            paint.setColor(0xFFA4C739);	//设置画笔的颜色为绿色
            //绘制机器人的头
            RectF rectf_head=new RectF(10, 10, 100, 100);
            rectf_head.offset(90, 20);
            canvas.drawArc(rectf_head, -10, -160, false, paint);	//绘制弧
            //绘制眼睛
            paint.setColor(Color.WHITE);	//设置画笔的颜色为白色
            canvas.drawCircle(125, 53, 4, paint);	//绘制圆
            canvas.drawCircle(165, 53, 4, paint);	//绘制圆
            paint.setColor(0xFFA4C739);	//设置画笔的颜色为绿色
            //绘制天线
            paint.setStrokeWidth(2);	//设置笔触的宽度
            canvas.drawLine(110, 15, 125, 35, paint);	//绘制线
            canvas.drawLine(180, 15, 165, 35, paint);	//绘制线
            //绘制身体
            canvas.drawRect(100, 75, 190, 150, paint);	//绘制矩形
            RectF rectf_body=new RectF(100,140,190,160);
            canvas.drawRoundRect(rectf_body, 10, 10, paint);	//绘制圆角矩形
            //绘制胳膊
            RectF rectf_arm=new RectF(75,75,95,140);
            canvas.drawRoundRect(rectf_arm, 10, 10, paint);	//绘制左侧的胳膊
            rectf_arm.offset(120, 0);							//设置在X轴上偏移120像素
            canvas.drawRoundRect(rectf_arm, 10, 10, paint);	//绘制右侧的胳膊
            //绘制腿
            RectF rectf_leg=new RectF(115,150,135,200);
            canvas.drawRoundRect(rectf_leg, 10, 10, paint);	//绘制左侧的腿
            rectf_leg.offset(40, 0);							//设置在X轴上偏移40像素
            canvas.drawRoundRect(rectf_leg, 10, 10, paint);	//绘制右侧的腿
        }
    }
}
