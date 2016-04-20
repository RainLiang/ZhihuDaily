package com.rongma.zhihudaily.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.rongma.zhihudaily.R;
import com.rongma.zhihudaily.fragment.MainPageFragment;
import com.rongma.zhihudaily.global.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData()
    {

    }

    @Override
    protected void bindViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        MainPageFragment mainFrag = new MainPageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frag, mainFrag);
        transaction.commit();
    }

    @Override
    protected void initVirable() {

    }
}
