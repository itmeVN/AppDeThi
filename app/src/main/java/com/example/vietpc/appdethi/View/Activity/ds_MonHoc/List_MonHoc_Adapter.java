package com.example.vietpc.appdethi.View.Activity.ds_MonHoc;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vietpc.appdethi.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class List_MonHoc_Adapter extends BaseAdapter {
    private Context context;
    private List<String> List_MonHoc;

    public List_MonHoc_Adapter() {
    }

    public List_MonHoc_Adapter(Context context, List<String> list_MonHoc) {
        this.context = context;
        List_MonHoc = list_MonHoc;
    }

    @Override
    public int getCount() {
        return List_MonHoc.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_ds_item,null);
            holder = new ViewHolder();
            holder.text_Ten_MH = (TextView) convertView.findViewById(R.id.textview_monhoc);
            String monhoc = List_MonHoc.get(position);
            holder.text_Ten_MH.setText(monhoc);
            holder.text_Ten_MH.setBackgroundColor(Color().get(position));
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();
        holder.text_Ten_MH.setText(List_MonHoc.get(position));
        return convertView;
    }

    public class ViewHolder{
        TextView text_Ten_MH;
        public ViewHolder(){};
    }

    private List<Integer> Color(){
        List<Integer> color_code = new ArrayList<>();
        color_code.add(Color.parseColor("#a2aad8"));
        color_code.add(Color.parseColor("#b8aad8"));
        color_code.add(Color.parseColor("#cbaad8"));
        color_code.add(Color.parseColor("#e0aad8"));
        color_code.add(Color.parseColor("#ffaad8"));
        return  color_code;
    }

}
