package com.baiyun.service;

import com.baiyun.entity.User;

public interface UserService {
    User login(String account, String password);
}
