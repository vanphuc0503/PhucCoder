package com.t3h.buoi8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.t3h.buoi8.fragment.FavoritedFragment;
import com.t3h.buoi8.fragment.NewsFragment;
import com.t3h.buoi8.fragment.SavedFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private TabLayout tab;
    private NewsPagerAdapter adapter;
    private ViewPager pager;

    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSaved = new SavedFragment();
    private FavoritedFragment fmFavorited = new FavoritedFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }

    private void initviews() {
        pager = findViewById(R.id.view_pager);
        tab = findViewById(R.id.tad);
        tab.setupWithViewPager(pager);
        adapter = new NewsPagerAdapter(getSupportFragmentManager(), fmNews, fmSaved, fmFavorited);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.e(getClass().getName(), position + "");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}