package com.tj.edu.practice2.spring_ioc_practice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringIocPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocPracticeApplication.class, args);
        ApplicationContext ac = ApplicationContextProvider.getApplicationContext();

        Encoder encoder = ac.getBean("base64Encode", Encoder.class);
        System.out.println("base64Encode  ====> : " + encoder);
    }

}


@Configuration(enforceUniqueMethods=false)
class AppConfig{
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}



