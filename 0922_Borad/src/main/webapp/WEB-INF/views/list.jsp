<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
	text-align: center;
	padding: 4px 10px;
	background-color: #F6F6F6;
}

th {
	text-align: center;
	padding: 4px 10px;
	background-color: #B2CCFF;
}

/* 가운데 정렬 */
h2{text-align: center;}
table {
	width: 800px;
	margin: 0px auto;
}
</style>
<script type="text/javascript">
	function write_go() {
		location.href = "write.do"
	}
</script>
</head>
<body>
	<h2>BOARD 리스트</h2>
	<table width="700">
		<thead>
			<tr>
				<th width="15%">번호</th>
				<th width="40%">제목</th>
				<th width="15%">글쓴이</th>
				<th width="15%">날짜</th>
				<th width="15%">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="5">
							<h3>원하시는 자료가 존재하지 않습니다.</h3>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="k" items="${list}" varStatus="vs">
						<tr>
							<td>${paging.totalRecord - ((paging.nowPage-1)*paging.numPerPage+vs.index)} </td>
							<td style="text-align: left; padding-left: 20px;">
								<c:forEach begin="1" end="${k.step}">
									&nbsp;&nbsp;[RE]
								</c:forEach>
							<a href="onelist.do?idx=${k.idx}&cPage=${paging.nowPage}">${k.title}</a></td>
							<td>${k.writer}</td>
							<td>${k.regdate.substring(0,10)}</td>
							<td>${k.hit}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<!-- 이전  -->
					<c:choose>
						<c:when test="${paging.beginBlock > paging.pagePerBlock }">
						<a href="list.do?cPage=${paging.beginBlock-paging.pagePerBlock}">
							<span style="background: #b2ccff"><font size="4">이전으로</font></span></a>&nbsp;&nbsp;&nbsp; 
						</c:when>
						<c:otherwise>
							<font size="4" style="color: gray;"> 이전으로 </font>&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
					<!-- 페이지번호 -->
					<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}" 
						step="1" var ="k">
					<c:choose>
						<c:when test="${k==paging.nowPage}">
							<font size="4">${k}</font> &nbsp; &nbsp;
						</c:when>
						<c:otherwise>
						  	<a href="list.do?cPage=${k}"><span style="background: #b2ccff"><font size="4">${k}</font></a> &nbsp; &nbsp;
						</c:otherwise>
					</c:choose>
					</c:forEach>
					<!-- 이후 -->
					<c:choose>
						<c:when test="${paging.endBlock < paging.totalPage }">
						<a href="list.do?cPage=${paging.beginBlock+paging.pagePerBlock}">
							<span style="background: #b2ccff"><font size="4">다음으로</font></span></a>&nbsp;&nbsp;&nbsp; 
						</c:when>
						<c:otherwise>
							<font size="4" style="color: gray;">다음으로</font>&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
				</td>
				<td><button onclick="write_go()">글쓰기</button> </td>
			</tr>
		</tfoot>		
	</table>
</body>
</html>