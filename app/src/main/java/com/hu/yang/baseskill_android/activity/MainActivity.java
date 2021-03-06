package com.hu.yang.baseskill_android.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.fragment.AnimDownFragment;
import com.hu.yang.baseskill_android.fragment.AnimListFragment;
import com.hu.yang.baseskill_android.fragment.BindServiceFragment;
import com.hu.yang.baseskill_android.fragment.DBFragment;
import com.hu.yang.baseskill_android.fragment.DownloadFragment;
import com.hu.yang.baseskill_android.fragment.LoginFragment;
import com.hu.yang.baseskill_android.fragment.MusicFragment;
import com.hu.yang.baseskill_android.fragment.PhonePadFragment;
import com.hu.yang.baseskill_android.fragment.RecycleViewFragment;
import com.hu.yang.baseskill_android.fragment.SaveImageToGalleryFragment;
import com.hu.yang.baseskill_android.fragment.SendMsgFragment;
import com.hu.yang.baseskill_android.fragment.SmsFragment;
import com.hu.yang.baseskill_android.fragment.WheelViewFragment;
import com.hu.yang.baseskill_android.fragment.XmlFragment;
import com.hu.yang.baseskill_android.fragment.ItemFragment;
import com.hu.yang.baseskill_android.fragment.ZoomImageFragment;

public class MainActivity extends BaseActivity implements ItemFragment.OnItemClickListener {

    private MusicFragment musicFragment;

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            replaceFragment(new ItemFragment());
        }
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content, fragment).commit();
    }

    private void replaceFragmentAddToBackStack(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content, fragment).addToBackStack(null).commit();
    }

    @Override
    protected void initView() {

    }

    @Override
    public int getResourceId() {
        return R.layout.activity_fragment;
    }


    @Override
    public void onItemClick(String item) {
        if ("login".equals(item)) {
            replaceFragmentAddToBackStack(new LoginFragment());
        } else if ("xml".equals(item)) {
            replaceFragmentAddToBackStack(new XmlFragment());
        } else if ("anim down".equals(item)) {
            replaceFragmentAddToBackStack(new AnimDownFragment());
        } else if ("db".equals(item)) {
            replaceFragmentAddToBackStack(new DBFragment());
        }else if ("animlist".equals(item)) {
            replaceFragmentAddToBackStack(new AnimListFragment());
        }else if ("wheelview".equals(item)) {
            replaceFragmentAddToBackStack(new WheelViewFragment());
        }else if ("download".equals(item)) {
            replaceFragmentAddToBackStack(new DownloadFragment());
        }else if ("zoomimage".equals(item)) {
            replaceFragmentAddToBackStack(new ZoomImageFragment());
        }else if ("saveimaegtogallery".equals(item)) {
            replaceFragmentAddToBackStack(new SaveImageToGalleryFragment());
        }else if ("sendmsg".equals(item)) {
            replaceFragmentAddToBackStack(new SendMsgFragment());
        }else if ("phone_pad".equals(item)) {
            replaceFragmentAddToBackStack(new PhonePadFragment());
        }else if ("music".equals(item)) {
            replaceFragmentAddToBackStack(new MusicFragment());
        }else if ("bindservice".equals(item)) {
            replaceFragmentAddToBackStack(new BindServiceFragment());
        }else if ("recycleview".equals(item)) {
            replaceFragmentAddToBackStack(new RecycleViewFragment());
        }else if ("sms".equals(item)) {
            replaceFragmentAddToBackStack(new SmsFragment());
        }
    }
}
