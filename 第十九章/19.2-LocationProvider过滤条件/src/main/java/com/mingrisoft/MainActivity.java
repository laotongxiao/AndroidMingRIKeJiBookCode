package com.mingrisoft;

import android.app.Activity;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView textView = (TextView) findViewById(R.id.provider);   //获取显示最佳LocationProvider的TextView组件

        //获取location服务
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        Criteria criteria=new Criteria();   //创建过滤条件

        criteria.setCostAllowed(false);    //使用不收费的

        criteria.setAccuracy(Criteria.ACCURACY_FINE);   //使用精度最准确的

        criteria.setPowerRequirement(Criteria.POWER_LOW);  //使用耗电量最低的

        //获取最佳的LocationProvider名称
        String provider=locationManager.getBestProvider(criteria,true);

        textView.setText(provider);  //显示最佳的LocationProvider名称

    }
}
