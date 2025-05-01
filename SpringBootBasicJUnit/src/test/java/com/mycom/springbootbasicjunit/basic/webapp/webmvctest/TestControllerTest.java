package com.mycom.springbootbasicjunit.basic.webapp.webmvctest;

import com.mycom.springbootbasicjunit.user.controller.TestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TestController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // #1
    @Test
    @Order(1)
    public void testHello() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }

    // #2
    @Test
    @Order(2)
    public void testParam1() throws Exception{
        this.mockMvc.perform(
                post("/param1")
                    .param("id", "111")
                    .param("name", "홍길동")
                )
                .andExpect(status().isOk());
    }

    // #3
    @Test
    @Order(3)
    public void testParam2() throws Exception{
        this.mockMvc.perform(
                post("/param2")
                        .param("id", "111")
                        .param("name", "홍길동")
            )
            .andExpect(status().isOk());
    }

    // #4
    @Test
    @Order(4)
    public void testResponse1() throws Exception{
        this.mockMvc.perform(
                        post("/response1")
                                .param("id", "111")
                                .param("name", "홍길동")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    // #5
    @Test
    @Order(5)
    public void testResponse2() throws Exception{
        this.mockMvc.perform(
                        post("/response2")
                                .param("id", "111")
                                .param("name", "홍길동")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // #6
    @Test
    @Order(6)
    public void testResponse3() throws Exception{
        this.mockMvc.perform(
                        post("/response3")
                                .param("id", "111")
                                .param("name", "홍길동")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("success"));
    }

    // #7
    @Test
    @Order(7)
    public void testResponse4() throws Exception{
        this.mockMvc.perform(
                        post("/response4")
                                .param("id", "111")
                                .param("name", "홍길동")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("success"))
                .andExpect(jsonPath("$.count").isEmpty())
                .andExpect(jsonPath("$.testUserDto.email").value("ts@ts.com"))
                .andExpect(jsonPath("$.testUserDto.phone").isArray());
    }
}