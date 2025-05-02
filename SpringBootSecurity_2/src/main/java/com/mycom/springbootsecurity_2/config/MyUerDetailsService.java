package com.mycom.springbootsecurity_2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUerDetailsService implements UserDetailsService {

    // DI
    private final PasswordEncoder passwordEncoder;

    // 기본 form ui 로그인 그대로
    // username, password가 user / console password 사용 X <- UserDetailsService를 제공하므로
    // form ui에 사용자가 입력한 username 값이 loadUserByUsername() 파라미터로 전달 (username)
    // DB를 통해서 (JPA 경우 UserRepository를거쳐서) username으로 select username, password를 가져와서
    // UserDetails 구현 객체를 만들어서 return 해야 함 (그런데 우리는 하드코딩 실습 중)
    // UserDetails 구현 객체는 우선 Spring secutiry에서 제공하는 org.springframework.security.core.userdetails.User를 사용
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // PasswordEncoder 객체 구현 클래스
        System.out.println(passwordEncoder.getClass());

        if("mj".equals(username)) {
            return User.builder()
                    .username("mj")
                    .password(passwordEncoder.encode("0206"))
                    .build();
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
