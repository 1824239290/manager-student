package com.baiyun.dao.impl;

import com.baiyun.dao.CourseDao;
import com.baiyun.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/manager_student";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD ="123456";

    @Override
    public List<Course> getAllCourses() throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Course> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            String sql = "select * from `course`";
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                //一次循环对应一个实体对象。
                int cid = resultSet.getInt("cid");
                String courseName=resultSet.getString("courseName");
                Course course = new Course();
                course.setCourseName(courseName);
                course.setCid(cid);
                list.add(course);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet !=null){
                resultSet.close();
            }
            if (ps != null){
                ps.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return list;
    }

    @Override
    public int delectCourses(int cid) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        int rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
        String sql = "delete from course where cid = ?;";
        ps =connection.prepareStatement(sql);
        ps.setInt(1,cid);
        rs = ps.executeUpdate();
        System.out.println("删除成功");
        return rs;
    }

    @Override
    public Course getCourseByCourseName(String courseName) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
        String sql = "select * from course where courseName = ?";
        ps =connection.prepareStatement(sql);
        ps.setString(1,courseName);
        rs = ps.executeQuery();
        if (rs.next()){
            Course course = new Course();
            course.setCid(rs.getInt("cid"));
            course.setCourseName(rs.getString("courseName"));
            return course;
        }

        if (rs !=null){
            rs.close();
        }
        if (ps != null){
            ps.close();
        }
        if(connection != null){
            connection.close();
        }
        return null;
    }

    @Override
    public void addCourse(String courseName) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
        String sql = "insert into course (courseName) values (?);";
        ps = connection.prepareStatement(sql);
        ps.setString(1,courseName);
        ps.executeUpdate();
        if (ps != null){
            ps.close();
        }
        if(connection != null){
            connection.close();
        }
    }
}
