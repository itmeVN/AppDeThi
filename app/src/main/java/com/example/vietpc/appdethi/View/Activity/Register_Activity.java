package com.example.vietpc.appdethi.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vietpc.appdethi.Model.Register.Captcha;
import com.example.vietpc.appdethi.Presenter.Register.Register_PrensterAnswerView;
import com.example.vietpc.appdethi.Presenter.Register.Register_Presenter;
import com.example.vietpc.appdethi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends Activity implements View.OnClickListener, Register_PrensterAnswerView {
    EditText edtEmail, edtMK, edtMK2, edtHoTen, edtCapCha;
    ImageView img_CapCha;
    Button btnQL, btnDK, btnRefresh;
    Register_Presenter presenter;
    Captcha captcha = new Captcha();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        AnhXa();
    }

    private void AnhXa() {
        edtEmail = (EditText) findViewById(R.id.editText_reg_Email);
        edtMK = (EditText) findViewById(R.id.editText_reg_MK);
        edtMK2 = (EditText) findViewById(R.id.editText_reg_MK2);
        edtHoTen = (EditText) findViewById(R.id.editText_reg_HoTen);
        edtCapCha = (EditText) findViewById(R.id.editText_Capcha);
        btnQL = (Button) findViewById(R.id.button_reg_QL);
        btnDK = (Button) findViewById(R.id.button_reg_DK);
        btnRefresh = (Button) findViewById(R.id.button_reg_RF);
        btnRefresh.setOnClickListener(this);
        btnDK.setOnClickListener(this);
        btnQL.setOnClickListener(this);
        img_CapCha = (ImageView) findViewById(R.id.imageView_capcha);
        img_CapCha.setImageBitmap(captcha.CaptchaBitMap());

        presenter = new Register_Presenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_reg_QL:
                finish();
                break;
            case R.id.button_reg_DK:
                String captchaText = "";
                captchaText = captcha.TakeCap();
                presenter.DangKy(Register_Activity.this,edtEmail.getText().toString(),
                        edtMK.getText().toString(),
                        edtMK2.getText().toString(),
                        edtHoTen.getText().toString(),
                        edtCapCha.getText().toString(),
                        captchaText);
                break;
            case R.id.button_reg_RF:
                img_CapCha.setImageBitmap(captcha.CaptchaBitMap());
                break;
        }
    }

    @Override
    public void RegisterSuccess() {
        Toast.makeText(this,"Dang ky thanh cong!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void RegisterFail_Email() {
        Toast.makeText(this,"Email khong hop le!",Toast.LENGTH_LONG).show();
        img_CapCha.setImageBitmap(captcha.CaptchaBitMap());
    }

    @Override
    public void RegisterFail_CaptCha() {
        Toast.makeText(this,"Nhap sai Captcha!",Toast.LENGTH_LONG).show();
        img_CapCha.setImageBitmap(captcha.CaptchaBitMap());
    }

    @Override
    public void RegisterFail_MK() {
        Toast.makeText(this,"Mat khau chua du 8 ky tu!",Toast.LENGTH_LONG).show();
        img_CapCha.setImageBitmap(captcha.CaptchaBitMap());
    }

    @Override
    public void RegisterFail_MK1() {
        Toast.makeText(this,"Mat khau nhap lai khong khop!",Toast.LENGTH_LONG).show();
        img_CapCha.setImageBitmap(captcha.CaptchaBitMap());
    }

    @Override
    public void RegisterFail_HoTen() {
        Toast.makeText(this,"Ho ten khong hop le!",Toast.LENGTH_LONG).show();
        img_CapCha.setImageBitmap(captcha.CaptchaBitMap());
    }

    @Override
    public void NoConnection() {
        Toast.makeText(this,"Khong co ket noi Internet!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void RegisterFail_Email_Exsist() {
        Toast.makeText(this,"Email da ton tai!",Toast.LENGTH_LONG).show();
    }


}
