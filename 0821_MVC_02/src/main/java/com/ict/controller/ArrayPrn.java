package com.ict.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ArrayPrn implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		// 일처리 
		String[] dogName = {"땅콩이", "점순이","토리","댕댕이"};
		
		ArrayList<String> humanName = new ArrayList<String>();
		humanName.add("차원홍");
		humanName.add("차선홍");
		humanName.add("차진홍");
		humanName.add("차현홍");
		
		ArrayList<String> catName = new ArrayList<String>();
		catName.add("야옹이");
		catName.add("다옹이");
		catName.add("루미");
		catName.add("노루");
		
		// 일처리 결과 저장
		mv.addObject("humanName", humanName);
		mv.addObject("catName", catName);
		mv.addObject("dogName", dogName);
		
		return mv;
	}
}
