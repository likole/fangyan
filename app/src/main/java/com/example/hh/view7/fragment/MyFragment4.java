package com.example.hh.view7.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
;

import com.example.hh.view7.R;
import com.example.hh.view7.activity.AgentApplication;
import com.example.hh.view7.activity.BaseActivity;
import com.example.hh.view7.activity.Mo;
import com.example.hh.view7.activity.manage_zhu;
import com.example.hh.view7.activity.pingjia;


public class MyFragment4 extends BaseFragment {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private BaseActivity parentActivity;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.mf4;
    }

    @Override
    protected void setUpView() {
        parentActivity = (BaseActivity) getActivity();
        button=$(R.id.button);
        button1=$(R.id.button1);
        button2=$(R.id.button2);
        button3=$(R.id.button3);
    }

    @Override
    protected void setUpData() {
   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(parentActivity, manage_zhu.class);
           startActivity(intent);
       }
   });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(parentActivity, Mo.class);
                startActivity(intent2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(parentActivity, pingjia.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(parentActivity, AgentApplication.class);
                startActivity(intent2);
            }
        });
    }

}
