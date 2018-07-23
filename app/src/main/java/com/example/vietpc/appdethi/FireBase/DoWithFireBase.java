package com.example.vietpc.appdethi.FireBase;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DoWithFireBase  {
    FirebaseAuth firebaseAuth;
    public void register_Acc(Activity act, String Email, String Mk){
        final Boolean check = false;
        firebaseAuth = FirebaseAuth.getInstance();

    }


    
    public void ReadData() {
        FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference();
    }
}
