package com.mycom.springbootsecurity_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/board")
    public String board() {
        return "/board.html";
    }
}
