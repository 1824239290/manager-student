package com.baiyun.dao;


import com.baiyun.dao.impl.TeacherDaoImpl;
import com.baiyun.entity.Teacher;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TeacherDaoTest {

    TeacherDao teacherDao=new TeacherDaoImpl();

    @Test
    public void getTeachers() throws SQLException, ClassNotFoundException {
        List<Teacher> teachers = teacherDao.getTeachers();
        if(teachers != null){
            System.out.println("获取成功，共"+teachers.size()+"条消息");
        }else{
            System.out.println("获取失败");
        }
    }

    @Test
    public void getTeacherByNumber() throws SQLException, ClassNotFoundException {
        Teacher teacherByNumber = teacherDao.getTeacherByNumber("0004");
        if(teacherByNumber != null){
            System.out.println("获取成功,获取数据为："+teacherByNumber.toString());
        }else{
            System.out.println("获取失败");
        }

    }

    @Test
    public void addTeacher() throws SQLException, ClassNotFoundException {
       int count= teacherDao.addTeacher("1234567","DaoTest","男","15991457321","123432156");
        if(count == 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }
}