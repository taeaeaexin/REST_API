package com.mycom.springbootsecurity_jwt.config;

import com.mycom.springbootsecurity_jwt.jwt.JwtAuthenticationFilter;
import com.mycom.springbootsecurity_jwt.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtUtil jwtUtil;

    @Bean
    SecurityFilterChain filterChain(
            HttpSecurity http,
            MyAuthenticationEntryPoint entryPoint
    ) throws Exception{
        return http
                // form 로그인 관련 disable
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(formLogin -> formLogin.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        request -> {
                            request.requestMatchers(
                                    "/",
                                    "/index.html",
                                    "/csrf-token",
                                    "/login",
                                    "/register",
                                    "/register.html",
                                    "/users/register"
                                    ).permitAll()
                                    .requestMatchers("/customer/**").hasAnyRole("CUSTOMER","ADMIN")
                                    .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                                    .anyRequest().authenticated();
                        }
                )
                // form login 방식에서 허락되지 않는 요청에 대해서 자동으로 login.html 페이지로 분기
                // form login을 사용하지 않으니 -> 예외 발생 -> 예외 발생에 대해서 json 응답 (login 필요)
                .exceptionHandling(
                        exceptionHandlingCustomizer ->
                                exceptionHandlingCustomizer.authenticationEntryPoint(entryPoint))

                // formLogin 방식에서는 Spring Security 가 자동으로 Filter 처리 (UsernamePasswordAuthenticationFilter)
                // form login을 사용하지 않으니 -> 위 필터 앞에서 한 번 수행되는 jwt 인증 필터 적용
                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}