package com.mycom.springbootbasicjunit.basic.webapp.di;

import com.mycom.springbootbasicjunit.auth.service.UserService;
import com.mycom.springbootbasicjunit.user.controller.UserController;
import com.mycom.springbootbasicjunit.user.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// Spring Context 전체를 이용한 Test
//  @SpringBootTest
//  무겁다
//  전체 Cover
// Spring Web을 이용한 Test
//  @WebMvcTest (JPA Context 등 사용 X)
//  가볍다
//  Web cover

// DI 테스트
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_DI_1 {

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(0)
    void testDi() {
        assertNotNull(userController);
        assertNotNull(userService);
        assertNotNull(userRepository);
    }
}