package com.baiyun.dao;

import com.baiyun.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selentAll();
    List<Student> selectAlldt(String gid,String cid, int page, int rows);
    int addStudent(Student student);

    int updateStudent(Student student);
    int deleteStudent(String ids[]);
}
