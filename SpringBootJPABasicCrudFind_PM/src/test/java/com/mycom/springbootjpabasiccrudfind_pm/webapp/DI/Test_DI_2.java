package com.mycom.springbootjpabasiccrudfind_pm.webapp.DI;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerCrud;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerFind;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Entity.Phone;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.PhoneRepository;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceFind;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(PhoneControllerCrud.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class Test_DI_2 {
    @MockitoBean
    PhoneControllerFind phoneControllerFind;

    @MockitoBean
    PhoneServiceFind phoneServiceFind;

    @MockitoBean
    PhoneRepository phoneRepository;

    @Test
    @Order(0)
    void testDI() {
        log.debug("testDI() 시작");
        assertNotNull(phoneControllerFind);
        assertNotNull(phoneServiceFind);
        assertNotNull(phoneRepository);
        log.debug("testDI() 종료");
    }

    @Test
    @Order(1)
    void testDI_ALL() {
        log.debug("testDI() 시작");

        assertAll(
                "DI 묶음 테스트",
                () -> assertNotNull(phoneControllerFind),
                () -> assertNotNull(phoneServiceFind),
                () -> assertNotNull(phoneRepository)
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
    @Order(4)
    void testDI_EntityManager(){
        log.debug("testDI_EntityManager() 시작");
        assertNotNull(entityManager);
        Phone phone = entityManager.find(Phone.class, 1);
        assertNotNull(phone);
        log.debug("testDI() 종료");
    }
}