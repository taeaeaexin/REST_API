package com.mycom.springbootsecurity_4.user.dto;

import lombok.Data;

import java.util.List;

@Data
// @Builder 없다
public class UserResultDto {
    private String result;
    private UserDto userDto;
    private List<UserDto> userList;
}