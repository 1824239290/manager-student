package com.baiyun.dao;

import com.baiyun.dao.impl.GradeDaoImpl;
import com.baiyun.entity.Grade;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GradeDaoTest{
    private final GradeDao gradeDao = new GradeDaoImpl();
    @Test
    public void selectGradeList() throws SQLException {
        List<Grade> grades = gradeDao.selectGradeList(1,10);
        System.out.println(grades.toString());
    }

    @Test
    public void insertGrade() {
    }
}