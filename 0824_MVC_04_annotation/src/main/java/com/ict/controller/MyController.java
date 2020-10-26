package com.ict.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyProcess;

//  servlet-context.xml이 애노테이션을 지원할 때는
//  해당 클래스의 @Controller 사용하여
//  개발자가 메소드를 직접 만든다.
@Controller
public class MyController {
	public MyController() {
		System.out.println("MyController 생성자");
	}
	// 사용할 모델의 클래스를 가져온다.
	// 이때 변수 이름을  @Service("myProcess") 에 맞춘다.
	// setter를 만들어서 DI 할 수 있는 환경 만든다.
	@Autowired // spring
	// @Inject    // java
	private MyProcess myProcess;
	public void setMyProcess(MyProcess myProcess) {
		this.myProcess = myProcess;
	}
	
	// 인자는 상황에 따라서 변한다.
	// 사용자 요청에 따른 메소드실행을 직접 만들어야 한다.
	// 인자에는 value , method= 요청방식(GET,POST)

	// 요청이 hello.do 이면서 GET 방식일때 아래 메소드를 실행하게 된다.
	 @RequestMapping(value = "hello.do", method = RequestMethod.GET) 
	/* @RequestMapping(value = "hello.do") */
	/* @RequestMapping("hello.do")*/ 
	public ModelAndView HelloController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		mv.addObject("name", "홍길동");
		mv.addObject("age", 24);
		
		
		// autowired가 끝나면 myProcess를 사용할 수 있다.
		String msg = myProcess.getGreeting();
		mv.addObject("msg", msg);
		
		return mv;
	}
}








