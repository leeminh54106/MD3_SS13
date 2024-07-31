package com.example.baitap_1.model;

import java.util.Date;

public class Student {
    private Integer studentId;
    private String fullName;
    private boolean Gender;
    private Date birthday;
    private String address;
    private String classId;

    public Student() {
    }

    public Student(Integer studentId, String fullName, boolean gender, Date birthday, String address, String classId) {
        this.studentId = studentId;
        this.fullName = fullName;
        Gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
