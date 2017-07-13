package com.hu.yang.baseskill_android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by yanghu on 2017/7/13.
 */

public class PackageReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(Intent.ACTION_PACKAGE_ADDED.equals(action)){
            Toast.makeText(context, "安装了应用："+intent.getDataString(), Toast.LENGTH_SHORT).show();
        }else if(Intent.ACTION_PACKAGE_REMOVED.equals(action)){
            Toast.makeText(context, "卸载了应用："+intent.getDataString(), Toast.LENGTH_SHORT).show();
        }
    }
}
