package com.mycom.springbootbasicjunit.basic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

// assert000 메소드를 통해서 판단 (같다 다르다 null, !null 등등 .. )
// assert000 메소드의 테스트가 실패하면 세 번째 message가 Failure Trace에 보이게 된다
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Assert_2 {
    @Test
    @Order(1)
    void testAssertTrhows(){
        MyClass mc = new MyClass();
//        String str = "hello";
        String str = null;

        assertThrows(
                NullPointerException.class,
                () -> mc.getStringLength(str),
                "mc.getStringLength()는 NullPointException을 발생시켜야 함"
        );
    }
}
