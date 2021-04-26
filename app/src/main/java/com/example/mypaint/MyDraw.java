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


    float TouchX, startx, stopx;
    float TouchY, starty, stopy;
    int color = Color.BLUE;
    int color2 = Color.RED;


    Paint paint = new Paint();


    protected void onDraw(Canvas canvas) {
        paint.setStrokeWidth(10f);
        paint.setColor(color);
        canvas.drawCircle(100, 100, 50, paint);
        for (int i = 0; i < points.size(); i++) {
            DrawPoint(canvas, points.get(i), points.get(i).color);
        }

    }

    private void DrawPoint(Canvas canvas, Point point, int color) {
        paint.setColor(color);
        canvas.drawCircle(point.getX(), point.getY(), 50, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        TouchX = (float) event.getX();
        TouchY = (float) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                startx = TouchX;
                starty = TouchY;
                if (TouchX > 0 && TouchX < 100 && TouchY > 0 && TouchY < 100) {
                    color = Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

                }
            }
            break;
           /* case MotionEvent.ACTION_MOVE: { // движение{
                stopx = (float) event.getX();
                stopy = (float) event.getY();
                //invalidate();
            }
            break;
            case MotionEvent.ACTION_UP: {
                stopx = event.getX();
                stopy = event.getY();

            }
            break;
            // отпускание
            case MotionEvent.ACTION_CANCEL: {
                stopx = event.getX();
                stopy = event.getY();
                //invalidate();
            }
            break;*/
        }



        points.add(new Point(TouchX, TouchY, color));
        invalidate();
        return true;
    }

}
