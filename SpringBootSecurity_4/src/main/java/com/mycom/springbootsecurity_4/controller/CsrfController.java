package com.mycom.springbootsecurity_4.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// login.html window.onload event에서 이 token 값을 요청
@RestController
public class CsrfController {

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(CsrfToken token){
        return token;
    }
}
