package com.baiyun.service;


import com.baiyun.entity.Teacher;
import com.baiyun.service.impl.TeacherServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TeacherServiceTest {

    TeacherService teacherService=new TeacherServiceImpl();

    @Test
    public void getAllTeachers() {
        List<Teacher> teachers =teacherService.getAllTeachers();
        if(teachers != null){
            System.out.println("获取成功，共"+teachers.size()+"条消息");
        }else{
            System.out.println("获取失败");
        }


    }

    @Test
    public void addTeacher() {
        Map<String,Object> count =teacherService.addTeacher("12345678","serviceTest","女","15991457321","123432156");
        if(count != null){
            System.out.println("添加成功"+count);
        }else{
            System.out.println("添加失败");
        }
    }

    @Test
    public void delete() {
        String ids[] = {"26"};
        Map<String,Object> count = teacherService.delete(ids);
        if(count != null){
            System.out.println("添加成功"+count);
        }else{
            System.out.println("添加失败");
        }
    }
}