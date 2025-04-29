package com.mycom.myapp.controller;

import com.mycom.myapp.dto.StudentDto;
import com.mycom.myapp.dto.StudentResultDto;
import com.mycom.myapp.service.StudentServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// ResponseEntity만 사용
//  1.ResultDto 사용 X, 대신 예외 처리로 오류 파악, 이를 통해서 ResponseEntity의 응답 코드 결정
// ResponseEntity + ResultDto 함께 사용
//  1. ResultDto를 Client에게 전달, Client가 Server의 작업 결과를 ResultDto를 통해서 처리
//  2. ResultDto를 Client에게 전달 X, 대신 Controller에서 Service에서 return한 ResultDto 객체를 이용해서
//     ResponseEntity의 응답코드를 결정
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/json/re")
public class StudentControllerCrudJsonRequestRE {
    private final StudentServiceCrud studentServiceCrud;

    @GetMapping("/students")
    public ResponseEntity<StudentResultDto> listStudent() {
        StudentResultDto studentResultDto = studentServiceCrud.listStudent();
        // ResponseEntity + ResultDto 함께 사용 #1
//        return new ResponseEntity<StudentResultDto>(studentResultDto, HttpStatus.OK);

        // 500 error로 status 코드 보내도, body에 data가 있으면 브라우저에서 예외 처리 X
//        return new ResponseEntity<StudentResultDto>(studentResultDto, HttpStatus.INTERNAL_SERVER_ERROR);

        // 500 error로 status 코드 보내도, body에 data X -> try-catch에서 예외 발생
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // error

        // 200 error로 status 코드 보내도, body에 data X -> try-catch에서 예외 발생
//        return new ResponseEntity<>(null, HttpStatus.OK); // error

        // ResponseEntity 객체를 생성, return 하는 다른 표현
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(studentResultDto);

        return ResponseEntity
                .notFound()
//                .body(studentResultDto); // body() 오류 <- body를 채우면 client 오류 처리 X
                .build(); // body 없이 마무리
    }

    @GetMapping("/students/{id}")
    public StudentResultDto detailStudent(@PathVariable("id") Integer id) {
        return studentServiceCrud.detailStudent(id);
    }

    // 등록, 수정에 사용되는 StudentDto를 Client에서 JSON으로 보낸다
    @PostMapping("/students")
    public StudentResultDto insertStudent(@RequestBody StudentDto studentDto) {
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