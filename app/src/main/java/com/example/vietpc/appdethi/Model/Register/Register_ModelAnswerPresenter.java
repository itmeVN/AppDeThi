package com.example.vietpc.appdethi.Model.Register;

public interface Register_ModelAnswerPresenter {
    public void RegisterSuccess();
    public void RegisterFail_Email();
    public void RegisterFail_CaptCha();
    public void RegisterFail_MK();
    public void RegisterFail_MK1();
    public void RegisterFail_HoTen();
    public  void NoConnection();
    public  void RegisterFail_Email_Exsist();
}
