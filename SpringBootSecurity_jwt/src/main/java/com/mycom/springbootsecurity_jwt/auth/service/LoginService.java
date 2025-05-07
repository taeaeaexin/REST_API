package com.mycom.springbootsecurity_jwt.auth.service;

import com.mycom.springbootsecurity_jwt.auth.dto.LoginResultDto;

public interface LoginService {
    LoginResultDto login(String email, String password);
}
