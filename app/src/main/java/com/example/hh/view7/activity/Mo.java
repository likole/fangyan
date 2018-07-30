package com.example.hh.view7.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hh.view7.R;


/**
 * Created by 曾莹 on 2018/7/27.
 */

public class Mo extends AppCompatActivity {

    private CheckBox checkBox1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mo);

        checkBox1=(CheckBox)findViewById(R.id.checkBox);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                   //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "这是一款超级棒的产品，不是仅仅识别AI语言，主要是用于识别随意的一种语言是属于什么语言，能识别午夜凶铃哦，快来试试~", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
