package com.baiyun.service;

import com.baiyun.entity.Student;
import com.baiyun.service.impl.StudentServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StudentServiceTest {
    private StudentService studentService = new StudentServiceImpl();
    @Test
    public void selectAlldtTest() {
        List<Student> list = studentService.selectAlldt("4", null,1, 10);
        System.out.println(list);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setNumber("008");
        student.setName("lisi");
        student.setGender("男");
        student.setPhone("12345678901");
        student.setQq("1924239290");
        student.setGid(Integer.valueOf("2"));
        student.setCid(Integer.valueOf("3"));
        Map<String, Object> a = studentService.addStudent(student);
        System.out.println(a);
    }

    @Test
    public void deleteStudent() {
        String ids[] = {"21"};
        Map<String, Object> i =  studentService.deleteStudent(ids);
        System.out.println(i);
    }

    @Test
    public void selectAll() {
        System.out.println(studentService.selectAll());
    }


    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setNumber("0080");
        student.setName("lisi");
        student.setGender("男");
        student.setPhone("12345678901");
        student.setQq("1924239290");
        student.setGid(Integer.valueOf("2"));
        student.setCid(Integer.valueOf("3"));
        Map<String, Object> a = studentService.updateStudent(student);
        System.out.println(a);
    }

}