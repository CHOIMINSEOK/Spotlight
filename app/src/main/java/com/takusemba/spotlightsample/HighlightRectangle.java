package com.takusemba.spotlightsample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import com.takusemba.spotlight.shape.Shape;

public class HighlightRectangle implements Shape {

    private float width;
    private float height;
    private Paint highlight = new Paint();

    public HighlightRectangle(float width, float height) {
        this.width = width;
        this.height = height;
        highlight.setColor(Color.parseColor("#4dffffff"));
    }

    @Override
    public void draw(Canvas canvas, PointF point, float value, Paint paint) {
        float animatedWidth = value * width;
        float animatedHeight = value * height;
        int highlightLeft    = Math.round(point.x - animatedWidth / 2);
        int highlightTop     = Math.round(point.y - animatedHeight / 2);
        int highlightRight   = Math.round(point.x + animatedWidth / 2);
        int highlightBottom  = Math.round(point.y + animatedHeight / 2);

        int left    = Math.round(point.x - width / 2);
        int top     = Math.round(point.y - height / 2);
        int right   = Math.round(point.x + width / 2);
        int bottom  = Math.round(point.y + height / 2);

        canvas.drawRect(highlightLeft, highlightTop, highlightRight, highlightBottom, highlight);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    @Override
    public int getWidth() {
        return Math.round(width);
    }

    @Override
    public int getHeight() {
        return Math.round(height);
    }
}
