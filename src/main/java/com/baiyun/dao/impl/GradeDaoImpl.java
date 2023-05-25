package com.baiyun.dao.impl;

import com.baiyun.dao.GradeDao;
import com.baiyun.entity.Grade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {

    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/manager_student";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD ="123456";

    @Override
    public List<Grade> selectGradeList(int limit, int size) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Grade> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            String sql = "select * from grade limit ?,?";
            ps.setInt(1,limit);
            ps.setInt(2,size);
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                //一次循环对应一个实体对象。
                Grade grade = new Grade();
                grade.setGradeName(resultSet.getString("gradeName"));
                grade.setGid(resultSet.getInt("gid"));
                list.add(grade);
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
    public int insertGrade(String gradeName) {
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            String sql = "insert into grade(gradeName) value(?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,gradeName);
            count = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
