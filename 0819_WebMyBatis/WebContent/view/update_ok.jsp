<%@page import="com.ict.db.DAO"%>
<%@page import="com.ict.db.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
    VO vo = (VO)session.getAttribute("vo");
    // 이름과 나이만 고쳐서 다시 세션에 저장하자
    vo.setM_name(request.getParameter("m_name"));
    vo.setM_age(request.getParameter("m_age"));
    
    // DB update도 하자
    DAO dao = (DAO)session.getAttribute("dao");
    int result = dao.getUpdate(vo);
    
    // 기존의 session에 덮어쓰자 
    session.setAttribute("vo", vo);
    
    response.sendRedirect("onelist.jsp?idx="+vo.getIdx());
%>    

</html>