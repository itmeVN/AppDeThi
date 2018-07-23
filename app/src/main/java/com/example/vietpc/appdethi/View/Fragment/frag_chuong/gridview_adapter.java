package com.example.vietpc.appdethi.View.Fragment.frag_chuong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vietpc.appdethi.Model.Register.Captcha;
import com.example.vietpc.appdethi.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class gridview_adapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> chapterArrayList;

    public gridview_adapter(Context context, ArrayList<String> chapterArrayList) {
        this.context = context;
        this.chapterArrayList = chapterArrayList;
    }

    @Override
    public int getCount() {
        return chapterArrayList.size();
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
        Log.d(TAG, "getView: " + chapterArrayList.size());
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.gridview_item_layout, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView_Logo);
        TextView textView = (TextView) convertView.findViewById(R.id.textView_title);

        imageView.setImageBitmap(img_title(chapterArrayList.get(position)));
        textView.setText(chapterArrayList.get(position));
        return convertView;
    }

    public Bitmap img_title(String title) {
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#ff00ff"));
        textPaint.setTextSize(10);

        StaticLayout layout = new StaticLayout(title, textPaint, 225,
                Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);

        // Create bitmap
        Bitmap b = Bitmap.createBitmap(225, 45, Bitmap.Config.ARGB_4444);
        Canvas c = new Canvas(b);

        // Draw background
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);

        // Draw text
        c.save();
        c.translate(0, 0);
        layout.draw(c);
        c.restore();

        return b;
    }

}
