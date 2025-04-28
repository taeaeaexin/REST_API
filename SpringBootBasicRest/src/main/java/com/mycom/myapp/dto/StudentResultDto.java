package com.mycom.myapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentResultDto {
    private String result;
    private StudentDto studentDto;
    private List<StudentDto> studentList;
    private Long count;
}