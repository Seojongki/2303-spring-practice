package com.tj.edu.practice4.intercepter_filtor.controller;


import com.tj.edu.practice4.aop.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/user/{id}")
    public String user(@PathVariable(name = "id") String id, @RequestParam(required = false, defaultValue = "이순신") String name) {

        StopWatch stopWatch = new StopWatch();
        //스탑워치 시작
        stopWatch.start();



        System.out.println("id: "+ id);
        System.out.println("name: " + name);


        //스탑워치 끝
        stopWatch.stop();
        System.out.println("2개의 system.out.println 실행하는 데 길린시간 : " + stopWatch.getTotalTimeSeconds());



        return id + " / " + name;
    }

    @PostMapping("/user")
    public User user(User user) {

        StopWatch stopWatch = new StopWatch();
        //스탑워치 시작
        stopWatch.start();



        System.out.println("id: "+ user.getId());
        System.out.println("name: " + user.getName());


        //스탑워치 끝
        stopWatch.stop();
        System.out.println("2개의 system.out.println 실행하는 데 길린시간 : " + stopWatch.getTotalTimeSeconds());

        return user;
    }

    @PutMapping("/user")
    public User updateUser(User user){
        System.out.println("=======");
        System.out.println("id: "+ user.getId());
        return user;
    }

}
