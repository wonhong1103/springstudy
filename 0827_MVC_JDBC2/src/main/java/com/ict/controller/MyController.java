package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {
	@Autowired
	private DAO dao;
	public void setDao(DAO dao) { this.dao = dao;	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView listCommand() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		// jdbc에서 select문 무조건 List<VO>가 반환형
		List<VO> list = dao.getList();
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	@RequestMapping(value = "write_ok.do", method = RequestMethod.GET)
	public ModelAndView writeOkCommand() {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public ModelAndView writeOk2Command(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		
		try {
			String path = request.getSession()
					.getServletContext().getRealPath("/resources/upload");
			MultipartRequest mr = 
					new MultipartRequest(request, path,
						500*1024*1024, "utf-8", new DefaultFileRenamePolicy());

			String name = mr.getParameter("name");
			String subject = mr.getParameter("subject");
			String email = mr.getParameter("email");
			String pwd = mr.getParameter("pwd");
			String content = mr.getParameter("content");
			String file_name="";
			
			// 파일업로드를 했을 때와 안했을 때 구분
			File file =  mr.getFile("file_name");
			if(file!=null) {
				file_name = mr.getFilesystemName("file_name");
			}
			
			VO vo 
				= new VO("", name, subject, content, email, pwd, file_name, "");
			
			int result = dao.getInsert(vo); 
			
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping(value = "onelist.do", method=RequestMethod.GET)
	public ModelAndView oneListCommand(VO vo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		List<VO> list = dao.getOneList(vo.getIdx());
		VO ovo = list.get(0);
		// 수정과 삭제를 위해서 
		request.getSession().setAttribute("ovo", ovo);
		return mv;
	}
	
	// 다운로드
	@RequestMapping(value = "down.do",method = RequestMethod.GET)
	public void downCommand(HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos =  null;
		try {
			String file_name = request.getParameter("file_name");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition",
			 "attachement; filename="+URLEncoder.encode(file_name,"utf-8"));
			// 실제 IO
			File file = new File(new String(path.getBytes("utf-8")));
			int b;
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			
			while((b = bis.read()) != -1) {
				bos.write(b);
			}
			bos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
			}
		}
	}
	
	//  삭제화면
	@RequestMapping(value = "delete.do" , method = RequestMethod.POST)
	public ModelAndView deleteCommand() {
		return new ModelAndView("delete");
	}
	
	//  실제 삭제
	@RequestMapping(value = "delete_ok.do" , method = RequestMethod.POST)
	public ModelAndView deleteOKCommand(HttpServletRequest request) {
		VO vo = (VO)request.getSession().getAttribute("ovo");
		int result = dao.getDelete(vo.getIdx());
		return new ModelAndView("redirect:list.do");
	}
	
    //  수정화면
	@RequestMapping(value = "update.do" , method = RequestMethod.POST)
	public ModelAndView updateCommand() {
		return new ModelAndView("update");
	}
	
	@RequestMapping(value = "update_ok.do", method = RequestMethod.GET)
	public ModelAndView updateOk2Command() {
		return new ModelAndView("write");
	}
	
	// 실제수정
	@RequestMapping(value = "update_ok.do", method = RequestMethod.POST)
	public ModelAndView updateOkCommand(HttpServletRequest request) {
		try {
			String path = request.getSession()
					.getServletContext().getRealPath("/resources/upload");
			
			MultipartRequest mr = 
					new MultipartRequest(request, path,
						500*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String idx = mr.getParameter("idx");	
			String name = mr.getParameter("name");
			String subject = mr.getParameter("subject");
			String email = mr.getParameter("email");
			String pwd = mr.getParameter("pwd");
			String content = mr.getParameter("content");
			String f_name = mr.getParameter("f_name");
			
			String file_name = "";
			// 파일업로드를 했을 때와 안했을 때 구분
			File file =  mr.getFile("file_name");
			
			// 파일 첨부를 함
			if(file != null) {
				file_name = mr.getFilesystemName("file_name");
			}else {
				file_name = f_name ;
			}
			
			VO vo 
				= new VO(idx, name, subject, content, email, pwd, file_name, "");
			
			int result = dao.getUpdate(vo); 
			
			ModelAndView mv = new ModelAndView("redirect:onelist.do?idx="+idx);
			return mv;
		} catch (Exception e) {
		}
		return null;
	}
}








