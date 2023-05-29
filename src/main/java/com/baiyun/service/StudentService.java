package com.baiyun.service;

import com.baiyun.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> selectAll();
    List<Student> selectAlldt(String gid,String cid, int page,int rows);

    Map<String,Object> addStudent(Student student);

    Map<String,Object> updateStudent(Student student);

}
