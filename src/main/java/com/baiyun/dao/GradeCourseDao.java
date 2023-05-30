package com.baiyun.dao;


import com.baiyun.entity.Grade;
import com.baiyun.entity.GradeCourse;

import java.sql.SQLException;
import java.util.List;

public interface GradeCourseDao {
     Grade getGradeByGradeName(String gradeName) throws ClassNotFoundException, SQLException;

    int addGrade(String gradeName, String courseName) throws ClassNotFoundException, SQLException;


    List<GradeCourse> getAllGradeCourses() throws ClassNotFoundException, SQLException;

    int deleteGrade(int gid);
}
