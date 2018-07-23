package com.example.vietpc.appdethi.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vietpc.appdethi.Presenter.Login.Login_PresenterAnswerView;
import com.example.vietpc.appdethi.Presenter.Login.Login_Presenter;
import com.example.vietpc.appdethi.R;
import com.example.vietpc.appdethi.View.Activity.ds_MonHoc.DS_MonHoc_Activity;

public class LogIn_Activity extends Activity implements View.OnClickListener, Login_PresenterAnswerView {
    EditText edtTenDN, edtMK;
    Button btnDangNhap, btnQuayLai;
    CheckBox cbSave;
    Login_Presenter presenter;
    private SharedPreferences preferences;
    private static final String email = "email_saved";
    private static final String matkhau = "matkhau_saved";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_);
        AnhXa();
        SetTextSave();
    }

    private void AnhXa() {
        presenter = new Login_Presenter(this);
        btnDangNhap = (Button) findViewById(R.id.button_DangNhap);
        btnQuayLai = (Button) findViewById(R.id.button_QuayLai);
        edtTenDN = (EditText) findViewById(R.id.editText_Ten_DangNhap);
        edtMK = (EditText) findViewById(R.id.editText_Mat_Khau);
        cbSave = (CheckBox) findViewById(R.id.checkBox);
        btnDangNhap.setOnClickListener(this);
        btnQuayLai.setOnClickListener(this);
        preferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_DangNhap:
                presenter.ReceivefromView(LogIn_Activity.this,edtTenDN.getText().toString().trim(),
                        edtMK.getText().toString().trim());
                break;
            case R.id.button_QuayLai:
                finish();
                break;

        }
    }

    @Override
    public void LoginSuccess() {
        //Kiem tra check box
        if(cbSave.isChecked()){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email",edtTenDN.getText().toString());
            editor.putString("matkhau",edtMK.getText().toString());
            editor.putBoolean("checked",true);
            editor.commit();
        }
        else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("email");
            editor.remove("matkhau");
            editor.remove("checked");
            editor.commit();
        }
        Intent intent = new Intent(LogIn_Activity.this, DS_MonHoc_Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "Ten dang nhap hoac mat khau bi loi!", Toast.LENGTH_LONG).show();

    }

    private void SetTextSave(){
        edtTenDN.setText(preferences.getString("email",""));
        edtMK.setText(preferences.getString("matkhau",""));
        cbSave.setChecked(preferences.getBoolean("checked",false));
    }
}
