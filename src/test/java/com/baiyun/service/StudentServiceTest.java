package com.baiyun.service;

import com.baiyun.entity.Student;
import com.baiyun.service.impl.StudentServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest{
    private StudentService studentService = new StudentServiceImpl();
    @Test
    public void selectAlldtTest() {
        List<Student> list = studentService.selectAlldt("4", null,1, 10);
        System.out.println(list);
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setNumber("001");
        student.setName("lisi");
        student.setGender("男");
        student.setPhone("12345678901");
        student.setQq("1924239290");
        student.setGid(Integer.valueOf("2"));
        student.setCid(Integer.valueOf("3"));
//        int a = studentService.addStudent(student);
//        System.out.println(a);
    }
}