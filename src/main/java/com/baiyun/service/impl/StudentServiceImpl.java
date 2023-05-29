package com.baiyun.service.impl;

import com.baiyun.dao.StudentDao;
import com.baiyun.dao.impl.StudentDaoImpl;
import com.baiyun.entity.Student;
import com.baiyun.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> selectAll() {
        return studentDao.selentAll();
    }

    @Override
    public List<Student> selectAlldt(String gid,String cid,int page,int rows) {
        page = page-1;
        return studentDao.selectAlldt(gid,cid,page,rows);
    }

    @Override
    public Map<String, Object> addStudent(Student student) {
        Map<String,Object> result = new HashMap<>();
        try{
            studentDao.addStudent(student);
            result.put("status",200);
            result.put("message","添加成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("status",500);
        result.put("message","添加失败");
        return result;
    }

    @Override
    public Map<String, Object> updateStudent(Student student) {
        Map<String,Object> result = new HashMap<>();
        try{
            studentDao.updateStudent(student);
            result.put("status",200);
            result.put("message","添加成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("status",500);
        result.put("message","添加失败");
        return result;
    }
}
