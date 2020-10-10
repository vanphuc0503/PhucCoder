package com.example.buoi14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.buoi14.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainListener {
    private ActivityMainBinding binding;
    private Animation alpha;
    private Animation rotate;
    private Animation translate;
    private Animation scale;
    private Animation set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setListener(this);
        initAnimation();
    }

    private void initAnimation() {
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        set = AnimationUtils.loadAnimation(this, R.anim.set);
    }

    @Override
    public void onAlphaClicked(View view) {
        view.startAnimation(alpha);
    }

    @Override
    public void onRotateClicked(View view) {
        view.startAnimation(rotate);
    }

    @Override
    public void onTranslateClicked(View view) {
        view.startAnimation(translate);
    }

    @Override
    public void onScaleClicked(View view) {
        view.startAnimation(scale);
    }

    @Override
    public void onSetClicked(View view) {
        view.startAnimation(set);
    }
}