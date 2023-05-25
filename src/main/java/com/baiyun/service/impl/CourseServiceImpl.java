package com.baiyun.service.impl;

import com.baiyun.dao.CourseDao;
import com.baiyun.dao.impl.CourseDaoImpl;
import com.baiyun.entity.Course;
import com.baiyun.service.CourseService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();
    @Override
    public List<Course> getAllCourses() throws SQLException {
        return courseDao.getAllCourses();
    }

    @Override
    public Map<String, Object> deleteCourse(int cid) throws SQLException, ClassNotFoundException {
        Map<String,Object> result = new HashMap<>();
        try {
                courseDao.delectCourses(cid);
                result.put("status", 200);
                result.put("message", "删除成功!");
                return result;

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        result.put("status", 500);
        result.put("message", "删除!");
        return result;
    }

    @Override
    public Map<String, Object> addCourse(String courseName) {
        Map<String,Object> result = new HashMap<>();
        try {
            Course c = courseDao.getCourseByCourseName(courseName);

            if (c != null) {
                //说明课程已经有了
                result.put("status", 500);
                result.put("message", "课程名重复，添加失败！");
                return result;
            } else {
                courseDao.addCourse(courseName);
                result.put("status", 200);
                result.put("message", "添加成功!");
                return result;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        result.put("status", 500);
        result.put("message", "添加失败!");
        return result;
        }
}
