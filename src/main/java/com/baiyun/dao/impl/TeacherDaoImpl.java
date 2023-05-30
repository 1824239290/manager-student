package com.baiyun.dao.impl;


import com.baiyun.dao.TeacherDao;
import com.baiyun.entity.Teacher;
import com.baiyun.mapper.TeacherMapper;
import com.baiyun.util.MybatisUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    private TeacherMapper teacherMapper;

    {
        try {
            teacherMapper = MybatisUtil.getOpenSession().getMapper(TeacherMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/manager_student";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123456";

    @Override
    public List<Teacher> getTeachers() throws SQLException, ClassNotFoundException {
        List<Teacher> list=new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        PreparedStatement ps=connection.prepareStatement("SELECT t.*,c.courseName from teacher t LEFT JOIN teacher_course tc ON t.tid=tc.tid LEFT JOIN course c on tc.courseId=c.cid ORDER BY tid desc;");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            int tid=rs.getInt("tid");
            String name =rs.getString("name");
            String number =rs.getString("number");
            String gender =rs.getString("gender");
            String phone =rs.getString("phone");
            String qq =rs.getString("qq");
            String courseName =rs.getString("courseName");
            Teacher teacher=new Teacher();
            teacher.setTid(tid);
            teacher.setNumber(number);
            teacher.setName(name);
            teacher.setGender(gender);
            teacher.setPhone(phone);
            teacher.setQq(qq);
            teacher.setCourseName(courseName);
            list.add(teacher);
        }
        if (rs != null){
            rs.close();
        }
        if (ps != null){
            ps.close();
        }
        if (connection != null){
            connection.close();
        }
        return list;
    }

    @Override
    public Teacher getTeacherByNumber(String number) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        PreparedStatement ps=connection.prepareStatement("select * from teacher where number = ?");
        ps.setString(1,number);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            int tid=rs.getInt("tid");
            String tNumber =rs.getString("number");
            String name=rs.getString("name");
            String gender =rs.getString("gender");
            String phone =rs.getString("phone");
            String qq =rs.getString("qq");
            Teacher teacher=new Teacher();
            teacher.setTid(tid);
            teacher.setNumber(tNumber);
            teacher.setName(name);
            teacher.setGender(gender);
            teacher.setPhone(phone);
            teacher.setQq(qq);
            return teacher;
        }
        if (rs != null){
            rs.close();
        }
        if (ps != null){
            ps.close();
        }
        if (connection != null){
            connection.close();
        }
        return null;
    }

    @Override
    public int addTeacher(String number,String name,String gender,String phone,String qq) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        PreparedStatement ps=connection.prepareStatement("insert into teacher(number,name,gender,phone,qq) values (?,?,?,?,?);");
        ps.setString(1,number);
        ps.setString(2,name);
        ps.setString(3,gender);
        ps.setString(4,phone);
        ps.setString(5,qq);
        ps.executeUpdate();
        if (ps != null){
            ps.close();
        }
        if (connection != null){
            connection.close();
        }
        return 0;
    }

    @Override
    public int delete(String[] ids) {
        return teacherMapper.delete(ids);
    }

}
