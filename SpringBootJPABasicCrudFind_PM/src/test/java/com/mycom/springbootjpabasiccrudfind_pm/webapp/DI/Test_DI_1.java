package com.mycom.springbootjpabasiccrudfind_pm.webapp.DI;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerCrud;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerFind;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.PhoneRepository;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceCrud;
import com.mycom.springbootjpabasiccrudfind_pm.User.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
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

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class Test_DI_1 {
    // #1 MVC 기본 컴퓨넌트 DI 확인
    @Autowired
    PhoneControllerCrud phoneControllerCrud;
    @Autowired
    PhoneControllerFind phoneControllerFind;
    @Autowired
    PhoneServiceCrud phoneServiceCrud;
    @Autowired
    PhoneRepository phoneRepository;

    @Test
    @Order(0)
    void testDI() {
        log.debug("Test DI() 시작");
        assertNotNull(phoneControllerCrud);
        assertNotNull(phoneControllerFind);
        assertNotNull(phoneServiceCrud);
        assertNotNull(phoneRepository);
        log.debug("Test DI() 시작");
    }

    @Test
    @Order(1)
    void testDI_ALL() {
        log.debug("Test DI() 시작");
        assertAll(
            () -> assertNotNull(phoneControllerCrud),
            () -> assertNotNull(phoneControllerFind),
            () -> assertNotNull(phoneServiceCrud),
            () -> assertNotNull(phoneRepository)
        );
        log.debug("Test DI() 시작");
    }

    // #2 HTTP 관련 객체 테스트
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @Test
    @Order(2)
    void testDI_SessionRequest() {
        assertNotNull(session);
        assertNotNull(request);
    }

    // #3 JPA 영역
    @Autowired
    EntityManager entityManager;

    @Test
    @Order(3)
    void testDI_EntityManager(){
        User user = entityManager.find(User.class, 1);
        assertNotNull(user);
    }
}
