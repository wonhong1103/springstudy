package com.ict.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
	// Spring Container : 객체(Bean)를 생성하고 관리한다.
	// Spring Container =  ApplicationContext = BenaFactory
	
	// Spring Container의 정보는 ApplicationContext에 의해 관리된다.
	// ApplicationContext는	Bean 생성 및 DI, 생명주기를 관리하는 BeanFactory의 기능과
	// Spring AOP, 메시지 리소스 처리, 이벤트 처리 등의 기능을 제공한다.
	// 객체 생성 및 관리를 위해서 Spring Container 설정 정보를 참조
	// 설정 정보는  xml 또는 자바 애노테이션으로 구성 되어 있다.
		
	// 만들어진 Configuration 정보를 읽을 수 있는 ApplicationContext를 만들자
       ApplicationContext context 
       	= new ClassPathXmlApplicationContext("com/ict/ex02/configuration.xml");
       
       // configurateion.xml안에 있는 객체를 얻어내서 사용하자
       Service service =  (Service)context.getBean("service");
       service.biz();
	}
}






