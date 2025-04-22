package com.mycom.myapp.controller;

import com.mycom.myapp.entity.Student;
import com.mycom.myapp.service.StudentServiceFind;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentControllerFind {

    private final StudentServiceFind studentServiceFind;

    @GetMapping("/find/by-name")
    public List<Student> findByName(@RequestParam("name") String name) {
        return studentServiceFind.findByName(name);
    }

    @GetMapping("/find/by-name-like")
    public List<Student> findByNameLike(@RequestParam("name") String name) {
        return studentServiceFind.findByNameLike(name);
    }

    @GetMapping("/find/by-email-and-phone")
    public List<Student> findByEmailAndPhone(
            @RequestParam("email") String email,
            @RequestParam("phone") String phone) {
        return studentServiceFind.findByEmailAndPhone(email, phone);
    }

    @GetMapping("/find/by-email-or-phone")
    public List<Student> findByEmailOrPhone(
            @RequestParam("email") String email,
            @RequestParam("phone") String phone) {
        return studentServiceFind.findByEmailOrPhone(email, phone);
    }
}
