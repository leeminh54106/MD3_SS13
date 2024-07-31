package com.example.baitap_1.service;

import com.example.baitap_1.model.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> findAll();
    Classes findById(String classId);
    boolean addClass(Classes classes);
    boolean updateClass(Classes classes);
    boolean deleteClass(String classId);
    List<Classes> findClassByName(String className);
}
