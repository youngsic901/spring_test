package pack1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	@Override
	// AOP에서 자동으로 호출
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// joinpoint에 삽입되어 동작할 코드 기술
		
		System.out.println("핵심로직 수행 전에 할 일들은 여기에 기술");
		AspectClass aspectClass = new AspectClass();
		aspectClass.abc();	// <== 관심사항
		
		Object object = invocation.proceed(); // 핵심 로직 수행. 예를 들어 sayHi()
		
		System.out.println("핵심로직 수행 후에 처리 코드는 이곳에 기술");
		
		return object;
	}
}
