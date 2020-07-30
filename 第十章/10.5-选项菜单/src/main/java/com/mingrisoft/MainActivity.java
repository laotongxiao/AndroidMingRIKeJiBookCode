package com.mingrisoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);  //实例化一个MenuInflater对象
        menuInflater.inflate(R.menu.menu, menu);   //解析菜单文件
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { //获取选中菜单id
            case R.id.settings: //通过选中id跳转指定页面
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
                break;
            case R.id.regard:  //通过选中id跳转指定页面
                Intent intent1 = new Intent(MainActivity.this, Regard.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
