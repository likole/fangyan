package com.example.hh.view7.activity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.hh.view7.R;

/**
 * Created by 曾莹 on 2018/8/4.
 */

public class ClockActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mediaPlayer=mediaPlayer.create(this, R.raw.yueban);
        mediaPlayer.start();
        //对话框
        new AlertDialog.Builder(ClockActivity.this).setTitle("闹钟").setMessage("小猪小猪快起床~~").setPositiveButton("关闭闹钟",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                mediaPlayer.stop();
                ClockActivity.this.finish();
            }
        }).show();
    }
}
