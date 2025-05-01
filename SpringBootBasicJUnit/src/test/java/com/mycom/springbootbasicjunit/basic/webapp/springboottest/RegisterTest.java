package com.mycom.springbootbasicjunit.basic.webapp.springboottest;

import com.mycom.springbootbasicjunit.auth.service.UserService;
import com.mycom.springbootbasicjunit.user.controller.UserController;
import com.mycom.springbootbasicjunit.user.dto.UserResultDto;
import com.mycom.springbootbasicjunit.user.entity.User;
import com.mycom.springbootbasicjunit.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterTest {
//    @Autowired
//    private MockMvc mockMvc;

    // 개발 순서
    // Repository -> Service -> Controller
    // 초기 설계를 마무리한 상태에서 실제 coding 순서

    // userRepository test는 User Entity만 saver
    // insert into user (email,name,password) values

//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    @Transactional //자동 rollback
//    public void testRegister() {
//        User user = new User();
//        user.setName("문태신");
//        user.setEmail("ts@ts.com");
//        user.setPassword("0206");
//
//        User savedUser = userRepository.save(user);
//        assertNotNull(savedUser);
//    }
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    @Transactional //자동 rollback
//    public void testRegister2() {
//        User user = new User();
//        user.setName("문태신");
//        user.setEmail("ts@ts.com");
//        user.setPassword("0206");
//
//        UserResultDto userResultDto = userService.insertUser(user);
//        assertEquals("sueccess", userResultDto.getResult());
//    }

//    @Autowired
//    private UserController userController;
//
//    @Test
//    @Transactional
//    public void testRegister3(){
//        User user = new User();
//        user.setName("문태신");
//        user.setEmail("ts@ts.com");
//        user.setPassword("0206");
//        UserResultDto userResultDto = userController.insertUser(user);
//        assertEquals("success", userResultDto.getResult());
//    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void testRegister4() throws Exception {
        this.mockMvc.perform(
                post("/users/register")
                        .param("name","문태신")
                        .param("email","ts@ts.com")
                        .param("password", "0206")
        )
                .andExpect(status().isOk());
    }

}