package com.example.hh.view7.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 曾莹 on 2018/8/4.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,ClockActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.e("HEHE","运行了~么么哒");
        context.startActivity(i);
    }
}
