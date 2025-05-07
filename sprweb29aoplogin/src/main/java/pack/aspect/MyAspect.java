package pack.aspect;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Autowired
    private LoginClass loginClass;

    @Around("execution(* jikwonProcess*(..))")
    public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        // 로그인 이므로 핵심로직 수행 전에 로그인 처리를 수행하도록 함(intercept)
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        // session 을 처리해야 하기 때문에 pointcut 대상 메소드를
        for (Object obj:joinPoint.getArgs()) {
            // getArgs() : pointcut 대상 메소드들의 인자를 읽어 request, response 객체를 얻음
            if(obj instanceof HttpServletRequest) {
                request = (HttpServletRequest) obj;
            }

            if(obj instanceof HttpServletResponse) {
                response = (HttpServletResponse) obj;
            }
        }

        if (request != null && response != null) {
            if (!loginClass.loginCheck(request, response)) {
                response.sendRedirect("/login");
                return null; // 로그인 실패 시 핵심 로직 중단
            }
        }

        Object object = joinPoint.proceed(); // public String jikwonProcess(Model model)

        return object;
    }
}
