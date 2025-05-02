package com.mycom.springbootsecurity_1.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Customer!";
    }
}
