package mingrisoft.com;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Chronometer;

public class MainActivity extends Activity {
    Chronometer ch;          //定义计时器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);    //设置全屏显示
        ch = (Chronometer) findViewById(R.id.ch);   //获取计时器组件
        ch.setBase(SystemClock.elapsedRealtime());  //设置起始时间
        ch.setFormat("%s");                         //设置显示时间格式
        ch.start();                                 //开启计时器
        //添加监听器
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //判断时间计时达到60秒时
                if (SystemClock.elapsedRealtime() - ch.getBase() >= 60000) {
                    ch.stop();  //停止计时器
                }


            }
        });
    }

}
