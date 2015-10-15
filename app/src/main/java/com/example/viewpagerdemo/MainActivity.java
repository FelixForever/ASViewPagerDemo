package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private ViewPager mViewPager;
    private AdpViewPager mAdpViewPager;
    private List<View> mViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager=(ViewPager)findViewById(R.id.vp_main);
        LayoutInflater layoutInflater=getLayoutInflater();
        this.mViewList=new ArrayList<>();
        mViewList.add(layoutInflater.inflate(R.layout.layout1,null));
        mViewList.add(layoutInflater.inflate(R.layout.layout2, null));
        mViewList.add(layoutInflater.inflate(R.layout.layout3,null));
        mAdpViewPager=new AdpViewPager(mViewList);
        mViewPager.setAdapter(mAdpViewPager);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("felixheh","this is my tag");
                Toast.makeText(MainActivity.this,"this is a text",Toast.LENGTH_SHORT).show();
            }
        });
    }
    class AdpViewPager extends PagerAdapter
    {
        List<View> mViewList;
        AdpViewPager(List<View> views)
        {
            this.mViewList=views;
        }
        @Override
        public boolean isViewFromObject(View view, Object o)
        {
            return view==o;
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
