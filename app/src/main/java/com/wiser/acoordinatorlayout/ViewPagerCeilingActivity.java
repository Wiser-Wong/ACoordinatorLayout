package com.wiser.acoordinatorlayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCeilingActivity extends FragmentActivity {

    private ViewPager vp;

    private TabLayout tabLayout;

    private List<Fragment> fragments;

    private List<String> titles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ceiling_viewpager);

        vp = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.tab_layout);

        fragments = new ArrayList<>();
        fragments.add(VpFragment.getInstance(40));
        fragments.add(VpFragment.getInstance(3));
        fragments.add(VpFragment.getInstance(0));
        fragments.add(VpFragment.getInstance(12));

        titles = new ArrayList<>();
        titles.add("首页");
        titles.add("办款");
        titles.add("健康");
        titles.add("我的");

        vp.setAdapter(new MAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(vp);
    }

    private class MAdapter extends FragmentStatePagerAdapter{

        public MAdapter(@NonNull FragmentManager fm) {
            super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
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
            return titles.get(position);
        }
    }
}
