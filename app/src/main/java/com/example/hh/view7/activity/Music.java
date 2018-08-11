package com.example.hh.view7.activity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

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

    private Button btn_play3;
    private Button btn_stop3;

    private Button btn_play4;
    private Button btn_stop4;

    private Button btn_play5;
    private Button btn_stop5;

    private Button btn_play6;
    private Button btn_stop6;

    private Button btn_play7;
    private Button btn_stop7;

    private Button btn_play8;
    private Button btn_stop8;


    private MediaPlayer mPlayer = null;
    private MediaPlayer mPlayer1 = null;
    private MediaPlayer mPlayer2 = null;
    private MediaPlayer mPlayer3 = null;
    private MediaPlayer mPlayer4 = null;
    private MediaPlayer mPlayer5 = null;
    private MediaPlayer mPlayer6 = null;
    private MediaPlayer mPlayer7 = null;
    private MediaPlayer mPlayer8 = null;


    private boolean isRelease = true;   //判断是否MediaPlayer是否释放的标志
    private boolean isRelease1 = true;
    private boolean isRelease2 = true;
    private boolean isRelease3 = true;
    private boolean isRelease4 = true;
    private boolean isRelease5 = true;
    private boolean isRelease6 = true;
    private boolean isRelease7 = true;
    private boolean isRelease8 = true;

    private ScrollView scrollView = null;

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

        btn_play3 = (Button) findViewById(R.id.btn_play3);
        btn_stop3 = (Button) findViewById(R.id.btn_stop3);

        btn_play4 = (Button) findViewById(R.id.btn_play4);
        btn_stop4 = (Button) findViewById(R.id.btn_stop4);

        btn_play5 = (Button) findViewById(R.id.btn_play5);
        btn_stop5 = (Button) findViewById(R.id.btn_stop5);

        btn_play6 = (Button) findViewById(R.id.btn_play6);
        btn_stop6 = (Button) findViewById(R.id.btn_stop6);

        btn_play7 = (Button) findViewById(R.id.btn_play7);
        btn_stop7 = (Button) findViewById(R.id.btn_stop7);

        btn_play8 = (Button) findViewById(R.id.btn_play8);
        btn_stop8 = (Button) findViewById(R.id.btn_stop8);

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

        btn_play1.setOnClickListener(this);
        btn_stop1.setOnClickListener(this);

        btn_play2.setOnClickListener(this);
        btn_stop2.setOnClickListener(this);

        btn_play3.setOnClickListener(this);
        btn_stop3.setOnClickListener(this);


        btn_play4.setOnClickListener(this);
        btn_stop4.setOnClickListener(this);

        btn_play5.setOnClickListener(this);
        btn_stop5.setOnClickListener(this);

        btn_play6.setOnClickListener(this);
        btn_stop6.setOnClickListener(this);

        btn_play7.setOnClickListener(this);
        btn_stop7.setOnClickListener(this);

        btn_play8.setOnClickListener(this);
        btn_stop8.setOnClickListener(this);

        scrollView = (ScrollView) findViewById(R.id.id_scrollView);
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
                    mPlayer2 = MediaPlayer.create(this, R.raw.wdhbx);
                    isRelease2 = false;
                }
                mPlayer2.start();
                btn_play2.setEnabled(false);
                btn_stop2.setEnabled(true);
                break;
            case R.id.btn_play3:
                if (isRelease) {
                    mPlayer3 = MediaPlayer.create(this, R.raw.awmz);
                    isRelease3 = false;
                }
                mPlayer3.start();
                btn_play3.setEnabled(false);
                btn_stop3.setEnabled(true);
                break;
            case R.id.btn_play4:
                if (isRelease) {
                    mPlayer4 = MediaPlayer.create(this, R.raw.sht);
                    isRelease4 = false;
                }
                mPlayer4.start();
                btn_play4.setEnabled(false);
                btn_stop4.setEnabled(true);
                break;
            case R.id.btn_play5:
                if (isRelease) {
                    mPlayer5 = MediaPlayer.create(this, R.raw.ob);
                    isRelease5 = false;
                }
                mPlayer5.start();
                btn_play5.setEnabled(false);
                btn_stop5.setEnabled(true);
                break;
            case R.id.btn_play6:
                if (isRelease) {
                    mPlayer6 = MediaPlayer.create(this, R.raw.hnj);
                    isRelease6 = false;
                }
                mPlayer6.start();
                btn_play6.setEnabled(false);
                btn_stop6.setEnabled(true);
                break;
            case R.id.btn_play7:
                if (isRelease) {
                    mPlayer7 = MediaPlayer.create(this, R.raw.yfx);
                    isRelease7 = false;
                }
                mPlayer7.start();
                btn_play7.setEnabled(false);
                btn_stop7.setEnabled(true);
                break;

            case R.id.btn_play8:
                if (isRelease) {
                    mPlayer8 = MediaPlayer.create(this, R.raw.xmj);
                    isRelease8 = false;
                }
                mPlayer8.start();
                btn_play8.setEnabled(false);
                btn_stop8.setEnabled(true);
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
            case R.id.btn_stop3:
                mPlayer3.reset();
                mPlayer3.release();
                isRelease3 = true;
                btn_play3.setEnabled(true);
                btn_stop3.setEnabled(false);
                break;
            case R.id.btn_stop4:
                mPlayer4.reset();
                mPlayer4.release();
                isRelease4 = true;
                btn_play4.setEnabled(true);
                btn_stop4.setEnabled(false);
                break;
            case R.id.btn_stop5:
                mPlayer5.reset();
                mPlayer5.release();
                isRelease5 = true;
                btn_play5.setEnabled(true);
                btn_stop5.setEnabled(false);
                break;
            case R.id.btn_stop6:
                mPlayer6.reset();
                mPlayer6.release();
                isRelease6 = true;
                btn_play6.setEnabled(true);
                btn_stop6.setEnabled(false);
                break;
            case R.id.btn_stop7:
                mPlayer7.reset();
                mPlayer7.release();
                isRelease7 = true;
                btn_play7.setEnabled(true);
                btn_stop7.setEnabled(false);
                break;
            case R.id.btn_stop8:
                mPlayer8.reset();
                mPlayer8.release();
                isRelease8 = true;
                btn_play8.setEnabled(true);
                btn_stop8.setEnabled(false);
                break;

        }
    }
}

