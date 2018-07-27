package com.takusemba.spotlightsample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import com.takusemba.spotlight.shape.Shape;

public class HighlightCircle implements Shape {

    private float radius;
    private Paint highlight = new Paint();

    public HighlightCircle(float radius) {
        this.radius = radius;
        highlight.setColor(Color.parseColor("#4dffffff"));
    }

    @Override
    public void draw(Canvas canvas, PointF point, float value, Paint paint) {
        canvas.drawCircle(point.x, point.y, value * radius, highlight);
        canvas.drawCircle(point.x, point.y, radius, paint);
    }

    @Override
    public int getHeight() {
        return (int) radius * 2;
    }

    @Override
    public int getWidth() {
        return (int) radius * 2;
    }
}

