package com.mycom.springbootjpabasiccrudfind_pm.User.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResultDto register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    @PostMapping("/login")
    public UserResultDto login(@RequestBody UserDto userDto) {
        return userService.login(userDto.getEmail(), userDto.getPassword());
    }
}
