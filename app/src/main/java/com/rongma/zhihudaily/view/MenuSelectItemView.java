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

/**
 * Created by RongMa on 16/5/8.
 */
public class MenuSelectItemView extends LinearLayout
{
    private ImageView imageView;
    private TextView textView;
    private OnItemViewClickListener listener;
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

        imageView = (ImageView) view.findViewById(R.id.iv_menu_item_icon);
        textView = (TextView) view.findViewById(R.id.tv_menu_item_title);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });

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
                case R.styleable.MenuSelectItemView_background_color:
                    setBackgroundColor(typedArray.getColor(R.styleable.MenuSelectItemView_background_color,0));
                    break;
                case R.styleable.MenuSelectItemView_menuTextColor:
                    textView.setTextColor(typedArray.getColor(R.styleable.MenuSelectItemView_menuTextColor,0));
                    break;
                case R.styleable.MenuSelectItemView_menuTextSize:
                    textView.setTextSize(typedArray.getFloat(R.styleable.MenuSelectItemView_menuTextSize,14));
                    break;
            }
        }
        typedArray.recycle();
    }



    public void setOnClickListener(OnItemViewClickListener listener)
    {
        this.listener = listener;
    }

    //点击事件的回调入口
    interface OnItemViewClickListener
    {
        void onClick();
    }

}
