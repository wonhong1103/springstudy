package com.ict.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/ict/ex04/config.xml");
		ArrayPrint ap = (ArrayPrint)context.getBean("ap");
		ap.s_prn();
		System.out.println("--------");
		ap.i_prn();
	}
}
