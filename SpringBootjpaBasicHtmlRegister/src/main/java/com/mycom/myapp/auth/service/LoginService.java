package com.mycom.myapp.auth.service;

import com.mycom.myapp.user.dto.UserResultDto;

public interface LoginService {
    UserResultDto login(String email, String password);
}
