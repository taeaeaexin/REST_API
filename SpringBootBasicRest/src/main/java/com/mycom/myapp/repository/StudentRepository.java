package com.mycom.myapp.repository;

import com.mycom.myapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    List<Student> findByEmailAndPhone(String email, String phone);
    List<Student> findByEmailOrPhone(String email, String phone);
    List<Student> findByNameLike(String name);
}
