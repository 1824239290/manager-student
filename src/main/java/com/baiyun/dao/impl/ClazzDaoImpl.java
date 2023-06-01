package com.baiyun.dao.impl;

import com.baiyun.dao.ClazzDao;
import com.baiyun.entity.Clazz;
import com.baiyun.mapper.ClazzMapper;
import com.baiyun.util.MybatisUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClazzDaoImpl implements ClazzDao {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/manager_student";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123456";
    ClazzMapper clazzMapper;

    {
        try {
            clazzMapper = MybatisUtil.getOpenSession().getMapper(ClazzMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Clazz> selectAlldt(String gid) {
        return clazzMapper.selectAlldt(gid);
    }

    @Override
    public List<Clazz> selectAllByPageAndRow(int page,int row) {
        return clazzMapper.selectAllByPageAndRow(page, row);
    }


    @Override
    public List<Clazz> getAllClazz(String gid) throws ClassNotFoundException, SQLException {
        List<Clazz> list = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement preparedStatement=null;
        if (gid==null||gid=="0") {
            preparedStatement = connection.prepareStatement("select c.*,g.gradeName from clazz c,grade g where c.gid = g.gid;");
        }else {
            preparedStatement = connection.prepareStatement("select c.*,g.gradeName from clazz c,grade g where c.gid = g.gid and c.gid=?;");
            preparedStatement.setString(1,gid);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int cid = resultSet.getInt("cid");
            String className = resultSet.getString("clazzName");
            int git = resultSet.getInt("gid");
            String gradeName = resultSet.getString("gradeName");
            Clazz clazz = new Clazz();
            clazz.setCid(cid);
            clazz.setClazzName(className);
            clazz.setGid(git);
            clazz.setGradeName(gradeName);
            list.add(clazz);
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
        return list;
    }

    @Override
    public Clazz getClazzByClazzName(String clazzName) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from clazz where clazzName=?");
        preparedStatement.setString(1, clazzName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int cid = resultSet.getInt("cid");
            String clazzName1 = resultSet.getString("clazzName");
            int git = resultSet.getInt("gid");
            Clazz clazz = new Clazz();
            clazz.setCid(cid);
            clazz.setClazzName(clazzName1);
            clazz.setGid(git);
            return clazz;
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return null;
    }

    @Override
    public void addClazz(String clazzName, int gid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("insert into clazz (clazzName,gid) value (?,?);");
        preparedStatement.setString(1, clazzName);
        preparedStatement.setInt(2,gid);
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public void deleteClazz(String clazzId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clazz where cid =?");
        preparedStatement.setString(1, clazzId);
        int i  =  preparedStatement.executeUpdate();
        System.out.println(i);
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Clazz getClazzByCid(String cid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from clazz where cid =?");
        preparedStatement.setString(1, cid);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int cid2 = resultSet.getInt("cid");
            String clazzName1 = resultSet.getString("clazzName");
            int git = resultSet.getInt("gid");
            Clazz clazz = new Clazz();
            clazz.setCid(cid2);
            clazz.setClazzName(clazzName1);
            clazz.setGid(git);
            return clazz;
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return null;
    }
}
