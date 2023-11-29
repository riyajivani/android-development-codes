package com.example.touchablecanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Drawing extends View {

    private Paint paint;
    private float circleX, circleY;
    private boolean isCircleVisible = false;
    private final int CIRCLE_RADIUS = 200; // Adjust as needed
    private final int CIRCLE_DURATION_MS = 200; // 2 seconds

    public Drawing(Context context) {
        super(context);
        init();
    }
    public Drawing(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init()
    {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isCircleVisible) {
            canvas.drawCircle(circleX, circleY, CIRCLE_RADIUS, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                circleX = event.getX();
                circleY = event.getY();
                isCircleVisible = true;
                invalidate(); // Request a redraw to display the circle

                // Schedule the removal of the circle after CIRCLE_DURATION_MS milliseconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Hide the circle
                        isCircleVisible = false;
                        invalidate(); // Request a redraw to hide the circle
                    }
                }, CIRCLE_DURATION_MS);

                return true;
        }
        return super.onTouchEvent(event);
    }
}
