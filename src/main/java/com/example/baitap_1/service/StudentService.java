package com.example.baitap_1.service;

import com.example.baitap_1.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Integer studentId);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Integer studentId);
    List<Student> findByStudentName(String studentName);
}
