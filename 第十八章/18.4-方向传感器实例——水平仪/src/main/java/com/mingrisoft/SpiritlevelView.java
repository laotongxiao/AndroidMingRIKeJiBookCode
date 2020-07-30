package com.mingrisoft;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/4/21.
 */
public class SpiritlevelView extends View implements SensorEventListener {

    private Bitmap bubble;         // 定义水平仪中的小蓝球位图
    private int MAX_ANGLE = 30;   // 定义水平仪最大倾斜角，超过该角度，小蓝球将直接位于边界
    private int bubbleX, bubbleY; // 定义水平仪中小蓝球的X、Y坐标

    public SpiritlevelView(Context context, AttributeSet attrs) {
        super(context, attrs);

        bubble = BitmapFactory   // 加载小蓝球图片
                .decodeResource(getResources(), R.drawable.bubble);

        SensorManager sensorManager = (SensorManager) context
                .getSystemService(Context.SENSOR_SERVICE);   // 获取传感器管理
        sensorManager.registerListener(this,  //为磁场传感器注册监听器
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this,  //为加速度传感器注册监听器
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    float[] accelerometerValues = new float[3];   //创建加速度传感器Z轴、X轴、Y轴取值数组
    float[] magneticValues = new float[3];          //创建磁场传感器Z轴、X轴、Y轴取值数组

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {          //如果当前为加速度传感器
            accelerometerValues = event.values.clone();                    //将取出的值放到加速度传感器取值数组中
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {  //如果当前为磁场传感器
            magneticValues = event.values.clone();                         //将取出的值放到磁场传感器取值数组中
        }

        float[] R = new float[9];                                           //创建存放旋转数据的取值数组
        float[] values = new float[3];                                        //创建存放方向数据的取值数组
        SensorManager.getRotationMatrix(R, null, accelerometerValues, magneticValues);
        SensorManager.getOrientation(R, values);                              //获取方向Z轴、X轴、Y轴信息值

        float xAngle = (float) Math.toDegrees(values[1]);  // 获取与X轴的夹角
        float yAngle = (float) Math.toDegrees(values[2]);   // 获取与Y轴的夹角
        getPosition(xAngle,yAngle); //获取小蓝球的位置坐标
        super.postInvalidate();  // 刷新界面
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bubble, bubbleX, bubbleY, null);   // 根据小蓝球坐标绘制小蓝球
    }
    //根据x轴和y轴的旋转角度确定小蓝球的位置
    private  void getPosition(float xAngle,float yAngle){
        // 小蓝球位于中间时（水平仪完全水平），小蓝球的X、Y坐标
        int x = (super.getWidth() - bubble.getWidth()) / 2;
        int y = (super.getHeight() - bubble.getHeight()) / 2;
        /********控制小球的X轴位置******/

        if (Math.abs(yAngle) <= MAX_ANGLE) {   // 如果Y轴的倾斜角度还在最大角度之内
            // 根据Y轴的倾斜角度计算X坐标的变化值（倾斜角度越大，X坐标变化越大）
            int deltaX = (int) ((super.getWidth() - bubble.getWidth()) / 2 * yAngle / MAX_ANGLE);
            x -= deltaX;
        } else if (yAngle > MAX_ANGLE) {  // 如果Y轴的倾斜角度已经大于MAX_ANGLE，小蓝球在最左边
            x = 0;
        } else {  // 如果与Y轴的倾斜角已经小于负的MAX_ANGLE，小蓝球在最右边
            x = super.getWidth() - bubble.getWidth();
        }
        /********控制小球的Y轴位置******/
        if (Math.abs(xAngle) <= MAX_ANGLE) {  // 如果X轴的倾斜角度还在最大角度之内
            // 根据X轴的倾斜角度计算Y坐标的变化值（倾斜角度越大，Y坐标变化越大）
            int deltaY = (int) ((super.getHeight() - bubble.getHeight()) / 2 * xAngle / MAX_ANGLE);
            y += deltaY;
        } else if (xAngle > MAX_ANGLE) {  // 如果与X轴的倾斜角度已经大于MAX_ANGLE，小蓝球在最下边
            y = super.getHeight() - bubble.getHeight();
        } else {  // 如果X轴的倾斜角已经小于负的MAX_ANGLE，小蓝球在最上边
            y = 0;
        }
        //更新小蓝球的坐标
        bubbleX = x;
        bubbleY = y;
    }
}
