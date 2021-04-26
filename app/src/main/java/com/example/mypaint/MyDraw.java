package com.example.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    List<Point> points = new ArrayList<>();
    Paint paint = new Paint();
    float TouchX, TouchY;
    float TouchXend, TouchYend;
    int color = Color.BLUE;

    public void DrawMyPoint(Canvas canvas, Point point) {
        paint.setColor(point.getColor());
        canvas.drawCircle(point.getX(), point.getY(), 50, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10f);
        //canvas.drawRect(0, 0, 100, 100, paint);
        for (int i = 0; i < points.size(); i++) {
            paint.setColor(points.get(i).getColor());
            canvas.drawRect(0, 0, 100, 100, paint);
            if (points.get(i).getX() > 100 && points.get(i).getY() > 100)
                DrawMyPoint(canvas, points.get(i));
        }


        // canvas.drawCircle(TouchX, TouchY, 50, paint);
        // canvas.drawLine(TouchX, TouchY, TouchXend, TouchYend, paint);
        // canvas.drawCircle(TouchXend, TouchYend, 50, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchX = event.getX();
        TouchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (TouchX > 0 && TouchX < 100 && TouchY > 0 && TouchY < 100) {
                    color = Color.rgb(
                            (int) (Math.random() * 255),
                            (int) (Math.random() * 255),
                            (int) (Math.random() * 255));
                }

            }
            break;
            /*case MotionEvent.ACTION_MOVE: {
                TouchX = event.getX();
                TouchY = event.getY();
                invalidate();
            }
            break;
            case MotionEvent.ACTION_UP: {
                TouchXend = event.getX();
                TouchYend = event.getY();
                // invalidate();
            }
            break;*/

        }
        points.add(new Point(TouchX, TouchY, color));
        invalidate();
        return true;

    }

}