package com.mingrisoft;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button)findViewById(R.id.bt);
        rg = (RadioGroup)findViewById(R.id.rg);
        bt.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View v){
                                      for(int i = 0;i<rg.getChildCount();i++){
                                          RadioButton radioButton = (RadioButton)rg.getChildAt(i);
                                          if(radioButton.isChecked()){
                                              if(radioButton.getText().equals("B:100")){
                                                  Toast.makeText(MainActivity.this,"回答正确",Toast.LENGTH_LONG).show();
                                              }else{
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("回答错误，下面请看解析：当张山换完零钱之后，" +
                                                          "给了顾客75还有价值25元的商品，自己还剩下了25元。这时，" +
                                                          "李石来找张山要钱，张山把自己剩下的相当于是李石的25元给了李石，" +
                                                          "另外自己掏了75元。这样张山赔了一个25元的商品和75元的人民币，" +
                                                          "总共价值100元。");
                                                  builder.setPositiveButton("确定",null).show();
                                              }
                                              break;
                                          }
                                      }
                                  }
                              }

        );

    }
}
