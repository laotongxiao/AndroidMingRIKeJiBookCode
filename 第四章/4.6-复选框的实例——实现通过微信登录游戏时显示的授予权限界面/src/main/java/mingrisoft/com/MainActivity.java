package mingrisoft.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;        //定义登录按钮
    CheckBox checkBox1, checkBox2, checkBox3;   //定义复选框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button) findViewById(R.id.btn_login);      //通过ID获取布局确认登录按钮
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);    //通过ID获取布局复选框1
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);    //通过ID获取布局复选框2
        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);    //通过ID获取布局复选框3
        btn_login.setOnClickListener(new View.OnClickListener() {   //为确认登录按钮
            @Override
            public void onClick(View v) {
                String checked = "";           //保存选中的值
                if (checkBox1.isChecked()) { //当第一个复选框被选中
                    checked += checkBox1.getText().toString() ;  //输出第一个复选框内信息
                }
                if (checkBox2.isChecked()) { //当第二个复选框被选中
                    checked += checkBox2.getText().toString() ;  //输出第二个复选框内信息
                }
                if (checkBox3.isChecked()) { //当第三个复选框被选中
                    checked += checkBox3.getText().toString() ;  //输出第三个复选框内信息
                }
                //显示被选中复选框对应的信息
                Toast.makeText(MainActivity.this, checked, Toast.LENGTH_LONG).show();
            }
        });
    }
}
