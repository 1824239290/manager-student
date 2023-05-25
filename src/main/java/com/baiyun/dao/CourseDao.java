package com.baiyun.dao;

import com.baiyun.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses() throws SQLException;
    int delectCourses(int cid) throws ClassNotFoundException, SQLException;


    Course getCourseByCourseName(String courseName) throws ClassNotFoundException, SQLException;

    void addCourse(String courseName) throws ClassNotFoundException, SQLException;
}
