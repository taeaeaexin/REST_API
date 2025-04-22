package com.mycom.myapp.controller;

import com.mycom.myapp.entity.Student;
import com.mycom.myapp.service.StudentServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentControllerCrud {
    private final StudentServiceCrud studentServiceCrud;

    @GetMapping("/list")
    public List<Student> listStudent() {
        return studentServiceCrud.listStudent();
    }

    @GetMapping("/detail/{id}")
    public Optional<Student> detailStudent(@PathVariable("id") Integer id) {
        return studentServiceCrud.detailStudent(id);
    }

    @PostMapping("/insert")
    public Student insertStudent(Student student) {
        return studentServiceCrud.insertStudent(student);
    }

    @PostMapping("/update")
    public Optional<Student> updateStudent(Student student) {
        return studentServiceCrud.updateStudent(student);
    }

    @GetMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentServiceCrud.deleteStudent(id);
    }

    @GetMapping("/count")
    public long countStudent() {
        return studentServiceCrud.countStudent();
    }

    @GetMapping("/page")
    public List<Student> listStudent(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return studentServiceCrud.listStudent(pageNumber, pageSize);
    }
}