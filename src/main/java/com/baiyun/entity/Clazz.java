package com.baiyun.entity;

public class Clazz {
    Integer cid;
    String clazzName;
    Integer gid;
    String gradeName;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", clazzName='" + clazzName + '\'' +
                ", gid=" + gid +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
