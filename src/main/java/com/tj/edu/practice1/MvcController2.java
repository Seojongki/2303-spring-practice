package com.tj.edu.practice1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController2 {
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
}
