package com.baiyun.dao;

import com.baiyun.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

public interface ClazzDao {
    List<Clazz>selectAlldt(String gid);
    List<Clazz>selectAllByPageAndRow(int page,int row);



    List<Clazz> getAllClazz(String gid) throws ClassNotFoundException, SQLException;

    Clazz getClazzByClazzName(String clazzName) throws ClassNotFoundException, SQLException;

    void addClazz(String clazzName, int gid) throws ClassNotFoundException, SQLException;

    void deleteClazz(String clazzId) throws ClassNotFoundException, SQLException;

    Clazz getClazzByCid(String cid) throws ClassNotFoundException, SQLException;
}
