package com.mingrisoft;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {
    private ImageButton play, stop, record;           //定义播放、停止、录制、三种图片按钮
    private MediaRecorder mediaRecorder;          //定义用于实现录制视频的MediaRecorder类
    private SurfaceView surfaceView;               //定义用于显示图像的SurfaceView类
    private boolean isRecord = false;               //定义录制状态
    private File videoFile;                          //定义录制视频的文件夹
    private android.hardware.Camera camera;        //定义摄像头
    private File path;                                //定义录制视频保存的路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (!android.os.Environment.getExternalStorageState().equals(  //判断SD卡是否存在，如果不存在给出相应提示
                android.os.Environment.MEDIA_MOUNTED)) {
            Toast.makeText(MainActivity.this, "请安装SD卡！", Toast.LENGTH_SHORT).show(); // 弹出消息提示框显示提示信息
        }
        record = (ImageButton) findViewById(R.id.record);  //获取录制按钮
        stop = (ImageButton) findViewById(R.id.stop);      //获取停止录制的按钮
        play = (ImageButton) findViewById(R.id.play);      //获取播放已经录制好视频的按钮
        stop.setEnabled(false);                           //设置停止按钮不可用
        play.setEnabled(false);                           //设置播放按钮不可用
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);    //获取显示图像的SurfaceView组件
        surfaceView.getHolder().setFixedSize(1920, 1080);    //设置SurfaceView的分辨率

        record.setOnClickListener(new View.OnClickListener() {  //为录制按钮设置单击事件，实现录制功能
            @Override
            public void onClick(View v) {
                record();                                        //调用record()方法实现录制功能
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {  //为停止按钮设置单击事件，实现停止录制并提示保存视频位置
            @Override
            public void onClick(View v) {
                if (isRecord) {                //如果是正在录制
                    mediaRecorder.stop();      //停止录制
                    mediaRecorder.release();   //释放资源
                    record.setEnabled(true);   //设置录制按钮可用
                    stop.setEnabled(false);    //设置停止按钮不可用
                    play.setEnabled(true);     //设置播放按钮可用
                    Toast.makeText(MainActivity.this, "录像保存在：" + path, Toast.LENGTH_SHORT).show();
                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {  //为播放按钮设置单击事件，实现播放录制好的视频
            @Override
            public void onClick(View v) {
                //通过Intent跳转播放视频界面
                Intent intent = new Intent(MainActivity.this, PlayVideoActivity.class);
                startActivity(intent);
            }
        });

    }

    private void record() {  //创建record()方法，实现录制功能
        //设置录制视频保存的文件夹
        videoFile = new File(Environment.getExternalStorageDirectory() + "/Myvideo/");
        if (!videoFile.exists()) {                                     //如果该目录不存在
            videoFile.mkdir();                                     //就创建该目录
        }
        String fileName = "video.mp4";                             //视频文件的名称
        path = new File(videoFile, fileName);                       //视频文件的路径
        //创建MediaRecorder对象
        mediaRecorder = new MediaRecorder();
        camera.setDisplayOrientation(90);                    //调整摄像头角度
        camera.unlock();    //解锁摄像头
        mediaRecorder.setCamera(camera);                               //使用摄像头
        mediaRecorder.reset();   //重置MediaRecorder
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);       //设置麦克风获取声音
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);    //设置摄像头获取图像
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);  //设置视频输出格式为MP4
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);  //设置声音编码格式
        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);//设置视频编码格式为MP4
        mediaRecorder.setVideoEncodingBitRate(1920 * 1080);                    //设置清晰度
        mediaRecorder.setVideoSize(1920, 1080);                               //设置视频的尺寸
        mediaRecorder.setVideoFrameRate(10);                                 //设置为每秒10帧
        mediaRecorder.setOutputFile(path.getAbsolutePath());                 //设置视频输出路径
        mediaRecorder.setPreviewDisplay(surfaceView.getHolder().getSurface()); //设置使用SurfaceView预览视频
        mediaRecorder.setOrientationHint(90);                                   //调整播放视频角度
        try {
            mediaRecorder.prepare();                                            //准备录像
        } catch (Exception e) {
            e.printStackTrace();
        }
        mediaRecorder.start();  //开始录制
        Toast.makeText(MainActivity.this, "开始录像", Toast.LENGTH_SHORT).show();
        record.setEnabled(false);   //设置录制按钮不可用
        stop.setEnabled(true);      //设置停止按钮可用
        play.setEnabled(false);     //设置播放按钮不可用
        isRecord = true;             //设置录像状态为正在录制
    }

    @Override
    protected void onResume() {  //当Activity获取焦点时，开启摄像头
        camera = android.hardware.Camera.open();             //开启摄像头
        super.onResume();
    }

    @Override
    protected void onPause() {  //当Activity失去焦点时，停止预览并释放资源
        camera.stopPreview();       //停止预览
        camera.release();           //释放资源
        super.onPause();
    }
}
