package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Aspect
public class LoginAdvice {
    @Around("execution(public void startProcess())")
    public Object mymethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.print("id 입력 : ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        scanner.close();

        if(!id.equals("aa")){
            System.out.print("id 불일치! 작업을 종료합니다");
            return null;
        }

        return joinPoint.proceed();
    }
}
