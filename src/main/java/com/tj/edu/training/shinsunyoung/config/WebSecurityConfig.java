//package com.tj.edu.training.shinsunyoung.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//    private final UserDetailsService userDetailsService;
//
//    /*
//    * 웹 보안 설정 control
//    *   (1) 스프링 시큐리티 비활성화 (static 폴더 아래에 있는 모든 것들)
//    * @return WebSecurityCustomizer
//    *
//    * */
//
//    @Bean
//    public WebSecurityCustomizer configure(){
//        return (web -> web.ignoring()
////                .requestMatchers(toH2Console)
////                .requestMatchers("/static/**")
//                .requestMatchers("/images/**")  // images 폴더에 접근가능
//                .requestMatchers("/api/**")  // images 폴더에 접근가능
////                .requestMatchers("/**") // 모든 폴더 접근 가능
//        );
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        return http
////                .formLogin(withDefaults())
//                .authorizeRequests()
//                .requestMatchers("/login", "/signup", "/user").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin((formLogin) -> {
//                    formLogin.loginPage("/login")
//                                 .defaultSuccessUrl("/articles",true);
//                })
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login")
//                        .invalidateHttpSession(true)
//
//                )
//                .build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//}
