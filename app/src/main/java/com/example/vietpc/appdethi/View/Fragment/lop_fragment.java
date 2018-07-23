package com.example.vietpc.appdethi.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vietpc.appdethi.R;
import com.example.vietpc.appdethi.View.Fragment.frag_chuong.fragment_chuong;

public class lop_fragment extends Fragment implements View.OnClickListener {
    View view;
    Button btn_l12,btn_l11,btn_l10,btn_l9,btn_l8;
    public lop_fragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lop, container, false);
        AnhXa();
        return view;
    }
    private void AnhXa(){
        btn_l8 = (Button) view.findViewById(R.id.button_l8);
        btn_l9 = (Button) view.findViewById(R.id.button_l9);
        btn_l10 = (Button) view.findViewById(R.id.button_l10);
        btn_l11 = (Button) view.findViewById(R.id.button_l11);
        btn_l12= (Button) view.findViewById(R.id.button_l12);
        btn_l8.setOnClickListener(this);
        btn_l9.setOnClickListener(this);
        btn_l10.setOnClickListener(this);
        btn_l11.setOnClickListener(this);
        btn_l12.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button_l8:
                MoveToNextFragment();
                break;
            case R.id.button_l9:
                break;
            case R.id.button_l10:
                break;
            case R.id.button_l11:
                break;
            case R.id.button_l12:
                break;
        }
    }

    private void MoveToNextFragment(){
        FragmentTransaction t = this.getFragmentManager().beginTransaction();
        Fragment mFrag = new fragment_chuong();
        t.replace( R.id.viewpager_id,mFrag);
        t.addToBackStack(null);
        t.commit();
    }
}
