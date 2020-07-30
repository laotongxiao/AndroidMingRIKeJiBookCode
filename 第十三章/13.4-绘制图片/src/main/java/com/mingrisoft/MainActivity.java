package com.mingrisoft;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局文件中添加的帧布局管理器
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        frameLayout.addView(new MyView(this)); //将自定义的MyView视图添加到帧布局管理器中
    }

    private class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();  //创建一个采用默认设置的画笔
            String path = Environment.getExternalStorageDirectory() + "/img01.jpg";  //指定图片文件的路径
            Bitmap bm = BitmapFactory.decodeFile(path);  //获取图片文件对应的Bitmap对象
            canvas.drawBitmap(bm, 0, 30, paint);   //将获取的Bitmap对象绘制在画布的指定位置
            Rect src = new Rect(105, 70, 220, 170);  //设置挖取的区域
            Rect dst = new Rect(350, 90, 465, 190);  //设置绘制的区域
            canvas.drawBitmap(bm, src, dst, paint);  //绘制挖取到的图像


        }

    }

}
