package com.mingrisoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout, linearLayout2;//定义linearLayout为默认布局管理器，linearLayout2为新建布局管理器
    ScrollView scrollView;//定义滚动视图组件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.ll);//获取布局管理器
        linearLayout2 = new LinearLayout(MainActivity.this);//创建一个新的布局管理器
        linearLayout2.setOrientation(LinearLayout.VERTICAL);//设置为纵向排列
        scrollView = new ScrollView(MainActivity.this);//创建滚动视图组件
        linearLayout.addView(scrollView);//默认布局中添加滚动视图组件
        scrollView.addView(linearLayout2);//滚动视图组件中添加新建布局
        ImageView imageView = new ImageView(MainActivity.this);//创建ImageView组件
        imageView.setImageResource(R.mipmap.cidian);//ImagView添加图片
        TextView textView = new TextView(MainActivity.this);//创建TextView组件
        textView.setText(R.string.cidian);//TextView添加文字
        linearLayout2.addView(imageView);//新建布局中添加ImageView组件
        linearLayout2.addView(textView);//新建布局中添加TextView组件
    }
}



