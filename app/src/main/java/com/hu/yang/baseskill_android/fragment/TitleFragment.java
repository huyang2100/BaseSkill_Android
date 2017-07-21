package com.hu.yang.baseskill_android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hu.yang.baseskill_android.constant.Datas;
import com.hu.yang.baseskill_android.R;

/**
 * Created by yanghu on 2017/7/20.
 */

public class TitleFragment extends ListFragment {

    private OnTitleSelectedListener onTitleSelectedListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1, Datas.titles));
    }

    public interface OnTitleSelectedListener{
        void onTitleSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onTitleSelectedListener = (OnTitleSelectedListener) activity;
        } catch (Exception e) {
            throw new ClassCastException("this activity not implements OnTitleSelectedListener");
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        if(getActivity().findViewById(R.id.frag_content)!=null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(0,true);
            onTitleSelectedListener.onTitleSelected(0);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        onTitleSelectedListener.onTitleSelected(position);
    }
}
