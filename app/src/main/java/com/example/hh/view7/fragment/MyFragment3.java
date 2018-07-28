package com.example.hh.view7.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.hh.view7.R;
import com.example.hh.view7.adapter.MyAdapter;
import com.example.hh.view7.bean.Icon;

import java.util.ArrayList;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment3 extends BaseFragment {

    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    // private GridView grid_photo2;
    // private ArrayList<Icon> mData2 = null;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.mf3;
    }

    @Override
    protected void setUpView() {
        grid_photo = $(R.id.grid_photo);
        // grid_photo2 = (GridView) findViewById(R.id.grid_photo2);
    }

    @Override
    protected void setUpData() {
        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.fz1, "图标1"));
        mData.add(new Icon(R.mipmap.fz1, "图标2"));
        mData.add(new Icon(R.mipmap.fz1, "图标3"));
        mData.add(new Icon(R.mipmap.fz1, "图标4"));
        mData.add(new Icon(R.mipmap.fz1, "图标5"));
        mData.add(new Icon(R.mipmap.fz1, "图标4"));
        mData.add(new Icon(R.mipmap.fz1, "图标5"));
        mData.add(new Icon(R.mipmap.fz1, "图标4"));
        mData.add(new Icon(R.mipmap.fz1, "图标5"));

     /*   mData2 = new ArrayList<Icon>();
        mData2.add(new Icon(R.mipmap.fz1, "图标1"));
        mData2.add(new Icon(R.mipmap.fz1, "图标2"));
        mData2.add(new Icon(R.mipmap.fz1, "图标3"));*/


        mAdapter = new MyAdapter<Icon>(mData, getMContext()) {
            @Override
            public void bindView(MyAdapter.ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);
        // grid_photo2.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getMContext(), "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
       /* grid_photo2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
