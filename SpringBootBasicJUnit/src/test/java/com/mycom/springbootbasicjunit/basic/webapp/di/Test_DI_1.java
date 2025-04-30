package com.mycom.springbootbasicjunit.basic.webapp.di;

import com.mycom.springbootbasicjunit.auth.service.UserService;
import com.mycom.springbootbasicjunit.user.controller.UserController;
import com.mycom.springbootbasicjunit.user.entity.User;
import com.mycom.springbootbasicjunit.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
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
@Slf4j
public class Test_DI_1 {

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(0)
    void testDI() {
        log.debug("testDI() 시작");
        assertNotNull(userController);
        assertNotNull(userService);
        assertNotNull(userRepository);
        log.debug("testDI() 종료");
    }

    @Test
    @Order(1)
    void testDI_ALL() {
        log.debug("testDI() 시작");

        assertAll(
                "DI 묶음 테스트",
                () -> assertNotNull(userController),
                () -> assertNotNull(userService),
                () -> assertNotNull(userRepository)
        );
        log.debug("testDI() 종료");
    }

    @Autowired
    HttpSession session;

    @Autowired
    HttpServlet request;

    @Test
    @Order(2)
    void testDI_SessionRequest() {
        log.debug("testDI() 시작");
        assertNotNull(session);
        assertNotNull(request);
        log.debug("testDI() 종료");
    }

    // jpa 영역
    @Autowired
    EntityManager entityManager;

    @Test
    @Order(3)
    void testDI_EntityManager(){
        log.debug("testDI_EntityManager() 시작");
        assertNotNull(entityManager);
        User user = entityManager.find(User.class, 1);
        assertNotNull(user);
        log.debug("testDI() 종료");
    }
}