package com.baiyun.dao.impl;

import com.baiyun.dao.ClazzDao;
import com.baiyun.entity.Clazz;
import com.baiyun.mapper.ClazzMapper;
import com.baiyun.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

public class ClazzDaoImpl implements ClazzDao {
    ClazzMapper clazzMapper;

    {
        try {
            clazzMapper = MybatisUtil.getOpenSession().getMapper(ClazzMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Clazz> selectAlldt(String gid) {
        return clazzMapper.selectAlldt(gid);
    }

    @Override
    public List<Clazz> selectAllByPageAndRow(int page,int row) {
        return clazzMapper.selectAllByPageAndRow(page, row);
    }
}
