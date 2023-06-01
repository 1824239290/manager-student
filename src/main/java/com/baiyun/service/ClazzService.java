package com.baiyun.service;

import com.baiyun.entity.Clazz;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ClazzService {
    List<Clazz> selectAlldt(String gid);
    List<Clazz> selectAllByPageAndRow(int page,int row);


    List<Clazz> getAllClazz(String gid) throws SQLException, ClassNotFoundException;

    Map<String, Object> addClazz(String clazzName, int gid);

    Map<String, Object> deleteClazz(String cid);
}
