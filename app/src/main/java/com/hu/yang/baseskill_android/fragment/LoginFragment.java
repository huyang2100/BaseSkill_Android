package com.hu.yang.baseskill_android.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;

/**
 * Created by yanghu on 2017/6/24.
 */

public class LoginFragment extends Fragment {

    private static final String SP_CONFIG = "sp_config";
    private static final String SP_KEY_USERNAME = "sp_key_username";
    private static final String SP_KEY_PWD = "sp_key_pwd";
    private static final String SP_KEY_IS_SAVE_PWD = "sp_key_is_save_pwd";
    private EditText mEt_username;
    private EditText mEt_pwd;
    private CheckBox mCb_save_psd;
    private SharedPreferences mSp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEt_username = (EditText) view.findViewById(R.id.et_username);
        mEt_pwd = (EditText) view.findViewById(R.id.et_pwd);
        mCb_save_psd = (CheckBox) view.findViewById(R.id.cb_save_pwd);
        mSp = getActivity().getSharedPreferences(SP_CONFIG, Context.MODE_PRIVATE);
        mEt_username.setText(mSp.getString(SP_KEY_USERNAME, ""));
        mEt_pwd.setText(mSp.getString(SP_KEY_PWD, ""));
        mCb_save_psd.setChecked(mSp.getBoolean(SP_KEY_IS_SAVE_PWD,false));
        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEt_username.getText().toString();
                String pwd = mEt_pwd.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(getActivity(), "用户名或密码为空！", Toast.LENGTH_SHORT).show();
                    return;
                }

                mSp.edit().putString(SP_KEY_USERNAME, username).commit();
                mSp.edit().putString(SP_KEY_PWD, pwd).commit();
                mSp.edit().putBoolean(SP_KEY_IS_SAVE_PWD,mCb_save_psd.isChecked()).commit();
                Toast.makeText(getActivity(), "loin succse!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
