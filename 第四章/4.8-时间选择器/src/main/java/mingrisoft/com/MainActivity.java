package mingrisoft.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;            //定义时间选择器
    int hour,minute;                  //定义小时和分
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker= (TimePicker) findViewById(R.id.timePicker);  //通过ID获取布局时间选择器
        timePicker.setIs24HourView(true);                         //设置时间为24小时制
        Calendar calendar=Calendar.getInstance();
        hour=calendar.get(Calendar.HOUR_OF_DAY);                  //获取当前小时
        minute=calendar.get(Calendar.MINUTE);                     //获取当前分钟
        //为时间选择器设置监听器
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                MainActivity.this.hour=hourOfDay;          //改变小时后的参数
                MainActivity.this.minute=minute;           //改变分钟后的参数
                show(hourOfDay,minute);                     //通过消息框显示选择的时间
            }

            private void show(int hourOfDay, int minute) {
                String str=hourOfDay+"时"+minute+"分";      //获取选择器设置的时间
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();//显示消息提示框
            }
        });
    }
}
