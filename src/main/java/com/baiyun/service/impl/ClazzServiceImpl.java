package com.baiyun.service.impl;

import com.baiyun.dao.ClazzDao;
import com.baiyun.dao.impl.ClazzDaoImpl;
import com.baiyun.entity.Clazz;
import com.baiyun.service.ClazzService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Override
    public List<Clazz> getAllClazz(String gid) {
        try {
            return clazzDao.getAllClazz(gid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Map<String, Object> addClazz(String clazzName, int gid) {
        Map<String, Object> result = new HashMap<>();
        try {
            Clazz clazz = clazzDao.getClazzByClazzName(clazzName);
            if (clazz != null) {
                //说明班级名已存在
                result.put("status", 500);
                result.put("message", "班级名重复,添加失败");
                return result;
            } else {
                clazzDao.addClazz(clazzName, gid);
                //说明课程名已存在
                result.put("status", 200);
                result.put("message", "添加成功");
                return result;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.put("status", 500);
        result.put("message", "添加失败");
        return result;
    }

    @Override
    public Map<String, Object> deleteClazz(String cid) {
        Map<String, Object> rs = new HashMap<>();
        try {
            Clazz clazz = clazzDao.getClazzByCid(cid);
            if (clazz == null) {
                //说明班级名已被删除
                rs.put("status", 500);
                rs.put("message", "班级名已被删除");
                return rs;
            } else {
                clazzDao.deleteClazz(cid);
                rs.put("status", 200);
                rs.put("message", "删除成功");
                return rs;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rs.put("status", 500);
        rs.put("message", "删除失败");
        return rs;
    }
}
