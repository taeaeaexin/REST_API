package com.mycom.springbootjpabasiccrudfind_pm.User.Controller;

import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public UserResultDto login(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        return userService.login(email, password);
    }
}
