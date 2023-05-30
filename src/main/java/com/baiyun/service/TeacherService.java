package com.baiyun.service;


import com.baiyun.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Map<String, Object> addTeacher(String number,String name,String gender,String phone,String qq);

    Map<String,Object> delete(String ids[]);
}
