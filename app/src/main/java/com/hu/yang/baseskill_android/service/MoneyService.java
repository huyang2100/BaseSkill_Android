package com.hu.yang.baseskill_android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by yanghu on 2017/7/23.
 */

public class MoneyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder{
        public void call(int money){
            if(money < 200){
                Toast.makeText(MoneyService.this, "打发要饭的呀！", Toast.LENGTH_SHORT).show();
            }else{
                methodInService();
            }
        }
    }

    private void methodInService(){
        Toast.makeText(this, "为人民服务！", Toast.LENGTH_SHORT).show();
    }
}
