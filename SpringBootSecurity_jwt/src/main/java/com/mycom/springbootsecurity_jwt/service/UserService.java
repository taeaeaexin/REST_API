package com.mycom.springbootsecurity_jwt.service;


import com.mycom.springbootsecurity_jwt.user.dto.UserDto;
import com.mycom.springbootsecurity_jwt.user.dto.UserResultDto;

public interface UserService {
    UserResultDto insertUser(UserDto userDto);
}