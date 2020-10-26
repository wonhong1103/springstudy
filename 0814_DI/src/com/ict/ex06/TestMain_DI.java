package com.ict.ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/ict/ex06/config.xml");
		SetPrint sp = (SetPrint)context.getBean("sp");
		
		sp.s_prn();
		System.out.println("-------");
		sp.i_prn();
	}
}
