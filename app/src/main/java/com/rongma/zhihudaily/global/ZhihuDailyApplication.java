package com.rongma.zhihudaily.global;

import android.app.Application;

/**
 * Created by RongMa on 16/4/20.
 */
public final class ZhihuDailyApplication extends Application
{
    public final boolean IS_DEBUG = true; //是否处于调试状态
    private static ZhihuDailyApplication application = new ZhihuDailyApplication();

    private ZhihuDailyApplication(){}

    public static ZhihuDailyApplication getApplication()
    {
        return application;
    }


}
