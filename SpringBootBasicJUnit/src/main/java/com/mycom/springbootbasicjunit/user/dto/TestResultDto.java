package com.mycom.springbootbasicjunit.user.dto;

import lombok.Data;

@Data
public class TestResultDto {
    private String result;
    private Long count;
    private TestUserDto testUserDto;
}
