package com.baiyun.service.impl;


import com.baiyun.dao.CourseDao;
import com.baiyun.dao.GradeCourseDao;
import com.baiyun.dao.impl.CourseDaoImpl;
import com.baiyun.dao.impl.GradeCourseDaoImpl;
import com.baiyun.entity.GradeCourse;
import com.baiyun.service.GradeCourseService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeCourseServiceImpl implements GradeCourseService {
    private GradeCourseDao gradeCourseDao = new GradeCourseDaoImpl();
    private CourseDao courseDao =new CourseDaoImpl();


    public Map<String, Object> addGrade(String gradeName, String courseName) throws SQLException, ClassNotFoundException {
        Map<String,Object>result=new HashMap<>();

        result = new HashMap<>();
            try {
                int i = gradeCourseDao.addGrade(gradeName,courseName);
                if (i==0) {
                    result.put("status", 500);
                    result.put("message", "添加失败");

                    return result;
                }else {
                    result.put("status", 200);
                    result.put("message", "添加成功");
                    result.put("aaa",i);
                    return result;
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        return result;
    }

    @Override
    public List<GradeCourse> getAllGradeCourses() {
        try {
            return gradeCourseDao.getAllGradeCourses();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Object> deleteGrade(int gid) {
        Map<String,Object>result=new HashMap<>();

        result = new HashMap<>();
        int i = gradeCourseDao.deleteGrade(gid);
        if (i==0) {
            result.put("status", 500);
            result.put("message", "删除失败");

            return result;
        }else {
            result.put("status", 200);
            result.put("message", "删除成功");
            result.put("aaa",i);
            return result;
        }
    }
}
