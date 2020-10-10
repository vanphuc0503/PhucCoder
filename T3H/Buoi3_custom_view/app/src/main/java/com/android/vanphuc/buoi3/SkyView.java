package com.android.vanphuc.buoi3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SkyView extends View implements Runnable {

    private int countStar = 300;
    private int min = 10;
    private int max = 50;

    private Paint p = new Paint();
    private ArrayList<Star> arrStar = new ArrayList<>();

    public SkyView(Context context) {
        super(context);
        init(null);
    }

    public SkyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SkyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SkyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null){
            TypedArray arr = getContext().obtainStyledAttributes(
                    attrs,
                    R.styleable.SkyView); //doc duoc tat ca cac thuoc tinh trong xml
            countStar = arr.getInt(R.styleable.SkyView_countStar, 300);
            min = arr.getInt(R.styleable.SkyView_minSize, 10);
            max = arr.getInt(R.styleable.SkyView_maxSize, 50);
            arr.recycle();
        }
        p.setColor(Color.RED);
        p.setStrokeWidth(30);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            initStar();
            invalidate();
        }
    }

    private void initStar() {
        arrStar.clear();
        for (int i = 0; i < countStar; i++) {
            Star s = new Star(getWidth(), getHeight(), min, max);
            arrStar.add(s);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Paint + Canvas == Graphics 2d
        super.onDraw(canvas);
        for (Star s : arrStar) {
            s.draw(canvas);
        }
    }

    @Override
    public void run() {
        while (true) {
            postInvalidate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
