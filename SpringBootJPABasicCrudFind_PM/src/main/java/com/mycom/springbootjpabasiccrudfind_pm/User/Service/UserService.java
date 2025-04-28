package com.mycom.springbootjpabasiccrudfind_pm.User.Service;

import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserResultDto;

public interface UserService {
    UserResultDto register(UserDto userDto);
    UserResultDto login(String email, String password);
}