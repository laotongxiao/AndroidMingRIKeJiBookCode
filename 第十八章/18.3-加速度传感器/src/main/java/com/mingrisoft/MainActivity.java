package com.mingrisoft;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;  //定义传感器管理器
    private Vibrator vibrator;            //定义振动器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);  // 获取传感器管理器
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);  //获取振动器服务

    }

    @Override
    protected void onResume() {
        super.onResume();
        //为加速度传感器注册监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = event.values;  //获取传感器X、Y、Z三个轴的输出信息
        int sensorType = event.sensor.getType();  // 获取传感器类型
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {  //如果是加速度传感器
            //X轴输出信息>15,Y轴输出信息>15,Z轴输出信息>20
            if (values[0] > 15 || values[1] > 15 || values[2] > 20) {
                Toast.makeText(MainActivity.this, "摇一摇", Toast.LENGTH_SHORT).show();
                //创建AlertDialog.Builder对象
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setView(R.layout.packet);     //添加布局文件
                alertDialog.show();                        //显示alertDialog
                vibrator.vibrate(500);                    //设置振动器频率
                sensorManager.unregisterListener(this);  //取消注册监听器
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
