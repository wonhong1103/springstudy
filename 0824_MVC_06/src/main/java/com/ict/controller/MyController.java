package com.ict.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyCalc;
import com.ict.model.VO;

@Controller
public class MyController {
	// 모델 연결
	@Autowired
	private MyCalc myCalc;

	public void setMyCalc(MyCalc myCalc) {
		this.myCalc = myCalc;
	}
	
	// 요청정보 연결 : HandlerMapping
	/* 방법1 : JSP 방식
	@RequestMapping(value = "param.do", method = RequestMethod.POST)
	public ModelAndView ParamController(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int s1 = Integer.parseInt(request.getParameter("s1"));
		int s2 = Integer.parseInt(request.getParameter("s2"));
		String op = request.getParameter("op");
		String cPage = request.getParameter("cPage");
		
		int result = 0 ;
		switch (op) {
			case "+":  result = myCalc.add(s1, s2);  break;
			case "-":  result = myCalc.sub(s1, s2);  break;
			case "*":  result = myCalc.mul(s1, s2);  break;
			case "/":  result = myCalc.div(s1, s2);  break;
		}
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		mv.addObject("result", result);
		mv.addObject("cPage", cPage);
		
		// 배열
		String[] hobby = request.getParameterValues("hobby");
		mv.addObject("hobby", hobby);
		
		return mv;
	}
	*/
	
	// 방법2 : VO 사용 (자동으로 vo에 파라미터값이 들어감)
	/*
	@RequestMapping(value = "param.do", method = RequestMethod.POST)
	public ModelAndView ParamController(VO vo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int s1 = Integer.parseInt(vo.getS1());
		int s2 = Integer.parseInt(vo.getS2());
		String op = vo.getOp();
		String cPage = vo.getcPage();
		
		int result = 0 ;
		switch (op) {
			case "+":  result = myCalc.add(s1, s2);  break;
			case "-":  result = myCalc.sub(s1, s2);  break;
			case "*":  result = myCalc.mul(s1, s2);  break;
			case "/":  result = myCalc.div(s1, s2);  break;
		}
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		mv.addObject("result", result);
		mv.addObject("cPage", cPage);
		
		// 배열
		String[] hobby = vo.getHobby();
		mv.addObject("hobby", hobby);
		
		return mv;
	}
	*/
	// 방법3 : Model 사용
	// 들어온 파라미터들이 결과를 보여줄 JSP에 넘어가야 될때 사용
		@RequestMapping(value = "param.do", method = RequestMethod.POST)
		public ModelAndView ParamController(@ModelAttribute("mvo")VO vo) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("result");
			
			int s1 = Integer.parseInt(vo.getS1());
			int s2 = Integer.parseInt(vo.getS2());
			String op = vo.getOp();
			String cPage = vo.getcPage();
			
			int result = 0 ;
			switch (op) {
				case "+":  result = myCalc.add(s1, s2);  break;
				case "-":  result = myCalc.sub(s1, s2);  break;
				case "*":  result = myCalc.mul(s1, s2);  break;
				case "/":  result = myCalc.div(s1, s2);  break;
			}
			// mv.addObject("s1", s1);
			// mv.addObject("s2", s2);
			// mv.addObject("op", op);
			mv.addObject("result", result);
			// mv.addObject("cPage", cPage);
			
			// 배열
			// String[] hobby = vo.getHobby();
			// mv.addObject("hobby", hobby);
			
			return mv;
		}
}













