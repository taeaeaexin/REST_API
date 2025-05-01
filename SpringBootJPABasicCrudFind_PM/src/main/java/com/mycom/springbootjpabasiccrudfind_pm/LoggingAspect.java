package com.mycom.springbootjpabasiccrudfind_pm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {
    private final HttpSession session;

    @Pointcut(value="execution(* com.mycom.springbootjpabasiccrudfind_pm.Phone.Repository.*(..) )")
    private void logPointcut(){}

    @Before("logPointcut()")
    public void logRepositoryMethodCall(JoinPoint joinPoint) { // JoinPoint는 위 Pointcut의 대상 중 실제로 호출된 메소드 진입점
        String username = (String)session.getAttribute("username");
        if(username == null) return;

        String methodName = joinPoint.getSignature().getName(); // 메소드 명
        log.info("User["+username+"]가 method : "+methodName+" 을 "+ LocalDateTime.now()+"호출했습니다.");
    }
}