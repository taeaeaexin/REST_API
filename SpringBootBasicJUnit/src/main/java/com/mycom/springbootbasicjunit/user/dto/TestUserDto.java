package com.mycom.springbootbasicjunit.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestUserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<String> phone;
}