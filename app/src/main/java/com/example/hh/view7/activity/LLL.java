package com.example.hh.view7.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hh.view7.R;

import java.util.Calendar;

/**
 * Created by 曾莹 on 2018/8/1.
 */

public class LLL extends AppCompatActivity implements View.OnClickListener{

    private Button btn_set;
    private Button btn_cancel;
    private AlarmManager alarmManager;
    private PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiemian1);
       TimePicker tp_test = (TimePicker) findViewById(R.id.time);
        tp_test.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(LLL.this,"您选择的时间是："+hourOfDay+"时"+minute+"分!",Toast.LENGTH_SHORT).show();
            }
        });
        bindViews();
    }

    private void bindViews() {
        btn_set=(Button)findViewById(R.id.btn_set);
        btn_cancel=(Button)findViewById(R.id.btn_cancel);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        Intent intent=new Intent(LLL.this,ClockActivity.class);
        pi=PendingIntent.getActivity(LLL.this,0,intent,0);

        btn_set.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_set:
                Calendar currentTime = Calendar.getInstance();
                new TimePickerDialog(LLL.this,0,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view,int hourOfDay,int minute)
                    {
                        //当前时间
                        Calendar c=Calendar.getInstance();
                        c.setTimeInMillis(System.currentTimeMillis());
                        //根据用户选择来设置Calendar对象
                        c.set(Calendar.HOUR,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        //设置AlarmManaager在Calendar对应的时间启动Activity
                        alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
                        Log.e("HEHE",c.getTimeInMillis()+"");
                        //完毕
                        Toast.makeText(LLL.this, "亲~闹钟设置完毕~"+ c.getTimeInMillis(),
                                Toast.LENGTH_SHORT).show();
                    }
                }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                        .get(Calendar.MINUTE),false).show();
                btn_cancel.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_cancel:
                alarmManager.cancel(pi);
                btn_cancel.setVisibility(View.GONE);
                Toast.makeText(LLL.this,"闹钟已取消",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}













































/*  implements View.OnClickListener
private Chronometer chronometer;
    private Button btn_start,btn_stop,btn_base,btn_format;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiemian1);
        initView();

    }

    private void initView() {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        btn_start = (Button) findViewById(R.id.jishi1);
        btn_stop = (Button) findViewById(R.id.jishi2);
        btn_base = (Button) findViewById(R.id.btnReset);
        btn_format = (Button) findViewById(R.id.btn_format);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_base.setOnClickListener(this);
        btn_format.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jishi1:
                chronometer.start();// 开始计时
                break;
            case R.id.jishi2:
                chronometer.stop();// 停止计时
                break;
            case R.id.btnReset:
                chronometer.setBase(SystemClock.elapsedRealtime());// 复位
                break;
            case R.id.btn_format:
                chronometer.setFormat("Time：%s");// 更改时间显示格式
                break;
        }
    }

}*/


