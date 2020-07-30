package com.mingrisoft;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    int[] tvid = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
            R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9};    //文本框组件ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] color=getResources().getIntArray(R.array.bgcolor);		//获取保存背景颜色的数组
        String[] word=getResources().getStringArray(R.array.word);		//获取保存显示文字的数组
        //通过循环为每个文本框设置背景颜色和显示文字
        for(int i=0;i<9;i++){
            TextView tv=(TextView)findViewById(tvid[i]);	//获取文本框组件对象
            tv.setBackgroundColor(color[ i]);		//设置背景颜色
            tv.setText(word[i]); 					//设置显示文字
        }
    }
}
