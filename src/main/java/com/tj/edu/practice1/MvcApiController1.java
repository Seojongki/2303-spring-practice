package com.tj.edu.practice1;

import org.springframework.web.bind.annotation.*;


@RestController
public class MvcApiController1 {

//    @RequestMapping("/test1")
    @GetMapping("/test1")
    public String test1(){
        return "test1388888883";
    }

    @PostMapping(value="/post-test1")
    public String postTest1() {
        return """
                {
                    "name":"홍길동",
                    "birth": "1990-12-12"
                }
                """;
    }

    @PutMapping(value = "/put-test1")
    public String putTest1() {
        return "put은 업데이트 http 메소드 입니다.";
    }

    @DeleteMapping(value="/delete-test1")
    public String deleteTest1(){
        return "Delete http 메소드입니다";
    }

}
