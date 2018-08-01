package com.example.hh.view7.activity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hh.view7.R;

/**
 * Created by 曾莹 on 2018/7/27.
 */

public class Music extends AppCompatActivity implements View.OnClickListener{
    private Button btn_play;
    private Button btn_stop;

    private Button btn_play1;
    private Button btn_stop1;

    private Button btn_play2;
    private Button btn_stop2;

    private MediaPlayer mPlayer = null;
    private MediaPlayer mPlayer1 = null;
    private MediaPlayer mPlayer2 = null;

    private boolean isRelease = true;   //判断是否MediaPlayer是否释放的标志
    private boolean isRelease1 = true;
    private boolean isRelease2 = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        bindViews();
    }

    private void bindViews() {
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_stop = (Button) findViewById(R.id.btn_stop);

        btn_play1 = (Button) findViewById(R.id.btn_play1);
        btn_stop1 = (Button) findViewById(R.id.btn_stop1);

        btn_play2 = (Button) findViewById(R.id.btn_play2);
        btn_stop2 = (Button) findViewById(R.id.btn_stop2);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

        btn_play1.setOnClickListener(this);
        btn_stop1.setOnClickListener(this);

        btn_play2.setOnClickListener(this);
        btn_stop2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                if (isRelease) {
                    mPlayer = MediaPlayer.create(this,R.raw.yueban);
                    isRelease = false;
                }
                mPlayer.start();
                btn_play.setEnabled(false);
                btn_stop.setEnabled(true);
                break;

            case R.id.btn_play1:
                if (isRelease) {
                    mPlayer1 = MediaPlayer.create(this, R.raw.xixi);
                    isRelease1 = false;
                }
                mPlayer1.start();
                btn_play1.setEnabled(false);
                btn_stop1.setEnabled(true);
                break;
            case R.id.btn_play2:
                if (isRelease) {
                    mPlayer2 = MediaPlayer.create(this, R.raw.xixi);
                    isRelease2 = false;
                }
                mPlayer2.start();
                btn_play2.setEnabled(false);
                btn_stop2.setEnabled(true);
                break;
            case R.id.btn_stop:
                mPlayer.reset();
                mPlayer.release();
                isRelease = true;
                btn_play.setEnabled(true);
                btn_stop.setEnabled(false);
                break;
            case R.id.btn_stop1:
                mPlayer1.reset();
                mPlayer1.release();
                isRelease1 = true;
                btn_play1.setEnabled(true);
                btn_stop1.setEnabled(false);
                break;

            case R.id.btn_stop2:
                mPlayer2.reset();
                mPlayer2.release();
                isRelease2 = true;
                btn_play2.setEnabled(true);
                btn_stop2.setEnabled(false);
                break;
        }
    }
}

