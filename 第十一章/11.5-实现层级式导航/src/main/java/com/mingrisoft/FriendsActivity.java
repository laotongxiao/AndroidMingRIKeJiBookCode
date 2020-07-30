package com.mingrisoft;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        if (NavUtils.getParentActivityName(FriendsActivity.this) != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);    //显示向左的箭头图标
        }
    }
}
