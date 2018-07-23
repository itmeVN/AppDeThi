package com.example.vietpc.appdethi.View.Activity.lop_dethi;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.vietpc.appdethi.R;
import com.example.vietpc.appdethi.View.Activity.Account_infor_Activity;
import com.example.vietpc.appdethi.View.Fragment.fragment_khode;
import com.example.vietpc.appdethi.View.Fragment.lop_fragment;

import java.util.ArrayList;


public class Lop_DeThi_Activity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop__de_thi_);
        AnhXa();

    }
    private void AnhXa() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new lop_fragment(),"Lớp");
        adapter.AddFragment(new fragment_khode(),"Kho đề");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_TK:
                item_TK_event();
                break;
            case R.id.item_DG:
                item_DG_event();
                break;
            case R.id.item_BL:
                item_BL_event();
                break;
            case R.id.item_DX:
                item_DX_event();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void item_TK_event(){
        Intent intent = new Intent(Lop_DeThi_Activity.this,Account_infor_Activity.class);
        startActivity(intent);
    }

    private void item_DG_event(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.alfazi.tracnghiemdethi"));
        startActivity(intent);
    }

    private void item_BL_event(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com.vn"));
        startActivity(intent);
    }

    private void item_DX_event(){
        Toast.makeText(this,"Đăng xuất thành công!",Toast.LENGTH_LONG).show();
    }



}
