package com.example.hh.view7.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.MessageQueue;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.hh.view7.R;
import com.example.hh.view7.activity.BaseActivity;

import java.io.File;
import java.io.IOException;

import static android.os.Looper.getMainLooper;

/**

 */
public class MyFragment2 extends BaseFragment implements CompoundButton.OnCheckedChangeListener {

    private AutoCompleteTextView acTextView;
    private String[] res = {"音乐", "午夜凶铃", "语音识别", "普通话", "潮汕话", "闽南语"};
    private ToggleButton tb;
    private boolean isStart = false;
    private MediaRecorder mr = null;

    private TextView textView;
    private BaseActivity parentActivity;

    AnimationDrawable drawable;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.mf2;
    }
    protected void setUpData() {

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(parentActivity,android.R.layout.simple_list_item_1,res);
        acTextView.setAdapter(adapter);
        textView.setBackgroundResource(R.drawable.maikefeng);//绑定Frame动画
        drawable = (AnimationDrawable) textView.getBackground();
        getMainLooper().myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                //启动动画
                return false;
            }
        });

        tb.setOnCheckedChangeListener(this);
    }

    protected void setUpView() {
        tb = $(R.id.toggleButton);
        parentActivity = (BaseActivity) getActivity();
        acTextView =$(R.id.autoCompleteTextView);
         textView = $(R.id.maike2);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //当tb被点击的时候，当前方法会执行
        //buttonView---代表被点击控件的本身
        //当点击这个tb的时候，更换imag的背景
        if (isChecked) {
            drawable.start();
            if (!isStart) {
                startRecord();
                isStart =true;
            }
        } else {
            drawable.stop();
            stopRecord();
            isStart =false;
        }
    }

    private void startRecord() {
        if (mr == null) {
            File dir = new File(Environment.getExternalStorageDirectory(), "sounds");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File soundFile = new File(dir, System.currentTimeMillis() + ".amr");
            if (!soundFile.exists()) {
                try {
                    soundFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            mr = new MediaRecorder();
            mr.setAudioSource(MediaRecorder.AudioSource.MIC);  //音频输入源
            mr.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);   //设置输出格式
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);   //设置编码格式
            mr.setOutputFile(soundFile.getAbsolutePath());
            try {
                mr.prepare();
                mr.start();  //开始录制
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private void stopRecord(){
        if(mr != null){
            mr.stop();
            mr.release();
            mr = null;
        }
     }
}
