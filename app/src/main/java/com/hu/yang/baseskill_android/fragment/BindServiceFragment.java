package com.hu.yang.baseskill_android.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.service.MoneyService;

/**
 * Created by yanghu on 2017/7/23.
 */

public class BindServiceFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "BindServiceFragment";
    private EditText editText;
    private MoneyService.MyBinder myBinder;

    @Override
    protected void initData(Bundle savedInstanceState) {


    }

    @Override
    protected void initView(View view) {
        editText = (EditText) view.findViewById(R.id.et);
        view.findViewById(R.id.bind).setOnClickListener(this);
        view.findViewById(R.id.call).setOnClickListener(this);
        view.findViewById(R.id.stop).setOnClickListener(this);
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_bindservice;
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(editText.getText().toString())){
            Toast.makeText(getActivity(), "输入金额！", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (v.getId()) {
            case R.id.bind:
                getActivity().bindService(new Intent(getActivity(), MoneyService.class),new MyConn(), Context.BIND_AUTO_CREATE);
                break;
            case R.id.call:
                if(myBinder != null){
                    myBinder.call(Integer.valueOf(editText.getText().toString()));
                }
                break;
            case R.id.stop:
                getActivity().stopService(new Intent(getActivity(), MoneyService.class));
                myBinder = null;
                break;
        }
    }

    class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: ");
            myBinder = (MoneyService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ");
        }
    }
}
