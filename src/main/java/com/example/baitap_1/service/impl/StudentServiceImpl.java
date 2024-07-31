package com.example.baitap_1.service.impl;

import com.example.baitap_1.model.Student;
import com.example.baitap_1.repository.impl.StudentRepImpl;
import com.example.baitap_1.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() {
        return new StudentRepImpl().findAll();
    }

    @Override
    public Student findById(Integer studentId) {
        return new StudentRepImpl().findById(studentId);
    }

    @Override
    public boolean addStudent(Student student) {
        return new StudentRepImpl().addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return new StudentRepImpl().updateStudent(student);
    }

    @Override
    public boolean deleteStudent(Integer studentId) {
        return new StudentRepImpl().deleteStudent(studentId);
    }

    @Override
    public List<Student> findByStudentName(String studentName) {
        return new StudentRepImpl().findByStudentName(studentName);
    }
}
