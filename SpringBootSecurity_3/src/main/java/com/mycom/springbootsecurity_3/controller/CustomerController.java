package com.mycom.springbootsecurity_3.controller;

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
