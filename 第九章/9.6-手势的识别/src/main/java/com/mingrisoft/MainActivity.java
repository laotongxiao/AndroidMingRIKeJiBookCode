package com.mingrisoft;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity implements GestureOverlayView.OnGesturePerformedListener {
    private GestureLibrary library;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        library = GestureLibraries.fromRawResource
                (MainActivity.this, R.raw.gestures); //加载手势文件
        editText = (EditText) findViewById(R.id.editText); //获取编辑框
        if (!library.load()) {// 如果加载失败则退出
            finish();
        }
        GestureOverlayView gestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);
        gestureOverlayView.setGestureColor(Color.BLACK);
        gestureOverlayView.setFadeOffset(1000);
        gestureOverlayView.addOnGesturePerformedListener(this);// 增加事件监听器
    }
    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> gestures = library.recognize(gesture);// 获得全部预测结果
        int index = 0;// 保存当前预测的索引号
        double score = 0.0;// 保存当前预测的得分
        for (int i = 0; i < gestures.size(); i++) {// 获得最佳匹配结果
            Prediction result = gestures.get(i);// 获得一个预测结果
            if (result.score > score) {
                index = i;
                score = result.score;
            }
        }
        String text = editText.getText().toString();// 获得编辑框中已经包含的文本
        text += gestures.get(index).name;// 获得最佳匹配
        editText.setText(text);// 更新编辑框
    }
}
