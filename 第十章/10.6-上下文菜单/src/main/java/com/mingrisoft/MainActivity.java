package com.mingrisoft;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView introduce;  //定义TextView组件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        introduce = (TextView) findViewById(R.id.introduce);  //获取介绍TextView组件
        registerForContextMenu(introduce);        //为文本框注册上下文菜单
    }


    @Override
    //创建上下文菜单
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater inflater = new MenuInflater(this); //实例化一个MenuInflater对象
            inflater.inflate(R.menu.introduce_menu, menu);    //解析菜单文件
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_copy: //选中介绍文字菜单中的复制时
                Toast.makeText(MainActivity.this, "已复制", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_collect: //选中介绍文字菜单中的收藏时
                Toast.makeText(MainActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
