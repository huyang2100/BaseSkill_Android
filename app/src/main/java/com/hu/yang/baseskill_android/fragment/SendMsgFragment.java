package com.hu.yang.baseskill_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;

/**
 * Created by yanghu on 2017/7/18.
 */

public class SendMsgFragment extends BaseFragment {
    private String number = "18701582100";

    @Override
    protected void initData(Bundle savedInstanceState) {
        
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage(number,null,"Hello I am yang from MAC!!!!",null,null);
                Toast.makeText(getActivity(), "send success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_send_msg;
    }
}
