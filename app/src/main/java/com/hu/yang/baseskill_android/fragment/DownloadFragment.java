package com.hu.yang.baseskill_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;

/**
 * Created by Yang on 2017/7/9.
 */

public class DownloadFragment extends BaseFragment {

    private EditText et;
    private ProgressBar pb;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {
        et = (EditText) view.findViewById(R.id.et);
        pb = (ProgressBar) view.findViewById(R.id.pb);
        view.findViewById(R.id.btn_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils httpUtils = new HttpUtils();
                HttpHandler<File> httpHandler = httpUtils.download(et.getText().toString(), "/mnt/sdcard/hello.png", true, new RequestCallBack<File>() {
                    @Override
                    public void onSuccess(ResponseInfo<File> responseInfo) {
                        Toast.makeText(getActivity(), "down success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        super.onLoading(total, current, isUploading);
                        pb.setProgress((int) current);
                        pb.setMax((int) total);
                    }
                });

            }


        });
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_download;
    }
}