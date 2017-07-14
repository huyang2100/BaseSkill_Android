package com.hu.yang.baseskill_android.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.widget.TouchImageView;

/**
 * Created by yanghu on 2017/7/14.
 */

public class ImageFragment extends DialogFragment {
    public static final String KEY_URL = "key_url";
    private TouchImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container);
        iv = (TouchImageView) v.findViewById(R.id.iv);
        Bundle args = getArguments();

        if(args == null){
            return null;
        }

        String url  = args.getString(KEY_URL);
        Glide.with(getActivity()).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                iv.setImageBitmap(resource);
            }

        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
    }
}
