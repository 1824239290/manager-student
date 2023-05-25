package com.baiyun.service.impl;

import com.baiyun.dao.UserDao;
import com.baiyun.dao.impl.UserDaoImpl;
import com.baiyun.entity.User;
import com.baiyun.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();
    public User login(String account, String password) {
        User user = null;
        try{
            user = userDao.selectByUsername(account);
            if (user == null){
                throw new RuntimeException("账号不存在");
            }
            if (!user.getPassword().equals(password)){
                throw new RuntimeException("密码错误");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
