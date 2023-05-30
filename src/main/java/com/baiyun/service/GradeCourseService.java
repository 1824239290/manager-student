package com.baiyun.service;


import com.baiyun.entity.GradeCourse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GradeCourseService {


 Map<String, Object> addGrade(String gradeName, String courseName) throws SQLException, ClassNotFoundException;

    List<GradeCourse> getAllGradeCourses();

    Map<String, Object> deleteGrade(int gid);
}
