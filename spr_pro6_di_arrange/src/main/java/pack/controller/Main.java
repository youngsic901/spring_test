package pack.controller;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		MessageImpl m1 = new MessageImpl("관우", "적토마");
//		m1.sayHi();
//		MessageImpl m2 = new MessageImpl("장비", "막내");
//		m2.sayHi();
//		System.out.println(m1 + " " + m2);
		
		// ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:pack/controller/init.xml");
		//singleton 확인
		MessageImpl messageImpl = (MessageImpl)context.getBean("msgImpl");
		messageImpl.sayHi();
		
		MessageImpl messageImpl2 = (MessageImpl)context.getBean("msgImpl");
		messageImpl2.sayHi();
		System.out.println(messageImpl + " " + messageImpl2);
		
		System.out.println();
		// 다형성
		MessageInter inter = (MessageInter)context.getBean("msgImpl");
		inter.sayHi();
		
		MessageInter inter2 = context.getBean("msgImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();
	}
}
