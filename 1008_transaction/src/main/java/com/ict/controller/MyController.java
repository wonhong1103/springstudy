package com.ict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.db.DAO;
import com.ict.db.VO;

@Controller
public class MyController {
	@Autowired
	private DAO dao;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("result.do")
	public ModelAndView resultCommand(VO vo) throws Exception {
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("vo", vo);			
		int res = dao.getInsert(vo);
		mv.addObject("res", res);			

		return mv;
	}
	
	
}
