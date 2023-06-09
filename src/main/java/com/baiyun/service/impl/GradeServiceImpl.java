package com.baiyun.service.impl;

import com.baiyun.dao.GradeDao;
import com.baiyun.dao.impl.GradeDaoImpl;
import com.baiyun.entity.Grade;
import com.baiyun.service.GradeService;
import java.sql.SQLException;
import java.util.List;

public class GradeServiceImpl implements GradeService {
    private final GradeDao gradeDao = new GradeDaoImpl();
    //select * from limit 0,10
    @Override
    public List<Grade> getList(int page, int size) throws SQLException {
        int limit = (page-1)*size ;
        return gradeDao.selectGradeList(limit, size);
    }

    @Override
    public List<Grade> selectAll() {
        return gradeDao.selectAll();
    }

    @Override
    public int add(String gradeName, String course) {
        //调用数据层
        return gradeDao.insertGrade(gradeName);

    }
}
