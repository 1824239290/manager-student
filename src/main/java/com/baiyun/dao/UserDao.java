package com.baiyun.dao;

import com.baiyun.entity.User;

import java.io.IOException;

/**
 * 语法规范
 * 企业开发规范 数据层 表的关键命名 select insert delete
 */
public interface UserDao {
    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return User
     */
    User selectByUsername(String username) throws IOException;
}
