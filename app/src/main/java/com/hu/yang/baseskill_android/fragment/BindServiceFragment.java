package com.hu.yang.baseskill_android.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.service.MoneyService;

/**
 * Created by yanghu on 2017/7/23.
 */

public class BindServiceFragment extends BaseFragment implements View.OnClickListener {

    private EditText editText;
    private Intent intent;

    @Override
    protected void initData(Bundle savedInstanceState) {
        intent = new Intent(getActivity(), MoneyService.class);

    }

    @Override
    protected void initView(View view) {
        editText = (EditText) view.findViewById(R.id.et);
        view.findViewById(R.id.bind).setOnClickListener(this);
        view.findViewById(R.id.call).setOnClickListener(this);
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_bindservice;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bind:

                getActivity().bindService(intent,new MyConn(), Context.BIND_AUTO_CREATE);
                break;
            case R.id.call:

                break;
        }
    }

    class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
