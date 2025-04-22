package com.mycom.myapp.service;

import com.mycom.myapp.entity.Student;

import java.util.List;

public interface StudentServiceFind {
    List<Student> findByName(String name);
    List<Student> findByEmailAndPhone(String email, String phone);
    List<Student> findByEmailOrPhone(String email, String phone);
    List<Student> findByNameLike(String name);
}
