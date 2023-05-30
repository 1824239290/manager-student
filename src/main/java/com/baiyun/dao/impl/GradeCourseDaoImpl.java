package com.baiyun.dao.impl;

import com.baiyun.dao.CourseDao;
import com.baiyun.dao.GradeCourseDao;
import com.baiyun.entity.Grade;
import com.baiyun.entity.GradeCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeCourseDaoImpl implements GradeCourseDao {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/manager_student";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123456";

    @Override
    public Grade getGradeByGradeName(String gradeName) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement ps =con.prepareStatement("select * from grade where gradeName=?");
        ps.setString(1,gradeName);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int gid = rs.getInt("gid");
            String gn=rs.getString("gradeName");
            Grade g = new Grade();
            g.setGid(gid);
            g.setGradeName(gn);
            return g;
        }
        if(rs !=null){
            rs.close();
        }
        if(ps !=null){
            ps.close();
        }
        if(con !=null){
            con.close();
        }
        return null;
    }
    private CourseDao courseDao=new CourseDaoImpl();
    @Override
    public int addGrade(String gradeName, String courseName) throws ClassNotFoundException, SQLException {

        int count=0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        if (getGradeByGradeName(gradeName)==null) {
            ps1 = con.prepareStatement("insert into grade(gradeName) values(?)");
            ps1.setString(1,gradeName);
            count+=ps1.executeUpdate();
        }
        if (courseDao.getCourseByCourseName(courseName)==null) {
            ps2 = con.prepareStatement("insert into course(courseName) values(?)");
            ps2.setString(1, courseName);
            count += ps2.executeUpdate();
        }
        PreparedStatement ps3 = con.prepareStatement("INSERT INTO grade_course(gid, cid) SELECT g.gid, c.cid FROM grade g, course c WHERE g.gradeName = ? AND c.courseName = ?;");
        ps3.setString(1, gradeName);
        ps3.setString(2, courseName);
        count+=ps3.executeUpdate();



        if(ps1 !=null){
            ps1.close();
        }
        if(ps2 !=null){
            ps2.close();
        }
        if(ps3 !=null) {
            ps3.close();
        }
        if(con !=null){
            con.close();
        }
        return count;
    }

    @Override
    public List<GradeCourse> getAllGradeCourses() throws ClassNotFoundException, SQLException {
        List<GradeCourse> list = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement ps =con.prepareStatement("SELECT gradeName,courseName,gcid FROM grade a,course b,grade_course c WHERE a.gid=c.gid and b.cid=c.cid");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int gcid = rs.getInt("gcid");
            String gradeName = rs.getString("gradeName");
            String courseName = rs.getString("courseName");
            GradeCourse c = new GradeCourse();
            c.setGcid(gcid);
            c.setGradeName(gradeName);
            c.setCourseName(courseName);
            list.add(c);
        }
        if(rs !=null){
            rs.close();
        }
        if(ps !=null){
            ps.close();
        }
        if(con !=null){
            con.close();
        }
        return list;
    }
    @Override
    public int deleteGrade(int gid) {
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String sql = "delete from grade_course where gcid=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, gid);
            count = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    }

