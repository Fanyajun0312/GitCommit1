package com.example.shixunexam.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @date：2020/8/26
 * @describe：
 * @author：FanYaJun
 */
public class VpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> titls;
    private ArrayList<Fragment> fragments;

    public VpAdapter(@NonNull FragmentManager fm, ArrayList<String> titls, ArrayList<Fragment> fragments) {
        super(fm);
        this.titls = titls;
        this.fragments = fragments;
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
