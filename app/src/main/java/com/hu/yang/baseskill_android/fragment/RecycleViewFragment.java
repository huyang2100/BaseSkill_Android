package com.hu.yang.baseskill_android.fragment;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.constant.Datas;

/**
 * Created by yanghu on 2017/7/24.
 */

public class RecycleViewFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    protected void initData(Bundle savedInstanceState) {
        recyclerView.setAdapter(new MyAdapter());
//        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
//        lm.setOrientation(LinearLayoutManager.VERTICAL);

//        GridLayoutManager lm = new GridLayoutManager(getActivity(), 2);

        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.item_recycleview, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.tv_name.setText(Datas.datas[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), Datas.datas[position], Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return Datas.datas.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView tv_name;
            private View itemView;

            public ViewHolder(View itemView) {
                super(itemView);
                this.itemView= itemView;
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_recycleview;
    }
}
