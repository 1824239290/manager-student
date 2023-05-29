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
}