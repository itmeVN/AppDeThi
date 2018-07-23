package com.example.vietpc.appdethi.View.Fragment.frag_chuong;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.vietpc.appdethi.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_chuong extends Fragment {
    View view;
    GridView gridView;
    ArrayList<String> titleList;
    gridview_adapter adapter;
    public fragment_chuong() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chuong_layout,container,false);
        AnhXa();
        return view;
    }

    private void AnhXa(){
        gridView = (GridView) view.findViewById(R.id.Gridview_id);
        titleList = new ArrayList<>();
        titleList.add("Asus");
        titleList.add("Dell");
        titleList.add("Acer");
        titleList.add("lenovo");
        titleList.add("alienware");
        adapter = new gridview_adapter(getActivity(),titleList);
        gridView.setAdapter(adapter);
    }

}
