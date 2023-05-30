package com.baiyun.dao;

import com.baiyun.dao.impl.StudentDaoImpl;
import com.baiyun.entity.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {
    private  StudentDao dao = new StudentDaoImpl();
    @Test
    public void selentAll() {
        List<Student> list = dao.selentAll();
        if (!list.equals(null)){
            System.out.println("有"+list.size()+"条数据");
        }
    }

    @Test
    public void selectAlldt() {
        List<Student> student = dao.selectAlldt(null,null,0,10);
        if (!student.equals(null)){
            System.out.println("有"+student.size()+"条数据");
        }
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setNumber("999");
        student.setName("007");
        student.setGender("男");
        student.setPhone("13232323232");
        student.setQq("1824239290");
        student.setGid(3);
        student.setCid(2);
        int i = dao.addStudent(student);
        if (i > 0){
            System.out.println("添加成功");
        }
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setNumber("999");
        student.setName("007修改");
        student.setGender("男");
        student.setPhone("13232323232");
        student.setQq("1824239290");
        student.setGid(3);
        student.setCid(2);
        int i = dao.updateStudent(student);
        if (i > 0){
            System.out.println("修改成功");
        }
    }

    @Test
    public void deleteStudent() {
        String ids[] = {"20"};
        int i = dao.deleteStudent(ids);
        if (i > 0){
            System.out.println("删除成功");
        }

    }
}