package com.mycom.springbootsecurity_jwt.jwt;

// jsw 생성, 검증 ..

import com.mycom.springbootsecurity_jwt.config.MyUserDetailsService;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Getter
public class JwtUtil {
    @Value("${SpringBootSecurity_jwt.jwt.secret}")
    private String secretKeyStr;
    private SecretKey secretKey;
    private final long tokenValidDuration = 1000L * 60 * 60 * 24; // 1000분의 1 단위

    private final MyUserDetailsService myUserDetailsService;

    @PostConstruct
    private void init() {
//        System.out.println(secretKeyStr);
        secretKey = new SecretKeySpec(
                secretKeyStr.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
//        System.out.println(secretKey);
    }

    // jwt 생성
    // username (subject, role)
    public String createToken(String username, List<String> roles) {
        // 발급일자, 만료일자
        Date now = new Date();

        return Jwts.builder()
                .subject(username)
                .claim("roles", roles)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + tokenValidDuration))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    // UserDetailsService를 통해 사용자 UserDetails 객체를 얻고
    // 이를 통해서 UsernamePasswordAuthenticationToken 객체를 만들어 리턴
    // 유효성 검증을 아래 메소드를 통해서 DB를 통한 검증을 진행하는 건 token 발급 기간이 길면 발급 시점의 UserDetails와 현재 UserDetails가 다를 수 있다는 점 강조
    // 반대로 Client가 접속할 때 마다, DB Access <= 이건 큰 부담
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(this.getUsernameFromToken(token));
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), "", userDetails.getAuthorities());
    }
    
    // jwt로 부터 username을 추출
    public String getUsernameFromToken(String token){
       return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token).getPayload()
                .getSubject();
    }

    // request로 부터 toekn 획득
    // client가 header에 "X-AUTH-TOKEN"
    public String getTokenFromHeader(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    // jwt 유효성 검증
    // 만료 일자만 검증
    public boolean validateToken(String token){
        return ! Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token).getPayload()
            .getExpiration().before(new Date());
    }
}