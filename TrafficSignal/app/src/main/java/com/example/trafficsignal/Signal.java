package com.example.trafficsignal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.os.Handler;

public class Signal extends View {

    private Paint brush, Rbrush, Ybrush, Gbrush;
    public int currentLight = 1; // 1 for Red, 2 for Yellow, 3 for Green

    public Signal(Context context) {
        super(context);
        init();
    }

    private void init() {
        brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        Rbrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        Ybrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        Gbrush = new Paint(Paint.ANTI_ALIAS_FLAG);

        brush.setColor(Color.WHITE);
        brush.setStyle(Paint.Style.STROKE);
        brush.setColor(Color.BLACK);
        brush.setStrokeWidth(15f);

        Rbrush.setColor(Color.RED);

        Ybrush.setColor(Color.YELLOW);

        Gbrush.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(50,50,350,950,brush);
        canvas.drawCircle(200, 200, 100, brush);
        canvas.drawCircle(200, 500, 100, brush);
        canvas.drawCircle(200, 800, 100, brush);

        if (currentLight == 1)
        {
            canvas.drawCircle(200, 200, 100, Rbrush);
            currentLight=2;
        }
        else if (currentLight == 2)
        {
            canvas.drawCircle(200, 500, 100, Ybrush);
            currentLight=3;
        }
        else if(currentLight==3)
        {
            canvas.drawCircle(200, 800, 100, Gbrush);
            currentLight=1;
        }

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                invalidate();
            }
        },1000 );

        canvas.save();
        super.onDraw(canvas);
    }
}
