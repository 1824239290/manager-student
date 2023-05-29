package com.baiyun.dao;

import com.baiyun.entity.Clazz;

import java.util.List;

public interface ClazzDao {
    List<Clazz>selectAlldt(String gid);
    List<Clazz>selectAllByPageAndRow(int page,int row);
}
