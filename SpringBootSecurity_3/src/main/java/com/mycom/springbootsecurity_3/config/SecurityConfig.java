package com.mycom.springbootsecurity_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(
                        request -> {
                            request.requestMatchers(
                                    "/",
                                    "/index.html",
                                    "/csrf-token",
                                    "/login"
                                    ).permitAll()
                                    .requestMatchers("/customer/**").hasAnyRole("CUSTOMER","ADMIN")
                                    .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                                    .anyRequest().authenticated();
                        }
                )
                // csrf 설정
//                .csrf(csrf -> csrf.disable()) // 기능 off
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // cookie csrf token을 내려준다
                .formLogin(form ->
                        form
                                // 사용자정의 login 페이지를 사용하면 기본적으로 csrf를 전송하도록 구현해야 한다
                                // 만약 구현하지 않으면 csrf 토큰이 없다는 오류 발생, 로그인 처리 X
                                // csrf를 무시하도록 설정
                                .loginPage("/login.html")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/", true)
                                .permitAll())
                .logout(logout -> logout.permitAll()) // /logout url로 요청하면 자동으로 Spring Security가 session을 invalidate 시킴

                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}