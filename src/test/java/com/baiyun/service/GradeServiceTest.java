package com.baiyun.service;

import com.baiyun.entity.Grade;
import com.baiyun.service.impl.GradeServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GradeServiceTest{
    private GradeService gradeService = new GradeServiceImpl();

    @Test
    public void getList() throws SQLException {
        List<Grade> grades = gradeService.getList(1,10);
        for (int i = 0; i <grades.size() ; i++) {
            Grade grade = grades.get(i);
            System.out.println(grade.toString());
        }
    }

    @Test
    public void add() {
    }
}