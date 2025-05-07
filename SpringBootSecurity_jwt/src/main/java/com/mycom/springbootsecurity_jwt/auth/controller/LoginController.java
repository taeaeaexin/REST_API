package com.mycom.springbootsecurity_jwt.auth.controller;

import com.mycom.springbootsecurity_jwt.auth.dto.LoginResultDto;
import com.mycom.springbootsecurity_jwt.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginServcie;

    @PostMapping("/login")
    public LoginResultDto login(@RequestBody Map<String, String> loginData) {
        return loginServcie.login(loginData.get("username"), loginData.get("password"));
    }
}
