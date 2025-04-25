package com.mycom.myapp.auth.controller;

import com.mycom.myapp.auth.service.LoginService;
import com.mycom.myapp.user.dto.UserResultDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public UserResultDto login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session
            ){
        UserResultDto userResultDto = loginService.login(email, password);
        if(userResultDto.getResult().equals("sucess")){
            session.setAttribute("userDto", userResultDto.getUserDto());
        }
        return userResultDto;
    }

    @GetMapping("/logout")
    public UserResultDto logout(HttpSession session) {
        UserResultDto userResultDto = new UserResultDto();

        session.invalidate();
        userResultDto.setResult("success");

        return userResultDto;
    }
}
