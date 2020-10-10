package com.android.vanphuc.buoi3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Star {
    private int x;
    private int y;
    private int color;
    private int size;

    private Paint p;
    private Random rd = new Random();

    public Star(int w, int h, int min, int max) {
        size = rd.nextInt(max - min + 1) + min;
        x = rd.nextInt(w - size);
        y = rd.nextInt(h - size);
        p = new Paint();
        p.setTextSize(size);
    }

    private void randomColor() {
        int percent = rd.nextInt(101);
        if (percent < 95) return;
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        color = Color.rgb(r, g, b);
    }

    public void draw(Canvas c) {
        randomColor();
        p.setColor(color);
        c.drawText("★", x, y, p);
    }
}
