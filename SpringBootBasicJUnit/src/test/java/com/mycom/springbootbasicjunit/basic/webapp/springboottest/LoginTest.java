package com.mycom.springbootbasicjunit.basic.webapp.springboottest;

import com.mycom.springbootbasicjunit.auth.controller.LoginController;
import com.mycom.springbootbasicjunit.auth.service.LoginService;
import com.mycom.springbootbasicjunit.user.dto.UserResultDto;
import com.mycom.springbootbasicjunit.user.entity.User;
import com.mycom.springbootbasicjunit.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
//    @Autowired
//    private MockMvc mockMvc;

    // Controller
    @Autowired
    private LoginController loginController;

    @Autowired
    private HttpSession httpSession;

    @Test
    public void testLogin() {
        UserResultDto userResultDto =
                loginController.login("user1@mycom.com", "password1", httpSession);
        assertEquals("success", userResultDto.getResult());
    }

    // Service
    @Autowired
    private LoginService loginService;

    @Test
    public void testLogin2() {
        UserResultDto userResultDto = loginService.login("user1@mycom.com", "password1");
        assertEquals("success", userResultDto.getResult());
        assertNotNull(userResultDto.getUserDto());
    }

    // Repository
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testLogin3(){
        Optional<User> optionalUser = userRepository.findByEmail("user@mycom.com");
    }
}