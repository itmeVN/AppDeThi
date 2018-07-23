package com.example.vietpc.appdethi.Presenter.Register;

import android.app.Activity;

import com.example.vietpc.appdethi.Model.Register.Register_Model;
import com.example.vietpc.appdethi.Model.Register.Register_ModelAnswerPresenter;

public class Register_Presenter implements Register_ModelAnswerPresenter {
    private Register_Model model;
    private Register_PrensterAnswerView callback;

    public Register_Presenter(Register_PrensterAnswerView callback) {
        this.callback = callback;
    }

    public void DangKy(Activity act, String Email, String MK, String MK2, String Hten, String Capcha, String textCatcha) {
        model = new Register_Model((Register_ModelAnswerPresenter) (this));
        model.CheckInfor(act,Email, MK, MK2, Hten, Capcha, textCatcha);
    }

    @Override
    public void RegisterSuccess() {
        callback.RegisterSuccess();
    }

    @Override
    public void RegisterFail_Email() {
        callback.RegisterFail_Email();
    }

    @Override
    public void RegisterFail_CaptCha() {
        callback.RegisterFail_CaptCha();
    }

    @Override
    public void RegisterFail_MK() {
        callback.RegisterFail_MK();
    }

    @Override
    public void RegisterFail_MK1() {
        callback.RegisterFail_MK1();
    }

    @Override
    public void RegisterFail_HoTen() {
        callback.RegisterFail_HoTen();
    }

    @Override
    public void NoConnection() {
        callback.NoConnection();
    }

    @Override
    public void RegisterFail_Email_Exsist() {
        callback.RegisterFail_Email_Exsist();
    }
}
