package com.zzx.cashbook.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class RecordPagerAdapter extends FragmentPagerAdapter{
    List<Fragment> list;
    String titles[]={"支出","收入"};

    public RecordPagerAdapter(@NonNull FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
