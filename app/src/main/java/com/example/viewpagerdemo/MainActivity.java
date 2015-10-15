package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.viewpagerdemo.fragment.Fragment1;
import com.example.viewpagerdemo.fragment.Fragment2;
import com.example.viewpagerdemo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity
{
    private final String TAG = MainActivity.class.getName().substring(MainActivity.class.getName().lastIndexOf('.'));
    private ViewPager mViewPager;
    private AdpViewPager mAdpViewPager;
    private List<View> mViewList;
    private List<Fragment> mFragmentList;
    private AdpFgViewPager madpFgViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        LayoutInflater layoutInflater = getLayoutInflater();
        this.mViewList = new ArrayList<>();
        mViewList.add(layoutInflater.inflate(R.layout.layout1, null));
        mViewList.add(layoutInflater.inflate(R.layout.layout2, null));
        mViewList.add(layoutInflater.inflate(R.layout.layout3, null));
        mAdpViewPager = new AdpViewPager(mViewList);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new Fragment1());
        mFragmentList.add(new Fragment2());
        mFragmentList.add(new Fragment3());
        Log.i(TAG, "mfragmentlist.size=" + mFragmentList.size());
        madpFgViewPager = new AdpFgViewPager(getSupportFragmentManager(), mFragmentList);

        Log.i(TAG, "madpFgViewPager.size=" + madpFgViewPager.getCount());
        mViewPager.setAdapter(mAdpViewPager);
        //mViewPager.setAdapter(madpFgViewPager);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("felixheh", "this is my tag");
                Toast.makeText(MainActivity.this, "this is a text", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class AdpFgViewPager extends FragmentPagerAdapter
    {
        List<Fragment> mFragmentList;

        AdpFgViewPager(FragmentManager fm, List<Fragment> fgs)
        {
            super(fm);
            mFragmentList = fgs;
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }
    }

    class AdpViewPager extends PagerAdapter
    {
        List<View> mViewList;

        AdpViewPager(List<View> views)
        {
            this.mViewList = views;
        }

        @Override
        public boolean isViewFromObject(View view, Object o)
        {
            return view == o;
        }

        @Override
        public int getCount()
        {
            return this.mViewList.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView(this.mViewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(this.mViewList.get(position));
            return this.mViewList.get(position);
        }

    }
}
