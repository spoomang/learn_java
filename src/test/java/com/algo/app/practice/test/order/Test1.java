package com.algo.app.practice.test.order;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// annotation 1
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test1 {

    static StringBuilder test = new StringBuilder("");

    @Test
    @Order(1)
    public void hack(){
        test.append("hack");
    }

    @Test
    @Order(3)
    public void rank(){
        test.append("rank");
    }

    @Test
    @Order(2)
    public void er(){
        test.append("er");


    }

    @AfterAll
    public static void ding() {
        assertEquals("hackerrank",test.toString());
    }
}
