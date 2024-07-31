package com.example.baitap_1.service.impl;

import com.example.baitap_1.model.Classes;
import com.example.baitap_1.repository.impl.ClassRepImpl;
import com.example.baitap_1.service.ClassesService;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {
    @Override
    public List<Classes> findAll() {
        return new ClassRepImpl().findAll();
    }

    @Override
    public Classes findById(String classId) {
        return new ClassRepImpl().findById(classId);
    }

    @Override
    public boolean addClass(Classes classes) {
        return new ClassRepImpl().addClass(classes);
    }

    @Override
    public boolean updateClass(Classes classes) {
        return new ClassRepImpl().updateClass(classes);
    }

    @Override
    public boolean deleteClass(String classId) {
        return new ClassRepImpl().deleteClass(classId);
    }

    @Override
    public List<Classes> findClassByName(String className) {
        return new ClassRepImpl().findClassByName(className);
    }
}
