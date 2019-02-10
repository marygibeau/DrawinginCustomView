package com.example.drawingincustomview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class OurView extends View {
    int x = 200, y = 300;
    int dx = 10, dy = 10;
    int c = Color.BLUE;

    public OurView(Context context) {
        super(context);
    }

    public OurView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OurView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OurView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        // deleted 4th attribue to get rid of api level error
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        x += dx;
        y += dy;
        Paint p = new Paint();
        p.setColor(c);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, y, 25, p);
        if (x < 0 || x > Resources.getSystem().getDisplayMetrics().widthPixels) {
            dx *= -1;
            Random rnd = new Random();
            c = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            canvas.drawCircle(x + dx, y, 25, p);
        }
        if (y < 0 || y > Resources.getSystem().getDisplayMetrics().heightPixels - 260) {
            dy *= -1;
            Random rnd = new Random();
            c = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            p.setColor(c);
            canvas.drawCircle(x, y + dy, 25, p);
        }
        invalidate();
    }
}
