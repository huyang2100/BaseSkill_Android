package com.hu.yang.baseskill_android.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hu.yang.baseskill_android.R;

import java.util.ArrayList;

/**
 * Created by yanghu on 2017/6/28.
 */

public class AnimDownFragment extends BaseFragment {

    private static final long ANIM_DURATION = 500;
    private ListView mLv;
    private ArrayList<String> contentList = new ArrayList<>();
    private View rootView;
    private View mFl_lv;
    private View mFl_bg;

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
                if (mFl_lv.getVisibility() == View.GONE) {
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
        rootView = view.findViewById(R.id.root_view);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideList();
            }
        });
        mFl_lv = view.findViewById(R.id.fl_lv);
        mFl_bg = view.findViewById(R.id.fl_bg);
    }

    private void showList() {
        if (mFl_lv.getVisibility() == View.GONE) {
            mFl_lv.setVisibility(View.VISIBLE);
            mFl_bg.setVisibility(View.VISIBLE);
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mFl_lv, "translationY", -rootView.getHeight(), 0);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimator.setDuration(ANIM_DURATION).start();
            objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mFl_bg.setAlpha(animation.getAnimatedFraction());
                }
            });
        }
    }

    private void hideList() {
        if (mFl_lv.getTranslationY() == 0f) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mFl_lv, "translationY", 0, -rootView.getHeight()).setDuration(ANIM_DURATION);
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimator.start();
            objectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mFl_lv.setVisibility(View.GONE);
                    mFl_bg.setVisibility(View.GONE);
                }
            });
            objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mFl_bg.setAlpha(1-animation.getAnimatedFraction());
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
