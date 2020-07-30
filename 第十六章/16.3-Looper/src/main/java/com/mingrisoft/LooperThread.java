package com.mingrisoft;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/1.
 */
public class LooperThread extends Thread {
    public Handler handler;					//声明一个Handler对象
    @Override
    public void run() {
        super.run();
        Looper.prepare();					//初始化Looper对象
        //实例化一个Handler对象
        handler = new Handler() {
            public void handleMessage(Message msg) {
                Log.i("Looper", String.valueOf(msg.what));
            }
        };

        Message m=handler.obtainMessage();	//获取一个消息
        m.what=0x7;						//设置Message的what属性的值
        handler.sendMessage(m);			//发送消息
        Looper.loop();						//启动Looper

    }

}
