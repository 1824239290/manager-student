package com.baiyun.service.impl;

import com.baiyun.dao.ClazzDao;
import com.baiyun.dao.impl.ClazzDaoImpl;
import com.baiyun.entity.Clazz;
import com.baiyun.service.ClazzService;

import java.util.List;

public class ClazzServiceImpl implements ClazzService {
    private ClazzDao clazzDao = new ClazzDaoImpl();
    @Override
    public List<Clazz> selectAlldt(String gid) {
        return clazzDao.selectAlldt(gid);
    }

    @Override
    public List<Clazz> selectAllByPageAndRow(int page,int row) {
        return clazzDao.selectAllByPageAndRow(page,row);
    }
}
