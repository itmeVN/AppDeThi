package com.example.vietpc.appdethi.Model.Register;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Captcha {
    String text = "";
    public  Bitmap CaptchaBitMap() {
        text = CaptchaCode();

        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.parseColor("#ff00ff"));
        textPaint.setTextSize(30);

        StaticLayout layout = new StaticLayout(text,textPaint,225,
                Layout.Alignment.ALIGN_CENTER,1.0f, 0.0f, false);

        // Create bitmap
        Bitmap b = Bitmap.createBitmap(225,45,Bitmap.Config.ARGB_4444);
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

    public String CaptchaCode(){
        Random r = new Random();
        String captcha = "";
        for(int i = 0;i<=4;i++){
            char random = (char) (97 + r.nextInt(25));
            captcha += " " + String.valueOf(random) ;
        }
        return  captcha;
    }

    public String TakeCap(){
        return text;
    }

}
