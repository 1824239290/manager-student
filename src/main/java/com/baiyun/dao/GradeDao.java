package com.baiyun.dao;

import com.baiyun.entity.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeDao {
    List<Grade> selectGradeList(int page,int size) throws SQLException;
    List<Grade> selectAll();
    int insertGrade(String grade);
}
