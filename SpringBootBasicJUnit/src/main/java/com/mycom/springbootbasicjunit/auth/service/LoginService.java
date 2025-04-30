package com.mycom.springbootbasicjunit.auth.service;

import com.mycom.springbootbasicjunit.user.dto.UserResultDto;

public interface LoginService {
    UserResultDto login(String email, String password);
}
