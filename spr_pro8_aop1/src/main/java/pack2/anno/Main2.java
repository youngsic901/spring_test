package pack2.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop2.xml");
		
		LogicInter logicInter = (LogicInter)context.getBean("logicImpl");
		logicInter.selectDataProcess1();
		logicInter.selectDataProcess2();
	}
}
