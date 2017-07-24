package com.hu.yang.baseskill_android.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.hu.yang.baseskill_android.activity.MainActivity;

/**
 * Created by yanghu on 2017/7/24.
 */

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "BootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "BootReceiver: 开机启动了。。。。。。。。");
        Toast.makeText(context, "开机启动，哦吼!!!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
