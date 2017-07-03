package com.hu.yang.baseskill_android.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hu.yang.baseskill_android.bean.Student;
import com.hu.yang.baseskill_android.db.MyDBHelper;

import java.util.ArrayList;

/**
 * Created by Yang on 2017/6/28.
 */

public class StudentDao {

    private final MyDBHelper myDBHelper;

    public StudentDao(Context context) {
        myDBHelper = new MyDBHelper(context);
    }

    public long addStudent(Student student) {
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDBHelper.COL_NAME, student.name);
        values.put(MyDBHelper.COL_AGE, student.age);
        values.put(MyDBHelper.COL_SEX, student.sex);
        long rowid = db.insert(MyDBHelper.TABLE_NAME, null, values);
        db.close();

        return rowid;
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> stuList = new ArrayList<>();
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        Cursor cursor = db.query(MyDBHelper.TABLE_NAME, new String[]{MyDBHelper.COL_NAME, MyDBHelper.COL_AGE, MyDBHelper.COL_SEX}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Student student = new Student();
            String name = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_AGE));
            String sex = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_SEX));
            student.name = name;
            student.age = age;
            student.sex = sex;
            stuList.add(student);
        }
        cursor.close();
        db.close();
        return stuList;
    }

    public boolean findByName(String name) {
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        Cursor cursor = db.query(MyDBHelper.TABLE_NAME, new String[]{MyDBHelper.COL_NAME}, "name=?", new String[]{name}, null, null, null);
        boolean b = cursor.moveToNext();
        cursor.close();
        db.close();
        return b;
    }

    public int delByName(String name) {
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        int i = db.delete(MyDBHelper.TABLE_NAME, "name=?", new String[]{name});
        db.close();
        return i;
    }
}
