package com.tj.edu.practice5.lombok;

import com.tj.edu.practice5.lombok.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LombokTestApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Lombok Test ")
    @Test
    void lombokTest(){
        User user = new User();
        user.setName("홍길동");
        user.setEmail("jildong@gmail.com");

        User user2 = new User("이순신", "test@naver.com", LocalDateTime.now(), LocalDateTime.now());

        System.out.println(user2.getName());
        System.out.println(user2.getEmail());


    }

    @AfterEach
    void tearDown() {
    }

}