package com.example.baitap_1.model;

public class Classes {
    private String classId;
    private String className;
    private boolean status;

    public Classes() {
    }

    public Classes(String classId, String className, boolean status) {
        this.classId = classId;
        this.className = className;
        this.status = status;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

