package com.bwie.newstitleliyannew.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class TabAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> list;
    private String[] title;
    private static int p;

    public TabAdapter(FragmentManager fm,Context context,String[] title,List<Fragment> list) {
        super(fm);
        this.context = context;
        this.title = title;
        this.list = list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        p = position;
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
