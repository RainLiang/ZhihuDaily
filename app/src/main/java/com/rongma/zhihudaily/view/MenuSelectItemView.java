package com.rongma.zhihudaily.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rongma.zhihudaily.R;
import com.rongma.zhihudaily.global.MenuSelectItemType;

/**
 * Created by RongMa on 16/5/8.
 */
public class MenuSelectItemView extends LinearLayout
{
    private ImageView imageView;
    private TextView textView;
    public MenuSelectItemView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        bindAttrs(context,attrs);
    }

    public MenuSelectItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bindAttrs(context, attrs);
    }


    private void bindAttrs(Context context,AttributeSet attrs)
    {
        View view = View.inflate(context,R.layout.menu_title_view_layout,this);
        LayoutParams params = new LayoutParams(context,attrs);

        imageView = (ImageView) view.findViewById(R.id.iv_menu_item_icon);
        textView = (TextView) view.findViewById(R.id.tv_menu_item_title);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MenuSelectItemView);
        int length = typedArray.getIndexCount();
        for(int i = 0 ; i < length ; i++)
        {
            int attr = typedArray.getIndex(i);
            switch(attr)
            {
                case R.styleable.MenuSelectItemView_imageSrc:
                    int resourceId = typedArray.getResourceId(R.styleable.MenuSelectItemView_imageSrc,0);
                    imageView.setImageResource(resourceId > 0 ? resourceId : R.drawable.ic_launcher);
                    break;
                case R.styleable.MenuSelectItemView_menuText:
                    textView.setText(typedArray.getString(R.styleable.MenuSelectItemView_menuText));
                    break;
                case R.styleable.MenuSelectItemView_type:
                    //根据控件的数据类型,进行相应的配置
                    int type = R.styleable.MenuSelectItemView_type;
                    setViewByType(type);
                    break;
            }
        }
        typedArray.recycle();
    }

    //根据View的类型,配置相应的View
    private void setViewByType(int type) {
        switch (type)
        {
            case MenuSelectItemType.BLUE_TITLE:
                setBackgroundColor(getResources().getColor(R.color.colorTopViewBg));
                LayoutParams imageParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                imageParams.setMargins(0,0,15,0);
                imageView.setLayoutParams(imageParams);
                break;
            case MenuSelectItemType.MAINPAGE_TITLE:
                setBackgroundResource(R.color.colorGrayText);
                LayoutParams imageParamsMainPage = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                imageParamsMainPage.setMargins(0,0,20,0);
                imageView.setLayoutParams(imageParamsMainPage);
                break;
        }

    }
}
