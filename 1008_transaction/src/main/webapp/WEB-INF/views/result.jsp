<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 결과보기 </h2>
	<c:choose>
		<c:when test="${res>=2}">
			<h3>
				<li> ${vo.consumerid} 고객님 </li>
				<li> ${vo.amount} 자리 결제 하셨습니다 </li>
				<li> ${vo.countnum}개 티켓을 구매하셨습니다. </li>
			</h3>
		</c:when>
		<c:otherwise>
			<h2> 결제가 취소되었습니다. </h2>
		</c:otherwise>	
	</c:choose>
</body>
</html>