package com.baiyun.dao.impl;

import com.baiyun.dao.GradeDao;
import com.baiyun.entity.Grade;
import com.baiyun.mapper.GradeMapper;
import com.baiyun.util.MybatisUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GradeDaoImpl implements GradeDao {

    public static final GradeMapper gradeMapper;

    static {
        try {
            gradeMapper = MybatisUtil.getOpenSession().getMapper(GradeMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Grade> selectGradeList(int limit, int size) throws SQLException {
        return gradeMapper.selectGradeList(limit,size);
    }

    @Override
    public List<Grade> selectAll() {
        return gradeMapper.selectAll();
    }


    @Override
    public int insertGrade(String gradeName) {
        return gradeMapper.insertGrade(gradeName);
    }
}
