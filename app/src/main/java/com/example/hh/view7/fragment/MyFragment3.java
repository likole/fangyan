package com.example.hh.view7.fragment;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hh.view7.R;
import com.example.hh.view7.activity.BaseActivity;
import com.example.hh.view7.adapter.MyAdapter;
import com.example.hh.view7.bean.Icon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment3 extends BaseFragment {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    private BaseActivity parentActivity;

     private GridView grid_photo2;
    private BaseAdapter mAdapter2 = null;
     private ArrayList<Icon> mData2 = null;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.mf3;
    }

    @Override
    protected void setUpView() {

        parentActivity = (BaseActivity) getActivity();
        swipeRefreshLayout=$(R.id.swid);
        listView=$(R.id.my_list_view);

        grid_photo2 = $(R.id.grid_photo2);
    }

    @Override
    protected void setUpData() {
        final List<String> dataList=new ArrayList<>();
        dataList.add("");
        dataList.add("据媒体报道，语言识别在联盟炸开了");
        dataList.add("许多背井离乡的学子认为语音识别提升自己家乡自豪感");
        Toast.makeText(parentActivity,"下拉获取更多内容",Toast.LENGTH_LONG).show();

        final ArrayAdapter<String> adapter0= new ArrayAdapter<String>(parentActivity,android.R.layout.simple_list_item_1,android.R.id.text1,dataList);
        listView.setAdapter(adapter0);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){


            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(parentActivity,"加载完成",Toast.LENGTH_LONG).show();
                        for(int i=0;i<10;i++)
                        {
                            dataList.add("识别小BUG，请前往212拯救~");
                        }
                        adapter0.notifyDataSetChanged();
                    }
                },4000);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN);
        swipeRefreshLayout.setProgressViewOffset(false,5,10);
    }

/*
    mData2 = new ArrayList<Icon>();
        mData2.add(new Icon(R.mipmap.fz2, "图标1"));
        mData2.add(new Icon(R.mipmap.fz2, "图标2"));
        mData2.add(new Icon(R.mipmap.fz2, "图标3"));


        mAdapter = new MyAdapter<Icon>(mData, getMContext()) {
            @Override
            public void bindView(MyAdapter.ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };
        mAdapter2 = new MyAdapter<Icon>(mData2, getMContext()) {
            @Override
            public void bindView(MyAdapter.ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };


        grid_photo2.setAdapter(mAdapter2);


       grid_photo2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getMContext(), "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });

    }*/
}
