package com.ict.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//애노테이션이 아니면 반드시 Controller 인터페이스를 상속 
public class StartController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("output2");
		
		// 일처리 
		
		// 일처리 결과 저장(request, session, ModelAndView)
		request.setAttribute("city", "서울");
		request.getSession().setAttribute("dogName", "댕댕이");
		mv.addObject("catName", "벌이");
		
		//Contorller의 리턴은 무조건  servlet-context.xml 이다.
		return mv;
	}
}
