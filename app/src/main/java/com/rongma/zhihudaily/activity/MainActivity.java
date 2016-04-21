package com.rongma.zhihudaily.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.rongma.zhihudaily.R;
import com.rongma.zhihudaily.fragment.MainPageFragment;
import com.rongma.zhihudaily.global.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle; //在Toolbar左侧显示的按钮,可以弹出DrawerLayout
    private DrawerLayout drawer;
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
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        //设置DrawerToggle
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        toggle.syncState();
        drawer.setDrawerListener(toggle);
        MainPageFragment mainFrag = new MainPageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frag, mainFrag);
        transaction.commit();
    }

    @Override
    protected void initVirable() {

    }
}
