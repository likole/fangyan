package com.example.hh.view7.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.hh.view7.R;
import com.example.hh.view7.activity.BaseActivity;
import com.example.hh.view7.activity.MainActivity;
import com.example.hh.view7.activity.login;
import com.example.hh.view7.activity.result;
import com.example.hh.view7.util.OkHttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Result;

import okhttp3.Response;

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
    File soundFile;
    protected String infor = null;

    AnimationDrawable drawable;
    private static String[] PERMISSION_AUDIO = {
            android.Manifest.permission.RECORD_AUDIO,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    };

    //***********/
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            Intent it=new Intent(parentActivity,result.class);
            it.putExtra("infor_result",infor);
            startActivity(it);
        }
    };

    @Override
    protected int setLayoutResourceID() {
        return R.layout.mf2;
    }

    protected void setUpData() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(parentActivity, android.R.layout.simple_list_item_1, res);
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

        //权限

        int permission = android.support.v4.app.ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.RECORD_AUDIO);
        if (permission != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            android.support.v4.app.ActivityCompat.requestPermissions(getActivity(), PERMISSION_AUDIO, 1);
        }
        tb = $(R.id.toggleButton);
        parentActivity = (BaseActivity) getActivity();
        acTextView = $(R.id.autoCompleteTextView);
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
                isStart = true;
            }
        } else {
            drawable.stop();
            stopRecord();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Response response = OkHttpUtils.doPost("/upload_file.php", soundFile, "audio/amr");
                    String s = null;
                    try {
                        s = response.body().string();
                        System.out.print(s);
                        JsonObject root = (JsonObject) new JsonParser().parse(s);
                        String ok = root.get("ok").getAsString();
                        Message msg = new Message();

                        if (ok.equals("shanghai"))
                        {
                            msg.what = 1;infor="上海话";
                        }
                        else if (ok.equals("nanchang"))
                        {
                            msg.what = 2;infor="南昌话";
                        }
                        else if (ok.equals("minnan"))
                        {
                            msg.what = 3;infor="闽南话";
                        }
                        else if (ok.equals("kejia"))
                        {
                            msg.what = 4;infor="客家话";
                        }
                        else if (ok.equals("hebei"))
                        {
                            msg.what = 5;infor="河北话";
                        }
                        else if (ok.equals("changsha"))
                        {
                            msg.what = 6;infor="长沙话";
                        }
                        else if (ok.equals("sichuan"))
                        {
                            msg.what = 7;infor="四川话";
                        }
                        else if (ok.equals("hefei"))
                        {
                            msg.what = 8;infor="合肥话";
                        }
                        else if (ok.equals("false"))
                        {
                            msg.what = 0;infor="无法识别";
                        }


                        handler.sendMessage(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            isStart = false;
        }
    }

    private void startRecord() {
        if (mr == null) {
            File dir = new File(Environment.getExternalStorageDirectory(), "sounds");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            soundFile = new File(dir, "spjsb" + ".amr");
            if (soundFile.exists()) soundFile.delete();
            try {
                soundFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
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

    private void stopRecord() {
        if (mr != null) {
            mr.stop();
            mr.release();
            mr = null;
        }
    }

}
