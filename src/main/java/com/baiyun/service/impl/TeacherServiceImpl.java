package com.baiyun.service.impl;


import com.baiyun.dao.TeacherDao;
import com.baiyun.dao.impl.TeacherDaoImpl;
import com.baiyun.entity.Teacher;
import com.baiyun.service.TeacherService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao=new TeacherDaoImpl();

    @Override
    public List<Teacher> getAllTeachers() {
        try {
            return teacherDao.getTeachers();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Object> addTeacher(String number, String name, String gender, String phone, String qq) {
        Map<String,Object> result =new HashMap<>();
        try {
            Teacher teacher=teacherDao.getTeacherByNumber(number);
            if (teacher != null){
                result.put("status",500);
                result.put("message","教师工号重复，添加失败");
                return result;
            }else {
                teacherDao.addTeacher(number, name, gender, phone, qq);
                result.put("status",200);
                result.put("message","添加成功");
                return result;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        result.put("status",500);
        result.put("message","添加失败");
        return result;

    }

    @Override
    public Map<String, Object> delete(String[] ids) {
        Map<String,Object> result =new HashMap<>();
        try {
            teacherDao.delete(ids);
            result.put("status",200);
            result.put("message","删除成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("status",500);
        result.put("message","添加失败");
        return result;
    }
}
