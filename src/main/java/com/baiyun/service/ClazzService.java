package com.baiyun.service;

import com.baiyun.entity.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> selectAlldt(String gid);
    List<Clazz> selectAllByPageAndRow(int page,int row);
}
