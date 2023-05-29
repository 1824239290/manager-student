package com.baiyun.dao.impl;

import com.baiyun.dao.StudentDao;
import com.baiyun.entity.Student;
import com.baiyun.mapper.StudentMapper;
import com.baiyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private SqlSession sqlSession;

    {
        try {
            sqlSession = MybatisUtil.getOpenSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    @Override
    public List<Student> selentAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> selectAlldt(String gid,String cid, int page, int rows) {
        return studentMapper.selectALLdt(gid,cid,page,rows);
    }
}
