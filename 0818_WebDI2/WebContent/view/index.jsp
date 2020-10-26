<%@page import="com.ict.edu.WelCome"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		WebApplicationContext context =
		  WebApplicationContextUtils.getWebApplicationContext(application);
	
		WelCome welCome = (WelCome)context.getBean("welcome");
		String msg = welCome.sayWelCome();
	    out.println("<h2>" + msg +"</h2>");
	%>
</body>
</html>