package com.mycom.springbootbasiclogging;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// com.mycom.app.repository의 모든 메소드가 호출될 때 기본 로그를 남기는 Aspect
// repository 패키지의 메소드는 모두 login 한 상태에서만 호출 가능
// 요약 : 로그인 한 사용자가 Repository 메서드를 호출할 때, 해당 메서드명을 로그로 남기기 위한 AOP Aspect
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {
    // session
    private final HttpSession session;

    @Pointcut(value = "execution( * com.mycom.springbootbasiclogging.repository.*.*(..) )")
    private void logPointcut(){}

    // 로그인 한 사용자가 호출할 경우, 호출한 사용자의 이름과 시간 출력
    @Before("logPointcut()")
    public void logRepositoryMethodCall(JoinPoint joinPoint) { // JoinPoint는 위 Pointcut의 대상 중 실제로 호출된 메소드 진입점
        String username = (String)session.getAttribute("username");
        if(username == null) return;

        String methodName = joinPoint.getSignature().getName(); // 메소드 명
        log.info("User["+username+"]가 method : "+methodName+" 을 "+ LocalDateTime.now()+"호출했습니다.");
    }
}
