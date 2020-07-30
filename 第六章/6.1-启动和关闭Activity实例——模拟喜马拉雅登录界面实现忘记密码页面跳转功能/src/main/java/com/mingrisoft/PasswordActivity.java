package com.mingrisoft;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PasswordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        ImageButton close = (ImageButton) findViewById(R.id.close); //获取布局文件中的关闭按钮
        close.setOnClickListener(new View.OnClickListener() {  //为关闭按钮创建监听事件
            @Override
            public void onClick(View v) {
                finish(); //关闭当前Activity
            }
        });
    }
}
