package com.mycom.myapp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mycom.myapp.dto.StudentDto;
import com.mycom.myapp.dto.StudentResultDto;
import com.mycom.myapp.service.StudentServiceCrud;
import lombok.RequiredArgsConstructor;
// ResponseEntity 만 사용
//    1. ResultDto 사용 X, 대신 예외 처리로 오류 파악, 이를 통해서 ResponseEntity 의 응답코드를 결정
// ResponseEntity + ResultDto 함께 사용
//    #1. ResultDto 를 Client 에게 전달, Client 가 Server 의 작업 결과를 ResultDto 를 통해서 처리
//    #2. ResultDTo 를 Client 에게 전달 사용 X, 대신 Controller 에서 Service 에서 return 한 ResultDto 객체를 이용해서
//       ResponseEntity 의 응답코드를 결정
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/json/re")
public class StudentControllerCrudJsonRequestRE {
    private final StudentServiceCrud studentServiceCrud;

    @GetMapping("/students")
    public ResponseEntity<StudentResultDto> listStudent(){
        StudentResultDto studentResultDto =  studentServiceCrud.listStudent();
        // ResponseEntity + ResultDto 함께 사용 의 #1
        // 오류 없으면 ResultDto body 추가, 200
        // 오류 있으면 ResultDto bodyx 추가 X, 에러 코드
        // client 는 try-catch

//      return new ResponseEntity<StudentResultDto>(studentResultDto, HttpStatus.OK);

        // 500 에러로 status 코드를 보내도, body에 데이터가 있으면 브라우저에서 예외 처리 X
//      return new ResponseEntity<StudentResultDto>(studentResultDto, HttpStatus.INTERNAL_SERVER_ERROR);

        // 500 에러로 status 코드를 보내도, body에 데이터 X -> try-catch 에서 에외 발생
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        // 200 OK 로 status 코드를 보내도, body에 데이터 X -> try-catch 에서 에외 발생
//      return new ResponseEntity<>(null, HttpStatus.OK);

        // ResponseEntity 객체를 생성, 리턴하는 다른 표현
//      return ResponseEntity
//              .status(HttpStatus.OK) // .status(HttpStatus.NOT_FOUNT) .....
//              .body(studentResultDto);

        return ResponseEntity
                .ok()
                .body(studentResultDto);

//      return ResponseEntity
//              .notFound()
////                .body(studentResultDto);        // body() 오류 <- body 를 채우면 client 오류 처리 X
//              .build();  // body 없이 마무리
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResultDto> detailStudent(@PathVariable("id") Integer id){

        // ResponseEntity + ResultDto 함께 사용 의 #2
        // Service 의 리턴인 ResultDto 의 result 값을 확인하고 그에 맞는 ResponseEntity 객체 생성, client 전달

        StudentResultDto studentResultDto = studentServiceCrud.detailStudent(id);
        switch( studentResultDto.getResult() ) {
            case "success" : return ResponseEntity.ok().body(studentResultDto);
            case "notfound" : return ResponseEntity.notFound().build();
            case "fail" : return ResponseEntity.internalServerError().build();
            default : return ResponseEntity.internalServerError().build();
        }

//      return ResponseEntity
//              .notFound()
//              .build();  // body 없이 마무리

//      return ResponseEntity
//              .internalServerError()
//              .build();  // body 없이 마무리

//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 등록, 수정에 사용되는 StudentDto 를 Client 에서 JSON 으로 보낸다.
    @PostMapping("/students")
    public StudentResultDto insertStudent(@RequestBody StudentDto studentDto) {
        return studentServiceCrud.insertStudent(studentDto);
    }

    @PutMapping("/students/{id}")
    public StudentResultDto updateStudent(@PathVariable("id") Integer id, @RequestBody StudentDto studentDto){
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
            @RequestParam("pageNumber") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize) {
        return studentServiceCrud.listStudent(pageNumber, pageSize);
    }
}