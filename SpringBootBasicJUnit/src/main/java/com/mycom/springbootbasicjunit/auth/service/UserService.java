package com.mycom.springbootbasicjunit.auth.service;

import com.mycom.springbootbasicjunit.user.dto.UserResultDto;
import com.mycom.springbootbasicjunit.user.entity.User;

public interface UserService {
    UserResultDto insertUser(User user);
}
