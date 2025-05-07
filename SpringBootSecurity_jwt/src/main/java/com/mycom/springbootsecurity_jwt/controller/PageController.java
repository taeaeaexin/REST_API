package com.mycom.springbootsecurity_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/board")
    public String board() {
        return "/board.html";
    }

    @GetMapping("/register")
    public String register() {
        return "/register.html";
    }

    @GetMapping("/login")
    public String login() {
        return "/login.html";
    }
}
