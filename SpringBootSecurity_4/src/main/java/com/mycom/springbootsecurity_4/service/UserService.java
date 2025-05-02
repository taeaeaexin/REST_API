package com.mycom.springbootsecurity_4.service;

import com.mycom.springbootsecurity_4.user.dto.UserDto;
import com.mycom.springbootsecurity_4.user.dto.UserResultDto;

public interface UserService {
    UserResultDto insertUser(UserDto userDto);
}