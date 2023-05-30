package com.baiyun.dao.impl;

import com.baiyun.dao.UserDao;
import com.baiyun.entity.User;
import com.baiyun.mapper.UserMapper;
import com.baiyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserDaoImpl implements UserDao {

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
    public User selectByUsername(String username) throws IOException {
        User user ;
        SqlSession sqlSession =  MybatisUtil.getOpenSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        user = userMapper.selectByUsername(username);
        return user;
    }
}
