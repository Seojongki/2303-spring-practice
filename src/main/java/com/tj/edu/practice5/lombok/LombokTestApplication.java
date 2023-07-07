package com.tj.edu.practice5.lombok;

import com.tj.edu.practice5.lombok.model.User;

import java.time.LocalDateTime;

public class LombokTestApplication {
    public static void main(String[] args) {
        User user = new User();
        user.setName("홍길동");
        user.setEmail("gildong@gmail.com");


        User user2 = new User("이순신", "test@naver.com", LocalDateTime.now(), LocalDateTime.now());

        System.out.println(user.getName());
        System.out.println(user.getEmail());





    }
}
