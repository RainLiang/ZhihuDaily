package com.rongma.zhihudaily.global;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RongMa on 16/4/20.
 */
public abstract class BaseFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //初始化成员变量
        initVirables();
        //绑定UI
        View view = bindView(inflater,container,savedInstanceState);
        //获取数据
        initData();
        return view;
    }

    protected abstract void initData();

    protected abstract View bindView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initVirables();
}
