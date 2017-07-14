package com.hu.yang.baseskill_android.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.widget.TouchImageView;

/**
 * Created by yanghu on 2017/7/14.
 */

public class ZoomImageFragment extends BaseFragment {

    private String largeurl = "http://global.bing.com/az/hprichbg/rb/LagazuoiRefuge_EN-US12120955316_1920x1080.jpg";
    private String smallurl = "http://pic129.nipic.com/file/20170512/12176395_201437942000_2.jpg";

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.btn_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ImageFragment imageFragment = new ImageFragment();
                Bundle args = new Bundle();
                args.putString(ImageFragment.KEY_URL,largeurl);
                imageFragment.setArguments(args);
                imageFragment.show(ft,"image");
            }
        });
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_zoomimage;
    }

}
