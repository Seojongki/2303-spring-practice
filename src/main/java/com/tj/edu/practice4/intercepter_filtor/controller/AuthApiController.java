package com.tj.edu.practice4.intercepter_filtor.controller;


import com.tj.edu.practice4.intercepter_filtor.annotations.AuthUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authapi")
@AuthUser
public class AuthApiController {
    @GetMapping("/get")
    public String get(){
        return "authapi/get호출";
    }
}
