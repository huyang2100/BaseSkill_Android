package com.hu.yang.baseskill_android.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.hu.yang.baseskill_android.constant.Datas;

/**
 * Created by yanghu on 2017/7/20.
 */

public class ArticalFragment extends Fragment {

    public static final String KEY_POSITION = "key_position";
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ScrollView sv = new ScrollView(getActivity());
        tv = new TextView(getActivity());
        Bundle args = getArguments();
        if(args!=null){
            tv.setText(Datas.Articles[args.getInt(KEY_POSITION,0)]);
        }
        tv.setPadding(30,30,30,30);
        tv.setTextSize(24);
        tv.setTextColor(Color.BLACK);
        sv.addView(tv);
        return sv;
    }

    public void fresh(int position) {
        tv.setText(Datas.Articles[position]);
    }
}
