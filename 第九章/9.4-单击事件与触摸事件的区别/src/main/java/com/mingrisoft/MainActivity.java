package com.mingrisoft;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button= (Button) findViewById(R.id.btn);  //获得按钮对象
//        为按钮添加单击事件监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick","单击事件");
            }
        });
//        为按钮添加触摸事件监听器
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){	//表示手指按下时
                    Log.i("onTouch","按下");
                }else if (event.getAction()==MotionEvent.ACTION_UP){	//表示手指抬起时
                    Log.i("onTouch","抬起");
                }
                return false;		//表示未消耗掉这个事件
            }
        });
    }
}
