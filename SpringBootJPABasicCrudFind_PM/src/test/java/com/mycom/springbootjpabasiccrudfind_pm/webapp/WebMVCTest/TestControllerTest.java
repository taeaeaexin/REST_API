package com.mycom.springbootjpabasiccrudfind_pm.webapp.WebMVCTest;

import com.mycom.springbootjpabasiccrudfind_pm.Phone.Controller.PhoneControllerCrud;
import com.mycom.springbootjpabasiccrudfind_pm.Phone.Service.PhoneServiceCrud;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PhoneControllerCrud.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PhoneServiceCrud phoneServiceCrud;

    // #1
    @Test
    @Order(1)
    public void testHello() throws Exception {
        this.mockMvc.perform(get("/api/phones"))
                .andExpect(status().isOk());
    }
}
