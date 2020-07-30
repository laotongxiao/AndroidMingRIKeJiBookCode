package com.mingrisoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    private  ImageView[] img=new ImageView[12];		         //声明一个保存ImageView组件的数组
    private int[] imagePath=new int[]{
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,R.mipmap.img08,
            R.mipmap.img09,R.mipmap.img10,R.mipmap.img11,R.mipmap.img12
    };										                    //声明并初始化一个保存访问图片的数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout=(GridLayout)findViewById(R.id.layout);//获取XML文件中定义的线性布局管理器
        for(int i=0;i<imagePath.length;i++){
            img[i]=new ImageView(MainActivity.this);			//创建一个ImageView组件
            img[i].setImageResource(imagePath[i]);				//为ImageView组件指定要显示的图片
            img[i].setPadding(2, 2,2, 2);						//设置ImageView组件的内边距
            ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(116,68);//设置图片的宽度和高度
            img[i].setLayoutParams(params);					    //为ImageView组件设置布局参数
            layout.addView(img[i]);							    //将ImageView组件添加到布局管理器中
        }
    }
}
