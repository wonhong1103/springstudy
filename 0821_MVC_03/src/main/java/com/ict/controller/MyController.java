package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ict.model.MyProcess;

public class MyController implements Controller{
	// DI
	private MyProcess myProcess;
	
	// setter를 이용해서 주입한다.
	public void setMyProcess(MyProcess myProcess) {
		this.myProcess = myProcess;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		mv.addObject("name", "나 둘리");
		mv.addObject("age", 28);
		
		// DI가 아닐 경우
		// MyProcess myProcess = new MyProcess();
		
		
		String msg = myProcess.getGreeting();
		mv.addObject("msg", msg);
		
		
		return mv;
	}

	
}
