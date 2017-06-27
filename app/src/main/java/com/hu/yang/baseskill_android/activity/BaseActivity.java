package com.hu.yang.baseskill_android.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yanghu on 2017/6/27.
 */

abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceId());
        initView();
        initData(savedInstanceState);
    }


    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initView();

    public abstract int getResourceId();
}
