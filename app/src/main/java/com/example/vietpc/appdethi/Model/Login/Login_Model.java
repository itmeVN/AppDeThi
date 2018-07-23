package com.example.vietpc.appdethi.Model.Login;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.vietpc.appdethi.View.Activity.LogIn_Activity;
import com.example.vietpc.appdethi.View.Activity.Register_Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Model {
    Login_ModelAnswerPresenter callback;
    FirebaseAuth firebaseAuth;
    public Login_Model(Login_ModelAnswerPresenter callback) {
        this.callback = callback;
    }

    public void Handle(Activity act, String TenDN, String MK){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(TenDN, MK)
                .addOnCompleteListener(act, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            callback.LoginSuccess();
                        } else {
                            callback.LoginFail();
                            }
                    }
                });

    }
}
