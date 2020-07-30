package com.mingrisoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this); 	    // 创建帧布局管理器
        frameLayout.setBackgroundResource(R.mipmap.bg);         //设置背景
        setContentView(frameLayout); 						    // 设置在Activity中显示frameLayout
        text1 = new TextView(this);
        text1.setText("开始游戏");							    //设置显示文字
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18); 	// 设置文字大小，单位为SP（缩放像素）
        text1.setTextColor(Color.rgb(17, 85, 114)); 		    // 设置文字的颜色
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);		     //创建保存布局参数的对象
        params.gravity = Gravity.CENTER;					     //设置居中显示
        text1.setLayoutParams(params);						     //设置布局参数
        text1.setOnClickListener(new OnClickListener() {    // 为text1添加单击事件监听器
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("系统提示") // 设置对话框的标题
                        .setMessage("游戏有风险，进入需谨慎，真的要进入吗？")    // 设置对话框的显示内容
                        .setPositiveButton("确定",                               // 为确定按钮添加单击事件
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.i("桌面台球", "进入游戏");           // 输出消息日志
                                    }
                                }).setNegativeButton("退出",                     // 为取消按钮添加单击事件
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("桌面台球", "退出游戏");                   // 输出消息日志
                                finish();                                        // 结束游戏
                            }
                        }).show();									             // 显示对话框
            }
        });
        frameLayout.addView(text1);                             // 将text1添加到布局管理器中
    }
}

