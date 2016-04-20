package com.rongma.zhihudaily.global;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

/**
 * Created by RongMa on 16/4/20.
 */
public abstract class BaseActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //初始化成员变量
        initVirable();
        //绑定UI控件
        bindViews(savedInstanceState);
        //获取数据 网络\Intent\本地数据库等
        initData();
    }

    protected abstract void initData();

    protected abstract void bindViews(Bundle savedInstanceState);

    protected abstract void initVirable();

    /**
     * 显示吐司
     * @param msg 显示吐司的内容
     */
    protected void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



}
