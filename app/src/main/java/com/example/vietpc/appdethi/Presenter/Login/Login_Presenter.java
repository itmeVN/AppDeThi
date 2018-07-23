package com.example.vietpc.appdethi.Presenter.Login;

import android.app.Activity;

import com.example.vietpc.appdethi.Model.Login.Login_ModelAnswerPresenter;
import com.example.vietpc.appdethi.Model.Login.Login_Model;

public class Login_Presenter implements Login_ModelAnswerPresenter {
    private Login_Model model;
    private Login_PresenterAnswerView callback;

    public Login_Presenter(Login_PresenterAnswerView callback) {
        this.callback = callback;
    }

    public void ReceivefromView(Activity act, String TenDN, String MatKhau) {
        model = new Login_Model(this);
        model.Handle(act,TenDN, MatKhau);
    }

    @Override
    public void LoginSuccess() {
        callback.LoginSuccess();
    }

    @Override
    public void LoginFail() {
        callback.LoginFail();
    }
}
