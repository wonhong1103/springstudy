package com.ict.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.db.DAO;
import com.ict.db.VO;

@Controller
public class MyController {
	// @Autowired  (spring)
	@Inject        //(java)
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("list.do")
	public ModelAndView listCommand() {
		ModelAndView mv = new ModelAndView("list");
		List<VO> list = dao.getList();
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	@RequestMapping("write_ok.do")
	public ModelAndView writeOKCommand(VO vo) {
		ModelAndView mv = new ModelAndView();
		int result = dao.getInsert(vo);
		if(result>0) {
			mv.setViewName("redirect:list.do");  
		}else {
			mv.setViewName("redirect:write.do");
		}
		return mv;
	}
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		String idx = request.getParameter("idx");
		VO vo = dao.getOneList(idx);
		request.getSession().setAttribute("vo", vo);
		return mv;
	}
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand() {
		return new ModelAndView("delete");
	}
	@RequestMapping("update.do")
	public ModelAndView updateCommand() {
		return new ModelAndView("update");
	}
	@RequestMapping("delete_ok.do")
	public ModelAndView deleteOKCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// 삭제를 위해서 vo에 있는 idx를 불러온다.
		VO vo = (VO)request.getSession().getAttribute("vo");
		int result = dao.getDelete(vo.getIdx());
		if(result>0) {
			mv.setViewName("redirect:list.do");
		}else {
			mv.setViewName("dedirect:onelist.do?idx="+vo.getIdx());
		}
		return mv;
	}
	@RequestMapping("update_ok.do")
	public ModelAndView updateOKCommand(VO vo) {
		ModelAndView mv = new ModelAndView();
		int result = dao.getUpdate(vo);
		if(result>0) {
			mv.setViewName("redirect:onelist.do?idx="+vo.getIdx());
		}else {
			mv.setViewName("redirect:update.do");
		}
		return mv;
	}
}




