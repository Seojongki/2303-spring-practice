package com.tj.edu.practice3.spring_exception.controller;


import com.tj.edu.practice3.spring_exception.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Validated
public class ApiController {


    @GetMapping("/user")
    public User user(
            @Size(min =2) @RequestParam String name,
            @RequestParam int age
    ){
        //double a = 1 / 0;

        //User user = null;
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user ;
    }


    //사용자 정보를 등록하는 api
    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(user);
    }


//    @ExceptionHandler(value = MissingServletRequestParameterException.class)
//    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException manve){
//        System.out.println("필수값을 보내주세요");
//        System.out.println(manve.getBody());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("controller api1 name값을 넣어서 보내주세요");
//    }
}
