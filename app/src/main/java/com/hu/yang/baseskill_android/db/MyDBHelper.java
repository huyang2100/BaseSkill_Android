package com.hu.yang.baseskill_android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yang on 2017/6/28.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";
    public static final String TABLE_NAME = "student";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_SEX = "sex";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (_id integer primary key autoincrement," + COL_NAME + " varchar(20)," + COL_AGE + " varchar(10)," + COL_SEX + " varchar(2))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}