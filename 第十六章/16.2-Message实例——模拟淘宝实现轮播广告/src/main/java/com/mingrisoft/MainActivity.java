package com.mingrisoft;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
    final int FLAG_MSG = 0x001;    //定义要发送的消息代码
    private ViewFlipper flipper;   //定义ViewFlipper
    private Message message;        //声明消息对象
    //定义图片数组
    private int[] images = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8};
    private Animation[] animation = new Animation[2];  //定义动画数组，为ViewFlipper指定切换动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);  //获取ViewFlipper
        for (int i = 0; i < images.length; i++) {      //遍历图片数组中的图片
            ImageView imageView = new ImageView(this);  //创建ImageView对象
            imageView.setImageResource(images[i]);  //将遍历的图片保存在ImageView中
            flipper.addView(imageView);             //加载图片
        }
        //初始化动画数组
        animation[0] = AnimationUtils.loadAnimation(this, R.anim.slide_in_right); //右侧平移进入动画
        animation[1] = AnimationUtils.loadAnimation(this, R.anim.slide_out_left); //左侧平移退出动画
        flipper.setInAnimation(animation[0]);   //为flipper设置图片进入动画效果
        flipper.setOutAnimation(animation[1]);  //为flipper设置图片退出动画效果

        message=Message.obtain();       //获得消息对象
        message.what=FLAG_MSG;  //设置消息代码
        handler.sendMessage(message); //发送消息
    }


    Handler handler = new Handler() {  //创建android.os.Handler对象
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == FLAG_MSG) {  //如果接收到的是发送的标记消息
                flipper.showPrevious();                  //示下一张图片
            }
            message=handler.obtainMessage(FLAG_MSG);   //获取要发送的消息
            handler.sendMessageDelayed(message, 3000);  //延迟3秒发送消息
        }
    };
}
