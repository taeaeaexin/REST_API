package com.mycom.springbootsecutiry_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 요청에 대해 모두 허락
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        return http
//                .authorizeHttpRequests(request -> request.anyRequest().permitAll())
//                .build();
//    }

    // 요청에 대해 모두 인증
    // 로그인 페이지를 통한 인증
    // 아무런 설정이 없는 경우와 동일
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        return http
//                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }

    // /, index.html 모두 허락, 나머지는 모두 인증
    // 로그인 페이지를 통한 인증
    // 아무런 설정이 없는 경우와 동일
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(
                        request -> {
                            request.requestMatchers("/", "/index.html").permitAll();
                            request.anyRequest().authenticated();
                        }
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
