package com.tj.edu.practice4.aop.controller;


import com.tj.edu.practice4.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/user/{id}")
    public String user(@PathVariable(name = "id") String id, @RequestParam(required = false, defaultValue = "이순신") String name) {
        System.out.println("id: "+ id);
        System.out.println("name: " + name);
        return id + " / " + name;
    }

    @PostMapping("/user")
    public User user(User user) {
        return user;
    }
}
