package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
// spring bean에 등록해서 쓴다.
// 여기에 components 라고 선언 하거나 config에 등록한다.
@Component
public class TimeTraceAop {

    // Aroung 어노테이션은 어느 부분을 구동 시킬지 범위를 정하는 어노테이션이다.
    // hello패키지의 hellospring 아래의 모든 클래스를 보라는 의미이다.
//    @Around("execution(* hello.hellospring..*(..))")
    @Around("execution(* hello.hellospring.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.printf("execute(ProceedingJoinPoint : %s) invoked.\n",joinPoint);
        System.out.printf("start : %s\n",joinPoint.toString());

        try {
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.printf("END : %s\n",joinPoint.toString());
            System.out.printf("timeMs : %s\n",timeMs);
        }

    }   // end execute


}   // end class
