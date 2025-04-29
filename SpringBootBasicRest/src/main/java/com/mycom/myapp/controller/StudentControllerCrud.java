package com.mycom.myapp.controller;

import com.mycom.myapp.dto.StudentDto;
import com.mycom.myapp.dto.StudentResultDto;
import com.mycom.myapp.entity.Student;
import com.mycom.myapp.service.StudentServiceCrud;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//Rest를 적용하면 .api
// get list : /students
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

@Tag(name="기본 Student CRUD API", description = "Student의 등록, 수정, 삭제, 목록 조회, 상세 조회 기능을 REST API로 제공합니다")
public class StudentControllerCrud {
    private final StudentServiceCrud studentServiceCrud;

    @GetMapping("/students")
    public StudentResultDto listStudent() {
        return studentServiceCrud.listStudent();
    }

    @GetMapping("/students/{id}")
    public StudentResultDto detailStudent(@PathVariable("id") Integer id) {
        return studentServiceCrud.detailStudent(id);
    }

    @PostMapping("/students")
    public StudentResultDto insertStudent(StudentDto studentDto) {
        return studentServiceCrud.insertStudent(studentDto);
    }

    @PutMapping("/students/{id}")
    public StudentResultDto updateStudent(@PathVariable("id") Integer id, StudentDto studentDto) {
        studentDto.setId(id);
        return studentServiceCrud.updateStudent(studentDto);
    }

    @DeleteMapping("/students/{id}")
    public StudentResultDto deleteStudent(@PathVariable("id") Integer id) {
        return studentServiceCrud.deleteStudent(id);
    }

    @GetMapping("/students/count")
    public StudentResultDto countStudent() {
        return studentServiceCrud.countStudent();
    }

    @GetMapping("/students/page")
    public StudentResultDto listStudent(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return studentServiceCrud.listStudent(pageNumber, pageSize);
    }
}