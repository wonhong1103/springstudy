<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 그냥 실행하면 실행이 안됨, 
     WEB-INF안에 존재하는 파일은 읽을 수 없다.(보안)
     web.xml에서 첫 페이지를 설정하고 프로젝트에서 실행--%>
	<h1> 첫번째 스프링 MVC 예제 </h1>
	<h2> <a href="index.do"> index </a> </h2>
	<h2> <a href="start.do"> start </a> </h2>
</body>
</html>