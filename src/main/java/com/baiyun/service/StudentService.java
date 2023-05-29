package com.baiyun.service;

import com.baiyun.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();
    List<Student> selectAlldt(String gid,String cid, int page,int rows);

}
