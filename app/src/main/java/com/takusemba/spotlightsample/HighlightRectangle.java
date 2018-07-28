package com.takusemba.spotlightsample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.ColorInt;

import com.takusemba.spotlight.shape.Shape;

public class HighlightRectangle implements Shape {

    private float width;
    private float height;
    private Paint highlightPaint = new Paint();

    public HighlightRectangle(float width, float height, @ColorInt int highlightColor) {
        this.width = width;
        this.height = height;
        this.highlightPaint.setColor(highlightColor);
        this.highlightPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas, PointF point, float value, Paint paint) {
        float highlightWidth = 0.1f * value * Math.max(width, height);

        this.highlightPaint.setStrokeWidth(highlightWidth);
        canvas.drawRect(
            point.x - (highlightWidth +  width / 2.0f),
            point.y - (highlightWidth + height / 2.0f),
            point.x + (highlightWidth +  width / 2.0f),
            point.y + (highlightWidth + height / 2.0f),
            paint
        );
        canvas.drawRect(
            point.x - (highlightWidth +  width) / 2.0f,
            point.y - (highlightWidth + height) / 2.0f,
            point.x + (highlightWidth +  width) / 2.0f,
            point.y + (highlightWidth + height) / 2.0f,
            highlightPaint
        );
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
