package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;

public class Drawing extends View {

    private Paint brush;
    private Paint paint;
    private Paint paint2;

    Bitmap s;
    LinearGradient linearGradient = new LinearGradient(500,500,800,800,Color.BLACK,Color.BLUE, Shader.TileMode.MIRROR);
    RadialGradient radialGradient = new RadialGradient(600,600,200,Color.RED,Color.YELLOW,Shader.TileMode.MIRROR);
    public Drawing(Context context) {
        super(context);
        init();
    }

    public void init() {
        brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        brush.setColor(Color.parseColor("Black"));
        brush.setStrokeWidth(15f);

        paint= new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("Yellow"));
        paint.setStrokeWidth(20f);
        paint.setShader(radialGradient);

        paint2= new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setStrokeWidth(20f);
        paint2.setShader(linearGradient);

        s= BitmapFactory.decodeResource(getResources(),R.drawable.dog1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(100,500,500,800,paint);
        canvas.drawCircle(200,200,200f,brush);
        canvas.drawRect(300,3000,500,1050,paint2);

        canvas.drawBitmap(s,500,200,null);
        canvas.save();
        super.onDraw(canvas);
    }
}
