package com.hu.yang.baseskill_android.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.activity.MainActivity;
import com.hu.yang.baseskill_android.service.MusicService;

/**
 * Created by yanghu on 2017/7/23.
 */

public class MusicFragment extends BaseFragment implements View.OnClickListener {
    private MusicService musicService = new MusicService();
    private String[] paths = {"/mnt/sdcard/mymusic.mp3","/mnt/sdcard/zzr.mp3"};
    private int index = 0;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.play).setOnClickListener(this);
        view.findViewById(R.id.pause).setOnClickListener(this);
        view.findViewById(R.id.changemusic).setOnClickListener(this);
        view.findViewById(R.id.exit).setOnClickListener(this);
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_music;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(),MusicService.class);
        switch (v.getId()){
            case R.id.play:
                MusicService.path = paths[0];
                intent.putExtra(MusicService.KEY_ACTION,MusicService.PLAY);
                getActivity().startService(intent);
                break;
            case R.id.pause:
                intent.putExtra(MusicService.KEY_ACTION,MusicService.PAUSE);
                getActivity().startService(intent);
                break;
            case R.id.changemusic:
                index ++;
                MusicService.path = paths[index%2];
                intent.putExtra(MusicService.KEY_ACTION,MusicService.CHANGE);
                getActivity().startService(intent);
                break;
            case R.id.exit:
                getActivity().stopService(intent);
                break;
        }

    }


}
