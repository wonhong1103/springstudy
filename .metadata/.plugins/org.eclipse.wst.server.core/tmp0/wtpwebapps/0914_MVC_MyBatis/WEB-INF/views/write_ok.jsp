<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:choose>
	<c:when test="${result>0}">
		<script>
			alert("삽입 성공");
			location.href = "/0720_MVC_05_guestbook2/MyController?cmd=list";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삽입 실패");
			location.href = "/0720_MVC_05_guestbook2/MyController?cmd=write";
		</script>
	</c:otherwise>
</c:choose>











