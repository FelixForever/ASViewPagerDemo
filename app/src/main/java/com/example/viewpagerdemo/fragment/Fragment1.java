package com.example.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpagerdemo.R;

/**
 * Created by Administrator on 2015/10/15.
 */
public class Fragment1 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.i("felix","haha");
        return inflater.inflate(R.layout.layout1,container,false);
    }
}
