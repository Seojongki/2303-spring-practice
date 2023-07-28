package com.tj.edu.training.shinsunyoung.config.jwt;

import com.tj.edu.training.shinsunyoung.model.User;
import com.tj.edu.training.shinsunyoung.repository.UserRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserRepository userRepository;

    @DisplayName("generateToken() 테스트")
    @Test
    void generateTokenTest1() {
        // given
        // 테스트 유저 데이터 생성
        User testUser = userRepository.save(User.builder()
                .email("user1@abc.com")
                .password("abcd")
                .build());

        // when
        String token = tokenProvider.generateToken(testUser, Duration.ofDays(14));
        System.out.println("-----------genrateToken: " + token);

        // then
        Long userId = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .get("id", Long.class);
        assertThat(userId).isEqualTo(testUser.getId());
    }

    @DisplayName("validJwtToken() 테스트")
    @Test
    void validJwtTokenTest1() {
        // given
        // 테스트 유저 데이터 생성
        User testUser = userRepository.save(User.builder()
                .email("user1@abc.com")
                .password("abcd")
                .build());
        Date now = new Date();
//        String token = tokenProvider.generateToken(testUser, Duration.ofDays(14));
//        String token = Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)  // 헤더 type : JWT
//                .setIssuer(jwtProperties.getIssuer())   // application.yml에 있는 jwt1@abc.om
//                .setIssuedAt(now)   // token 발행 시간
//                // 아래 코드는 항상 현재 날짜보다 7일 전의 날짜로 토큰 만료시간을 설정함
//                .setExpiration(new Date(now.getTime() - Duration.ofDays(7).toMillis()))  // token 만료 시간
//                .setSubject(testUser.getEmail())    // token 제목
//                .claim("id", testUser.getId())  // 클레임id
//                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
//                .compact();

        String token = JwtFactory.builder()
                .expiration(new Date(now.getTime() - Duration.ofDays(7).toMillis()))
                .build()
                .createToken(jwtProperties);

        // when
        boolean result = tokenProvider.validJwtToken(token);

        // then
        assertThat(result).isFalse();
    }


    @DisplayName("getAuthentication():  토큰 기반으로 인증정보 가져오는 테스트")
    @Test
    void getAuthenticationTest1(){
        //given

        String token = JwtFactory.builder()
                .subject("user@email.com")
                .build()
                .createToken(jwtProperties);

        //when
        Authentication authentication = tokenProvider.getAuthentication(token);

        // 로그 확인
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        System.out.println("username: " + username);
        String password = ((UserDetails)authentication.getPrincipal()).getPassword();
        System.out.println("password: " + password);
        List<GrantedAuthority> grantedAuthorityList = ((UserDetails)authentication.getPrincipal()).getAuthorities().stream().collect(toList());
        grantedAuthorityList.forEach((authority) -> System.out.println("auth: " + authority.getAuthority()));

        // then
        assertThat(((UserDetails)authentication.getPrincipal()).getUsername()).isEqualTo("user@email.com");


    }



}