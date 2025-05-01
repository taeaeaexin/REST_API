package com.mycom.springbootbasiclogging.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;

//    public StudentDto(){}
//    public StudentDto(int id, String name, String email, String phone) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//    }
}