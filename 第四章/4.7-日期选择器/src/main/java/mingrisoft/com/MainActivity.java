package mingrisoft.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int year,month,day;     //定义年，月，日
    DatePicker datePicker;           //定义日期选择器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker= (DatePicker) findViewById(R.id.datePicker);    //通过ID获取布局日期选择器
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);           //获取当前年
        month=calendar.get(Calendar.MONTH);         //获取当前月
        day=calendar.get(Calendar.DAY_OF_MONTH);   //获取当前日
        //初始化日期选择器，并且在初始化时指定监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;            //改变年的参数
                MainActivity.this.month=monthOfYear;    //改变月的参数
                MainActivity.this.day=dayOfMonth;       //改变日的参数
                show(year,monthOfYear,dayOfMonth);       //通过消息框显示日期
            }
        });
    }
    private void show(int year, int monthOfYear, int dayOfMonth) {
        String str=year+"年"+monthOfYear+1+"月"+dayOfMonth+"日"; //获取选择器设置的日期
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show(); //将选择的日期显示出来
    }
}
