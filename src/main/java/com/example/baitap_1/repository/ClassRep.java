package com.example.baitap_1.repository;

import com.example.baitap_1.model.Classes;

import java.util.List;

public interface ClassRep {
    List<Classes> findAll();
    Classes findById(String classId);
    boolean addClass(Classes classes);
    boolean updateClass(Classes classes);
    boolean deleteClass(String classId);
    List<Classes> findClassByName(String className);
}
