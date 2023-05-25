package com.baiyun.service;

import com.baiyun.entity.Course;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Course> getAllCourses() throws SQLException;
    Map<String, Object> deleteCourse(int cid) throws SQLException, ClassNotFoundException;

    Map<String,Object> addCourse(String courseName);
}
