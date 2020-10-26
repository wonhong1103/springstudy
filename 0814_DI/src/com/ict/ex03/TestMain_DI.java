package com.ict.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/ict/ex03/config.xml");
		
		MyProcess process = (MyProcess)context.getBean("process");
		process.prn();
		
		MyProcess2 process2 = (MyProcess2)context.getBean("process2");
		process2.prn();
	}
}
