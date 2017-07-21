package com.hu.yang.baseskill_android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hu.yang.baseskill_android.activity.PhonePadActivity;

/**
 * Created by yanghu on 2017/7/20.
 */

public class PhonePadFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button button = new Button(getActivity());
        button.setText("start phonepad activity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhonePadActivity.actionStart(getActivity());
            }
        });
        return button;
    }

}
