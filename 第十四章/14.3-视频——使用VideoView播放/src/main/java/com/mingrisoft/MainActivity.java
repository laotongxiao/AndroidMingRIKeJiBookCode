package com.mingrisoft;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        VideoView video = (VideoView) findViewById(R.id.video);            //获取VideoView组件

        //指定模拟器SD卡上要播放的视频文件
        File file = new File(Environment.getExternalStorageDirectory() + "/video.mp4");
        MediaController mc = new MediaController(MainActivity.this);     //创建android.widget.MediaController对象，控制视频的播放

        //实现视频的播放功能
        if (file.exists()) {                                    //判断要播放的视频文件是否存在
            video.setVideoPath(file.getAbsolutePath());       //指定要播放的视频
            video.setMediaController(mc);                  //设置VideoView与MediaController相关联
            video.requestFocus();                         //让VideoView获得焦点
            try {
                video.start();                             //开始播放视频
            } catch (Exception e) {
                e.printStackTrace();                       //输出异常信息
            }

            //为VideoView添加完成事件监听器，实现视频播放结束后的提示信息
            video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //弹出消息提示框显示播放完毕
                    Toast.makeText(MainActivity.this, "视频播放完毕！", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            //弹出消息提示框提示文件不存在
            Toast.makeText(this, "要播放的视频文件不存在", Toast.LENGTH_SHORT).show();
        }

    }
}
