package com.mingrisoft;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
    private int[] arrayPictures = new int[]{R.mipmap.img01, R.mipmap.img02, R.mipmap.img03,
            R.mipmap.img04, R.mipmap.img05, R.mipmap.img06,
            R.mipmap.img07, R.mipmap.img08, R.mipmap.img09,
    };// 声明并初始化一个保存要显示图像ID的数组
    private ImageSwitcher imageSwitcher; // 声明一个图像切换器对象
    //要显示的图片在图片数组中的Index
    private int pictutureIndex;
    //左右滑动时手指按下的X坐标
    private float touchDownX;
    //左右滑动时手指松开的X坐标
    private float touchUpX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher); // 获取图像切换器
        //为ImageSwicher设置Factory，用来为ImageSwicher制造ImageView
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this); // 实例化一个ImageView类的对象
                imageView.setImageResource(arrayPictures[pictutureIndex]);//根据id加载默认显示图片
                return imageView; // 返回imageView对象
            }
        });
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //取得左右滑动时手指按下的X坐标
                    touchDownX = event.getX();
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //取得左右滑动时手指松开的X坐标
                    touchUpX = event.getX();
                    //从左往右，看下一张
                    if (touchUpX - touchDownX > 100) {
                        //取得当前要看的图片的index
                        pictutureIndex = pictutureIndex == 0 ? arrayPictures.length - 1 : pictutureIndex - 1;
                        //设置图片切换的动画
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_right));
                        //设置当前要看的图片
                        imageSwitcher.setImageResource(arrayPictures[pictutureIndex]);
                        //从右往左，看上一张
                    } else if (touchDownX - touchUpX > 100) {
                        //取得当前要看的图片index
                        pictutureIndex = pictutureIndex == arrayPictures.length - 1 ? 0 : pictutureIndex + 1;
                        //设置切换动画
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_left));
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_right));
                        //设置要看的图片
                        imageSwitcher.setImageResource(arrayPictures[pictutureIndex]);
                    }
                    return true;
                }
                return false;
            }
        });
    }

}
