package com.mingrisoft;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
            protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar(); //获取ActionBar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  //设置ActionBar为选项卡模式

        actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);  //隐藏标题栏
        actionBar.addTab(actionBar.newTab().setText("词典"). //将标签页添加ActionBar中
                setTabListener(new MyTabListener(this, Fragment1.class)));
        actionBar.addTab(actionBar.newTab().setText("百科"). //将标签页添加ActionBar中
                setTabListener(new MyTabListener(this, Fragment2.class)));
        actionBar.addTab(actionBar.newTab().setText("翻译").////将标签页添加ActionBar中
                setTabListener(new MyTabListener(this, Fragment3.class)));
        actionBar.addTab(actionBar.newTab().setText("发现").//将标签页添加ActionBar中
                setTabListener(new MyTabListener(this, Fragment4.class)));
        actionBar.addTab(actionBar.newTab().setText("我的").//将标签页添加ActionBar中
                setTabListener(new MyTabListener(this, Fragment5.class)));
    }


}
