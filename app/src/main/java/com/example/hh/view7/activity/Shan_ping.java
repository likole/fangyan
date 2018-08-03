package com.example.hh.view7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hh.view7.R;

import java.util.Timer;
import java.util.TimerTask;

public class Shan_ping extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity0);

        final Intent it=new Intent(this,MainActivity.class);
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            @Override
            public void run() {
                startActivity(it);
                finish();
            }
        };
        timer.schedule(task,1000*2);

    }

}
