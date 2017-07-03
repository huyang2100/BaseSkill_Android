package com.hu.yang.baseskill_android.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.hu.yang.baseskill_android.R;

/**
 * Created by Yang on 2017/7/3.
 */

public class AnimListFragment extends BaseFragment {
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        iv.setBackgroundResource(R.drawable.animlist);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv.getBackground();
        animationDrawable.start();
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_animlist;
    }
}
