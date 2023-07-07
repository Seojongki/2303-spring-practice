package com.tj.edu.practice1;

import org.junit.jupiter.api.*;

public class JUnitCycleTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll이 실행됨");
    }


    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach이 실행됨");
    }

    @Test
    public void test1(){
        System.out.println("Test1이 실행됨");
    }

    @Test
    public void test2(){
        System.out.println("Test2이 실행됨");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@afterAll이 실행됨");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@afterEach가 실행됨");
    }


}
