package com.hu.yang.baseskill_android.fragment;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.bean.Msg;

import java.util.ArrayList;

/**
 * Created by yanghu on 2017/7/26.
 */

public class SmsFragment extends BaseFragment implements View.OnClickListener {

    private static final String COL_ADDRESS = "address";
    private static final String COL_TYPE = "type";
    private static final String COL_BODY = "body";
    private ListView lv;
    private EditText et;
    private ArrayList<Msg> msgList = new ArrayList<>();
    private MyAdapter myAdapter;
    private Uri uri;
    private ContentResolver contentResolver;

    @Override
    protected void initData(Bundle savedInstanceState) {
        uri = Uri.parse("content://sms/");
        contentResolver = getActivity().getContentResolver();
        contentResolver.registerContentObserver(uri, true, new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                getMsgData();
                myAdapter.notifyDataSetChanged();
            }
        });

        getMsgData();

        myAdapter = new MyAdapter();
        lv.setAdapter(myAdapter);
    }

    private void getMsgData() {
        msgList.clear();
        Cursor cursor = contentResolver.query(uri, new String[]{COL_ADDRESS, COL_TYPE, COL_BODY}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Msg msg = new Msg();
                msg.setAddress(cursor.getString(cursor.getColumnIndex(COL_ADDRESS)));
                msg.setBody(cursor.getString(cursor.getColumnIndex(COL_BODY)));
                msg.setType(cursor.getInt(cursor.getColumnIndex(COL_TYPE)));
                msgList.add(msg);
            }
            cursor.close();
        }
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.write).setOnClickListener(this);
        lv = (ListView) view.findViewById(R.id.lv);
        et = (EditText) view.findViewById(R.id.et);
    }


    class MyAdapter extends BaseAdapter {

        private ViewHolder viewHolder;

        @Override
        public int getCount() {
            return msgList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getActivity(), android.R.layout.simple_list_item_1, null);
                viewHolder = new ViewHolder();
                viewHolder.tv = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tv.setText(msgList.get(position).toString());
            return convertView;
        }

        class ViewHolder {
            TextView tv;
        }
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_sms;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.write:
                String smsContent = et.getText().toString();
                if (TextUtils.isEmpty(smsContent)) {
                    Toast.makeText(getActivity(), "sms is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }


                ContentValues values = new ContentValues();
                values.put(COL_ADDRESS, "95888");
                values.put(COL_TYPE, 1);
                values.put(COL_BODY, smsContent);
                contentResolver.insert(uri, values);
                et.setText("");
                break;
        }
    }
}
