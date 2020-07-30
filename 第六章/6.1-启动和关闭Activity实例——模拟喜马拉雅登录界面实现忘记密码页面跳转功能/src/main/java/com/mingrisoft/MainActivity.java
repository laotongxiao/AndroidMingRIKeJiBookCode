package com.mingrisoft;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView password = (TextView) findViewById(R.id.wang_mima);   //获取布局文件中的忘记密码
        password.setOnClickListener(new View.OnClickListener() { //为忘记密码创建单击监听事件
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent = new Intent(MainActivity.this, PasswordActivity.class);
                startActivity(intent); //启动Activity
            }
        });
    }
}
