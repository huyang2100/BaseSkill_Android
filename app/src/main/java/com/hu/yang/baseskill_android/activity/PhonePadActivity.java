package com.hu.yang.baseskill_android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.fragment.ArticalFragment;
import com.hu.yang.baseskill_android.fragment.TitleFragment;

/**
 * Created by yanghu on 2017/7/20.
 */

public class PhonePadActivity extends AppCompatActivity implements TitleFragment.OnTitleSelectedListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonepad);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_frag,new TitleFragment()).commit();
        }
    }

    public static void actionStart(Context ctx) {
        Intent intent = new Intent(ctx, PhonePadActivity.class);
        ctx.startActivity(intent);
    }

    @Override
    public void onTitleSelected(int position) {
        ArticalFragment articalFragment = (ArticalFragment) getSupportFragmentManager().findFragmentById(R.id.frag_content);
        if(articalFragment != null){
            articalFragment.fresh(position);
        }else{
            articalFragment = new ArticalFragment();
            Bundle args = new Bundle();
            args.putInt(ArticalFragment.KEY_POSITION,position);
            articalFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_frag,articalFragment).addToBackStack(null).commit();
        }
    }
}
