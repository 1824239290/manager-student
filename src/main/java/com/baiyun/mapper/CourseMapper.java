package com.baiyun.mapper;

import com.baiyun.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface CourseMapper{
    @Select("select * from course")
    List<Course> getAllCourses() throws SQLException;

    @Delete("delete from course where cid = #{cid}")
    int delectCourses(int cid) throws ClassNotFoundException, SQLException;

    @Select("select * from course where courseName = #{courseName}")
    Course getCourseByCourseName(String courseName) throws ClassNotFoundException, SQLException;

    @Insert("insert into course (courseName) values (#{courseName});")
    void addCourse(String courseName) throws ClassNotFoundException, SQLException;
}
