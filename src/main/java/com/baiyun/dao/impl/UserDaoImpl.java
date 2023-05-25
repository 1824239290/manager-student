package com.baiyun.dao.impl;

import com.baiyun.dao.UserDao;
import com.baiyun.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    /**
     * 单词全部大写
     * 单词之间下划线
     */
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/manager_student";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD ="123456";
    /**
     * JDBC操作
     * 1.加载驱动（可以省略）
     * 2.建立链接
     * 3.创建sql对象
     * 4.执行sql语句
     * 5.处理结果 查询（结果集） 增删改返回影响的行数
     * 6.关闭资源释放链接
     * 
     * @param username 用户名
     * @return User
     */
    public User selectByUsername(String username) throws SQLException {
        /*
          数据库链接的URL地址
          数据库 用户名
          数据库 密码
         */
        User user ;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载jdbc驱动
            connection =  DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);//建立数据库链接
            String sql = "select * from user where username = ? and enabled=1";//sql语句
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            user = new User();
            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String nickname = resultSet.getString("nickname");
                String password = resultSet.getString("password");
                int enabled = resultSet.getInt("enabled");
                int role = resultSet.getInt("role");

                user.setId(id);
                user.setUsername(name);
                user.setNickname(nickname);
                user.setPassword(password);
                user.setRole(role);
                user.setEnable(enabled);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet !=null){
                resultSet.close();
            }if (preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }
        return user;
    }
}
