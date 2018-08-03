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
import android.widget.ViewFlipper;

import com.example.hh.view7.R;
import com.example.hh.view7.activity.BaseActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MyFragment1 extends BaseFragment {

    private ViewFlipper vflp_help;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main1;
    }
    @Override
    protected void setUpData() {
        vflp_help.startFlipping();
    }

    @Override
    protected void setUpView() {
        vflp_help = $(R.id.vflp_help);
    }
}
