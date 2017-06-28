package com.hu.yang.baseskill_android.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;

import java.util.ArrayList;

/**
 * Created by yanghu on 2017/6/28.
 */

public class AnimDownFragment extends BaseFragment {

    private static final long ANIM_DURATION = 500;
    private ListView mLv;
    private ArrayList<String> contentList = new ArrayList<>();
    private View mRootView;

    @Override
    protected void initData(Bundle savedInstanceState) {
        mLv.setAdapter(new MyAdapter());
    }

    @Override
    protected void initView(View view) {
        for (int i = 0; i < 5; i++) {
            contentList.add("student " + i);
        }
        view.findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLv.getVisibility() == View.GONE) {
                    showList();
                } else {
                    hideList();
                }
            }
        });

        mLv = (ListView) view.findViewById(R.id.lv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hideList();
            }
        });
        mLv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideList();
                return false;
            }
        });
        mRootView = view.findViewById(R.id.root_view);
    }

    private void showList() {
        if (mLv.getVisibility() == View.GONE) {
            mLv.setVisibility(View.VISIBLE);
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mLv, "translationY", -mRootView.getHeight(), 0);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimator.setDuration(ANIM_DURATION).start();
        }
    }

    private void hideList() {
        if (mLv.getTranslationY() == 0f) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mLv, "translationY", 0, -mRootView.getHeight()).setDuration(ANIM_DURATION);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimator.start();
            objectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mLv.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_anim_down;
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return contentList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.item_anim_down, null);
            }

            TextView tv = (TextView) convertView.findViewById(R.id.tv);
            tv.setText(contentList.get(position));
            return convertView;
        }
    }
}
