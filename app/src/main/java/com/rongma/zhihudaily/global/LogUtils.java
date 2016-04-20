package com.rongma.zhihudaily.global;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by RongMa on 16/4/20.
 */
public final class LogUtils
{
    private static final String TAG_PREFIX = "zhihudaily"; //自定义TAG的前缀

    //获取完整的tag: 前缀:类名.方法名(line:行数)
    private static String generateTag(StackTraceElement element)
    {
        String callerClazzName = element.getClassName(); //获取到完整类名
        String clazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".")+1); //截取,获得最末尾的数据
        String tag = clazzName+"."+element.getMethodName()+"(line:"+element.getLineNumber()+")";
        if(TextUtils.isEmpty(TAG_PREFIX))
        {
            return tag;
        }
        else
        {
            return callerClazzName+":"+tag;
        }
    }

    public static void show(String msg)
    {
        if(ZhihuDailyApplication.getApplication().IS_DEBUG)
        {
            StackTraceElement element = Thread.currentThread().getStackTrace()[4];
            String tag = generateTag(element);
            Log.e(tag,msg);
        }
    }
}
