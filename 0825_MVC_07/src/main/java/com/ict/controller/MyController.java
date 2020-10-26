package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {
	// get방식이면 다시 처리
	@RequestMapping(value = "f_up.do", method = RequestMethod.GET)
	public ModelAndView getF_up01() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	// 업로드는 POST 방식일때만 처리 가능
	// cos
	@RequestMapping(value = "f_up.do", method = RequestMethod.POST)
	public ModelAndView getF_up02(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("output01");
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartRequest mr = new MultipartRequest(request, path, 500 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			String name = mr.getParameter("name");
			String file_name = mr.getFilesystemName("file_name");
			String file_type = mr.getContentType("file_name");

			File file = mr.getFile("file_name");
			long size = file.length() / 1024; // KB
			SimpleDateFormat day = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 E요일");
			String lastday = day.format(file.lastModified());

			mv.addObject("name", name);
			mv.addObject("file_name", file_name);
			mv.addObject("file_type", file_type);
			mv.addObject("size", size);
			mv.addObject("lastday", lastday);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}

	@RequestMapping(value = "down.do", method = RequestMethod.GET)
	public void getFileDown(HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			String file_name = request.getParameter("file_name");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + file_name);
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file_name, "utf-8"));
			
			// 실제 IO
			File file = new File(new String(path.getBytes("utf-8")));
			int b;
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			bos.flush();
		} catch (Exception e) {
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
			}
		}
	}

	// get방식이면 다시 처리
	@RequestMapping(value = "f_up2.do", method = RequestMethod.GET)
	public ModelAndView getF_up03() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	// spring 자체 지원
	// root-context.xml CommonsMultipartResolver 객체 생성먼저
	@RequestMapping(value = "f_up2.do", 
			method = RequestMethod.POST)
	public ModelAndView getF_up04(
			@RequestParam("name2") String name2,
			@RequestParam("file_name2") MultipartFile file,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("output02");
		try {
			String path = request.getSession()
					.getServletContext()
					.getRealPath("/resources/upload");
			
			// Spring에서 지원하는 Multipart는 getFilesystemName이 없다.
			String file_name = file.getOriginalFilename();
			String file_type = file.getContentType();
			long size = file.getSize() / 1024 ;
			
			// 올릴 파일을 byte[]로 만듦
			byte[] in = file.getBytes();
			
			// 저장장소와 이름지정
			File out = new File(path, file_name);
			
			SimpleDateFormat day =
					new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 E요일");
			String lastday = day.format(out.lastModified());
			
			// 복사(upload)
			FileCopyUtils.copy(in, out);
			
			mv.addObject("name2",name2);
			mv.addObject("file_name",file_name);
			mv.addObject("file_type",file_type);
			mv.addObject("size",size);
			mv.addObject("lastday",lastday);
			
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping(value = "down2.do" , method =RequestMethod.GET)
	public void getFileDown2(
			@RequestParam("file_name")String file_name,
			HttpServletRequest request, 
			HttpServletResponse response
			) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//String file_name = request.getParameter("file_name");
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + file_name);
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file_name, "utf-8"));
			
			// 실제 I/O
			File file = new File(new String(path.getBytes("utf-8")));
			
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			
			FileCopyUtils.copy(bis, bos);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}







