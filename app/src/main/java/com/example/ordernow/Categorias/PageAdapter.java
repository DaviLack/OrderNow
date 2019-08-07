package com.example.ordernow.Categorias;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    int counttab;

    public PageAdapter(FragmentManager fm, int counttab) {

        super(fm);
        this.counttab = counttab;

    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {

            case  0:
                TabOne tabOne = new TabOne();
                return tabOne;

            case  1:
                TabTwo tabTwo = new TabTwo();
                return tabTwo;

            case  2:
                TabThree tabThree = new TabThree();
                return tabThree;
            case  3:
                TabFour tabFour = new TabFour();
                return tabFour;

             default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return counttab;
    }
}
