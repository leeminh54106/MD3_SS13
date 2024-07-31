package com.example.baitap_1.repository;

import com.example.baitap_1.model.Student;

import java.util.List;

public interface StudentRep {
    List<Student> findAll();
    Student findById(Integer studentId);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Integer studentId);
    List<Student> findByStudentName(String studentName);
}
