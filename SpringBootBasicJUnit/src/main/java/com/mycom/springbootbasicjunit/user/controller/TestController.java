package com.mycom.springbootbasicjunit.user.controller;

import com.mycom.springbootbasicjunit.user.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    // #1
    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }

    // #2
    @PostMapping("/param1")
    public void param1(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name
    ) {
         log.info("param1");
         log.info("id : "+id+" name : "+name);
    }

    // #3
    @PostMapping("/param2")
    public void param2(TestDto testDto) {
        log.info("param2");
        log.info("id : "+testDto.getId()+" name : "+testDto.getName());
    }

    // #4
    @PostMapping("/response1")
    public String response1(TestDto testDto) {
        log.info("response1");
        log.info("id : "+testDto.getId()+" name : "+testDto.getName());
        return "success";
    }
}