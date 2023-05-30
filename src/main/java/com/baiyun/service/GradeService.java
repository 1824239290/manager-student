package com.baiyun.service;

import com.baiyun.entity.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeService {
    List<Grade> getList(int page,int size) throws SQLException;
    List<Grade> selectAll();
    int add(String gradeName,String course);
}
