package com.example.buoi6;

import androidx.annotation.DrawableRes;

public class Face {
    private @DrawableRes int resId; //@DrawableRes chi cho truyen R.drawable.......
    private String name;

    public Face(@DrawableRes int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public String getName() {
        return name;
    }
}
