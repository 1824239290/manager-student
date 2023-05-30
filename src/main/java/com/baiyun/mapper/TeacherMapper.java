package com.baiyun.mapper;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    int delete(@Param("ids") String ids[]);
}
