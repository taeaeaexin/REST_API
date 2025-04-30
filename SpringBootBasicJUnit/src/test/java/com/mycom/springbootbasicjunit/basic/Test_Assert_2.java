package com.mycom.springbootbasicjunit.basic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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

    int m1() {return 1;};
    boolean m2() {return true;};
    String m3() {return "hello";};
    @Test
    @Order(2)
    void testAssertAll() {
        assertAll(
                "묶음 테스트",
                () -> assertEquals(4, m1()),
                () -> assertTrue(m2()),
                () -> assertNotNull(m3())
        );
    }

    // array, collection
    int[] expectedArray = {1,2,3};
    int[] actualArray = {1,2,3};

    @Test
    @Order(3)
    void testAssertArrayEquals(){
        assertArrayEquals(expectedArray, actualArray, "두 배열은 같아야 한다");
    }

    List<String> expectedList = Arrays.asList("aaa", "bbb", "ccc");
    List<String> actualList = Arrays.asList("aaa", "bbb", "ccc");

    @Test
    @Order(4)
    void testAssertIterableEquals(){
        assertIterableEquals(expectedList, actualList, "두 컬렉션은 같아야 한다");
    }

    // MyClass 의 equals() & hashcode가 없으면 실패
    List<MyClass> expectedList2 = Arrays.asList(new MyClass(), new MyClass(), new MyClass());
    List<MyClass> actualList2 = Arrays.asList(new MyClass(), new MyClass(), new MyClass());

    @Test
    @Order(5)
    void testAssertIterableEquals2(){
        assertIterableEquals(expectedList2, actualList2, "두 컬렉션은 같아야 한다");
    }
    
    // equals000() 객체의 경우 필드 비교 일반적, 만약 주소참조값을 비교

    @Test
    @Order(6)
    void testAssertSame(){
        String str1 = "JUnit";
        String str2 = str1;
        String str3 = "Junit";
        assertSame(str1, str3, "두 변수는 같은 객체를 가리킨다");
    }

    @Test
    @Order(7)
    void testAssertNotSame(){
        String str1 = "JUnit";
        String str2 = new String("JUnit");
        String str3 = "JUnit";
        assertNotSame(str1, str3, "두 변수는 같은 객체를 가리킨다");
    }

    void myFunc() {
        try{
            Thread.sleep(500); // 0.5ch
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(8)
    void testAssertTimeout() {
            assertTimeout(
                    Duration.ofSeconds(1L),
                    () -> {
                        myFunc();
                    },
                    "myFunc는 0.5초 이내로 수행되어야 한다."
            );
    }

}
