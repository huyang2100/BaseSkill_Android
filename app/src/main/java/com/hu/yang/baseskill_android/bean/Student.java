package com.hu.yang.baseskill_android.bean;

/**
 * Created by Yang on 2017/6/28.
 */

public class Student {
    public String name;
    public String age;
    public String sex;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
