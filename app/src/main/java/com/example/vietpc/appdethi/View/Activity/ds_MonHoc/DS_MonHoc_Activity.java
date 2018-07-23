package com.example.vietpc.appdethi.View.Activity.ds_MonHoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vietpc.appdethi.R;
import com.example.vietpc.appdethi.View.Activity.lop_dethi.Lop_DeThi_Activity;

import java.util.ArrayList;
import java.util.List;

public class DS_MonHoc_Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listDS_MonHoc;
    List<String> list_MonHoc;
    List_MonHoc_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds__mon_hoc_);
        AnhXa();
        listDS_MonHoc.setOnItemClickListener(this);
    }

    private void AnhXa(){
        listDS_MonHoc = (ListView) findViewById(R.id.list_view_DS_MonHoc);
        list_MonHoc = new ArrayList<>();
        list_MonHoc.add("Toán");
        list_MonHoc.add("Vật lý");
        list_MonHoc.add("Hóa học");
        list_MonHoc.add("Anh văn");
        list_MonHoc.add("Sinh");
        adapter = new List_MonHoc_Adapter(this,list_MonHoc);
        listDS_MonHoc.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString("TenMon",list_MonHoc.get(position));
        Intent intent = new Intent(DS_MonHoc_Activity.this, Lop_DeThi_Activity.class);
        intent.putExtra("TenMonHoc",bundle);
        startActivity(intent);
    }
}
