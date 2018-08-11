package com.example.hh.view7.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.fingerprint.FingerprintManager;
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
import com.example.hh.view7.activity.BrowserActivity;
import com.example.hh.view7.adapter.My3Adapter;
import com.example.hh.view7.bean.Bean3;
import com.example.hh.view7.bean.Icon;

import java.util.ArrayList;
import java.util.List;

/**
.
 */
public class MyFragment3 extends BaseFragment {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    private Activity parentActivity;

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
        swipeRefreshLayout = $(R.id.swid);
        listView = $(R.id.my_list_view);

    }

    @Override
    protected void setUpData() {
//        final List<String> dataList=new ArrayList<>();
//        dataList.add("");
//        dataList.add("据媒体报道，语言识别在联盟炸开了");
//        dataList.add("许多背井离乡的学子认为语音识别提升自己家乡自豪感");
        final ArrayList<Bean3> dataList = new ArrayList<Bean3>();

        dataList.add(new Bean3("笑话1", "http://www.360doc.com/content/16/0620/17/4666759_569313579.shtml"));
        dataList.add(new Bean3("笑话2", "http://www.pig66.com/show-1714-1114835-1.html"));
        dataList.add(new Bean3("笑话3", "http://baijiahao.baidu.com/s?id=1602480786079558486&wfr=spider&for=pc"));
        dataList.add(new Bean3("笑话4", "http://baijiahao.baidu.com/s?id=1596326167531023513&wfr=spider&for=pc"));
        dataList.add(new Bean3("笑话5", "https://baijiahao.baidu.com/s?id=1573494971428634&wfr=spider&for=pc"));
        dataList.add(new Bean3("笑话6", "https://zhidao.baidu.com/question/23189908.html"));
        dataList.add(new Bean3("笑话7", "http://www.360doc.com/content/17/0616/01/773384_663515322.shtml"));
        dataList.add(new Bean3("笑话8", "http://www.360doc.com/content/16/0819/17/773384_584370456.shtml"));
        dataList.add(new Bean3("笑话9", "http://www.360doc.com/content/17/1215/09/8510298_713243227.shtml"));

       // Toast.makeText(parentActivity, "下拉获取更多内容", Toast.LENGTH_LONG).show();

//        final ArrayAdapter<String> adapter0= new ArrayAdapter<String>(parentActivity,android.R.layout.simple_list_item_1,android.R.id.text1,dataList);
        final My3Adapter adapter0 = new My3Adapter(dataList, getMContext());
        listView.setAdapter(adapter0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getMContext(), BrowserActivity.class);
                intent.putExtra("url", dataList.get((int) id).getUrl());
                startActivity(intent);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {


            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(parentActivity, "加载完成", Toast.LENGTH_LONG).show();
                       for(int i=0;i<20;i++)
                        {
                            dataList.add(new Bean3("笑话"+(i+10),"http://www.taobao.com"));
                        }
                        adapter0.notifyDataSetChanged();
                    }
                }, 4000);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        swipeRefreshLayout.setProgressViewOffset(false, 5, 10);
    }

}
