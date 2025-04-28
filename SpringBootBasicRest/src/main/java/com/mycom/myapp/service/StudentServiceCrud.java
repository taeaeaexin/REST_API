package com.mycom.myapp.service;

import com.mycom.myapp.dto.StudentResultDto;
import com.mycom.myapp.entity.Student;

public interface StudentServiceCrud {

    StudentResultDto listStudent();
    StudentResultDto detailStudent(int id);

    StudentResultDto insertStudent(Student student); // jpa를 통해서 table에 insert 하고 영속화 시킨 객체를 return
    StudentResultDto updateStudent(Student student);
    StudentResultDto deleteStudent(int id);

    StudentResultDto countStudent();
    StudentResultDto listStudent(int pageNumber, int pageSize);
}