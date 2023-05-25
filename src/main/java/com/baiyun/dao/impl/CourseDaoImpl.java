package com.baiyun.dao.impl;

import com.baiyun.dao.CourseDao;
import com.baiyun.entity.Course;
import com.baiyun.mapper.CourseMapper;
import com.baiyun.util.MybatisUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    CourseMapper courseMapper;

    {
        try {
            courseMapper = MybatisUtil.getOpenSession().getMapper(CourseMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Course> getAllCourses() throws SQLException {
        return courseMapper.getAllCourses();
    }

    @Override
    public int delectCourses(int cid) throws ClassNotFoundException, SQLException {
        return courseMapper.delectCourses(cid);
    }

    @Override
    public Course getCourseByCourseName(String courseName) throws ClassNotFoundException, SQLException {
        return courseMapper.getCourseByCourseName(courseName);
    }

    @Override
    public void addCourse(String courseName) throws ClassNotFoundException, SQLException {
        courseMapper.addCourse(courseName);
    }
}
