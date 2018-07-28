package com.takusemba.spotlightsample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.ColorInt;

import com.takusemba.spotlight.shape.Shape;

public class HighlightCircle implements Shape {

    private float radius;
    private Paint highlightPaint = new Paint();

    public HighlightCircle(float radius, @ColorInt int highlightColor) {
        this.radius = radius;
        this.highlightPaint.setColor(highlightColor);
        this.highlightPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas, PointF point, float value, Paint paint) {
        float highlightWidth = 0.2f * value * radius;

        this.highlightPaint.setStrokeWidth(highlightWidth);
        canvas.drawCircle(point.x, point.y, radius + highlightWidth, paint);
        canvas.drawCircle(point.x, point.y, radius + highlightWidth / 2.0f, highlightPaint);
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

