package com.example.mvpchow10.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public class VpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titls;

    public VpAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> titls) {
        super(fm);
        this.fragments = fragments;
        this.titls = titls;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titls.get(position);
    }
}
