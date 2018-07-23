package com.example.vietpc.appdethi.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vietpc.appdethi.Model.Register.Captcha;
import com.example.vietpc.appdethi.R;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btnDangNhap, btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnDangKy.setOnClickListener(this);
        btnDangNhap.setOnClickListener(this);
    }

    private void AnhXa() {
        btnDangNhap = (Button) findViewById(R.id.button_dangNhap);
        btnDangKy = (Button) findViewById(R.id.button_dangKy);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_dangNhap:
                btnDangNhapClicked();
                break;
            case R.id.button_dangKy:
                btnDangKyClicked();
                break;
        }
    }

    private void btnDangNhapClicked() {
        Intent intent = new Intent(MainActivity.this, LogIn_Activity.class);
        startActivity(intent);
    }

    private void btnDangKyClicked() {
        Intent intent = new Intent(MainActivity.this, Register_Activity.class);
        startActivity(intent);
    }

    //Model là nơi xử lý Logic nghiệp vụ cho các chức năng
    // View là nơi hiển thị thông tin choi người dùng nhìn thấy
    //Prensenter là nơi trung gian để giao tiếp giữa View và Model
}
