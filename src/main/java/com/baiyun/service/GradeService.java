package com.baiyun.service;

import com.baiyun.entity.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeService {
    List<Grade> list(int page,int size) throws SQLException;
    int add(String gradeName,String course);
}
