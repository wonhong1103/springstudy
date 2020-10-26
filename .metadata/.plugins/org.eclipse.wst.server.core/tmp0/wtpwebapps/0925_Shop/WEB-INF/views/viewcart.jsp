<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
<style type="text/css">
table {
	margin: 10px auto;
	width: 800px;
	border-collapse: collapse;
	font-size: 8pt;
	border-color: navy;
}

table, th, td {
	border: 1px solid black;
}
</style>

</head>
<body>
<p> <jsp:include page="top.jsp" /></p>
	<table>
		<caption><h2> :: 장바구니 내용 :: </h2></caption>
		<thead>
			<tr bgcolor="#dedede">
				<th>제품번호</th>
				<th width="25%">제품명</th>
				<th>단가</th>
				<th>수량</th>
				<th>금액</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty cartList}">
				<tr>
					<td colspan="6"><h3> 장바구니가 비어 있습니다.</h3></td>
				</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${cartList}" var="k">
						<tr>
							<td>${k.p_num}</td>
							<td>${k.p_name}</td>
							<td>정가 : ${k.p_price}<br>
							   <font color="red"><b>세일가격 :0</b></font>   
							</td>
							<td>
								<form action="editcount.do" method="post">
									<input type="number" name="p_su" value="${k.p_su}" >
									<input type="hidden" name="p_num" value="${k.p_num}">
									<input type="hidden" name="id" value="${k.id}">
									<input type="submit" value="수정">
								</form>
							</td>
							<td>
								${k.p_price * k.p_su}
							</td>
							<td>
							  	<button onclick="location.href='delproduct.do?p_num=${k.p_num}&id=${k.id}'">삭제</button>
							</td>
						</tr>
						<c:set var="cartTotal" value="${cartTotal = cartTotal+(k.p_price * k.p_su)}"></c:set>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
		<tr align="right"><td colspan="6"><h2>총 결재역: ${cartTotal} &nbsp;&nbsp;&nbsp;</h2></td></tr>
		</tfoot>
	</table>
</body>
</html>