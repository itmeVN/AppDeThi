package com.example.vietpc.appdethi.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vietpc.appdethi.R;

public class Account_infor_Activity extends AppCompatActivity {
    TextView tv_Ten_user,tv_user_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_infor_);
        AnhXa();
    }

    private void AnhXa() {
        tv_Ten_user = (TextView)  findViewById(R.id.textView_ten_user);
        tv_user_email =  (TextView) findViewById(R.id.textView_email_user);
    }
}
