package com.mingrisoft;

import android.app.Activity;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //获取显示LocationProvider名称的TextView组件
        TextView textView = (TextView) findViewById(R.id.provider);

        //获取location服务
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //获取系统所有的LocationProvider名称
        List<String> providersNames = locationManager.getAllProviders();

        StringBuilder stringBuilder = new StringBuilder();  //使用StringBuilder保存数据

        //遍历获取到的全部LocationProvider名称
        for (Iterator<String> iterator = providersNames.iterator(); iterator.hasNext(); ) {
            stringBuilder.append(iterator.next() + "\n");
        }

        textView.setText(stringBuilder.toString());  //显示LocationProvider名称
    }
}

