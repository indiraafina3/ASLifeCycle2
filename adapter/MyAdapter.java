package com.codepolitan.myapplicationviewpager.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codepolitan.myapplicationviewpager.fragment.FragmentKedua;
import com.codepolitan.myapplicationviewpager.fragment.FragmentKeempat;
import com.codepolitan.myapplicationviewpager.fragment.FragmentKetiga;
import com.codepolitan.myapplicationviewpager.fragment.FragmentPertama;

import java.util.ArrayList;
import java.util.List;

//alt+enter
public class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentPertama();
            case 1:
                return new FragmentKedua();
            case 2:
                return new FragmentKetiga();
            case 3:
                return new FragmentKeempat();
                default:
                    return new FragmentPertama();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //string[] titles = new String[]{"News","Position};
        //return titles[position];
        List<String> title = new ArrayList<>();
        title.add("news");
        title.add("info");
        title.add("tutorial");
        title.add("opini");

        return title.get(position);
    }
}