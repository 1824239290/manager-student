package com.baiyun.entity;

public class Grade {
    private int gid;
    private String gradeName;

    public Grade() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
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
        return "Grade{" +
                "gid=" + gid +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
