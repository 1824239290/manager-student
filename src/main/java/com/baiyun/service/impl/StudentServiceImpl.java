package com.baiyun.service.impl;

import com.baiyun.dao.StudentDao;
import com.baiyun.dao.impl.StudentDaoImpl;
import com.baiyun.entity.Student;
import com.baiyun.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> selectAll() {
        return studentDao.selentAll();
    }
}