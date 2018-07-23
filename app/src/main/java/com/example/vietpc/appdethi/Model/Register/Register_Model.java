package com.example.vietpc.appdethi.Model.Register;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register_Model {
    Register_ModelAnswerPresenter callback;
    FirebaseAuth firebaseAuth;
    public Register_Model(Register_ModelAnswerPresenter callback) {
        this.callback = callback;
    }

    public void CheckInfor(Activity act, String Email, String Mk, String MK2, String Hten, String Capcha, String textCaptcha) {

        if(checkInternetConnection(act)){
            if (checkEmail(Email) && checkCapcha(Capcha, textCaptcha) && checkMK(Mk) && checlMK2(Mk, MK2) && checkTen(Hten)) {
                {
                    checkOnFireBase(act,Email,Mk);
                }
            } else {
                if (checkEmail(Email) == false)
                    callback.RegisterFail_Email();
                else if (checkMK(Mk) == false)
                    callback.RegisterFail_MK();
                else if (checlMK2(Mk, MK2) == false)
                    callback.RegisterFail_MK1();
                else if (checkTen(Hten) == false)
                    callback.RegisterFail_HoTen();
                else
                    callback.RegisterFail_CaptCha();
            }
        }
        else {
            callback.NoConnection();
        }


    }

    // Kiểm tra Email nhập vào đã đứng định dạng mail hay chưa
    private static boolean checkEmail(String email) {
        boolean check = false;
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    // Kiểm tra Captcha nhập vào đã đứng với Captcha trong hình hay chưa
    private boolean checkCapcha(String Capcha, String textCatcha) {
        boolean check = false;
        String []Chuoi = textCatcha.trim().split(" ");
        String NewText = "";
        for(int i =0;i<Chuoi.length;i++)
        {
            NewText += Chuoi[i];
        }
        Log.d("Thong bao: ",  Capcha + " = " + NewText );
        if (Capcha.trim().equals(NewText.trim()))
            check = true;
        else
            check = false;
        return check;
    }

//    private boolean checkEmailExsist(String Email){
//        firebaseAuth.fetchSignInMethodsForEmail(Email)
//                .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
//
//                    }
//                });
//
//
//    }


    // kiểm tra mật khẩu đã nhập đủ 8 ký tự hay chưa
    private boolean checkMK(String MK) {
        boolean check = false;
        if (MK.length() >= 8)
            check = true;
        else
            check = false;
        return check;
    }

    // Kiểm tra Nhập lại mật khẩu đã khớp với mật khẩu vừa mới nhập hay chưa
    private boolean checlMK2(String MK, String MK2) {
        boolean check = false;
        if (MK.equals(MK2))
            check = true;
        else
            check = false;
        return check;
    }

    // Kiểm tra đã nhập tên hay chưa
    private boolean checkTen(String HoTen) {
        boolean check = false;
        String StringPartern = "^[a-z A-Z]{1,50}$";
        Pattern regex = Pattern.compile(StringPartern);
        Matcher matcher = regex.matcher(HoTen);
        if (matcher.find())
            check = true;
        else
            check = false;
        return check;
    }
    // Kiem tra dien thoai co ket noi internet hay khong
    private boolean checkInternetConnection(Context ctx){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void checkOnFireBase(Activity act, String Email, String Mk) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(Email, Mk)
                .addOnCompleteListener(act, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            callback.RegisterSuccess();

                        }
                        else
                            callback.RegisterFail_Email_Exsist();
                    }
                });
    }
}
