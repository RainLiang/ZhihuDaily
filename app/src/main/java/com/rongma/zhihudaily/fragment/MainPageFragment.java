package com.rongma.zhihudaily.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rongma.zhihudaily.R;
import com.rongma.zhihudaily.global.BaseFragment;

/**
 * Created by RongMa on 16/4/20.
 */
public class MainPageFragment extends BaseFragment
{

    @Override
    protected void initData() {

    }

    @Override
    protected View bindView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frag_layout,null);
        return view;
    }

    @Override
    protected void initVirables() {

    }
}
