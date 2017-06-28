package com.hu.yang.baseskill_android;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.hu.yang.baseskill_android.bean.Student;
import com.hu.yang.baseskill_android.dao.StudentDao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

/**
 * Created by Yang on 2017/6/28.
 */
@RunWith(AndroidJUnit4.class)
public class StudentTest {

    @Test
    public void addStu() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDao studentDao = new StudentDao(appContext);

        Student student = new Student();
        student.name = "test1";
        student.age = "30";
        student.sex = "male";
        long result = studentDao.addStudent(student);
        Assert.assertEquals(true, result != -1);
    }

    @Test
    public void getAllStu() throws Exception{
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDao studentDao = new StudentDao(appContext);

        ArrayList<Student> allStudent = studentDao.getAllStudent();
        Student student = allStudent.get(0);
        Assert.assertEquals("test1",student.name);
    }
}
