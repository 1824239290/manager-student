package com.baiyun.entity;

public class GradeCourse {
    private  Integer gcid;
    private  String gradeName;
    private  String courseName;

    public Integer getGcid() {
        return gcid;
    }

    public void setGcid(Integer gcid) {
        this.gcid = gcid;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "GradeCourse{" +
                "gcid=" + gcid +
                ", gradeName='" + gradeName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
