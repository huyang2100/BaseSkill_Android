package com.hu.yang.baseskill_android.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;

/**
 * Created by yanghu on 2017/6/27.
 */

public class ItemFragment extends BaseFragment {

    private String[] items = {"login", "xml","db","anim down","animlist","wheelview","download"};
    private ListView mListView;
    private OnItemClickListener onItemClickListener;

    @Override
    protected void initData(Bundle savedInstanceState) {
        mListView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onItemClickListener = (OnItemClickListener) activity;
        } catch (Exception e) {
            throw new ClassCastException("This activity not implements interface OnItemClickListener!");
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String item);
    }

    @Override
    protected void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.lv);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClickListener.onItemClick(items[position]);
            }
        });
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_item;
    }
}
