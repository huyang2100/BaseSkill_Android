package com.hu.yang.baseskill_android.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;

/**
 * Created by yanghu on 2017/6/30.
 */

public class WheelViewFragment extends BaseFragment {
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {
        final WheelView wheelView = (WheelView) view.findViewById(R.id.wheelview);
        wheelView.setWheelAdapter(new ArrayWheelAdapter(getActivity())); // 文本数据源
        wheelView.setSkin(WheelView.Skin.Holo);
        final ArrayList<String> strings = new ArrayList<>();

//        strings.add("2015-2016第一学期");
//        strings.add("2015-2016第二学期");
//        strings.add("2016-2017第一学期");
//        strings.add("2016-2017第二学期");
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextColor = Color.RED;
        style.backgroundColor = Color.WHITE;
        style.selectedTextZoom = 1.2f;
        style.textColor = Color.GRAY;
        style.holoBorderColor = android.R.color.transparent;
        wheelView.setStyle(style);
        wheelView.postDelayed(new Runnable() {
            @Override
            public void run() {
                strings.clear();
                strings.add("2014-2015第一学期");
                strings.add("2014-2015第二学期");
                wheelView.setWheelData(strings);
                wheelView.setSelection(1);
            }
        },1000);

        strings.add("");
        wheelView.setWheelData(strings);
//        wheelView.setSelection(1);

    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_wheelview;
    }
}
