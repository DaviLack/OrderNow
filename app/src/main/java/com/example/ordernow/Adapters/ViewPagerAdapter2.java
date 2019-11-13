package com.example.ordernow.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter2 extends FragmentPagerAdapter {

    private final List<Fragment> lstFragment2 = new ArrayList<>();
    private final List<String> lstTitles2 = new ArrayList<>();

    public ViewPagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragment2.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles2.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles2.get(position);
    }

    public void AddFragment (Fragment fragment, String title) {

        lstFragment2.add(fragment);
        lstTitles2.add(title);

    }

}
