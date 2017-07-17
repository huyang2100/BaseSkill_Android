package com.hu.yang.baseskill_android.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hu.yang.baseskill_android.utils.ImageUtils;
import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.widget.TouchImageView;

/**
 * Created by yanghu on 2017/7/17.
 */

public class SaveImageToGalleryFragment extends BaseFragment {

    private TouchImageView iv;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) iv.getDrawable()).getBitmap();

                ImageUtils.saveBitmapToGallery(getActivity(),bitmap);
                Toast.makeText(getActivity(), "save success", Toast.LENGTH_SHORT).show();
            }
        });

        iv = (TouchImageView) view.findViewById(R.id.iv);
        iv.setImageResource(R.mipmap.ness);
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_save_image_to_gallery;
    }
}
