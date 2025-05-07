package com.mycom.springbootsecurity_jwt.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.List;

// Client가 전송한 Token 유효성 검증
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = jwtUtil.getTokenFromHeader(request);

        // token validation
        if(token != null && jwtUtil.validateToken(token)) {
            System.out.println("토큰 검증");

            // Spring Security가 기본 검증을
            // 토큰으로부터 username, roles을 얻어서 이후 filter chain을 이어나가야 한다
            SecretKey secretKey = jwtUtil.getSecretKey();

            Claims claims = Jwts.parser()
                                .verifyWith(secretKey)
                                .build()
                                .parseSignedClaims(token).getPayload();

            String username = claims.getSubject();
            List<?> roles = (List<?>) claims.get("roles");

            List<SimpleGrantedAuthority> authorities = roles.stream()
                    .map(authority -> new SimpleGrantedAuthority("ROLE_"+authority.toString())).toList();
            System.out.println(authorities);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(username, null, authorities);

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}