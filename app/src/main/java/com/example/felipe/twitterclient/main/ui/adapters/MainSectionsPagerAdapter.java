package com.example.felipe.twitterclient.main.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Felipe on 04-Sep-16.
 */
public class MainSectionsPagerAdapter extends FragmentPagerAdapter {

    private String[] tittles;
    private Fragment[] fragments;

    public MainSectionsPagerAdapter(FragmentManager fm, String[] tittles, Fragment[] fragments) {
        super(fm);
        this.tittles = tittles;
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tittles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments[position];
    }

    @Override
    public int getCount() {
        return this.fragments.length;
    }
}
