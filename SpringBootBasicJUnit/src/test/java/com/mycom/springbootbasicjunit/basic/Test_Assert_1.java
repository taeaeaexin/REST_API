package com.mycom.springbootbasicjunit.basic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

// assert000 메소드를 통해서 판단 (같다 다르다 null, !null 등등 .. )
// assert000 메소드의 테스트가 실패하면 세 번째 message가 Failure Trace에 보이게 된다
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Assert_1 {
    @Test
    @Order(1)
    void testAssertEquals(){
        int legacyNum = LegacySystem.getNum();
        int testNum = TestSystem.getNum();
        assertEquals(legacyNum, testNum, "Legacy와 Test 비교");
    }

    @Test
    @Order(2)
    void testAssertNotEquals(){
        int legacyNum = 2;
        int testNum = 3;
        assertNotEquals(legacyNum, testNum, "Legacy와 Test 비교");
    }

    @Test
    @Order(3)
    void testAssertEqualsObject(){
        // MyClass에 equals(), hashcode() 재정의 하지 않으면 실패, 재정의 후에는 성공
        MyClass mc = new MyClass();
        MyClass mc2 = new MyClass();
        assertNotEquals(mc, mc2, "mc와 mc2 비교");
    }

    @Test
    @Order(4)
    void testAssertTrue(){
        // MyClass에 equals(), hashcode() 재정의 하지 않으면 실패, 재정의 후에는 성공
        MyClass mc = new MyClass();
        assertTrue(mc.getResult(), "mc.getResult()의 결과가 true 여야 함");
    }

    @Test
    @Order(5)
    void testAssertFalse(){
        // MyClass에 equals(), hashcode() 재정의 하지 않으면 실패, 재정의 후에는 성공
        MyClass mc = new MyClass();
        assertFalse(mc.getResult(), "mc.getResult()의 결과가 false 여야 함");
    }

    @Test
    @Order(6)
    void testAssertNull(){
        // MyClass에 equals(), hashcode() 재정의 하지 않으면 실패, 재정의 후에는 성공
        MyClass mc = new MyClass();
        assertNull(mc.getString(), "mc.getString()의 결과가 null 여야 함");
    }

    @Test
    @Order(6)
    void testAssertNotNull(){
        // MyClass에 equals(), hashcode() 재정의 하지 않으면 실패, 재정의 후에는 성공
        MyClass mc = new MyClass();
        assertNotNull(mc.getString(), "mc.getString()의 결과가 null 여야 함");
    }
}
