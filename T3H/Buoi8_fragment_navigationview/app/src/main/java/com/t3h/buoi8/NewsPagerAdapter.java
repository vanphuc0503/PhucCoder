package com.t3h.buoi8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.t3h.buoi8.fragment.FavoritedFragment;
import com.t3h.buoi8.fragment.NewsFragment;
import com.t3h.buoi8.fragment.SavedFragment;

public class NewsPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    public NewsPagerAdapter(@NonNull FragmentManager fm, Fragment... fragments) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
            case 0:
                return "News";
            case 1:
                return "Saved";
            case 2:
                return "Favorited";
        }
        return super.getPageTitle(position);
    }
}
