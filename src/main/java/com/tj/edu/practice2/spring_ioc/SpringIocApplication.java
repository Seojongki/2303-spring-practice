package com.tj.edu.practice2.spring_ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringIocApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
        ApplicationContext ac = ApplicationContextProvider.getApplicationContext();

        Encoder encoder = ac.getBean("encoder1", Encoder.class);
        System.out.println("encoder 객체: "+encoder);

        String url = "https://www.naver.com";
        String resultStr = encoder.encodeString(url);
        byte[] result = encoder.encodeByte(url);

        System.out.println("encodeString: "+ resultStr);
        System.out.println("encodeByte: "+ result);

        System.out.println("spring-ioc연습 끝");
    }
}

@Configuration(enforceUniqueMethods=false)
//@Component //: mvc
//@Service //: 서비스
//@Repository //: dao
//@Controller
//@RestController
class AppConfig{
    @Bean
    public Encoder encoder1(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean
    public Encoder encoder2(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }

}