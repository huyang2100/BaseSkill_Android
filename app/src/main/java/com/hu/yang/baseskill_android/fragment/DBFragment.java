package com.hu.yang.baseskill_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;
import com.hu.yang.baseskill_android.bean.Student;
import com.hu.yang.baseskill_android.dao.StudentDao;

import java.util.ArrayList;

/**
 * Created by Yang on 2017/6/28.
 */

public class DBFragment extends BaseFragment {

    private EditText et_name;
    private EditText et_age;
    private RadioButton rb_male;
    private StudentDao studentDao;
    private ListView lv;
    private StuAdapter stuAdapter;

    @Override
    protected void initData(Bundle savedInstanceState) {
        studentDao = new StudentDao(getActivity());
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)) {
                    Toast.makeText(getActivity(), "nage or age is null!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = new Student();
                String sex = "male";
                if (!rb_male.isChecked()) {
                    sex = "female";
                }

                student.name = name;
                student.age = age;
                student.sex = sex;
                studentDao.addStudent(student);
                Toast.makeText(getActivity(), "添加成功！", Toast.LENGTH_SHORT).show();

                ArrayList<Student> studentList = studentDao.getAllStudent();
                if (stuAdapter == null) {
                    stuAdapter = new StuAdapter();
                    stuAdapter.setList(studentList);
                    lv.setAdapter(stuAdapter);
                } else {
                    stuAdapter.setList(studentList);
                    stuAdapter.notifyDataSetChanged();
                }
            }
        });

        et_name = (EditText) view.findViewById(R.id.et_name);
        et_age = (EditText) view.findViewById(R.id.et_age);
        rb_male = (RadioButton) view.findViewById(R.id.rb_male);
        lv = (ListView) view.findViewById(R.id.lv);
    }

    class StuAdapter extends BaseAdapter {

        private ArrayList<Student> students;

        @Override
        public int getCount() {
            return students.size();
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
                convertView = View.inflate(getActivity(), R.layout.item_db, null);
            }

            Student student = students.get(position);
            TextView tv = (TextView) convertView.findViewById(R.id.tv);
            tv.setText(student.toString());
            return convertView;
        }

        public void setList(ArrayList<Student> studentList) {
            this.students = studentList;
        }
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_db;
    }
}
