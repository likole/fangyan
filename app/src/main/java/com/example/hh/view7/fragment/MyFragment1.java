package com.example.hh.view7.fragment;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.hh.view7.R;
import com.example.hh.view7.activity.BaseActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MyFragment1 extends BaseFragment {
    List<View> viewList=new ArrayList<>();
    ViewPager myViewPager;
    private int[]resId={R.mipmap.shui1,R.mipmap.shui1,R.mipmap.shui1};
    private BaseActivity parentActivity;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main1;
    }

    @Override
    protected void setUpView() {
        myViewPager=$(R.id.my_pager);
        parentActivity = (BaseActivity) getActivity();
    }
    @Override
    protected void setUpData() {


        {
            View view = LayoutInflater.from(parentActivity).inflate(R.layout.page_help_one, null);
            ImageView imageView = view.findViewById(R.id.imageView2);
            imageView.setBackgroundResource(resId[0]);
            viewList.add(view);
        }
        {
            View view;
            view = LayoutInflater.from(parentActivity).inflate(R.layout.page_help_one, null);
            ImageView imageView = view.findViewById(R.id.imageView2);
            imageView.setBackgroundResource(resId[1]);
            viewList.add(view);
        }
        {
            View view = LayoutInflater.from(parentActivity).inflate(R.layout.page_help_one, null);
            ImageView imageView = view.findViewById(R.id.imageView2);
            imageView.setBackgroundResource(resId[2]);
            viewList.add(view);
        }
        myViewPager.setAdapter(new PagerAdapter(){
            public int getCount()
            {
                return viewList.size();
            }
            public boolean isViewFromObject(View view,Object object)
            {
                return view==object;
            }

            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
            public void destroyItem(ViewGroup container,int position,Object object)
            {
                container.removeView(viewList.get(position));
            }
        });


    }
}
