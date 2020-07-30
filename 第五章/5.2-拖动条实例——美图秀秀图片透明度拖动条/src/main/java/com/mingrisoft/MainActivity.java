package com.mingrisoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
   private ImageView image;          //定义图片
    private SeekBar seekBar;          //定义拖动条
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);    //获取图片
        seekBar = (SeekBar) findViewById(R.id.seekbar);    //获取拖动条
        //为拖动条设置监听事件
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // 当拖动条的滑块位置发生改变时触发该方法
            @Override
            public void onProgressChanged(SeekBar arg0, int progress,
                                          boolean fromUser) {
                // 动态改变图片的透明度
                image.setImageAlpha(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar bar) {
            }
        });
    }
}
