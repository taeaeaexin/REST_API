package com.mycom.springbootsecurity_4.user.controller;

import com.mycom.springbootsecurity_4.user.dto.UserDto;
import com.mycom.springbootsecurity_4.user.dto.UserResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final com.mycom.springbootsecurity_4.service.UserService userService;

    @PostMapping("/register")
    public UserResultDto insertUser(@ModelAttribute UserDto userDto){
        return userService.insertUser(userDto);
    }
}
