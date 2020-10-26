<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
</head>
<body>
	<jsp:include page="../frame/header.jsp" />
	
	<a href="${pageContext.request.contextPath}/admin/home?menu=1">물품등록 관리</a>
	<a href="${pageContext.request.contextPath}/admin/home?menu=2">게시판 관리</a>
<hr>

	<c:if test="${param.menu eq 1}">
		물품등록 관리
	</c:if> 
	<c:if test="${param.menu eq 2}">
		게시판 관리
	</c:if> 
	
	<jsp:include page="../frame/footer.jsp" />
</body>
</html>